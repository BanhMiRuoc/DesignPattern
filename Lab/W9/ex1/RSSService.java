package ex1;

import java.util.*;

public class RSSService {
    private List<Post> posts;
    private List<Observer> observers;

    public RSSService() {
        posts = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addPost(Post p) {
        posts.add(p);
        notifyObservers(p);
    }

    private void notifyObservers(Post post) {
        for (Observer observer : observers) {
            observer.update(post);
        }
    }

    public List<Post> getPosts() {
        return posts;
    }
}
