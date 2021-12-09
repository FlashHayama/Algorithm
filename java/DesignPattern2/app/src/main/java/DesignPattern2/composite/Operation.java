package DesignPattern2.composite;

import java.util.ArrayList;

import DesignPattern2.strategy.Crossing;
import DesignPattern2.strategy.Postfixe;
import DesignPattern2.visitor.Calcul;

abstract public class Operation implements Expression
{
	private Expression[] exps;
	private Crossing strategy = Postfixe.Instance();

	protected String symbol;
	protected int neutral;
	protected ArrayList<Integer> nbs;
	protected ArrayList<String> ops;

	public /* constructor */ Operation(Expression[] exps)
	{
		this.exps = exps;
	}

	public Expression[] getExps()
	{
		return exps;
	}

	public void setStrategy(Crossing str){strategy = str;}

	abstract public int op(int l, int r);

	public int execute(Calcul calc)
	{
		return calc.execute(this);
	}

	public void collectOps(Crossing cross)
	{
		ops = cross.collectOps(this);
	}

	public void collectNbs(Crossing cross)
	{
		nbs = cross.collectNbs(this);
	}

	public void print()
	{
		int max = exps.length;
		System.out.print(symbol + "(");
		for(int i = 0; i < max - 1; i++)
		{
			exps[i].print();
			System.out.print(", ");
		}
		exps[max - 1].print();
		System.out.print(")");
	}
}
