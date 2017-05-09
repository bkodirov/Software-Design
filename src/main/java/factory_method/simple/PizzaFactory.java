package factory_method.simple;

/**
 * Factory interface (or an abstract class)
 */
public interface PizzaFactory {
Pizza createPizza(String type);
}