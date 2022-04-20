package q3;

/**
 * the following class inherts from Fish 
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 */
public class UnusualFish extends Fish{
    private int factor;
    //Constructors
    /**
     * Default constractor creates a default UnusualFish according the assignment
     */
    public UnusualFish(){
        super();
        factor = 1;
    }

    /**
    * Creates a new UnusualFish
    *
    * @param s as {@code int} to be given.
    * @param x as {@code int} to be given.
    * @param y as {@code int} to be given.
    * @param horSpeed as {@code int} to be given.
    * @param verSpeed as {@code int} to be given.
    * @param c as {@code int} to be given.
    * @param f as {@code int} to be given.
    */

    public UnusualFish(int s, int x, int y, int horSpeed, int verSpeed, int c,int f){
        super(s, x, y, horSpeed, verSpeed, c);
        factor = f;
    }

    /** 
     * set the factor to the given number
     * @param factor
     */

    public boolean setFactor(int f){ 
        factor = f;
        return factor == f;}

    /** 
     * get the factor of the UnusualFish
     * @return int
     */

    public int getFactor(){ return factor;}
    
    /**       
     * return the fish's size multiplayed by the factor 
     * @return int 
     */
    public int getSize(){
        return factor*super.getSize();
    }
    /**
     * Returns the UnusualFish's name, color, size and eatcount
     */
    public String toString(){
        return getAnimalName() + " " + getColor() + " " + getSize() + " " + getEatCount();

    }

    /** 
     * @return String with the name of the fish
     */
    public String getAnimalName(){
        return "UnusualFish";
    }
    /** 
     * Checks if this unusualFish is equal to another unusualFish.
     * <p>
     * Compares this {@code UnusualFish} another unusualFish.
     * <p>
     * Only objects of the type {@code UnusualFish} can be compared, any other types will return false.
     * @param other the other that is to be checked
     * @return true if other is equal to this date otherwise return false
     */
    public boolean equals(UnusualFish other){
        if(!(other instanceof UnusualFish) || other == null){
            return false;
        }
        if(factor == other.factor)
        return true;
        else return false;
    }
}
