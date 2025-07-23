 
/**
 * This class represents a Time2 object
 * @author Noga Matzliach
 * @version 11/05/2020
 */
public class Time2
{
    // instance variables 
    private int _minFromMid;
       
    private static final int MIN_HOUR=0, MAX_HOUR=23, MIN_MINUTES=0, MAX_MINUTES=59; //limitions in the clock
    private static final int MAX_SINGLE_DIGIT_NUMBER=9, MINUTES_IN_HOUR=60,HOURS_IN_DAY=24, DEFAULT=0;
    
    /**
     * Constructs and initializes a time with specified values from the user.
     * If the valurs are not valid, it initializes them to zero.
     * @param h The hour of this Time2
     * @param m The minute of this Time2
     */
    public Time2(int h, int m)
    {
        // initialise instance variables
       
        if (h >=MIN_HOUR && h<= MAX_HOUR)
            _minFromMid= h*MINUTES_IN_HOUR;
        else
            _minFromMid= DEFAULT;
        
        if (m >= MIN_MINUTES && m<=MAX_MINUTES)
            _minFromMid += m;
        else
            _minFromMid= DEFAULT;
    }
    
     /**
     * Copy constructor for Time2
     * Constructs and initializes a time with the same time as other time
     * @param t The time object from whice to construct the new time
     */
    public Time2(Time2 t)
    {
        // initialise instance variables
        //check that the given object is initialized
        if (t!=null)
        {
             _minFromMid= t._minFromMid;
        }
        
        else
        _minFromMid= DEFAULT;
    }

    /**
     * Returns the hour of the time
     * @return The hour of the time
     */
    public int getHour()
    { 
        return (_minFromMid/MINUTES_IN_HOUR) ;
    }
    
    /**
     * Returns the minutes of the time
     * @return The minutes of the time
     */
    public int getMinute()
    { 
        return (_minFromMid%MINUTES_IN_HOUR);
    }
    
    /**
     * The method changes the hour to be num (only if it's valid value)
     * @param num The new hour
     */
    public void setHour(int num)
    {
        if (num >=MIN_HOUR && num<=MAX_HOUR)
        {
            int hours= _minFromMid/MINUTES_IN_HOUR;
            int minutes= _minFromMid%MINUTES_IN_HOUR;
            
            _minFromMid=(num*MINUTES_IN_HOUR)+minutes;
        }
    }
    
     /**
     * The method changes the minute to be num (only if it's valid value)
     * @param  num  The new minutes
     */
    public void setMinute(int num)
    {
        if (num >=MIN_MINUTES && num<=MAX_MINUTES)
        {
            int hours= _minFromMid/MINUTES_IN_HOUR;
            int minutes= _minFromMid%MINUTES_IN_HOUR;
        
            _minFromMid= (hours*MINUTES_IN_HOUR)+num;   
        }
    }
    
    /**
     * Retuens a string representation of the time value in a specific format hh:mm (exactly 5 chars)
     * @return A string representation of the time
     */
    public String toString()
    {
        String time;
        int hour=_minFromMid/MINUTES_IN_HOUR;
        int minutes=_minFromMid%MINUTES_IN_HOUR;
        
        if (hour<=MAX_SINGLE_DIGIT_NUMBER && minutes<=MAX_SINGLE_DIGIT_NUMBER)
            time="0"+hour+":0"+minutes;

        else if (hour<=MAX_SINGLE_DIGIT_NUMBER)
            time="0"+hour+":"+minutes;
        
        else if (minutes<=MAX_SINGLE_DIGIT_NUMBER)
            time=hour+":0"+minutes;
        
        else
            time= hour+":"+minutes;  
       
        return time;
    }
    
    /**
     * The method calculates how much minutes have passed since midnight and returns it
     * @return The minutes have passed since midnight
     */
    public int minFromMidnight()
    {
         //mod 1440 (minutes in a day) in order to display the min passed from last midnight
        return (_minFromMid%(MINUTES_IN_HOUR*HOURS_IN_DAY));
    }
    
    /**
     * The method equals gets a specific time parameter and checks if it is the equals to the time represented by
     * the object on which the method is invoked.
     * If so, the method returns true and, if not, returns false.
     * @param other time represented by an object 
     * @return true/false
     */
    public boolean equals(Time2 other)
    {
        // check that the given object is initialized
        if (other!=null)
        {
            if (other._minFromMid== this._minFromMid)
                return true;
        
            else
                return false;
        }
        
        else
            return false;
    }
    
    /**
     * The before method gets a specific time parameter and checks if the object on which the method is invoked is prior in
     * time to the object that is accepted as a parameter.
     * If so, the method returns true or not, false
     * @param other time represented by an object
     * @return true/false
     */
    public boolean before (Time2 other)
    {
        // check that the given object is initialized
        if (other!=null)
        {
            if (this.equals(other)==true)
                return false;
        
            else
            {
              if(other._minFromMid>this._minFromMid)
                return true;
              
              else
                return false;
            }
        }
        else
            return false;
    }

    /**
     * The after method gets a specific time parameter and checks if the object on which the method is invoked
     * Late in time for an object that is accepted as a parameter.
     * If so, the method will return true and if not, it will be returned false.
     * This method only uses the method before defined above.
     * @param other time represented by an object
     * @return true/false
     */
    public boolean after (Time2 other)
    {
        // check that the given object is initialized
        if (other!=null)
            return other.before(this);
        
        else
            return false;
    }
    
    /**
     * The difference method gets a certain time parameter and returns the difference in minutes between
     * The object on which the method is invoked for an object that is accepted as a parameter.
     * assuming that:
     * the object on which the method is applied represents a later time From the time in the object received as a parameter.
     * both objects are representative times in the same day.
     * @param other time represented by an object
     * @return  difference in minutes
     */
    public int difference(Time2 other)
    {
        // check that the given object is initialized
        if (other!=null)
        {
            return (this._minFromMid - other._minFromMid);
        }
        else
            return DEFAULT;
    }
    
    /**
     * The addMinutes method gets a parameter representing minutes, and adds it for the time represented by the object 
     * on which the method is applied.
     * The method returns a new object representing the new time.
     * The object on which the method is invoked addMinutes does not change.
     * If the num parameter is negative, the method subtracts the number of minutes this is from the object.
     * @param  num  minutes to add to time
     * @return Time2 new object
     */
    public Time2 addMinutes(int num)
    {
       Time2 newTime;
       //if the new minutes in the clock are bigger than the valid limitions- can be only if the number is positive
       //if the new minutes in the clock are smaller than the valid limitions- can be only if the number is negative
       //((this._minute+num)>MAX_MINUTES || ((this._minute+num)<MIN_MINUTES))
                
       int newHour=((this._minFromMid+num)/MINUTES_IN_HOUR)%HOURS_IN_DAY;
       int newMinutes= ((this._minFromMid+num)%MINUTES_IN_HOUR);
       
       //if newMinutes is smaller than the limits, one hour need to be subtract
       if (newMinutes<MIN_MINUTES)
       {
               newMinutes+= MINUTES_IN_HOUR;
               newHour-=1;
       }
           
       // if newHour is smaller than the limits
       if(newHour<MIN_HOUR)
       {
               newHour+=HOURS_IN_DAY;
       }
       
       newTime=new Time2(newHour,newMinutes);
       return newTime;
    }    
}


