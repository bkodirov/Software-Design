#**_Command Pattern_**

**Intent**
<br/>
Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

**Motivation**
<br/>
- Sometimes it's necessary to issue requests without knowing anything about the operation being requested or the receiver of the request.
- For some applications, you have to store and pass requests around like other objects.
- For unsuccessfully executed requests, roll-back is required.

**Structure**
![Structure](https://ranjithabalaraman.files.wordpress.com/2014/06/structure.png)

**Participants**
<br/>
`Command` - declares an interface for executing an operation.
<br/>
`ConcreteCommand`
 - defines a binding between a Receiver object and an action.
 - implements Execute by invoking the corresponding operation(s) on Receiver.
<br/>
`Invoker` - asks the command to carry out the request.
<br/>
`Receiver` - knows how to perform the operations associated with carrying out a request. Any class may serve as a Receiver.
<br/>
`Client` - creates a ConcreteCommand object and sets its receiver.
<br/>

**Applicability.**  
<br/>
Use the Command pattern when you want to:
<br/>
- Pass an object as an action to perform. The object has a callback method to be called by the invoker. Commands are an object-oriented replacement for procedural language callback functions.
- Specify, queue, and execute requests at different times. Support transactions.
- Support undo.
- Support logging and system recovery.

There is a bad smell in the following code. How to fix it?
````
public void actionPerformed(ActionEvent e){
    Object o = e.getSource();
    if (o instanceof fileNewMenuItem)
        doFileNewAction();
    else if (o instanceof fileOpenMenuItem)
        doFileOpenAction();
    else if (o instanceof fileOpenRecentMenuItem)
        doFileOpenRecentAction();
    else if (o instanceof fileSaveMenuItem)
        doFileSaveAction();
      // and more ...
}
````
Solution: use the Command pattern.
````
public interface Command{
    public void execute();
}
public class FileOpenMenuItem extends JMenuItem implements Command{
    public void execute() {
    // your business logic goes here
  }
}
````
**Consequences**
<br/>
The Command pattern has the following consequences: 
- Command decouples the object that invokes the operation from the one that knows how to perform it.
- Commands are regular objects. They can be manipulated and extended like any other object.
- It's easy to add new Commands, because you don't have to change existing classes.
<hr/>

**Task**
<br/>
Design/implement a simple program with Command Pattern, which creates, scales, and moves a square by issuing commands. For example, „Create 5‟ will create a 5x5 square; „Scale 2‟ will make the sides of a square twice as long; „Move right 3‟ will move the position of a square to the right by 3, etc. Your program should also support „undo‟ to cancel a previous operation/command.    
[Task solution](../command/task)

