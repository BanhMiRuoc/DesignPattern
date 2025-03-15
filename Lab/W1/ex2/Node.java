abstract class Node {
    protected String name;
    protected Node nextNode;

    public Node(String name) {
        this.name = name;
    }
    public Node(){}
    public String getName() {
        return name;
    }
    public void insertNode(Node n) {
        nextNode = n;
    }
    public abstract void accept(Packet p);

}