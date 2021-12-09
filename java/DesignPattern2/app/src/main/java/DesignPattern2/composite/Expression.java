package DesignPattern2.composite;

import DesignPattern2.visitor.Calcul;

public interface Expression {
    public int execute(Calcul cross);
    public void print();
}
