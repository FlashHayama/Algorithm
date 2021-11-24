/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Exercice4;

import Exercice4.statepattern.DigitalClock;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        DigitalClock clock = new DigitalClock();

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a button to use the clock (1, 2, 3, 9 for exit): ");
        int button;

        while (true) {

            button = sc.nextInt();
            sc.nextLine();

            if (button == 1)
                clock.b1();
            else if (button == 2)
                clock.b2();
            else if (button == 3)
                clock.b3();
            else if (button == 9)
                System.exit(0);
        }
    }
}
