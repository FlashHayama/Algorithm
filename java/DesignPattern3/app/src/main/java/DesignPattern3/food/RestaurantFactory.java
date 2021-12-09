package DesignPattern3.food;

import java.util.ArrayList;
import java.util.Random;

import org.checkerframework.checker.index.qual.LessThan;

import DesignPattern3.food.legumes.*;
import DesignPattern3.food.viandes.*;
import DesignPattern3.food.fruits.*;

public class RestaurantFactory {

    public ArrayList<Food> createObject(String product) throws Exception {
        ArrayList<Food> lst = new ArrayList<Food>();
        if (product.equalsIgnoreCase("WINTER"))
        {
            lst.add(new Carotte());lst.add(new Apple());lst.add(new Boeuf());
            return lst;
        }
        else if (product.equalsIgnoreCase("SUMMER"))
        {
            lst.add(new Salade());lst.add(new Lemon());lst.add(new Porc());
            return lst;
        }
        else if (product.equalsIgnoreCase("autumns"))
        {
            lst.add(new Aubergine());lst.add(new Strawberry());lst.add(new Poulet());
            return lst;
        }
        else if (product.equalsIgnoreCase("RANDOM"))
        {
            Random r = new Random();
            Legumes[] l = {new Carotte(),new Aubergine(),new Salade()};
            Fruit[] f = {new Apple(),new Lemon(),new Strawberry()};
            Viandes[] v = {new Boeuf(),new Poulet(),new Porc()};
            int i = r.nextInt(l.length);
            int j = r.nextInt(f.length);
            int k = r.nextInt(v.length);
            lst.add(l[i]);lst.add(f[j]);lst.add(v[k]);
            return lst;
        }
        else
            throw new Exception(product + " does not exist");
    }
    
}
