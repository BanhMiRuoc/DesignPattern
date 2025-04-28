package ex1;

import java.util.*;

public class Client implements Observer {
    private String name;
    private List<Post> receivedPosts;

    public Client(String name) {
        this.name = name;
        this.receivedPosts = new ArrayList<>();
    }

    @Override
    public void update(Post post) {
        receivedPosts.add(post);
        refreshGUI(post);
    }

    public void refreshGUI(Post post) {
        System.out.println("[" + name + "] New ex1.Post Received:");
        System.out.println("Title: " + post.getTitle());
        System.out.println("Content: " + post.getContent());
        System.out.println();
    }
}
