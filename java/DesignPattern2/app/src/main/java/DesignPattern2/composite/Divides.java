package DesignPattern2.composite;

final public class Divides extends Operation
{

    public /* constructor */ Divides(Expression[] exps)
    {
        super(exps);
        symbol = "div";
        neutral = 1;
    }

    public int op(int l, int r)
    {
        return (l / r);
    }

}
