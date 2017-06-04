package cor.simple;

public class ChainBuilder {
    private AbstractHandler handler;


    //other necessary code here
    public void buildChain() {
        AbstractHandler junior = new IllegalArgumentExceptionHandler();
        AbstractHandler senior = new RuntimeExceptionHandler();
        AbstractHandler supervisor = new ThrowableHandler();
        junior.nextAgent = senior;
        senior.nextAgent = supervisor;
        handler = junior;
    }

    public AbstractHandler getHandler() {
        return handler;
    }
}