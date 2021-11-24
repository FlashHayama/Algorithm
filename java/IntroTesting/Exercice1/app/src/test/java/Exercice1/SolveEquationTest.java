package Exercice1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class SolveEquationTest {
    @Test
    @DisplayName("Test getNbSolution fonction with 2 equals solution in SolveEquation")
    public void test1 () {
        SolveEquation se = new SolveEquation(1.0, -2.0, -3.0);
        assertEquals(se.getNbSolutions(), 2);
        assertTrue(se.getSolutions().isIdenticalPair());
    }
    @Test
    @DisplayName("Test getNbSolution fonction with 1 solution in SolveEquation")
    public void test2 () {
        double epsilon =0.0001;
        SolveEquation se = new SolveEquation(1.0, 0.0, 0.0);
        assertEquals(se.getSolutions().getE1(),
            se.getSolutions().getE2(), epsilon);
        assertEquals(se.getNbSolutions(), 1);
    }
    @Test
    @DisplayName("Test 2 equals solution")
    public void test3 () {
        SolveEquation se = new SolveEquation(5.0, 0.0, 3.0);
        assertEquals(se.getSolutions().getE1(),
            se.getSolutions().getE2());
    }
    @Test
    @DisplayName("Test number solution with equation : 3x²=0")
    public void test4(){
        SolveEquation se = new SolveEquation(3, 0, 0);
        assertEquals(se.getNbSolutions(),1);
    }
    @Test
    @DisplayName("Test Arithmetic exception with equation without root")
    public void test5(){
        SolveEquation se = new SolveEquation(0, 0, 0);
        assertThrows(ArithmeticException.class, () -> {se.getSolutions();});
    }
}
