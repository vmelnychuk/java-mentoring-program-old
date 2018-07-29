package io.neko.service;

import io.neko.model.News;
import io.neko.model.SubscriberInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class Subscriber implements Observer {
    private static final Logger log = LoggerFactory.getLogger(Subscriber.class);

    private final SubscriberInfo subscriberInfo;

    private final RestTemplate restTemplate;

    public Subscriber(SubscriberInfo subscriberInfo) {
        this.subscriberInfo = subscriberInfo;
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public void postNews(News news) {
        log.info("Call subscriber by " + subscriberInfo.getCallbackUrl());
        HttpEntity<News> request = new HttpEntity<>(news);
        restTemplate.postForLocation(subscriberInfo.getCallbackUrl(), request);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        return subscriberInfo.equals(that.subscriberInfo);
    }

    @Override
    public int hashCode() {
        return subscriberInfo.hashCode();
    }
}
