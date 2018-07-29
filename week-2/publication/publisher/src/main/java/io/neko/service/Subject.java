package io.neko.service;

public interface Subject<T> {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(T update);
}
