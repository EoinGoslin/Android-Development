package com.example.user.snakegame;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;
import java.util.Random;


/**
 * Created by User on 18/11/2017.
 */

public class SnakeView extends SurfaceView implements Runnable {




    //All the code will run seperately to the UI
    private Thread m_Thread = null;
    //this next variable determines when the game is playing
    //volatile because can be accessed inside and outside the class
    private volatile boolean m_Playing;

    //creating what we will draw on
    private Canvas m_Canvas;
    //required by the canvas to do the drawing
    private SurfaceHolder m_Holder;
    //Lets us control the colorus
    private Paint m_Paint;
    //This will be a reference to the activity
    private Context m_context;

    //Sound effects
    private SoundPool m_SoundPool;
    private int m_get_mouse_sound = -1;
    private int m_dead_sound = -1;

    //for tracking movement m_Direction
    public enum Direction {Up, Right, Down, Left}
    //starts by heading to the right
    private Direction m_Direction = Direction.Left;

    //Screen resolution
    private int m_ScreenWidth;
    private int m_ScreenHeight;


    //Control pausing between updates
    private long m_NextFrameTime;
    //update games 10 times per second
    private final long FPS = 10;
    //There are 1000 milliseconds per second
    private final long MILLIS_IN_A_SECOND = 1000;

    //current m_Score
    private int m_Score;
    //location in the grid of all the segments
    private int[] m_SnakeXs;
    private int[] m_SnakeYs;

    //How long snake is at the a particular time
    private int m_SnakeLength;

    //locates the mouse
    private int m_MouseX;
    private int m_MouseY;

    //The size in pixels of a snake segment
    private int m_BlockSize;

    //The siz in segments of the playable area
    private final int NUM_BLOCKS_WIDE = 30;//original 40, make smaller to make more close in environment
    private int m_NumBlocksHigh;

    public SnakeView(Context context, Point size) {
        super(context);

        m_context = context;
        m_ScreenWidth = size.x;
        m_ScreenHeight = size.y;

        //Determine the size of each block/place on the
        //gameboard

        //by changing the value of NUM_BLOCKS_WIDE you will be able to control how big
        // or small the snake is and how vast or cramped his environment is.
        m_BlockSize = m_ScreenWidth / NUM_BLOCKS_WIDE;
        //How many blocks of the same size will fit into the heigth
        m_NumBlocksHigh = m_ScreenHeight / m_BlockSize;

        //set the sound up
        loadSound();

        //Initialise the drawing objects
        m_Holder = getHolder();
        m_Paint = new Paint();

        //if score 200 you are rewarded with a crash achievment
        m_SnakeXs = new int[200];
        m_SnakeYs = new int[200];

        //Start the game
        startGame();
    }

    @Override
    public void run() {
        //The check for m_player prevents a crash at the start
        //Could provide a pause feature here

        while(m_Playing) {
            //update 10 times per second
            if(checkForUpdate()){
                updateGame();
                drawGame();
            }

        }
    }

    public void pause() {
        m_Playing = false;
        try {
            m_Thread.join();
        } catch (InterruptedException e) {
            //Error
        }
    }

    public void resume() {
        m_Playing = true;
        m_Thread = new Thread(this);
        m_Thread.start();
    }

    public void startGame() {
        //starts with just a head in the middle
        //of the screen
        //The first position of each of the arrays holds the head. It is worth remembering this as it is the head
        //that we will use when we implement collision detection
        m_SnakeLength = 1;
        m_SnakeXs[0] = NUM_BLOCKS_WIDE / 2;
        m_SnakeYs[0] = m_NumBlocksHigh / 2;

        //a mouse is added to eat
        spawnMouse();
        //reset the m_score
        m_Score = 0;

        //Setup m_NextFrameTime so an update is triggered immediately
        m_NextFrameTime = System.currentTimeMillis();
    }

