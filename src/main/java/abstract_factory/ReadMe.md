#**_Abstract Factory_**

**Intent**

Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

**Motivation**
- Your application needs to create different series of products that belong to different inheritance hierarchies (or suites/ families of related, dependent classes).
- You have a common interface to create all different families of products.

**Structure**
![Structure](https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Abstract_factory_UML.svg/1354px-Abstract_factory_UML.svg.png)

**Participants**

`AbstractFactory` - declares an interface for operations that create abstract product objects.
`ConcreteFactory` - implements the operations to create concrete product objects.
`AbstractProduct` - declares an interface for a type of product object.
<br/>
`ConcreteProduct`
- defines a product object to be created by the corresponding concrete factory.
- implements the Abstract Product interface.

`Client` - uses only interfaces declared by AbstractFactory and AbstractProduct classes.

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

An online business sells gift items to both individuals and businesses. Each order is treated as a gift pack that may contain 1 or more gift items. When a customer places an order, the type of the gift pack has to be specified as one of the 3 - Business, Adults, or Kids. Depending on the gift pack type, each individual gift item needs to be packaged accordingly. For example, a gift item for a kid can be packaged with a „Micky Gift Bag‟, or a „Cartoon Box‟ or the „Happy Kid‟ gift wrap which has a different cost associated with each option (selected by the person placing the order). For now, there are only 3 available options – gift bag, gift box or gift wrap. For the Business type, the options are „Merchant Collection‟ bag, „Hard Plastic‟ box and „Holiday Surprise‟ wrap. For the Adults, they „Reusable Shopper‟ bag, „Plain Paper‟ box, and „Everyday Value‟ wrap. Prices as listed below.
![Structure](http://i.imgur.com/s1Hcd1q.png)
Suppose you are going to create a model and implement it with the Abstract Factory Pattern for the business to easily get packaging instructions and calculate the packaging cost from each of the orders. Also provide a client program that prints the packing instructions and the total packaging cost for each gift pack.

[Task solution](https://github.com/bkodirov/Software-Design/tree/master/src/main/java/abstract_factory/task)

