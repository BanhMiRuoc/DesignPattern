package ex1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RSSService service = new RSSService();

        Client client1 = new Client("ex1.Client 1");
        Client client2 = new Client("ex1.Client 2");

        service.addObserver(client1);
        service.addObserver(client2);

        Thread.sleep(2000);
        service.addPost(new Post("post 1 title", "post 1 content"));

        Thread.sleep(3000);
        service.addPost(new Post("post 2 title", "post 2 content"));
    }
}
