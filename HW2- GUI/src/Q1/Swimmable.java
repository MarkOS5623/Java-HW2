package Q1;

import java.awt.Graphics;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 * abstract class
 */
public abstract class Swimmable extends Thread{
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

    public boolean equals(Swimmable other){
        if (horSpeed==other.horSpeed && verSpeed==other.verSpeed) return true;
        else return false;
    }

    public int getHorSpeed() { return horSpeed; }
    public int getVerSpeed() { return verSpeed; }
    public void setHorSpeed(int hor) { horSpeed  = hor; }
    public void setVerSpeed(int ver) { verSpeed  = ver; }

    abstract public String getAnimalName();
    abstract public void drawAnimal(Graphics g);
    abstract public void setSuspend();
    abstract public void setResume();
    abstract public void setBarrier(CyclicBarrier b);
    abstract public int getSize();
    abstract public void eatInc();
    abstract public int getEatCount();
    abstract public String getColour();
}
