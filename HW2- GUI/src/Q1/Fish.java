package Q1;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import GUI.AquaFrame;


/**
 * @author Mark Grinblat 315126201
 * @author Hadar Isaacson 209831262
 * this class inherits from the Swimmable class
 */
public class Fish extends Swimmable{
    private int size;
    private Color col;
    private int eatCount;
    private int EAT_DISTANCE = 4;
    private int x_dir,y_dir;
    private int x_front, y_front;
    private boolean Suspended = false;
    private CyclicBarrier Barrier = null;
    //Constructors
    /**
     * Default constructor creates a default fish according the assignment
     */

    public Fish(){
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
    * Creates a new fish
    *
    * @param s  to be given as {@code int}
    * @param x to be given as {@code int}
    * @param y to be given as {@code int}
    * @param horSpeed to be given as {@code int}
    * @param verSpeed to be given as {@code int}
    * @param c to be given as {@code int}
    */

    public Fish(int s, int x, int y, int horSpeed, int verSpeed, Color c){
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
     * @return true if size change was successful otherwise false
     */

    public boolean setSize(int s){
        size = s;
        return size == s;
    }
    /** 
     * Set method for changing the day of the day
     * @param s is to be given as {@code int}
     * @return true if col change was successful otherwise false
     */
    public boolean setCol(Color c){
        col = c;
        return col == c;
    }
    /** 
     * Set method for changing the day of the day
     * @param e is to be given as {@code int}
     * @return true if eatCount change was successful otherwise false
     */
    public boolean seteatCount(int e){
        eatCount = e;
        return eatCount == e;
    }
    /** 
     * Set method for changing the day of the day
     * @param x is to be given as {@code int}
     * @return true if x_dir change was successful otherwise false
     */
    public boolean setx_dir(int x){
        x_dir = x;
        return x_dir == x;
    }
    /** 
     * Set method for changing the day of the day
     * @param y is to be given as {@code int}
     * @return true if y_dir change was successful otherwise false
     */
    public boolean sety_dir(int y){
        y_dir = y;
        return y_dir == y;
    }
    /** 
     * Set method for changing the day of the day
     * @param e is to be given as {@code int}
     * @return true if EAT_DISTANCE change was successful otherwise false
     */
    public boolean setEAT_DISTANCE(int e){
        EAT_DISTANCE = e;
        return EAT_DISTANCE == e;}
    /**
     * Returns the fish's name, colour, size and eatcount
     */
    public String toString(){return getAnimalName() + " " + getColour() + " " + getSize() + " " + getEatCount();}
    /** 
     * @return String with the colour of the fish
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
    public Color getColorNum(){return col;}
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
    
    public void drawAnimal(Graphics g)
    {
       g.setColor(col);
       if(x_dir==1) // fish swims to right side
       {
    	// Body of fish
    	g.fillOval(x_front - size, y_front - size/4, size, size/2);

    	// Tail of fish
    	int[] x_t={x_front-size-size/4,x_front-size-size/4,x_front-size};
    	int [] y_t = {y_front - size/4, y_front + size/4, y_front};
    	Polygon t = new Polygon(x_t,y_t,3);		
    	g.fillPolygon(t);

    	// Eye of fish
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255- col.getBlue()));
    	g2.fillOval(x_front-size/5, y_front-size/10, size/10, size/10);
    			
    	// Mouth of fish
    	if(size>70)
    		g2.setStroke(new BasicStroke(3));
    	else if(size>30)
    		g2.setStroke(new BasicStroke(2));
    	else
    		g2.setStroke(new BasicStroke(1));
          g2.drawLine(x_front, y_front, x_front-size/10, y_front+size/10);
          g2.setStroke(new BasicStroke(1));
       }
       else // fish swims to left side
       {
    	// Body of fish
    	g.fillOval(x_front, y_front - size/4, size, size/2);

    	// Tail of fish
    	int[] x_t={x_front+size+size/4,x_front+size+size/4,x_front+size};
    	int [] y_t = {y_front - size/4, y_front + size/4, y_front};
    	Polygon t = new Polygon(x_t,y_t,3);		
    	g.fillPolygon(t);

    	// Eye of fish
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setColor(new Color(255-col.getRed(),255-col.getGreen(),255-col.getBlue()));
    	g2.fillOval(x_front+size/10, y_front-size/10, size/10, size/10);
    			
    	// Mouth of fish
    	if(size>70)
    		g2.setStroke(new BasicStroke(3));
    	else if(size>30)
    		g2.setStroke(new BasicStroke(2));
    	else
    		g2.setStroke(new BasicStroke(1));
          g2.drawLine(x_front, y_front, x_front+size/10, y_front+size/10);
          g2.setStroke(new BasicStroke(1));
       }
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
