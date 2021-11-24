package Exercice1;

public class SolveEquation {
    private double a, b, c;
    public SolveEquation (double a, double b, double c){
        /* CONSTRUCTOR ’S BODY */ 
    }
    /* * Gives the number of solutions of the equation .
    * @return the number of solution .
    * @throws ArithmeticException if there
    is an infinite number of solutions . */
    public int getNbSolutions ()
        throws ArithmeticException {
        /* METHOD ’S BODY */ 
        return -1;
    }
    /* * Gives the equation ’s solutions for x .
    * @return the 2 solutions of the equation . If there is
    * only 1 solution , the 2 members of the pair are equal .
    * @throws ArithmeticException if there is no real
    * solution for x , or if there is an infinite number
    * of solutions . */
    public Pair<Double> getSolutions ()
        throws ArithmeticException {
        /* METHOD ’S BODY */ 
        //throw new ArithmeticException();
        return new Pair<Double>(-1.0,-1.1);
    }
}
