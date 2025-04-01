package command;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl(int slotCount) {
        onCommands = new Command[slotCount];
        offCommands = new Command[slotCount];
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void removeCommand(int slot) {
        onCommands[slot] = null;
        offCommands[slot] = null;
    }

    public void pressOn(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
        }
    }

    public void pressOff(int slot) {
        if (offCommands[slot] != null) {
            offCommands[slot].execute();
        }
    }
}
