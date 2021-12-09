package DesignPattern3;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

import DesignPattern3.food.Food;
import DesignPattern3.food.RestaurantFactory;
import DesignPattern3.food.fruits.Fruit;
import DesignPattern3.food.fruits.FruitFactory;
import DesignPattern3.food.legumes.LegumeFactory;
import DesignPattern3.food.legumes.Legumes;
import DesignPattern3.food.viandes.ViandeFactory;
import DesignPattern3.food.viandes.Viandes;

public class App {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        LegumeFactory legumeFactory = new LegumeFactory();
        ViandeFactory viandeFactory = new ViandeFactory();
        RestaurantFactory restaurantFactory = new RestaurantFactory();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice by typing X YYYY where X is the id of the shop and YYYY is the product name");
        System.out.println("1. Fruit shop");
        System.out.println("2. Legume shop");
        System.out.println("3. Viande shop");
        System.out.println("4. Restaurant");
        System.out.println("0 to exit");
        String product;
        int shop;

        ArrayList<Food> basket = new ArrayList<>();

        try {
            while (true) {
                System.out.print("Choose a shop: ");
                shop = sc.nextInt();
                if (shop == 0)
                    break;
                System.out.print("Choose a product: ");
                sc.nextLine();
                product = sc.next();

                switch (shop) {
                    case 1:
                        Fruit f = (Fruit)fruitFactory.createObject(product);
                        basket.add(f);
                        break;
                    case 2:
                        Legumes l = (Legumes)legumeFactory.createObject(product);
                        basket.add(l);
                        break;
                    case 3:
                        Viandes v = (Viandes)viandeFactory.createObject(product);
                        basket.add(v);
                        break;
                    case 4:
                        ArrayList<Food> fo = restaurantFactory.createObject(product);
                        basket.addAll(fo);
                        break;
                    default:
                        throw new Exception("Shop does not exist");
                }
            }

            computeTotalCost(basket);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void computeTotalCost(ArrayList<Food> b) {
        float result = 0f;
        for(Food f : b)
        {
            result += f.getPrice();
        }
        System.out.println("The total cost of basket is : " + result + "€");
    }
}
