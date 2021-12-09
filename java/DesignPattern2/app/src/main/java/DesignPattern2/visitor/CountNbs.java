package DesignPattern2.visitor;

import DesignPattern2.composite.Expression;
import DesignPattern2.composite.MyNumber;
import DesignPattern2.composite.Operation;

public class CountNbs implements Calcul {

    @Override
    public int execute(Expression exp) {
        if(exp instanceof MyNumber)
            return 1;
        Operation operation = (Operation)exp;
        Expression[] exps = operation.getExps();
        int max = exps.length;
		int result = 0; 
		for(int i = 0; i < max; i++)
		{
			result = result + exps[i].execute(this);
		}
		return result;
    }
    
}
