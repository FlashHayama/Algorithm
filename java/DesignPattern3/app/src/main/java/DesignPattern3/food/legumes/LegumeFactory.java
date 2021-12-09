package DesignPattern3.food.legumes;

import DesignPattern3.food.Food;
import DesignPattern3.food.FoodFactory;

public class LegumeFactory implements FoodFactory{

    @Override
    public Food createObject(String product) throws Exception {
        if (product.equalsIgnoreCase("CAROTTE"))
            return new Carotte();
        else if (product.equalsIgnoreCase("SALADE"))
            return new Salade();
        else if (product.equalsIgnoreCase("AUBERGINE"))
            return new Aubergine();
        else
            throw new Exception(product + " does not exist");
    }
    
}
