package DesignPattern2.visitor;

import DesignPattern2.composite.Expression;

public interface Calcul {
    int execute(Expression exp);
}
