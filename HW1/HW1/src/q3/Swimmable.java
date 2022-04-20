package q3;
/**
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 * abstruct class
 */
public abstract class Swimmable implements Comparable <Swimmable> {
    protected int horSpeed;
    protected int verSpeed;
    public Swimmable(){
        horSpeed = 0;
        verSpeed = 0;
    }

    public Swimmable(int hor, int ver){
        horSpeed = hor;
        verSpeed = ver;
    }

    public void sethorSpeed(int hor){
        horSpeed = hor;
    }

    public void setverSpeed(int ver){
        verSpeed = ver;
    }

    public int gethorSpeed(){
        return horSpeed;
    }

    public int getverSpeed(){
        return verSpeed;
    }

    public boolean equals(Swimmable other){
        if (horSpeed==other.horSpeed && verSpeed==other.verSpeed) return true;
        else return false;
    }

    public abstract String toString();
    public abstract String getAnimalName();
    public abstract int getEatCount();
    public abstract int getSize();
    public abstract String getColor();
    public abstract void eatInc();
}
