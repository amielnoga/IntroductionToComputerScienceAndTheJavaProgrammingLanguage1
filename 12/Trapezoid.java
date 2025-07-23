import java.util.Scanner;
/**
 * class Trapezoid calculates the area and the circumference of trapezoid
 *
 * @Noga Matzliach
 * @09.04.2020
 */
public class Trapezoid
{
    public static void main (String[]args)
    {
      int xA, yA, aToBLength, xD, yD, cToDLength; // Coordinates from the user A(x,y) an D(x,y)
      int xB, yB, xC, yC; // Coordinates that our program calculatr from the user data B(x,y) an C(x,y)
      double area, circumference;
      double distanceAToD, distanceCToB;
      int height;
      final int EXPONENT_FOR_DISTANCE=2; 
      final double DIVISOR_FOR_AREA=2.0; 
      
      Scanner scan= new Scanner (System.in);
      
      System.out.println("Please enter the left point coordinates of the base followed by its length:");
      xA=scan.nextInt();
      yA=scan.nextInt();
      aToBLength=scan.nextInt();
      
      System.out.println("Please enter the left point coordinates of the other base followed by its length:");
      xD=scan.nextInt();
      yD=scan.nextInt();
      cToDLength=scan.nextInt();
      
      //calaculating B(x,y)
      yB=yA;
      xB=xA+aToBLength;
      
      //calaculating C(x,y)
      xC=xD+cToDLength;
      yC=yD;
      
      // Auxiliary calculations for trapezoid circumference
      distanceAToD=Math.sqrt(Math.pow((xA-xD),EXPONENT_FOR_DISTANCE)+Math.pow((yA-yD),EXPONENT_FOR_DISTANCE));
      distanceCToB=Math.sqrt(Math.pow((xC-xB),EXPONENT_FOR_DISTANCE)+Math.pow((yC-yB),EXPONENT_FOR_DISTANCE));
       
      circumference=aToBLength+cToDLength+distanceAToD+distanceCToB;
      
      height=Math.abs(yD-yA);
      
      area=(height*(aToBLength+cToDLength))/DIVISOR_FOR_AREA;
       
      System.out.println("The area of the trapezoid is "+area);
      System.out.println("The perimeter of the trapezoid is "+circumference);
       
    }
}
