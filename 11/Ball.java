import java.util.Scanner;

/**
 * class Ball - calculates the volume and surface area of a ball
 * Noga Matzliach
 * 01.04.2020
 */

public class Ball
{
    public static void main (String[]args)
    {

        Scanner scan = new Scanner (System.in);

        int radius;
        double surfaceArea, volume;
        final int MAX=100; // Instrumental variable for Math.round function

        System.out.println("Please enter the Ball's radius:");
        radius = scan.nextInt();

        surfaceArea=Math.round(4*Math.PI*Math.pow(radius,2)*MAX)/(MAX*1.0);
        System.out.println("The Balls surface area is:");
        System.out.println(surfaceArea);

        volume=Math.round(4*Math.PI*Math.pow(radius,3)/3*MAX)/(MAX*1.0);
        System.out.println("The volume of the Ball is:");
        System.out.println(volume);

    }
}