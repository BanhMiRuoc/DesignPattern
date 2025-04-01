public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Command lightOn = new LightOnCommand();
        Command lightOff = new LightOffCommand();

        remote.setCommand(lightOn);
        remote.executeCommand(); // Output: Đã mở đèn

        remote.setCommand(lightOff);
        remote.executeCommand(); // Output: Đã tắt đèn

        remote.undo(); // Output: Đã hoàn tác lệnh.
        remote.redo(); // Output: Đã làm lại lệnh.
    }
}
