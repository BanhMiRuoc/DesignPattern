public class Printer extends Node {

    public Printer(String name) {
        super(name);
    }

    public void accept(Packet p) {

    }

    public void print(Packet p) {
        System.out.println(name + " is printing contents: " + p.getContent());
    }
}
