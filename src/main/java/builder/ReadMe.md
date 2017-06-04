#**_Builder Pattern_**

**Intent**
<br/>
Separate the construction of a complex object from its representation so that the same construction process can create different representations.

**Motivation**
<br/>
- Your application needs to create complex objects with many attributes of both primitive and reference types. 
- Instead of having a constructor that takes all of them as parameters, you choose a step-by-step approach to construct the complex object.
- You want to avoid creating a partially initiated object instance.
- Your construction process stays the same for creating a series of related products.

**Structure**
![Structure](https://ranjithabalaraman.files.wordpress.com/2014/06/structure.png)

**Participants**
<br/>
`Builder` - Specifies an abstract interface for creating parts of a Product object.
<br/>
`ConcreteBuilder`
 - Constructs and assembles parts of the product by implementing the Builder interface.
 - Defines and keeps track of the representation it creates.
 - Provides an interface for retrieving the product.
<br/>
`Director` - Constructs an object using the Builder interface.
<br/>
`Product` 
- Represents the complex object under construction. ConcreteBuilder builds the product's internal representation and defines the process by which it's assembled.
- Includes classes that define the constituent parts, including interfaces for assembling the parts into the final result.
<br/>
`Client` - creates a ConcreteCommand object and sets its receiver.
<br/>

**Applicability.**  
<br/>
Use the Builder pattern when:
<br/>
- the algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
- the construction process must allow different representations for the object that's constructed.

**Consequences**
<br/>
- It lets you vary a product's internal representation. The Builder interface only provides the director the steps for constructing the product without telling how the product gets assembled.
- It isolates code for construction and representation. Clients do not need to know anything about the classes that define the product's internal structure. Each Concrete Builder contains all the code to create and assemble a particular kind of product.
- It gives you finer control over the construction process (step-by-step vs construction in one shot as other creational patterns do), thus gives you finer control over the construction process and consequently the internal structure of the resulting product.
<hr/>

**Task**
<br/>
Design/implement a simple program with Command Pattern, which creates, scales, and moves a square by issuing commands. For example, „Create 5‟ will create a 5x5 square; „Scale 2‟ will make the sides of a square twice as long; „Move right 3‟ will move the position of a square to the right by 3, etc. Your program should also support „undo‟ to cancel a previous operation/command.    
[Task solution](../builder/task)

