#**_Chain Of Responsibility Pattern_**

**Intent**
<br/>
Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.

**Motivation**
<br/>
- From the client‟s perspective, a request needs to be handled.
- From the handlers‟ perspective, there are multiple resources with different skills, different roles, or different responsibilities organized in a chain structure.
- These resources only know their successors (whom to pass the request to if they are not able to handle it). And each resource has only one successor or none if it is the last in the chain.
- Request processing always starts from the first resource in the chain. If request gets processed, the work for processing the request terminates right away. If not, the request is passed to its successor.
- The client always expects all requests get handled.

**Structure**
![Structure](http://paginas.fe.up.pt/~aaguiar/as/gof/hires/Pictures/chain094.gif)
![Structure](http://eprogrammerz.com/wp-content/uploads/2016/04/chain-of-responsibility-general.png)

**Participants**
<br/>
`Handler`
 - defines an interface for handling requests. 
 - (optional) implements the successor link.
<br/>
`ConcreteHandler`
 - Handles requests it is responsible for.
 - Holds a reference to its successor.
 - If the ConcreteHandler can handle the request, it does so; otherwise it forwards the request to its successor.
<br/>
`Client` - Initiates the request to a ConcreteHandler object in the chain.
<br/>

**Applicability.**  
<br/>
Use Chain of Responsibility:
<br/>
- When more than one object may handle a request and the actual handler is not known in advance.
- You want to issue a request to one of several objects without specifying the receiver explicitly.
- The set of objects that can handle a request should be specified dynamically.
- When you process requests with a “handle or forward” model.

**Consequences**
<br/>
- Reduced coupling between the sender of a request and the receiver - the sender and receiver have no explicit knowledge of each other (except that the sender knows about the first one in the chain).
- Added flexibility in assigning responsibilities to objects. Chain of Responsibility gives you added flexibility in distributing responsibilities among objects. You can add or change responsibilities for handling a request by adding to or otherwise changing the chain at run-time.
- The chain does not consider how receipt is guaranteed - a request could fall off the end of the chain without being handled.

<hr/>

**Task**
<br/>
Create an application(Document) review process hierarchy of University. Use Chain of Responsibility pattern.    
[Task solution](../cor/task)

