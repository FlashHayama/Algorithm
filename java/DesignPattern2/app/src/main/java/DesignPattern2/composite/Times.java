package DesignPattern2.composite;

final public class Times extends Operation
{

    public /* constructor */ Times(Expression[] exps)
    {
        super(exps);
        symbol = "*";
        neutral = 1;
    }

    public int op(int l, int r)
    {
        return (l * r);
    }

}
