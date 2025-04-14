public class TextVersionTracker {
    private String lastSavedText = "";

    public void setLastSavedText(String text) {
        this.lastSavedText = text;
    }

    public String getLastSavedText() {
        return lastSavedText;
    }

    public boolean isChanged(String currentText) {
        return !currentText.equals(lastSavedText);
    }
}
