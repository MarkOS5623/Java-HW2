package q3;

/**
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 * this calss inherts from Swimmable
 */
public class Fish extends Swimmable{
    private int size;
    private int col;
    private int eatCount;
    private int EAT_DISTANCE = 4;
    private int x_dir,y_dir;
    private int x_front, y_front;

    //Constructors
    /**
     * Default constractor creates a default fish according the assignment
     */

    public Fish(){
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
    * Creates a new fish
    *
    * @param s  to be given as {@code int}
    * @param x to be given as {@code int}
    * @param y to be given as {@code int}
    * @param horSpeed to be given as {@code int}
    * @param verSpeed to be given as {@code int}
    * @param c to be given as {@code int}
    */

    public Fish(int s, int x, int y, int horSpeed, int verSpeed, int c){
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
    * Copy constructor creates a new fish based on an other fish
    * @param other {@code Fish} to copy.
    */

    public Fish(Fish other){
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
     * Set method for changing the day of the day
     * @param s is to be given as {@code int}
     * @return true if size change was succesful otherwise false
     */

    public boolean setSize(int s){
        size = s;
        return size == s;
    }
    /** 
     * Set method for changing the day of the day
     * @param s is to be given as {@code int}
     * @return true if col change was succesful otherwise false
     */
    public boolean setCol(int c){
        col = c;
        return col == c;
    }
    /** 
     * Set method for changing the day of the day
     * @param e is to be given as {@code int}
     * @return true if eatCount change was succesful otherwise false
     */
    public boolean seteatCount(int e){
        eatCount = e;
        return eatCount == e;
    }
    /** 
     * Set method for changing the day of the day
     * @param x is to be given as {@code int}
     * @return true if x_dir change was succesful otherwise false
     */
    public boolean setx_dir(int x){
        x_dir = x;
        return x_dir == x;
    }
    /** 
     * Set method for changing the day of the day
     * @param y is to be given as {@code int}
     * @return true if y_dir change was succesful otherwise false
     */
    public boolean sety_dir(int y){
        y_dir = y;
        return y_dir == y;
    }
    /** 
     * Set method for changing the day of the day
     * @param e is to be given as {@code int}
     * @return true if EAT_DISTANCE change was succesful otherwise false
     */
    public boolean setEAT_DISTANCE(int e){
        EAT_DISTANCE = e;
        return EAT_DISTANCE == e;}
    /**
     * Returns the fish's name, color, size and eatcount
     */
    public String toString(){return getAnimalName() + " " + getColor() + " " + getSize() + " " + getEatCount();}
    /** 
     * @return String with the color of the fish
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
     * @return String with the name of the animal
     */

    public String getAnimalName(){
        return "Fish";
    }
    /** 
     * @return int with the number of food the fish ate before changing size
     */
    public int getEatCount(){
        return eatCount;
    }
    /** 
     * @return int with the size of the fish
     */
    public int getSize(){
        return size;
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
     * @return int with the x_dir of the fish
     */
    public int getx_dir(){return x_dir;}
    /** 
     * @return int with the y_dir of the fish
     */
    public int gety_dir(){return y_dir;}
    /** 
     * @return int with the col of the fish
     */
    public int getColorNum(){return col;}
    /** 
     * @return int with the EAT_DISTANCE of the fish
     */
    public int getEAT_DISTANCE(){return EAT_DISTANCE;}
    /** 
     * set a new size for the fish
     */
    public void changeFish(int s){
        size = s;
    }
    /** 
     * cycle the fish's color
     */
    public void changeColor(){
        col++;
        if(col > 9) col = 1;
    }
    /** 
     * Checks if this fish is equal to another fish.
     * <p>
     * Compares this {@code Fish} another fish.
     * <p>
     * Only objects of the type {@code Fish} can be compared, any other types will return false.
     * @param other the other that is to be checked
     * @return true if other is equal to this date otherwise return false
     */
    public boolean equals(Fish other){
        if(!(other instanceof Fish) || other == null){
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
