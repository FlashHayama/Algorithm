package DesignPattern2.strategy;

import java.util.ArrayList;

import DesignPattern2.composite.Expression;

public class Prefixe implements Crossing {
    private static Prefixe instance;

    private Prefixe(){}

    public static Prefixe Instance()
    {
        if(instance == null)
        {
            instance = new Prefixe();
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
