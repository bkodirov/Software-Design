package builder.simple;

import builder.simple.domain.Meal;

/**
 * Client
 */
public class BuilderClient {
    public static void main(String[] args) {
        MealDirector md = new MealDirector(new ItalianMealBuilder());
        md.constructMeal();
        Meal meal = md.getMeal();
        System.out.println(meal);
        //see the difference between the 2 code
        md = new MealDirector(new MexicanMealBuilder()); md.constructMeal();
        meal = md.getMeal();
        System.out.println(meal);
    }
}