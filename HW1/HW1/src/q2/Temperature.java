package q2;
import q1.*;
/**
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 * @see package q1- as the date objects are generatred there 
 * @params -attributes scale and date scale 
 */
public class Temperature {
    //attributes
    private double scale; //the scale
    private MyDate scale_date; //the dated of measure 
    /**
     * constructor 
     * @param s -scale 
     * @param d -day
     * @param m -month
     * @param y -year 
     */
    public Temperature(double s, int d , int m, int y){
        this.scale=s;
        this.scale_date= new MyDate(d,m,y);
        
    }
    /**
     * equals method checks if two objects are equal 
     * @param other
     * @return true or false according to if other==this
     */
    public boolean equals(Temperature other){
        if(!(other instanceof Temperature) || other == null){
            return false;
        }
        if(this.scale!=other.scale||this.scale_date!=other.scale_date ) return false;
        else return true;
    }
    /**
     * this is another constructor that assign a given scale and the date of today (now)
     * @param s -scale
     */
    public Temperature(double s){
        this.scale=s;
        this.scale_date= new MyDate();
    }
    /**
     * copy constructor 
     * @param other
     */
    public Temperature(Temperature other){
        if(other!=null){
            this.scale=other.scale;
            this.scale_date=other.scale_date;
        }
        
    }
    /**
     * get function
     * @return the attribute of the scale 
     */
    public double getScale(){ return this.scale;}
    /**
     * get function
     * @return the attribute of the mesuarement date 
     */
    public MyDate getScaleDate(){ return this.scale_date;}
    /**
     * setter of scale 
     * @param s -scale
     * @return false or true if the attribute was assigned successfully
     */
    public boolean setScale(double s){ 
        this.scale=s;
        return (this.scale==s);
    }
    /**
     * setter of measurement date 
     * @param s_date -date of measurement 
     * @return false or true if the attribute was assigned successfully
     */
    public boolean setScaleDate(MyDate s_date){ 
         this.scale_date=s_date;
         return (this.scale_date==s_date);
        }
    /**
     * creats a string of the temperature with the date of measurment
     * @see toString of MyDate
     * @return a String 
     */
    public String toString() {
        if(scale>=0){
            return "+"+scale+"°C "+ scale_date.toString();
        }
        return "-"+scale+"°C "+ scale_date.toString();
    }
    /**
     * prints the temperature 
     */
    public void printTemp(){
        if(scale>=0){
            System.out.println( "+"+scale+"°C ");
        }
        else
        {System.out.println( "-"+scale+"°C ");}
    }
    public void printTempFull(){
        if(scale>=0){
            System.out.println( "+"+scale+"°C "+ scale_date.toString());
        }
        else
            {System.out.println( "-"+scale+"°C "+ scale_date.toString());}

    }
    /**
     * 
     * @param other -temp object 
     * @return the bigger temperature object when comparing 
     */
    public Temperature compTemp(Temperature other){
        //check if dosnt collide with cpy constructor

        if(this.scale<other.scale){
           return other;  
        }
        return this;
    }
 

       
    
}
