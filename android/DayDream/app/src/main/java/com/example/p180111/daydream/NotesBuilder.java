package com.example.p180111.daydream;

/**
 * Created by p180111 on 16/11/2017.
 */

public class NotesBuilder {
    private String title,
            content;

    public NotesBuilder() {
    }

    public NotesBuilder(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
