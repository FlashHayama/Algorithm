package DesignPattern2.composite;

final public class Plus extends Operation
{

    public /* constructor */ Plus(Expression[] exps)
    {
        super(exps);
        symbol = "+";
        neutral = 0;
    }

    public int op(int l, int r)
    {
        return (l + r);
    }
}
