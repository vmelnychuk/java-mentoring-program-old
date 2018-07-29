package io.neko.model;

public class News {
    private final String author;
    private final String title;


    public News(String author, String title, String description) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
