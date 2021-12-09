package DesignPattern2.strategy;

import java.util.ArrayList;

import DesignPattern2.composite.Expression;

public class Infixe implements Crossing {
    private static Infixe instance;

    private Infixe(){}

    public static Infixe Instance()
    {
        if(instance == null)
        {
            instance = new Infixe();
        }
        return instance;
    }

    @Override
    public ArrayList<Integer> collectNbs(Expression exp) {
        return null;
    }

    @Override
    public ArrayList<String> collectOps(Expression exp) {
        return null;
    }
}
