import java.util.Scanner;
/**
 * The Program do conversion between common scales:
 *  Celsius, Fahrenheit, Kelvin
 * @ Noga Matzliach
 * @ 09.04.2020
 */
public class Temperature
{
    public static void main(String[]args)
    {
        String word;
        char c;
        double celsiusTemperature, fahrenheitTemperature, kelvinTemperature;
        final double CELSIUSUS_TO_KELVIN=273.15, KELVIN_TO_FAHRENHEIT=(double)9/5, KELVIN_TO_FAHRENHEIT2=32, FAHRENHEIT_TO_CELSIUS=(double)5/9;
        final double KELVIN_TO_FAHRENHEIT3=CELSIUSUS_TO_KELVIN,FAHRENHEIT_TO_CELSIUS2=KELVIN_TO_FAHRENHEIT2;
        Scanner scan= new Scanner (System.in);
       
       
        System.out.println("Please enter the scale followed by the temperature:");
        word=scan.next();
        c=word.charAt(0);
        
        switch (c)
        {
            case 'C':
            {
                celsiusTemperature=scan.nextDouble();
                kelvinTemperature=celsiusTemperature+CELSIUSUS_TO_KELVIN;
                fahrenheitTemperature=KELVIN_TO_FAHRENHEIT*(kelvinTemperature-KELVIN_TO_FAHRENHEIT3)+KELVIN_TO_FAHRENHEIT2;
                break;
            }
            case 'F':
            {
                fahrenheitTemperature=scan.nextDouble();
                celsiusTemperature= FAHRENHEIT_TO_CELSIUS*(fahrenheitTemperature-FAHRENHEIT_TO_CELSIUS2);
                kelvinTemperature=celsiusTemperature+CELSIUSUS_TO_KELVIN;
                break;
            }
            case 'K':
            {
                kelvinTemperature=scan.nextDouble();
                fahrenheitTemperature=KELVIN_TO_FAHRENHEIT*(kelvinTemperature-KELVIN_TO_FAHRENHEIT3)+KELVIN_TO_FAHRENHEIT2;
                celsiusTemperature=FAHRENHEIT_TO_CELSIUS*(fahrenheitTemperature-FAHRENHEIT_TO_CELSIUS2);
                break;
            }
            
            /* In case the user didnt enter K/F/C */
            default:
            {
            kelvinTemperature=-1.0;
            fahrenheitTemperature=-1.0;
            celsiusTemperature=-1.0;
            }
           
        }
        
        System.out.println(celsiusTemperature+" C");
        System.out.println(fahrenheitTemperature+" F");
        System.out.println(kelvinTemperature+" K");
        
        
    }        
}


