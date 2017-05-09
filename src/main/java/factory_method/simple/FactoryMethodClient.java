package factory_method.simple;

/**
 * Client
 */
public class FactoryMethodClient {
    public static void main(String[] args) {
        PizzaFactory factory = SimplePizzaFactory.getFactory();
        Pizza pizza = factory.createPizza("cheese");
        //different from below on when the decision has to be made - runtime or compile time?
        //which is one difference between framework and application development
        Pizza pizza1 = new CheesePizza();
        System.out.println(pizza.getClass().getSimpleName());
    }
}