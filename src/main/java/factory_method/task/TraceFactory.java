package factory_method.task;

/**
 * Created by Beka on 10.04.17.
 */
public interface TraceFactory {
    Trace getTracer(String type);
}
