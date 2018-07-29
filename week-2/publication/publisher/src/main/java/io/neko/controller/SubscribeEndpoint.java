package io.neko.controller;

import io.neko.model.News;
import io.neko.model.SubscriberInfo;
import io.neko.service.Subject;
import io.neko.service.Subscriber;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SubscribeEndpoint {
    private final Subject<News> newsDisptibution;

    public SubscribeEndpoint(Subject<News> newsDisptibution) {
        this.newsDisptibution = newsDisptibution;
    }

    @PostMapping
    @RequestMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestBody SubscriberInfo subscriberInfo) {
        Subscriber subscriber = new Subscriber(subscriberInfo);
        newsDisptibution.registerObserver(subscriber);

        HashMap<String, String> data = new HashMap<>();
        data.put("url", subscriberInfo.getCallbackUrl());

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
            .body(data);
    }

    @PostMapping
    @RequestMapping("/unsubscribe")
    public ResponseEntity<?> unsubscribe(@RequestBody SubscriberInfo subscriberInfo) {
        Subscriber subscriber = new Subscriber(subscriberInfo);
        newsDisptibution.removeObserver(subscriber);

        HashMap<String, String> data = new HashMap<>();
        data.put("unsubscribed", "ok");

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
            .body(data);
    }
}
