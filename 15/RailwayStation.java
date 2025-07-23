/**
 * class RailwayStation represents a train station
 *
 * @author Noga Matzliach
 * @version 11/06/2020
 */
public class RailwayStation
{
    private static final int MAX_TRAINS=100; //The maximum number of trains in 24 hours (a day)
    
    // instance variables 
    private Train[] _station; // Array that saves the trains schedule
    private int _noOfTrs; // The number of trains leaving the station
    
    /**
     * Constructor for objects of class RailwayStation
     */
    public RailwayStation()
    {
        // initialise instance variables
        _station= new Train[MAX_TRAINS];
        _noOfTrs=0;    
    }

    /**
     * addTrain method- adds a ride to the train board. 
     * The method gets the ride as a parameter.
     * The method returns a true value if the insert was preformed right. If not, the method returns false.
     * 
     * @param  f  the ride
     * @return true/false
     */
    public boolean addTrain(Train f)
    {
        if(f==null)
            return false;
        
        // If this train already exists on the train board
            for (int i=0; i< _noOfTrs; i++)
                if (f.equals(_station[i]))
                    return false;
            
        // If there is no space on the train board
        if (_noOfTrs == MAX_TRAINS)
            return false;
        
        // insert was preformed right
        else
        {
            //the new train is added to the first free place  
            _station[_noOfTrs]=new Train(f);
            _noOfTrs=_noOfTrs+1;
            return true;
        }
    }
       
    /**
     * removeTrain method - deletes train from the train board.
     * The method gets a train ride as a parameter.
     * The method returns a true value if the delete was done correctly, if not, the method returns false.
     * If the trip is not on the train board, or if the array is empty, the method returns false
     *
     * @param  f  the ride
     * @return true/false
     */
    public boolean removeTrain(Train f)
    {
        int trainPlace=-1; // the place in the array the train is displayed
       
        // if the array is empty or train is empty
        if (_station== null || f==null || _noOfTrs==0)
            return false;
        
        // found the place in the array that the train need to be removed
        for (int i=0; i<_noOfTrs; i++)
        {
            if (f.equals(_station[i]))
            {
                trainPlace=i;
                break;
            }
        }
        
        // If the train is not on the train board   
        if (trainPlace==-1)
            return false;
        
        // The lsat cell in the array should be inserted instead of the one we want to delete from the train board
        _station[trainPlace]=_station[_noOfTrs-1];
        _station[_noOfTrs-1]=null;
        _noOfTrs=_noOfTrs-1;
        return true;
    }

    /**
     * firstDepartureToDestination method - gets a city and returns the first time the train leaves to the city.
     * If there is no trip to the destination place or no trips (empty array) will be returned null.
     *
     * @param place a city
     * @return time the first time the train leaves to the city  
     */
    public Time1 firstDepartureToDestination (String place)

    {
        Time1 minTime=new Time1(23,59); // 23:59 is the maximun hour
        Time1 t=new Time1(minTime);
        boolean isThereATrip=false;
        
        //no trips (empty array) or place is empty
        if(_station==null || _noOfTrs==0 || place==null)
            return null;
        
        // searching in all the trains if there is train to that destination
        for (int i=0; i<_noOfTrs;i++)
        {
            if(_station[i].getDestination().equals(place))
            {
                isThereATrip=true;
                t=_station[i].getDeparture();
                // searching the first train that day to that destination
                if(t.before(minTime))
                {
                    minTime=t;
                }
            }    
        }
   
        //If there is no trip to the destination place
        if(isThereATrip==false)
            return null;
        
        return (new Time1(minTime));
    }

    /**
     * toString method - Returns a string describing all the trains in the train array
     *
     * @return string describing all the trains in the train array
     */
    public String toString()
    {
        String str;
        
        // if there are no trains (array is empty)
        if (_station==null || _noOfTrs==0 )
        {
           str ="There are no trains today.";
           return str;
        }
        
        else
        {
            str="The trains today are:";
            for (int i=0;i<_noOfTrs;i++)
            {
                str= new String (str+"\n"+(_station[i].toString()));
            } 
        }
        
        return (str+"\n");
    }

    /**
     * howManyFullTrains method - Returns a number that says how many full trains there are that day.
     *
     * @return number that says how many full trains there are that day
     */
    public int howManyFullTrains()
    {
        int count=0;// counts the full trains
        
        for (int i=0; i<_noOfTrs; i++)
        {
            if(_station[i].isFull())
                count++;
        }
        return count;
    }

    /**
     * mostExpensiveTicket method- finding the first fare whose ticket is most expensive.
     * 
     * @return the first fare whose ticket is most expensive.
     */
    public Train mostExpensiveTicket()
    {
        int maxPrice=0; //intializing the maximun price to be the minimum
        
        // if there are no trains
        if(_station==null || _noOfTrs==0)
            return null;
        
        else
        {
            for (int i=0; i<_noOfTrs;i++)
            {
                if (_station[i].getPrice()>maxPrice)
                {
                    maxPrice=_station[i].getPrice();
                }
            }
         
            for (int i=0; i<_noOfTrs;i++)
            {
                //If there are several trains that they have the most expensive ticket must be returned the first train
                if(_station[i].getPrice()==maxPrice)
                    return (new Train(_station[i]));
            }
           
            return null;
        }
    }
   
    /**
     * longestTrain method - returns the longest trip in the train station.
     *
     * @return the longest trip in the train station
     */
    public Train longestTrain()
    {
        int maxDuration=0; //intializing the maximun duration to be the minimum
        
        // if there are no trains
        if(_station==null ||_noOfTrs==0 )
            return null;
        
        else
        {
            // finding the biggest duration in the train station
            for (int i=0; i<_noOfTrs;i++)
            {
                if (_station[i].getDuration()>maxDuration)
                {
                    maxDuration=_station[i].getDuration();
                }
            }
           
            for (int i=0; i<_noOfTrs;i++)
            {
                //If there are several trains that they have longest travel time must be returned the first train
                if(_station[i].getDuration()==maxDuration)
                    return (new Train(_station[i]));
            }
            return null;
        }
    }
   
    /**
     *  mostPopularDestination method- finding the first most popular city on that day
     *   
     * @return the first most popular city on that day
     */
    public String mostPopularDestination()
    {
        String st="";
        int destMax=0; //intializing the most poplar value to be the minimum
        
        // If no travel (array is empty) null must be returned.
        if (_station==null || _noOfTrs==0)
            st=null;
        
        else
        {
            String[] cityArr=new String[_noOfTrs]; //_noOfTrs is the biggest options to different cities
            int[] citySum=new int[_noOfTrs]; //_noOfTrs is the biggest options to different cities
             
            //creating new array for all the cities
            for (int i=0; i<_noOfTrs;i++)
            {
             cityArr[i]=_station[i].getDestination();
            }
            
            //counting how many times each city repeated
            for (int i=0; i<_noOfTrs;i++)
            {
                for (int j=0; j<_noOfTrs;j++)
                    if(cityArr[i].equals(cityArr[j]))
                        citySum[i]+=1;
            }
            
            //finging the most popluar city
            for(int i=0;i<_noOfTrs;i++)
            {
                if (citySum[i]>destMax)
                {
                    destMax=citySum[i];
                    st=_station[i].getDestination();
                }
            }    
        }
       
        return st;
    }
}
