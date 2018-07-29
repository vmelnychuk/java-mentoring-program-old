package io.neko.controller;

import io.neko.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class NewsFeedEndpoint {
    private static final Logger log = LoggerFactory.getLogger(NewsFeedEndpoint.class);

    @PostMapping
    @RequestMapping("/feed")
    public ResponseEntity<?> newsFeed(@RequestBody News news) {
        log.info("Get news: " + news.toString());

        HashMap<String, String> data = new HashMap<>();
        data.put("feed", "ok");

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
            .body(data);
    }
}
