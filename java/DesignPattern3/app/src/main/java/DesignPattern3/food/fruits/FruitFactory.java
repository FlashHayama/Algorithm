package DesignPattern3.food.fruits;

import DesignPattern3.food.Food;
import DesignPattern3.food.FoodFactory;

public class FruitFactory implements FoodFactory {

    public Food createObject(String product) throws Exception {
        if (product.equalsIgnoreCase("APPLE"))
            return new Apple();
        else if (product.equalsIgnoreCase("LEMON"))
            return new Lemon();
        else if (product.equalsIgnoreCase("STRAWBERRY"))
            return new Strawberry();
        else
            throw new Exception(product + " does not exist");

    }

}
