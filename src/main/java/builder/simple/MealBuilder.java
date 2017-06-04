package builder.simple;

import builder.simple.domain.Meal;

/**
 * Builder interface
 */
public interface MealBuilder {
    void buildDrink();
    void buildMainDish();
    void buildSideDish();
    Meal getMeal();
}