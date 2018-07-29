package io.neko.model;

public class News {
    private final String author;
    private final String title;

    public News() {
        this.author = null;
        this.title = null;
    }

    public News(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "News{" +
            "author='" + author + '\'' +
            ", title='" + title + '\'' +
            '}';
    }
}
