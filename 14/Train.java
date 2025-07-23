
/**
 * class Train represents a train driving.
 * @author Noga Matzliach
 * @version 11/05/2020
 */
public class Train
{
    // instance variables
    private String _destination;
    private Time1 _departure;
    private int _duration; // in minutes
    private int _passengers;
    private int _seats;
    private int _price; // for one person

    private static final int DEFAULT=0;

    /**
     * Constructs and initializes a train with specified values from the user.
     * If the valurs are not valid, it initializes them to zero.
     * @param dest The destination of the drive
     * @param h The hour of the departure time of the train
     * @param m The minutes of departure time of the train
     * @param duration The duration time of the drive in minutes
     * @param pass The number of the passengers on the drive
     * @param seats The number of seats on the train
     * @param price The price for one person
     */
    public Train(String dest, int h, int m, int duration, int pass, int seats, int price)
    {
        // initialise instance variables

        _destination=new String (dest);

        if(seats<DEFAULT)
            _seats= DEFAULT;
        else
            _seats=seats;

        if (pass>_seats)
            _passengers=_seats;
        else if (pass<DEFAULT)
            _passengers=DEFAULT;
        else
            _passengers=pass;

        if (duration < DEFAULT)
            _duration= DEFAULT;
        else
            _duration= duration;

        if (price<DEFAULT)
            _price= DEFAULT;
        else
            _price=price;

        _departure= new Time1(h, m);
    }

    /**
     * Copy constructor for Train
     * Constructs and initializes a train with the same train artibutes as other train
     * @param other The Train object from whice to construct the new train
     */
    public Train(Train other)
    {
        // initialise instance variables
        
        //check that the given object is initialized
        if (other!=null)
        {
            _price= other._price;
            _seats= other._seats;
            _passengers= other._passengers;
            _duration= other._duration;
            _departure= new Time1(other._departure);
            _destination= new String (other._destination);
        }

        else
        {
            _price= DEFAULT;
            _seats= DEFAULT;
            _passengers= DEFAULT;
            _duration= DEFAULT;
            _departure= new Time1(DEFAULT,DEFAULT);
            _destination= new String("");
        }
    }

    /**
     * The addPassengers method - add num passengers to the train.
     * @param num The number of passengers to add.
     * @return True if the total number of current passengers and num is less or equal to seats.
     */
    public boolean addPassengers(int num)
    {
        if ((_passengers+num)<=_seats)
        {
            _passengers+=num;
            return true;
        }
        else
            return false;
    }

    /**
     * The method arrivesEarlier- returns true if the arrival time of this train is earlier than the arrival time of the other train.
     * other is not null.
     * @param other the other train to compare arrival time with.
     * @return true if the arrival time of this train is earlier than arrival time of the other train.
     */
    public boolean arrivesEarlier(Train other)
    {
        if (other!=null)
        {
            if ((this.getArrivalTime()).before(other.getArrivalTime()))
                return true;

            else
                return false;
        }
        else
            return false;
    }

    /**
     * The equals method - check if the received train is equal to this train.
     * @param other The train to be compared with this train.
     * @return True if the received train is equal by number of seats, time of departure and destination to this train.
     */
    public boolean equals(Train other)
    {
        if (other!=null)    
        {
            if (_seats== other._seats && _departure.equals(other._departure)&& _destination.equals(other._destination))
                return true;
            else
                return false;
        }
        else
            return false;  
    }

    /**
     * The getArrivalTime method returns the arrival time.
     * @return The arrival time
     */
    public Time1 getArrivalTime()
    {
        Time1 arrivalTime= new Time1 (_departure.addMinutes(_duration));
        return (arrivalTime); 
    }

    /**
     * The getDeparture method - returns the departure time.
     * @return The departure time.
     */
    public Time1 getDeparture()
    { 
        return new Time1(_departure);
    }

    /**
     * The getDestination method - returns the destination.
     * @return The destination of the train.
     */
    public String getDestination()
    {
        String st1= new String(_destination);
        return st1;
    }

    /**
     * The getDuration method - returns the duration of the train.
     * @return the duration of the train.
     */
    public int getDuration()
    {
        return _duration;
    }
    
    /**
     * The getPassengers method - returns the number of passengers.
     * @return the number of passengers.
     */
    public int getPassengers()
    {
        return _passengers;
    }

    /**
     * The getPrice method - returns the price of the train.
     * @return the price of the train.
     */
    public int getPrice()
    {  
        return _price;
    }
    
    /**
     * The getSeats method - returns the number of seats.
     * @return the number of seats
     */
    public int getSeats()
    {
        return _seats;
    }
    
    /**
     * The isCheaper method - Returns true if the price for this train is cheaper than the other train. other is not null.
     * @param other the other train to compare price with.
     * @return true if the price for this train is cheaper than the other train.
     */
    public boolean isCheaper(Train other)
    {
        if (other!=null)
        {
            if(this._price<other._price)
                return true;
            else
                return false;
        }
        else
            return false;
    }
    
    /**
     * The isFull method - Returns true if train is full.
     * @return true if train is full.
     */
    public boolean isFull()
    {
        if (_seats==_passengers)
            return true;
        else
            return false;
    }
    
    /**
     * The setDeparture method - updates the departure time of the train.
     * t in not null.
     * @param t - the new departure time of the train.
     */
    public void setDeparture(Time1 t)
    {
        if (t!=null)
        {
            _departure= new Time1(t);
        }
    }

    /**
     * The setDestination method - updates the destination of the train. d in not null.
     * @param d - the new detination of the train.
     */
    public void setDestination(String d)
    {
        if (d!=null)
            _destination= new String(d);
    }
    
    /**
     * The setDuration method - updates the duration of the train. d should be positive or zero, otherwise duration is unchanged.
     * @param d - the new duration of the train.
     */
    public void setDuration(int d)
    {
        if (d>=DEFAULT)
            _duration=d;
    }
    
    /**
     * The setPassengers method - updates the number of passengers. p should be positive or zero, otherwise passengers is unchanged.
     * p should be less than seats otherwise it should be set to seats.
     * @param p - the new number of passengers.
     */
    public void setPassengers(int p)
    {
      if (p>=DEFAULT)
      {
          if (p<=_seats)
            _passengers=p;
          else
            _passengers=_seats;
      }
    }
    
    /**
     * The setPrice method - updates the price. p should be positive or zero, otherwise price is unchanged.
     * @param p - the new price.
     */
    public void setPrice(int p)
    {
        if (p>=DEFAULT)
            _price=p;
    }
    
    /**
     * The setSeats method - updates the number of seats. s should be positive or zero, otherwise seats is unchanged. 
     * s should be larger than passengers, otherwise seats is unchanged.
     * @param s - the new number of seats.
     */
    public void setSeats(int s)
    {
        if (s>=DEFAULT && s>=_passengers)
            _seats=s;     
    }
    
    /**
     * The toString method - return a string representation of the train.
     * @return String representation of the train.
     */
    public String toString()
    {
     String st1;
     
     if (this.isFull())
        st1= new String ("Train to "+_destination+" departs at "+_departure+". Train is full.");      
     else
        st1= new String ("Train to "+_destination+" departs at "+_departure+". Train is not full.");
     
     return st1;
    }
    
    /**
     * The totalPrice method - Returns the total price for all passengers.
     * @return the total price for all passengers.
     */
    public int totalPrice()
    {
        return _price*_passengers;
    }
}
