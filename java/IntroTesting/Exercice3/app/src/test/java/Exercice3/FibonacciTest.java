package Exercice3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FibonacciTest {
    @Test
    public void test1() {
        assertNotEquals(Fibonacci.fibo(2), 2);
    }

    @Test 
    public void test2() {
        assertThrows(IllegalArgumentException.class, () -> {Fibonacci.fibo(-2);});
    }

    @Test 
    public void test3() {
        assertTrue(Fibonacci.fibo(4) == 3);
    }

    @Test
    @Timeout(1000)
    public void test4(){
        Fibonacci.fibo(1000);
    }
}
