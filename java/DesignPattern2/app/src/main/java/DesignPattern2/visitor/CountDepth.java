package DesignPattern2.visitor;

import DesignPattern2.composite.Expression;
import DesignPattern2.composite.MyNumber;
import DesignPattern2.composite.Operation;

public class CountDepth implements Crossing {

    @Override
    public int execute(Expression exp) {
        if(exp instanceof MyNumber)
            return 0;
        Operation operation = (Operation)exp;
        Expression[] exps = operation.getExps();
        int max = exps.length;
		int result = 0;
		int depth = 1;
		for(int i = 0; i < max; i++)
		{
			result = 1 + exps[i].execute(this);
			if(result > depth)
				depth = result;
		}
		return depth;
    }
    
}
