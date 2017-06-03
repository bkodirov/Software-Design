#**_Iterator Pattern_**

**Intent**
<br/>
Provide a way to access the elements of an aggregate object (collection) sequentially without exposing its underlying representation

**Motivation**
<br/>
- An aggregate object such as a list or hash map should allow a way to traverse its elements without exposing its internal structure.
- It should allow different traversal methods depending on what the client needs (for example by using a functor).
- It should allow concurrent access by multiple threads. 
- But we want to take the responsibility for access and traversal out of the aggregate object and put it into an Iterator object.

**Structure**
![Structure](http://www.dofactory.com/images/diagrams/net/iterator.gif)

**Participants**
<br/>
`Iterator` - defines an interface for accessing and traversing elements.
<br/>
`ConcreteIterator`
- implements the Iterator interface.
- keeps track of the current position in the traversal of the aggregate.
<br/>
`Agrregate` - defines an interface for creating an Iterator object.
<br/>
`ConcreteAggregate` - implements the Iterator creation interface to return an instance of the proper ConcreteIterator.
<br/>

**Applicability.**  
Use the Iterator pattern:
<br/>
- To support traversals of aggregate objects without exposing their internal representation.
- To support multiple, concurrent traversals of aggregate objects.
- To provide a uniform interface for traversing different aggregate structures to support polymorphic iteration

**Consequences**
- Simplifies the interface of the aggregate by not polluting it with traversal methods
- Supports multiple, concurrent traversals
- Supports variant traversal techniques


<hr/>

**Task**
<br/>
Suppose the name repository in the above example uses a 2-dimensional array to store the names. Names can be dynamically added or removed from it. When you remove a name, you simply replace the name with a “-”. (You do not need to implement the add/remove methods though). Rewrite the NameIterator class that implements the same Iterator interface. But make sure that a “-” is never returned by the next() method.
[Task solution](../iterator/task)

