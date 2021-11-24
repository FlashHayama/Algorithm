package Exercice2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.random.*;

/**
 * Suite de tests pour vérifier la méthode sqrt dans la classe Sqrt
 */
public class SqrtTest {
    
    @Test
    public void testOutValueGreaterThanZero()
    {
        Random r = new Random();
        double nbr = r.nextDouble(10000);
        double out = Sqrt.sqrt(nbr);
        assertTrue(out >= 0);
    }
    @Test
    public void testOutCorrectValue()
    {
        double epsilon = 0.0001;
        double out = Sqrt.sqrt(16);
        assertEquals(out, 4,epsilon);
    }
    @Test
    public void testLittleValue()
    {
        Random r = new Random();
        double nbr = r.nextDouble(0.001,1);
        double out = Sqrt.sqrt(nbr);
        assertTrue(nbr < out && out < 1);
    }
    @Test
    public void testValueUpperThanOne()
    {
        Random r = new Random();
        double nbr = r.nextDouble(1,10000);
        double out = Sqrt.sqrt(nbr);
        assertTrue(1 < out && out < nbr);
    }
    @Test
    public void testTerminalValue()
    {
        assertEquals(Sqrt.sqrt(0), 0);
        assertEquals(Sqrt.sqrt(1), 1);
    }
    @Test
    public void testVeryLongValue()
    {
        double epsilon = 0.0001;
        double nbr = 1e15;
        assertEquals(Sqrt.sqrt(nbr), 31622776.6016,epsilon);
    }
    @Test
    public void testIncorrectValue()
    {
        assertThrows(IllegalArgumentException.class, () -> {Sqrt.sqrt(-3);});
    }
}