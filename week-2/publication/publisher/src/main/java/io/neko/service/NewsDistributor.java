package io.neko.service;

import io.neko.model.News;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsDistributor implements Subject<News> {
    private News news;
    private List<Observer> observers;

    public NewsDistributor() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.removeIf(ob -> ob.equals(observer));
    }

    @Override
    public void notifyObservers(News news) {
        this.news = news;
        observers.forEach(observer -> observer.postNews(news));
    }
}
