package command.simple;

//Command interface.
public interface Command {
    boolean execute();
    boolean undo();
}