    public void loadSound() {
        m_SoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            //create objects of the two required classes
            //use m_Context because this is a reference to the Activity
            AssetManager assetManager = m_context.getAssets();
            AssetFileDescriptor descriptor;

            //Prepare the two sounds in memory
            //sound files are loaded into RAM
            //All we will need to do when we want to make a noise is call the play method along
            // with the appropriate identifier( m_get_mouse_sound or m_dead_sound).
            descriptor = assetManager.openFd("get_mouse_sound.ogg");
            m_get_mouse_sound = m_SoundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("death_sound.ogg");
            m_dead_sound = m_SoundPool.load(descriptor, 0);




        } catch (IOException e) {
            //Error
        }
    }
            //The spawnMouse method simply gets two random int values
            // within the ranges of zero and NUM_BLOCKS_WIDE, zero and m_NumBlocksHigh,
            // then initializes the horizontal and vertical location of the mouse.
    public void spawnMouse() {
        Random random = new Random();
        m_MouseX = random.nextInt(NUM_BLOCKS_WIDE-1) + 1;
        m_MouseY = random.nextInt(m_NumBlocksHigh -1) +1;

    }

    public void eatMouse() {
        //Increase size of snake because has eaten a mouse
        m_SnakeLength++;
        //replace the mouse
        spawnMouse();
        //add to the m_Score
        m_Score = m_Score + 1;
        //play sound of mouse eaten
        m_SoundPool.play(m_get_mouse_sound, 1,1,0,0,1);
    }

    private void moveSnake() {
        //move the body
        for(int i = m_SnakeLength; i> 0; i--)
        {
            //start at the back and move the snake
            //to the position of the segment in front of it
            m_SnakeXs[i] = m_SnakeXs[i-1];
            m_SnakeYs[i] = m_SnakeYs[i-1];


        }
        //move the head in the correct m_direction
        switch (m_Direction) {
            case Up:
                m_SnakeYs[0]--;
                break;
            case Right:
                m_SnakeXs[0]++;
                break;
            case Down:
                m_SnakeYs[0]++;
                break;
            case Left:
                m_SnakeXs[0]--;
                break;
        }


    }

    public boolean detectDeath() {
        //check to see if snake died,
        //has snake head hit edge of level
        //or has it hit a segment of its body
        boolean dead = false;

        //checks to see if it hit a wall
        if(m_SnakeXs[0] == -1) dead = true;
        if(m_SnakeXs[0] >= NUM_BLOCKS_WIDE) dead = true;
        if(m_SnakeYs[0] == -1) dead = true;
        if(m_SnakeYs[0] == m_NumBlocksHigh) dead = true;

        //check to see if hit its own body
        for(int i = m_SnakeLength-1; i > 0; i--)
        {
            if((i>4) && (m_SnakeXs[0] == m_SnakeXs[i]) && (m_SnakeYs[0] == m_SnakeYs[i]))
            {
                dead = true;

            }

        }
        return dead;

    }

    public void updateGame() {
        //check to see if head of snake touched the mouse
        if(m_SnakeXs[0] == m_MouseX && m_SnakeYs[0] == m_MouseY)
        {
            eatMouse();
        }
        moveSnake();

        if(detectDeath()) {
            //start agin
            m_SoundPool.play(m_dead_sound,1,1,0,0,1);

            startGame();
        }


    }
    //sets up canvas and creates snake,background and mouse
    public void drawGame() {
        if (m_Holder.getSurface().isValid()) {
            m_Canvas = m_Holder.lockCanvas();
            //clear the screen
            m_Canvas.drawColor(Color.argb(255, 120, 197, 87));//original 255,120,197,87
            //set the colour of the paint to draw snake and mouse
            m_Paint.setColor(Color.argb(255, 255, 255, 255));//original 255,255,255,255

            //choose how big the score will be
            m_Paint.setTextSize(30);
            m_Canvas.drawText("Score : " + m_Score, 10, 30, m_Paint);//mm_Paint is the colour of the text

            //Draw the snake

            for (int i = 0; i < m_SnakeLength; i++) {
                m_Canvas.drawRect(m_SnakeXs[i] * m_BlockSize,
                        (m_SnakeYs[i] * m_BlockSize),
                        (m_SnakeXs[i] * m_BlockSize) + m_BlockSize,
                        (m_SnakeYs[i] * m_BlockSize) + m_BlockSize,
                        m_Paint);


            }
            //draw the mouse
            m_Canvas.drawRect(m_MouseX * m_BlockSize,
                    (m_MouseY * m_BlockSize),
                    (m_MouseX * m_BlockSize) + m_BlockSize,
                    (m_MouseY * m_BlockSize) + m_BlockSize,
                    m_Paint);

            //Draw the whole frame
            m_Holder.unlockCanvasAndPost(m_Canvas);

        }
    }

    public boolean checkForUpdate() {
        //checks to see if frame due to be updated
        if(m_NextFrameTime <= System.currentTimeMillis())
        {
            //then a tenth of a second has passed
            //set up when the nexxt update will be triggered
            m_NextFrameTime = System.currentTimeMillis() + MILLIS_IN_A_SECOND / FPS;

            //return true so that the update and draw
            //functions are exectued

            return true;
        }
        return false;
    }

    //next method handles touch screen
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                if(motionEvent.getX() >= m_ScreenWidth / 2) {
                    switch (m_Direction) {
                        case Up:
                            m_Direction = Direction.Right;
                            break;
                        case Right:
                            m_Direction = Direction.Down;
                            break;
                        case Down:
                            m_Direction = Direction.Left;
                            break;
                        case Left:
                            m_Direction = Direction.Up;
                            break;
                    }
                } else {
                    switch (m_Direction) {
                        case Up:
                            m_Direction = Direction.Left;
                            break;
                        case Left:
                            m_Direction = Direction.Down;
                            break;
                        case Down:
                            m_Direction = Direction.Right;
                            break;
                        case Right:
                            m_Direction = Direction.Up;
                            break;
                    }
                }
        }
        return true;




    }




    }










