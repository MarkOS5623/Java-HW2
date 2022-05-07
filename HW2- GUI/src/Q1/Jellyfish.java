package Q1;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import GUI.AquaFrame;

/**
 * this class is extension of Swimmable 
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 */
public class Jellyfish extends Swimmable{
    private int size;
    private Color col;
    private int eatCount;
    private int EAT_DISTANCE = 4;
    private int x_dir;
    private int y_dir;
    private int x_front, y_front;
    private boolean Suspended = false;
    private CyclicBarrier Barrier = null;

    //Constructors
    /**
     * Default constructor creates a default Jellyfish according the assignment
     */

    public Jellyfish(){
        super();
        size =0;
        col = new Color(0, 0, 0);
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
    
    public Jellyfish(int s, int x, int y, int horSpeed, int verSpeed, Color c){
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
    
    public String getColour(){
    	String rgb = String.valueOf(this.col.getRed()) + "," + String.valueOf(this.col.getGreen()) + ","
				+ String.valueOf(this.col.getBlue());
		if (rgb.equals("255,0,0"))
			return "Red";
		else if (rgb.equals("0,0,255"))
			return "Blue";
		else if (rgb.equals("0,255,0"))
			return "Green";
		else if (rgb.equals("0,255,255"))
			return "Cyan";
		else if (rgb.equals("255,165,0"))
			return "Orange";
		else if (rgb.equals("255,255,0"))
			return "Yellow";
		else if (rgb.equals("255,0,255"))
			return "Magenta";
		else if (rgb.equals("255,105,180"))
			return "Pink";
		else
			return "Black";
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
        return getAnimalName() + " " + getColour() + " " + getSize() + " " + getEatCount();
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


	public void drawAnimal(Graphics g)
	{
		int numLegs;
		if (size < 40)
			numLegs = 5;
		else if (size < 80)
			numLegs = 9;
		else
			numLegs = 12;

		g.setColor(col);
		g.fillArc(x_front - size / 2, y_front - size / 4, size, size / 2, 0, 180);

		for (int i = 0; i < numLegs; i++)
			g.drawLine(x_front - size / 2 + size / numLegs + size * i / (numLegs + 1), y_front,
					x_front - size / 2 + size / numLegs + size * i / (numLegs + 1), y_front + size / 3);
	}


	public void setSuspend() {
		Suspended = true;
	}

	public void setResume() {
		synchronized (this) {
			Suspended = false;
			notify();
		}
	}

	@Override
	public void setBarrier(CyclicBarrier b) {
		Barrier = b;
	}
	
	public void run() {
		try {
			if (Suspended) { // if the user press on sleep button
				if (AquaFrame.FishPanel.getWorm()) {
					if (Barrier != null) Barrier.await();
					synchronized (this) {
						wait();
					}
				}
			} else if (AquaFrame.FishPanel.getWorm()) EatWorm();
			else move();
			
		} catch (InterruptedException error) {
			error.printStackTrace();
			return;
		} catch (BrokenBarrierException error) {
			error.printStackTrace();
		}
		AquaFrame.FishPanel.repaint();
	}

	public void move() {
		if(x_front > AquaFrame.FishPanel.getWidth()) x_dir = -1;
		if(y_front > AquaFrame.FishPanel.getHeight()) y_dir = -1;
		if(x_front <0) x_dir = 1;
		if(y_front <0) y_dir = 1;
		this.x_front += horSpeed * x_dir;
		this.y_front += verSpeed * y_dir;
	}

	public void EatWorm() {
		if (Barrier != null) {
			try { Barrier.await();
			} catch (InterruptedException error) {
				error.printStackTrace();
			} catch (BrokenBarrierException error) {
				error.printStackTrace();
			}
		}
	    Barrier = null;
		double Old_VerSpeed = Math.sqrt(horSpeed * horSpeed + verSpeed * verSpeed);
		double Variable = (Math.abs((double) y_front - (double) (AquaFrame.FishPanel.getHeight()) / 2)
				/ Math.abs((double) x_front - (double) (AquaFrame.FishPanel.getWidth()) / 2));
		
		double newHorSpeed = Old_VerSpeed / Math.sqrt(Variable * Variable + 1);
		double newVerSpeed = newHorSpeed * Variable;

		if (x_front >= AquaFrame.FishPanel.getWidth() / 2 || x_front < 0) x_dir = - 1;
		else x_dir = 1;
		if (y_front > AquaFrame.FishPanel.getHeight() / 2) y_dir = -1;
		else y_dir = 1;
		
		x_front += newHorSpeed * x_dir;
		y_front += newVerSpeed * y_dir;

		synchronized (this) {
			if ((Math.abs(AquaFrame.FishPanel.getWidth() / 2 - x_front) <= 5) && (Math.abs(AquaFrame.FishPanel.getHeight() / 2 - y_front) <= 5)) {
				AquaFrame.FishPanel.wormEatenBy(this);
				AquaFrame.FishPanel.setWorm();
				AquaFrame.FishPanel.repaint();
			}
		}
	}

}

