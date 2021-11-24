package Exercice2;

/**
 * Calcule la racine carrée d'un nombre positif
 */
public class Sqrt {
    public static double sqrt(double val) throws IllegalArgumentException {
        if(val > 0)
        {
            double x = val;
            double l = 0.0001;
     
            // The closed guess will be stored in the root
            double root;
        
            // To count the number of iterations
            int count = 0;
        
            while (true)
            {
                count++;
        
                // Calculate more closed x
                root = 0.5 * (x + (val / x));
        
                // Check for closeness
                if (Math.abs(root - x) < l)
                    break;
        
                // Update root
                x = root;
            }
     
            return root;
        }
        else if(val == 0)
        {
            return 0;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
