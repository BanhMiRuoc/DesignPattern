public class Packet {
    private String originator;
    private String destination;
    private String content;

    public Packet(String originator, String destination, String content) {
        this.originator = originator;
        this.destination = destination;
        this.content = content;
    }

    public String getOriginator() {
        return originator;
    }
    public void setOriginator(String originator) {
        this.originator = originator;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isOriginator() {
        return originator != null;
    }
    public boolean isDestination() {
        return destination != null;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}