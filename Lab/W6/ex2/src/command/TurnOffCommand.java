package command;

import device.Device;

public class TurnOffCommand implements Command {
    private final Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.off();
    }
}
