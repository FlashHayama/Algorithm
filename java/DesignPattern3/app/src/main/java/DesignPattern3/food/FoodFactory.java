package DesignPattern3.food;

public interface FoodFactory {
    Food createObject(String product) throws Exception;
}
