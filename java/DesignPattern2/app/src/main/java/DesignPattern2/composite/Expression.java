package DesignPattern2.composite;

import DesignPattern2.visitor.Crossing;

public interface Expression {
    public int execute(Crossing cross);
    public void print();
}
