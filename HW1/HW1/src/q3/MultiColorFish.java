package q3;
/**
 * the following calss in inheret from Fish 
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 */

public class MultiColorFish extends Fish{
    //Constructors
    /**
     * Default constractor creates a default fish according the assignment
     */
    public MultiColorFish(){
        super();
    }
    /**
    * Creates a new MultiColorFish set 
    *
    * @param s to be given as {@code int}
    * @param x to be given as {@code int}
    * @param y to be given as {@code int}
    * @param horSpeed as {@code int}
    * @param verSpeed to be given as {@code int}
    * @param c to be given as {@code int}
    */
    public MultiColorFish(int s, int x, int y, int horSpeed, int verSpeed, int c){
        super(s, x, y, horSpeed, verSpeed, c);
    }
    /** 
     * this function check if the fish eat enough to go bigger 
     * if the fish ate enough it will grow,change color and reset it eat_count
    */
    public void eatInc(){
        seteatCount(getEatCount() + 1);
        if(getEatCount() == getEAT_DISTANCE()){
            setSize(getSize() + 1);
            changeColor();
            seteatCount(0);
        }
    } 
    /**
     * Returns the fish's name, color, size and eatcount
     */
    public String toString(){
        return getAnimalName() + " " + getColor() + " " + getSize() + " " + getEatCount();
    }

}
