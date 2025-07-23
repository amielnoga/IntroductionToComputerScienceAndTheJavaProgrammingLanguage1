
/**
 * class Petrol - converts car's petrol consumption measured in miles/gallon to liters/100Km.
 * Noga Matzliach
 * 01.04.2020
 */

import java.util.Scanner;

public class Petrol
{

    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);

        final int MAX=100; // Instrumental variable for Math.round function
        final double MILE_TO_KM=1.609, GALLON_TO_LITER=3.785;

        System.out.println ("Please enter the car's petrol consumption measured in miles/gallon:");
        double milesPerGallon = scan.nextDouble();

        /* In order to convert from km per liter to liter per km, we need to divide 1 by the number.
        To convert from liter per km to liter per 100 km we multipy by 100 */

        double beforeRounding=(1/(milesPerGallon*MILE_TO_KM/GALLON_TO_LITER))*100;
        double afterRounding = Math.round (beforeRounding * MAX) / (MAX * 1.0);

        System.out.println ("The car's petrol consumption converted to litres/100km is:");
        System.out.print (afterRounding);

    } // end of method main

} //end of class Petrol