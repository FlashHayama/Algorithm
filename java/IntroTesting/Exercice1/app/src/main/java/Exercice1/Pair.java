package Exercice1;

public class Pair<T> {
    private T e1, e2;
    public Pair (T e1, T e2) {
        this.e1 = e1;
        this.e2 = e2; 
    }
    public T getE1 () { return e1; }
    public T getE2 () { return e2; }

    public boolean isIdenticalPair () {
        return e1.equals(e2); 
    }
}
