package DesignPattern2.visitor;

import DesignPattern2.composite.Expression;
import DesignPattern2.composite.MyNumber;
import DesignPattern2.composite.Operation;

public class Compute implements Calcul {

    @Override
    public int execute(Expression exp) {
        if(exp instanceof MyNumber){
            MyNumber num = (MyNumber)exp;
            return num.getValue();
        }
        Operation operation = (Operation)exp;
        Expression[] exps = operation.getExps();
        int max = exps.length;
		int result = exps[0].execute(this);
		for(int i = 1; i < max; i++)
		{
			result = operation.op(result, exps[i].execute(this));
		}
		return result;
    }
}
