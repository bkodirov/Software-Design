#**_The Factory Method Pattern_**

**Intent**

Define an interface for creating an object, but let subclasses (concrete class that implements it) decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

**Motivation**

- Sometimes an object may only know that it needs an object of a certain type but does not know exactly which one from the set of subclasses of the parent class is to be selected.
- The choice of an appropriate class may depend on factors such as:
    - The state of the running application.
    - Application configuration settings.
    - Expansion of requirements or enhancements.
- Factory Method recommends encapsulating the functionality required, to select and instantiate an appropriate class, inside a designated method referred to as a factory method.
- A factory method can be defined as a method in a class that:
    - Selects an appropriate class from a class hierarchy based on the application context and other influencing factors.
    - Instantiates the selected class and returns it as an instance of the parent class type.

**Structure**
![Structure](https://sourcemaking.com/files/v2/content/patterns/Factory_Method.svg)

**Participants**

`Product`
- defines the interface of objects the factory method
creates.

`ConcreteProduct`
- implements the Product interface. 

`Creator`
- declares the factory method, which returns an object of
type Product. Creator may also define a default implementation of the factory method that returns a default ConcreteProduct object.
- may call the factory method to create a Product object.
 
`ConcreteCreator`
- overrides the factory method to return an instance of a
ConcreteProduct.

**Applicability**

Use the Factory Method pattern when:
- A class can't anticipate the class of objects it must create.
- A class wants its subclasses to specify the objects it creates. 
- Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.

**Consequences**
- Factory methods eliminate the need to bind application- specific classes into your client code. The client code only deals with the Product interface; therefore it can work with any user-defined concrete product classes.
- Any change in a concrete product class does not have any impact on the client code.
