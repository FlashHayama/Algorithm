package DesignPattern2.composite;

final public class Minus extends Operation
{

    public /* constructor */ Minus(Expression[] exps)
    {
        super(exps);
        symbol = "-";
        neutral = 0;
    }

    public int op(int l, int r)
    {
        return (l - r);
    }
}
