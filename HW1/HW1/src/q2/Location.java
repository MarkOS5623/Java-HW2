package q2;
/**
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 * @see package q1- as the date objects are generatred there 
 */
public class Location {
    /** attributes of the class */
    private String name;
    private Temperature temp[];
    
    /**
     * another constructor 
     * @param n would be a diffrent name 
     */
    public Location(String n){
        this.name=n;
        this.temp=null;
    }
    /**
     * copy constructor 
     * @param other
     */
    public Location(Location other){
        this.name = other.name;
        this.temp=other.temp; 
    }
    /**
     * 
     * @param other
     * @return wheter if the location is equal to another location 
     */
    public boolean equals(Location other){
        if(!(other instanceof Location) || other == null){
            return false;
        }
        if(this.name!=other.name||this.temp!=other.temp) return false;
        else return true;
    }
    /**
     * prints the location with the temperturs
     * @see function toString 
     */
    public void printLocation(){
        
        if (this.temp==null){
            System.out.println(this.name+" no temperature measurements available");
        }
        else{
            System.out.println(this.name+" temperature measurements: ");
            for (int i = 0; i < temp.length; i++){
                System.out.print(temp[i].toString()+"| ");
            }
        }
        System.out.print("\n");
    }
    /**
     * print the temp of the city which are in the given range from the avg temperatrue
     * @param range- a given range 
     * @param lim1 and lim2 are the limits of the range 
     * @see getAverage and getScale and toString 
     */
    public void printLocation(double range){
        System.out.print(this.name);
        if (this.temp==null){
            System.out.print("there are no measurement\n");
        }
        else{

            double avg= this.getAverage();
            double lim1=avg-range;
            double lim2=avg+range;
            System.out.print(" temperature measurements: ");
            for (int i = 0; i < temp.length; i++){
                if (lim1<=temp[i].getScale() && lim2>=temp[i].getScale() )
                    System.out.print(temp[i].toString()+"|");
            }
        }
        System.out.print("\n");
    }
    /**
     * 
     * @return double, the average temp for a city 
     * @see getScale 
     * 
     */
    public double getAverage(){
        //int n= temp.length;
        double sum=0;
        
        if (this.temp!=null){
            
            for (int i = 0; i < temp.length; i++){
                sum=sum+temp[i].getScale();
            }
            return (double) sum/temp.length;
        }
        else{ 
            System.out.print("there are no measurement for this location, so therefor there is no average\n");
            return sum;
        }
    }
    /**
     * 
     * @return Temerature object - of the max temperature in the array of the city 
     * @see compTemp
     */
    public Temperature getMax(){
        int n= temp.length;
        if (this.temp==null){ 
            System.out.println("there are no measurement for this location, so therefor there is no max value\n");
            return null; 
        }
        Temperature max= temp[0];
        for(int i=0;i<n;i++){
            max=temp[i].compTemp(max);
        }
        return max;
        
        
    }
    /**
     * This method adds temp object to the location array.
     * using a new bigger array we are chaining the rest of the temp and at last
     * adding the new one. assiging the new array to "this". 
     * @param s -scale 
     * @param d -day 
     * @param m -month
     * @param y -year
     */
    public void addTemp(double s,int d, int m, int y){

        Temperature addNewTemp= new Temperature(s, d, m, y);
        //int n=this.temp.length;
        Temperature helpTempArr[];
        if (this.temp==null){
            helpTempArr=new Temperature[1];
            helpTempArr[0]=addNewTemp;
        }
        else{
            helpTempArr=new Temperature[this.temp.length+1];
            for (int i=0;i<this.temp.length;i++){
                helpTempArr[i]=temp[i];
                
            }   
            helpTempArr[this.temp.length]=addNewTemp;
        }
        
        this.temp=helpTempArr;
    }
    /**
     * like the former function (@see addTemp above): 
     * this method adds temp object to the location array.
     * @param s - scale
     * the assigned date would be todays date (now)
     */
    public void addTemp(double s){

        Temperature addNewTemp= new Temperature(s);
        
        Temperature helpTempArr[];
        if (this.temp==null){
            helpTempArr=new Temperature[1];
            helpTempArr[0]=addNewTemp;
        }
        //int n=this.temp.length;
        else
        {
            helpTempArr=new Temperature[this.temp.length+1];
            for (int i=0;i<this.temp.length;i++){
                helpTempArr[i]=temp[i];
            }   
            helpTempArr[this.temp.length]=addNewTemp;
        }
        
        this.temp=helpTempArr;
        
    }
    /**
     * 
     * @return the name of the city
     */
    public String getName(){return this.name;}
    /**
     * 
     * @return array of the temperatures
     */
    public Temperature[] getTemp(){return this.temp;}
    /**
     * 
     * @return True in case that the temp array is null, otherwise returns False
     */
    public boolean tempIsNull(){return this.temp==null;}
    /**
     * name setter
     * @param n -the name 
     * @return true or false if the set function succseeded
     */
    public boolean setName(String n){
        name=n; 
        if(name==n) return true;
        else return false;
    }
    /**
     * temperature setter
     * @param arr -given temperature array 
     * @return true true or false if the set function succseeded
     */
    public boolean setTemp(Temperature arr[]){
        temp=arr; 
        if(temp==arr) return true;
        else return false;
    }


}
