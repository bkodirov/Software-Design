**_The Adapter Pattern_**

**Intent**

Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.

**Motivation**
- Sometimes a toolkit or class library cannot be used because its interface is incompatible with the interface required by an application
- We cannot change the library interface
- Even if we did have the source code, we should not change the library

**Structure**
- An adapter relies on object composition
![Structure](https://upload.wikimedia.org/wikipedia/commons/d/d7/ObjectAdapter.png)

**Participants**

- `Target` - Defines the domain-specific interface that Client uses. 
- `Adaptee` - Defines an existing interface that needs adapting. 
- `Adapter` - Adapts the interface of Adaptee to the Target interface. 
- `Client` - Collaborates with objects conforming to the Target
interface.

**Applicability**

Use the Adapter pattern when:
You want to use an existing class that performs similar functions but with a different interface. For example, a third-party report generator based on xml input.