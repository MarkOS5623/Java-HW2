package GUI;
import Q1.*;

import java.awt.*;
import javax.swing.*;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;

//@author Mark Grinblat 315126201
//@author Hadar Isaacson 209831262

public class AquaPanel extends JPanel {

	public static HashSet<Swimmable> Data = new HashSet<>();
	CyclicBarrier Barrier;
	public static boolean GotWorm = false;
	
	/**
	 * Create the panel.
	 */
	public AquaPanel() {
		setOpaque(false);
		setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	public void MakeBarrier() { // Barrier creation
		if(Data.size() > 0) {
			Barrier = new CyclicBarrier(Data.size());
			for(Swimmable Creature : Data) Creature.setBarrier(Barrier);
		}
	}
	
	public void paintComponent(Graphics g) { // drawing of all creatures
		super.paintComponent(g);
		for (Swimmable Creature : Data) {
				Creature.drawAnimal(g);
				new Thread(Creature).start();
			}
			if (GotWorm == true) DrawWorm(g);
		}

	public static void sleepFish() { for (Swimmable Creature : Data) Creature.setSuspend();}
	
	public static void wakeFish() { for (Swimmable Creature : Data) Creature.setResume();}
	
	public void setWorm() { // Changes the value of GotWorm indicating there is a worm present
		if (GotWorm == true) GotWorm = false;
		else GotWorm = true;
	}
	
	public boolean getWorm() { return GotWorm;}
	
	public void DrawWorm(Graphics g) { // Worm drawing function
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawArc(this.getWidth() / 2, this.getHeight() / 2 - 5, 10, 10, 30, 210);
		g2.drawArc(this.getWidth() / 2, this.getHeight() / 2 + 5, 10, 10, 180, 270);
		g2.setStroke(new BasicStroke(1));
	}

	public void wormEatenBy(Swimmable obj) {
		if(obj.getEatCount() == 3) { // Checks if the next piece of food will cause the creature to grow
			obj.eatInc();
			for(int i = 0; i < AquaFrame.DataLenght; i++) { // Updating the size and eatcount in the table
				if(obj.equals(AquaFrame.Data.get(i)) == true) { 
					AquaFrame.FishInfo.setValueAt(obj.getEatCount(), i + 1, 5);
					AquaFrame.FishInfo.setValueAt(obj.getSize(), i + 1, 2);
				}
			}
		} else { 
			obj.eatInc();
			for(int i = 0; i < AquaFrame.DataLenght; i++) { // Updating the value of eatcount in the table
				if(obj.equals(AquaFrame.Data.get(i)) == true) AquaFrame.FishInfo.setValueAt(obj.getEatCount(), i + 1, 5);
			}
		}
	}
	
}
