package io.neko.controller;

import io.neko.model.News;
import io.neko.service.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/publish")
public class NewsPublishEndpoint {
    private final Subject<News> newsDistributor;

    public NewsPublishEndpoint(Subject newsDistributor) {
        this.newsDistributor = newsDistributor;
    }

    @PostMapping
    public ResponseEntity<?> addNews(@RequestBody News news) {
        newsDistributor.notifyObservers(news);
        HashMap<String, String> data = new HashMap<>();
        data.put("published", "ok");

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
            .body(data);
    }
}
