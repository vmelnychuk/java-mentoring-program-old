package io.neko.service;

import io.neko.model.News;

public interface Observer {
    void postNews(News news);
}
