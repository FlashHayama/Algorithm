package DesignPattern2.strategy;

import DesignPattern2.composite.Expression;
import DesignPattern2.composite.MyNumber;
import DesignPattern2.composite.Operation;

public class CountOps implements Crossing {

    @Override
    public int execute(Expression exp) {
        if(exp instanceof MyNumber)
            return 0;
        Operation operation = (Operation)exp;
        Expression[] exps = operation.getExps();
        int max = exps.length;
		int result = 1; 
		for(int i = 0; i < max; i++)
		{
			result = result + exps[i].execute(this);
		}
		return result;
    }
    
}
