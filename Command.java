public interface Command {
    public void execute();
    public boolean match(String input);
    public void undo();
    public void redo();
}