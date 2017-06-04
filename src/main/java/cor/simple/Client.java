package cor.simple;

/**
 * Set up the chain and handle request
 */
public class Client {


    public Client() {
    }

    public void sendRequest(Throwable throwable) {
        //can be injected or received from a constructor
        ChainBuilder chain;
        chain=new ChainBuilder();
        chain.buildChain();
        chain.getHandler().handle(throwable);
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.sendRequest(new IllegalArgumentException());
    }
}
