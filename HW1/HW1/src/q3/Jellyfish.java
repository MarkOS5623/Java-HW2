package q3;
/**
 * this class is extention of Swimmable 
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 */
public class Jellyfish extends Swimmable{
    private int size;
    private int col;
    private int eatCount;
    private int EAT_DISTANCE = 4;
    private int x_dir;
    private int y_dir;
    private int x_front, y_front;

    //Constructors
    /**
     * Default constractor creates a default Jellyfish according the assignment
     */

    public Jellyfish(){
        super();
        size =0;
        col = 0;
        x_front = 0;
        y_front = 0;
        eatCount = 0;
        x_dir = 1;
        y_dir = 1;
    }

    /**
    * Creates a new Jellyfish
    *
    * @param s  to be given as {@code int}
    * @param x to be given as {@code int}
    * @param y to be given as {@code int}
    * @param horSpeed to be given as {@code int}
    * @param verSpeed to be given as {@code int}
    * @param c to be given as {@code int}
    */
    
    public Jellyfish(int s, int x, int y, int horSpeed, int verSpeed, int c){
        super(horSpeed, verSpeed);
        size = s;
        col = c;
        x_front = x;
        y_front = y;
        eatCount = 0;
        x_dir = 1;
        y_dir = 1;
    }

    /**
    * Copy constructor creates a new Jellyfish based on an other Jellyfish
    * @param other {@code Jellyfish} to copy.
    */

    public Jellyfish(Jellyfish other){
        super.horSpeed = other.horSpeed;
        super.verSpeed = other.verSpeed;
        size = other.size;
        col = other.col;
        x_front = other.x_front;
        y_front = other.y_front;
        eatCount = other.eatCount;
        x_dir = other.x_dir;
        y_dir = other.y_dir;
    }

    /** 
     * @return String with the color of the Jellyfish
     */
    
    public String getColor(){
        switch(col){
            case 1:
                return "Black";
            case 2:
                return "Red";
            case 3:
                return "Blue";
            case 4:
                return "Green";
            case 5:
                return "Cyan";
            case 6:
                return "Orange";
            case 7:
                return "Yellow";
            case 8:
                return "Magenta";
            case 9:
                return "Pink";
            default:
                System.out.println("Invalid color");
                break;
        }
        return "";
    }
    /** 
     * Method for changing the size of the Jellyfish
     * @param s is to be given as {@code int}
     */
    public boolean changeJellyfish(int s){
        size = s;
        return size == s;
    }

    /** 
    * @return String with the name of the animal
    */

    public String getAnimalName(){return "Jellyfish";}
    /** 
     * @return int with the number of food the fish ate before changing size
     */
    public int getEatCount(){return eatCount;}
    /** 
     * @return int with the size of the fish
     */
    public int getSize(){return size;}

    /**
     * Returns the Jellyfish's name, color, size and eatcount
     */
    public String toString(){
        return getAnimalName() + " " + getColor() + " " + getSize() + " " + getEatCount();
    }
    /** 
     * this function check if the fish eat enough to go bigger 
     * if the fish ate enough it will grow and reset it eat_count
    */
    public void eatInc(){
        eatCount++;
        if(eatCount == EAT_DISTANCE){
            size++;
            eatCount = 0;
        }
    }
    /** 
     * Checks if this jellyfish is equal to another jellyfish.
     * <p>
     * Compares this {@code Jellyfish} another jellyfish.
     * <p>
     * Only objects of the type {@code Jellyfish} can be compared, any other types will return false.
     * @param other the other that is to be checked
     * @return true if other is equal to this date otherwise return false
     */
    public boolean equals(Jellyfish other){
        if(!(other instanceof Jellyfish) || other == null){
            return false;
        }
        if(horSpeed == other.horSpeed
        && verSpeed == other.verSpeed
        && size == other.size
        && col == other.col
        && x_front == other.x_front
        && y_front == other.y_front
        && eatCount == other.eatCount
        && x_dir == other.x_dir
        && y_dir == other.y_dir)
        return true;
        else return false;
    }
    public int compareTo(Swimmable other){
        if (this.size>other.getSize()){
            return 1;
        }
        else if(this.size==other.getSize()){
            return 0;
        }
        return -1;
        
    }
  
}
