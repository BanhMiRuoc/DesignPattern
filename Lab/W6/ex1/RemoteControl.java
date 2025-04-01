import java.util.Stack;

public class RemoteControl {
    private Command command;
    private Stack<Command> commandHistory = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
        commandHistory.push(command);
        redoStack.clear(); // Clear redo stack on new command
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            redoStack.push(lastCommand);
            System.out.println("Undo command");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command commandToRedo = redoStack.pop();
            commandHistory.push(commandToRedo);
            System.out.println("Redo command");
        }
    }
}
