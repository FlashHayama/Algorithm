package DesignPattern2.composite;

import DesignPattern2.strategy.Crossing;

final public class MyNumber implements Expression
{
	private int value;
  
	public /*constructor*/ MyNumber(int v)
	{
		value=v;
	}

	public int getValue()
	{
		return value;
	}
	
	@Override
	public int execute(Crossing cross) {
		return cross.execute(this);
	}
	
	public void print()
    {
		System.out.print(value + "");
	}
	
}

