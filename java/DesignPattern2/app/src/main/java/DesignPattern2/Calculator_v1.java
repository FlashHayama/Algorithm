package DesignPattern2;

import DesignPattern2.composite.Divides;
import DesignPattern2.composite.Expression;
import DesignPattern2.composite.Minus;
import DesignPattern2.composite.MyNumber;
import DesignPattern2.composite.Operation;
import DesignPattern2.composite.Plus;
import DesignPattern2.composite.Times;
import DesignPattern2.visitor.Compute;
import DesignPattern2.visitor.CountDepth;
import DesignPattern2.visitor.CountNbs;
import DesignPattern2.visitor.CountOps;

public class Calculator_v1
{

    private static void displayResult(Operation o)
    {
        System.out.println("The result of the operation:");
        o.print();
        System.out.println("is: " + o.execute(new Compute()));
        System.out.println("The number of this operation is: " + o.execute(new CountOps()));
        System.out.println("The number of numbers is: " + o.execute(new CountNbs()));
        System.out.println("The number of Depth is: " + o.execute(new CountDepth()));
        System.out.println();
    }

    // Here is an example of how to use the calculator:
    public static void main(String args[])
    {
        Operation plus = new Plus(new Expression[]{new MyNumber(5),new MyNumber(4),new MyNumber(6),new MyNumber(10)});//25
        Operation divide = new Divides(new Expression[]{new MyNumber(100),new MyNumber(5),new MyNumber(2)});//10
        Operation minus = new Minus(new Expression[]{plus, new MyNumber(1),divide});//14
        Operation times = new Times(new Expression[]{minus, new MyNumber(2), new MyNumber(10)});//280
        displayResult(times);
    }

}
