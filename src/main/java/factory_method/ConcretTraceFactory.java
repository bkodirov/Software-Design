package factory_method;

/**
 * Created by Beka on 10.04.17.
 */
public class ConcretTraceFactory implements TraceFactory {
    @Override
    public Trace getTracer(String type) {
        switch (type) {
            case "trace.log":
                return new ConsoleTrace();
            case "console":
                return new FileTrace();
        }
        return null;
    }
}
