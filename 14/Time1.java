 
/**
 * This class represents a Time1 object
 * @author Noga Matzliach
 * @version 10/05/2020
 */
public class Time1
{
    // instance variables 
    private int _hour; // hour between 0 to 23
    private int _minute; // minute between 0 to 59
    
    private static final int MIN_HOUR=0, MAX_HOUR=23, MIN_MINUTES=0, MAX_MINUTES=59; //limitions in the clock
    private static final int MAX_SINGLE_DIGIT_NUMBER=9, MINUTES_IN_HOUR=60,HOURS_IN_DAY=24, DEFAULT=0;
    
    /**
     * Constructs and initializes a time with specified values from the user.
     * If the valurs are not valid, it initializes them to zero.
     * @param h The hour of this Time1
     * @param m The minute of this Time1
     */
    public Time1(int h, int m)
    {
        // initialise instance variables
       
        if (h >=MIN_HOUR && h<= MAX_HOUR)
            _hour= h;
        else
            _hour= DEFAULT;
        
        if (m >= MIN_MINUTES && m<=MAX_MINUTES)
            _minute= m;
        else
            _minute= DEFAULT;
    }
    
     /**
     * Copy constructor for Time1
     * Constructs and initializes a time with the same time as other time
     * @param t The time object from whice to construct the new time
     */
    public Time1(Time1 t)
    {
        // initialise instance variables
        //check that the given object is initialized
        if (t!=null)
        {
            _hour= t._hour;
            _minute= t._minute;
        }
        
        else
        {
            _hour= DEFAULT;
            _minute= DEFAULT;
        }
    }

    /**
     * Returns the hour of the time
     * @return The hour of the time
     */
    public int getHour()
    { 
        return _hour;
    }
    
    /**
     * Returns the minutes of the time
     * @return The minutes of the time
     */
    public int getMinute()
    { 
        return _minute;
    }
    
    /**
     * The method changes the hour to be num (only if it's valid value)
     * @param num The new hour
     */
    public void setHour(int num)
    {
        if (num >=MIN_HOUR && num<=MAX_HOUR)
            _hour=num;   
    }
    
     /**
     * The method changes the minute to be num (only if it's valid value)
     * @param  num  The new minutes
     */
    public void setMinute(int num)
    {
        if (num >=MIN_MINUTES && num<=MAX_MINUTES)
            _minute=num;   
    }
    
    /**
     * Retuens a string representation of the time value in a specific format hh:mm (exactly 5 chars)
     * @return A string representation of the time
     */
    public String toString()
    {
        String time;
        
        if (_hour<=MAX_SINGLE_DIGIT_NUMBER && _minute<=MAX_SINGLE_DIGIT_NUMBER)
            time="0"+_hour+":0"+_minute;

        else if (_hour<=MAX_SINGLE_DIGIT_NUMBER)
            time="0"+_hour+":"+_minute;
        
        else if (_minute<=MAX_SINGLE_DIGIT_NUMBER)
            time=_hour+":0"+_minute;
        
        else
            time= _hour+":"+_minute;  
       
        return time;
    }
    
    /**
     * The method calculates how much minutes have passed since midnight and returns it
     * @return The minutes have passed since midnight
     */
    public int minFromMidnight()
    {
        //mod 1440 (minutes in a day) in order to display the min passed from last midnight
        return (((_hour*MINUTES_IN_HOUR)+_minute)%(MINUTES_IN_HOUR*HOURS_IN_DAY));
    }
    
    /**
     * The method equals gets a specific time parameter and checks if it is the equals to the time represented by
     * the object on which the method is invoked.
     * If so, the method returns true and, if not, returns false.
     * @param other time represented by an object 
     * @return true/false
     */
    public boolean equals(Time1 other)
    {
        // check that the given object is initialized
        if (other!=null)
        {
            if ((other._hour== this._hour) && (other._minute==this._minute))
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
    public boolean before (Time1 other)
    {
        // check that the given object is initialized
        if (other!=null)
        {
            if (this.equals(other)==true)
                return false;
        
            else if (this._hour==other._hour)
            {
                if (other._minute<this._minute)
                    return false;
                else
                    return true;
            }
        
             //the hour is different and the minutes are different
             else
                if (other._hour<this._hour)
                    return false;
                else
                    return true; 
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
    public boolean after (Time1 other)
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
    public int difference(Time1 other)
    {
        // check that the given object is initialized
        if (other!=null)
        {
            int diffInHour=(this._hour)-(other._hour);
            int diffInMin=(this._minute)-(other._minute);
        
            return ((diffInHour*MINUTES_IN_HOUR)+diffInMin);
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
     * @return Time1 new object
     */
    public Time1 addMinutes(int num)
    {
       Time1 newTime;
       
       //if the new minutes in the clock are in the valid limitions
       if ((this._minute+num)>=MIN_MINUTES && (this._minute+num)<=MAX_MINUTES)
       {
           newTime= new Time1 (this._hour, this._minute+num);
           return newTime;
       }    

       //((this._minute+num)>MAX_MINUTES || ((this._minute+num)<MIN_MINUTES))
       else
       {              
           int newHour=((this._hour)+(num/MINUTES_IN_HOUR))%HOURS_IN_DAY;
           int newMinutes= (this._minute)+(num%MINUTES_IN_HOUR);
           
           //if newMinutes is bigger than the limits, one hour need to be added
           if(newMinutes>= MINUTES_IN_HOUR)
           {
               newHour+=1;
               newMinutes%= MINUTES_IN_HOUR;
           }
           
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
          
           newTime=new Time1(newHour,newMinutes);
           return newTime;
       }
    }
}

