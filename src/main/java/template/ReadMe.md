#**_Template Method_**

**Intent**

Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

**Motivation**

Sometimes you want to specify the order of operations that a method uses, but allow subclasses to provide their own implementations of some of these operations

**Structure**
- An adapter relies on object composition
![Structure](https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Template_Method_UML.svg/600px-Template_Method_UML.svg.png)

**Participants**

`AbstractClass`
- Defines abstract primitive operations that concrete
subclasses define to implement steps of an algorithm.
- Implements a template method defining the skeleton of
an algorithm. The template method calls primitive operations as well as operations defined in AbstractClass or those of other objects.

`ConcreteClass`
- Implements the primitive operations to carry out
subclass-specific steps of the algorithm.


**Applicability**

- To implement the invariant parts of an algorithm once and
leave it up to subclasses to implement the behavior that can
vary.
- To localize common behavior among subclasses and place
it in a common class (in this case, a superclass) to avoid code duplication. This is a classic example of “code refactoring.”
- To control how subclasses extend superclass operations. You can define a template method that calls "hook" operations at specific points, thereby permitting extensions only at those points. The Template Method is a fundamental technique for code reuse.
