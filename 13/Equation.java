
import java.util.Scanner;
import java.lang.Object;

/**
 * class Equation - the class gets quadratic equation and prints the number of solutions of the equation 
 *                  the class using Rational class
 *
 * @author Noga Matzliach
 * @version 27.4.2020
 */

public class Equation
{
    public static void main (String[]args)
    {
        Scanner scan= new Scanner(System.in);

        Rational a,b,c; // The coefficients of the quadratic equation
        Rational delta=new Rational(); // represent the discriminant
        Rational x1=new Rational(); //the result of quadratic equation when there is only one solution
        int deltaNum; 

        // constants for the root formula
        Rational ZERO=new Rational();
        Rational FOUR=new Rational(4,1);
        Rational ONEMINUES=new Rational(-1,1);
        Rational TWO=new Rational(2,1);

        System.out.println("The program calculates the number of solutions of a quadratic equation (ax^2+bx+c=0)");
        System.out.println("Enter 3 pairs of integers (each pair represents a coefficient a,b,c respectively)");

        a= new Rational(scan.nextInt(),scan.nextInt());
        b= new Rational(scan.nextInt(),scan.nextInt());
        c= new Rational(scan.nextInt(),scan.nextInt());

        delta=((b.multiply(b)).subtract(FOUR.multiply(a.multiply(c))));

        // numerator "soters" the sign (as you can see in page 329 in the book)
        deltaNum=delta.getNum();

        // Divide by 0 is not allowed and negative numbers must not be rooted in the world of real numbers
        if (a.equals(ZERO) || deltaNum<0)
            System.out.println("There isn't solution");

        else if (deltaNum>0)
            System.out.println("There are two solutions");

        else //delta=0
        {
            x1=(ONEMINUES.multiply(b)).divide(TWO.multiply(a)); //root formula (delta is zero) 
            System.out.println("There is only one solution: x="+x1);
        }
    }
}
