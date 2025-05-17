import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
    private Deque<Command> history = new ArrayDeque<>();
    private Deque<Command> undolist = new ArrayDeque<>();
    private Deque<Command> redolist = new ArrayDeque<>();
    private String player;
    private int position;

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
            undolist.push(command);
        }
    }

    public void redo() {
        if (!undolist.isEmpty()) {
            Command command = undolist.pop();
            command.execute();
            history.push(command);
            redolist.push(command);
        }
    }

    public void list() {
        System.out.println("Command History: " + history);
        System.out.println("Undone Commands: " + undolist);
        System.out.println("Redone Commands: " + redolist);
    }

    public void setplayerHistory(String player){
        this.player = player;
    }

    public String getplayerHistory(){
        return player;
    }

    public void setpositionHistory(int position){
        this.position = position;
    }

    public int getpositionrHistory(){
        return position;
    }
}