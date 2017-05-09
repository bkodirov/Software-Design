#**_The Prototype pattern_**
Programmers create a new object by cloning the prototypical instance to avoid resource-intensive operations or repeating the complex logic in building it every time. Thus the Prototype Pattern decouples the client from knowing all the details of the product classes it is dealing with.

**Intent**

Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

**Motivation**

- The Prototype Pattern allows you to make new instances by copying existing/template instances.
- When your application has to create objects without knowing their type or any details of how to create them. 
- When creating a large/complex object that is resource intensive, cloning works better than using the constructor sometimes.

**Structure**
![Structure](https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Prototype_UML.svg/1200px-Prototype_UML.svg.png)

**Participants**

`Prototype`
- declares an interface for cloning itself.

`ConcretePrototype`
- implementsanoperationforcloningitself.

`Client`
- creates a new object by asking a prototype to clone itself.


**Applicability**

Use the Prototype pattern when a system should be independent of how its products are created, composed, and represented (think about scenario1 for the Proxy pattern); and
- when the classes to instantiate are specified at run-time,
for example, by dynamic loading; or
- To avoid building a class hierarchy of factories that
parallels the class hierarchy of products; or

**Scenarios in real life:**
- Copy and Paste: copy an image and press „ctrl+v‟ many times, you get multiple copies of it.
- In Word when you select „Insert->Symbol‟, you get a symbol inserted into your document (like ≠, √, ≥).
- When an employer hires employees, they give each a copy of the employment contract made out of the „contract template‟.
- A trading company gives samples of products (simple enough to replicate) to its partner factory, the factory produces large quantities of them.
- 3D printing.

**Consequences**
- It hides the concrete product classes from the client, thereby reducing the number of names clients know about.
- It lets a client work with application-specific classes without modification.
- Prototypes let you incorporate a new concrete product class into a system simply by registering a prototypical instance with the client. That's a bit more flexible than other creational patterns, because a client can install and remove prototypes at run-time.
- A client can exhibit new behavior by delegating responsibility to the prototype.
- This kind of design lets users define new "classes" without programming.
- Factory Method often produces a hierarchy of Creator classes that parallels the product class hierarchy. The Prototype pattern lets you clone a prototype instead of asking a factory method to make a new object. Hence you don't need a Creator class hierarchy at all