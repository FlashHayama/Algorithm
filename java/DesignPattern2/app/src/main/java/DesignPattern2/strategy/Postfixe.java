package DesignPattern2.strategy;

import java.util.ArrayList;

import DesignPattern2.composite.Expression;

public class Postfixe implements Crossing {
    private static Postfixe instance;

    private Postfixe(){}

    public static Postfixe Instance()
    {
        if(instance == null)
        {
            instance = new Postfixe();
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
