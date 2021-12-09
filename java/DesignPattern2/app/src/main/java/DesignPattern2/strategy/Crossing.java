package DesignPattern2.strategy;

import java.util.ArrayList;

import DesignPattern2.composite.Expression;

public interface Crossing {
    ArrayList<Integer> collectNbs(Expression exp);
    ArrayList<String> collectOps(Expression exp);
}
