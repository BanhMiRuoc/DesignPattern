public class Server extends Node{
    private static Server instance;
    private Printer printer1 = new Printer("Printer1");
    private Printer printer2 = new Printer("Printer2");
    private boolean useFirstPrinter = true;

    private Server(String name) {
        super(name);
    }

    public static synchronized Server getInstance() {
        if (instance == null) {
            instance = new Server("Server");
        }
        return instance;
    }

    public boolean isForMe(Packet p) {
        return p.isDestination(this);
    }

    @Override
    public void accept(Packet p) {
        if (isForMe(p)) {
            System.out.println(" Server received packet from " + p.getOriginator() + " with contents: " + p.getContents());

            Printer selectedPrinter = useFirstPrinter ? printer1 : printer2;
            useFirstPrinter = !useFirstPrinter;

            selectedPrinter.accept(p);
        } else if (nextNode != null) {
            nextNode.accept(p);
        }
    }
}
