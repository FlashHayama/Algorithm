package DesignPattern2.composite;

import DesignPattern2.strategy.Crossing;

abstract public class Operation implements Expression
{
	private Expression[] exps;
	protected String symbol;
	protected int neutral;

	public /* constructor */ Operation(Expression[] exps)
	{
		this.exps = exps;
	}

	public Expression[] getExps()
	{
		return exps;
	}

	abstract public int op(int l, int r);

	public int execute(Crossing cross)
	{
		return cross.execute(this);
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
