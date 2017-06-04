package command.simple;

import java.util.Stack;

public class PersonSubSystemManager {
    private Command currentCommand = null;
    private Stack<Command> commandsExecuted = new Stack<>();

    public void saveParentAndChildren(Person parent) {
        currentCommand = new SaveCommand(parent);
        //parent object saved in database
        if (currentCommand.execute()) {
            commandsExecuted.push(currentCommand);
            if (!parent.getChildren().isEmpty()) {
                for (Person p : parent.getChildren()) {
                    currentCommand = new SaveCommand(p);
                    if (currentCommand.execute() == true) {
                        commandsExecuted.push(currentCommand);
                    } else {
                        break;
                    }
                }
                //undo all executed commands
                while (!commandsExecuted.empty()) {
                    commandsExecuted.pop().undo();
                }
                System.out.println("operation failed!");
                return;
            }//both parent and children objects saved in database System.out.println("operation completed!");
        } else {
            //parent object not saved System.out.println("operation failed!");
        }
    }
}