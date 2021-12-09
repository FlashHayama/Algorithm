package DesignPattern3.food.viandes;

import DesignPattern3.food.Food;
import DesignPattern3.food.FoodFactory;

public class ViandeFactory implements FoodFactory {
    @Override
    public Food createObject(String product) throws Exception {
        if (product.equalsIgnoreCase("BOEUF"))
            return new Boeuf();
        else if (product.equalsIgnoreCase("POULET"))
            return new Poulet();
        else if (product.equalsIgnoreCase("PORC"))
            return new Porc();
        else
            throw new Exception(product + " does not exist");
    }
}
