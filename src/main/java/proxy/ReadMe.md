#**_The Proxy Pattern_**

**Intent**

Provide a surrogate or placeholder for another object to control access to it.

**Motivation**
- To defer the full cost of its creation and initialization until we actually need to use it.
- There are situations in which a client does not or cannot reference an object directly, but wants to still interact with the object.
- A proxy object can act as the intermediary between the client and the target object.

**Structure**
- An adapter relies on object composition
![Structure](https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Proxy_pattern_diagram.svg/800px-Proxy_pattern_diagram.svg.png)

**Participants**

`Proxy`
- maintains a reference that allows the proxy to access the
real subject.
- provides an interface identical to Subject's so that a
proxy can be substituted for the real subject.
- controls access to the real subject and may be
responsible for creating and deleting it.
- other responsibilities depend on the kind of proxy:
    - Remote proxies are responsible for encoding a request and its arguments and for sending the encoded request to the real subject in a different address space;
    - Virtual proxies may cache additional information about the real subject so that they can postpone accessing it; 
    - Protection proxies check that the caller has the access permissions required to perform a request.

 
`Subject`
- defines the common interface for RealSubject and Proxy
so that a Proxy can be used anywhere a RealSubject is expected.

`RealSubject`
- defines the real object that the proxy represents.

**Applicability**

Proxy is applicable whenever there is a need for a more versatile or sophisticated reference to an object than a simple pointer. Here are several situations where the Proxy pattern is applicable:
- `Remote Proxy` - Provides a reference to an object located in a different address space on the same or different machine. 
- `Protection` (Access) Proxy - Provides different clients with different levels of access to a target object.
- `Cache Proxy` - Provides temporary storage of the results of expensive target operations so that multiple clients can share the results.
