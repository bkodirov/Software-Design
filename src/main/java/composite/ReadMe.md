#**_Abstract Factory_**

**Intent**

Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

**Motivation**
- Your application needs to create different series of products that belong to different inheritance hierarchies (or suites/ families of related, dependent classes).
- You have a common interface to create all different families of products.

**Structure**
![Structure](https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Abstract_factory_UML.svg/1354px-Abstract_factory_UML.svg.png)

**Participants**

`AbstractFactory`
- declares an interface for operations that create abstract product objects.
`ConcreteFactory`
- implements the operations to create concrete product objects.
`AbstractProduct`
- declares an interface for a type of product object.
`ConcreteProduct`
- defines a product object to be created by the corresponding concrete factory.
- implements the Abstract Product interface.
`Client`
- uses only interfaces declared by AbstractFactory and AbstractProduct classes.

Consequences
- It isolates concrete classes. Product class names are isolated in the implementation of the concrete factory; they do not appear in client code.
- It makes exchanging product families easy. e. It promotes consistency among products.
- Supporting new kinds of products is difficult.

**Applicability**

Use the Abstract Factory pattern in any of the following situations:
- A system should be independent of how its products are created, composed, and represented.
- A class can't anticipate the class of objects it must create. 
- A system must use just one of a set of families of products.
- A family of related product objects is designed to be used together, and you need to enforce this constraint.

<hr/>

**Task**

Below is a high-level view of the browser architecture. We are going to implement a “render tree” for the rendering engine. A render tree is basically a data structure that stores all visual elements in an html document with the original relations, dimensions, stylings information kept (for example, parent- child/sibling relations, height, width, color, styles, etc.).
![Render process](http://i.imgur.com/rFmvv69.png)
The rendering engine processes/renders information in the following sequence. The “render tree” is created in the second “box” in the diagram.
![Structure](http://i.imgur.com/HcFJkL1.png)

[Task solution](../task)

