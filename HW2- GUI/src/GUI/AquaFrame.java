package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import Q1.*;

//@author Mark Grinblat 315126201
//@author Hadar Isaacson 209831262

@SuppressWarnings("serial")
public class AquaFrame extends JFrame {
	
	public static AquaPanel FishPanel = new AquaPanel();
	private JPanel contentPanel; // main panel
	public static DefaultTableModel model = new DefaultTableModel(); 
	public static JTable FishInfo = new JTable(model);
	
	/**
	 * Launch the application.
	 */
	public static ArrayList<Swimmable> Data = new ArrayList<Swimmable>();
	public static int DataLenght = 0;
	
	public static String[] SwimToString(Swimmable Animal) {
		String[] data = {Animal.getAnimalName(),Animal.getColour(),Integer.toString(Animal.getSize()),
				Integer.toString(Animal.getHorSpeed()),Integer.toString(Animal.getVerSpeed()),
				Integer.toString(Animal.getEatCount())};
		return data;
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AquaFrame frame = new AquaFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Object[] Colours = {"Black", "Red","Blue","Green","Cyan","Orange","Yellow","Magenta", "Pink"};
	public Color StringToColour(int i) {
		Color c;
		switch (i) {
		case 0:
			c = new Color(254, 254, 254); // Black
			break;
		case 1:
			c = new Color(255, 0, 0); // Red
			break;
		case 2:
			c = new Color(0, 0, 255); // Blue
			break;
		case 3:
			c = new Color(0, 255, 0); // Green
			break;
		case 4:
			c = new Color(0, 255, 255); // Cyan
			break;
		case 5:
			c = new Color(255, 165, 0); // Orange
			break;
		case 6:
			c = new Color(255, 255, 0); // Yellow
			break;
		case 7:
			c = new Color(255, 0, 255); // Magenta
			break;
		case 8:
			c = new Color(255, 105, 180); // Pink
			break;
		
		default:
			c = new Color(255, 255, 255); // Black
			break;
		}
		return c;
	}

	/**
	 * Create the frame.
	 */
	public AquaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		
		//-------------------------------------------------------------------------------//
		
		// All the layered pane related code
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,1020,470);
		
		JLabel None = new JLabel();
		None.setOpaque(true);
		None.setBounds(0,0,1020,470);
		None.setBackground(null);
		layeredPane.add(None);
		layeredPane.setLayer(None, 0);
		
		JLabel Blue = new JLabel();
		Blue.setOpaque(true);
		Blue.setBounds(0,0,1020,470);
		Blue.setBackground(Color.BLUE);
		layeredPane.add(Blue);
		layeredPane.setLayer(Blue, 1);
		
		JPanel image = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon ImageName = new ImageIcon("Image.jpg");
				Image image = ImageName.getImage();
				g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		image.setBounds(0,0,1020,470);
		image.setOpaque(true);
		layeredPane.add(image);
		layeredPane.setLayer(image, 2);
		image.setVisible(false);
		
		model.addColumn("Animal"); 
		model.addColumn("Colour"); 
		model.addColumn("Size"); 
		model.addColumn("Hor.Speed"); 
		model.addColumn("Ver.Speed"); 
		model.addColumn("Eat Count");
		model.addRow(new Object[]{"Animal","Colour","Size","Hor.Speed","Ver.Speed","Eat Count"});
		FishInfo.setOpaque(true);
		FishInfo.setVisible(true);
		FishInfo.setBounds(0,0,1020,470);
		FishInfo.getColumnModel().getColumn(0).setPreferredWidth(27);
		layeredPane.add(FishInfo);
		layeredPane.setLayer(FishInfo, 3);
		
		Blue.setVisible(false);
		FishInfo.setVisible(false);
		FishPanel.setVisible(true);
		
		FishPanel.setOpaque(false);
		FishPanel.setLocation(0, 0);
		FishPanel.setSize(1010,480);
		FishPanel.setRequestFocusEnabled(false);
		FishPanel.setLayout(null);
		layeredPane.add(FishPanel);
		layeredPane.setLayer(FishPanel, 4);
		
		contentPanel = new JPanel();
		contentPanel.add(layeredPane);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		
		//-------------------------------------------------------------------------------//
		
		// All the Menu related code
		
		JMenuBar menuBar = new JMenuBar(); // create a menu bar
		setJMenuBar(menuBar);
		
		// The File Menu and all it's items
		
		JMenu FileMenu = new JMenu("File"); // creates the File Menu
		menuBar.add(FileMenu);
		
		JMenuItem ExitMenuItem = new JMenuItem("Exit"); // creates the exit MenuItem
		FileMenu.add(ExitMenuItem);
		
		ExitMenuItem.addActionListener(new ActionListener() { // waits for click and closes the program
			  public void actionPerformed(ActionEvent e) {
				  System.exit(1);
			  }
			 });
		
		// The Background Menu and all it's items
		
		JMenu BackgroundMenu = new JMenu("Background"); // creates the Background Menu
		menuBar.add(BackgroundMenu);
		
		JMenuItem ImageMenuItem = new JMenuItem("Image"); // creates the Image MenuItem
		BackgroundMenu.add(ImageMenuItem);
		
		ImageMenuItem.addActionListener(new ActionListener() { // waits for click and then sets the background to the colour blue
			  public void actionPerformed(ActionEvent e) {
				  None.setVisible(false);
				  Blue.setVisible(false);
				  image.setVisible(true);
			  }
			 });
		
		JMenuItem BlueMenuItem = new JMenuItem("Blue"); // creates the Blue MenuItem
		BackgroundMenu.add(BlueMenuItem);
		
		BlueMenuItem.addActionListener(new ActionListener() { // waits for click and then sets the background to the colour blue
			  public void actionPerformed(ActionEvent e) {
				  None.setVisible(false);
				  image.setVisible(false);
				  Blue.setVisible(true);
			  }
			 });
		
		JMenuItem NoneMenuItem = new JMenuItem("None"); // creates the None MenuItem
		BackgroundMenu.add(NoneMenuItem);
		
		NoneMenuItem.addActionListener(new ActionListener() { // waits for click and then sets the background to default colour(white)
			  public void actionPerformed(ActionEvent e) {
				  Blue.setVisible(false); 
				  image.setVisible(false);
				  None.setVisible(true); 
			  }
			 });
		
		// The Help Menu and all it's items
		
		JMenu HelpMenu = new JMenu("Help"); // creates the Help Menu
		menuBar.add(HelpMenu);
		
		JMenuItem HelpMenuItem = new JMenuItem("Help"); // create the Help MenuItem
		HelpMenu.add(HelpMenuItem);
		
		HelpMenuItem.addActionListener(new ActionListener() { //waits for click and then open a message box with the required String
			  public void actionPerformed(ActionEvent e) {
				  JOptionPane.showMessageDialog(null, "Java Homework 3\nGUI @ Threads");
			  }
			 });
		
		//-------------------------------------------------------------------------------//
		
		// Button related code 
		
		JButton AddAnimalButton = new JButton("Add Animal"); // creation of the button
		AddAnimalButton.setBounds(0, 470, 149, 53); 
		AddAnimalButton.setFont(new Font("Tahoma", Font.PLAIN, 16)); // setting of the font and font size 
		contentPanel.add(AddAnimalButton);
		AddAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  JTextField SizeField = new JTextField(8);
			      JTextField HorSpeedField = new JTextField(8);
			      JTextField VerSpeedField = new JTextField(8);

			      Object[] SwimmableType = {"Fish", "JellyFish"};
			      Object[] Colours = {"Black", "Red","Blue","Green","Cyan","Orange","Yellow","Magenta", "Pink"};
			      JPanel AddFish = new JPanel();
			      
			      JComboBox TypeCombo = new JComboBox(SwimmableType);
			      JComboBox ColourCombo = new JComboBox(Colours);
			      
			      AddFish.add(new JLabel("Type:"));
			      AddFish.add(TypeCombo); 
			      AddFish.add(new JLabel("Size:"));
			      AddFish.add(SizeField);
			      AddFish.add(new JLabel("Colour:"));
			      AddFish.add(ColourCombo);
			      AddFish.add(new JLabel("HorSpeed:"));
			      AddFish.add(HorSpeedField);
			      AddFish.add(new JLabel("VerSpeed:"));
			      AddFish.add(VerSpeedField);
			      try {
			      int result = JOptionPane.showConfirmDialog(null, AddFish, 
			               "Please Enter The Animal's Information", JOptionPane.OK_CANCEL_OPTION);
			      int Type = TypeCombo.getSelectedIndex();
			      int Size = Integer.parseInt(SizeField.getText());
			      int Index = ColourCombo.getSelectedIndex();
			      int HorSpeed = Integer.parseInt(HorSpeedField.getText());
			      int VerSpeed = Integer.parseInt(VerSpeedField.getText());
			      Color colour = StringToColour(Index);
			      if(Size < 20 || Size > 320) {
			    	  throw new IllegalStateException();
			      }
			      if(HorSpeed < 1 || HorSpeed > 10) {
			    	  throw new IllegalArgumentException();
			      }
			      if(VerSpeed < 1 || VerSpeed > 10) {
			    	  throw new IllegalArgumentException();
			      }
			      if((1 <= HorSpeed && HorSpeed <=10) && (1 <= VerSpeed && VerSpeed <= 10) && (20 <= Size && Size <= 320)) {
			      	if(Type == 0) {
			      		Data.add(new Fish(Size,0 , 0, HorSpeed, VerSpeed, colour));
			      		Fish temp = new Fish(Size,0 , 0, HorSpeed, VerSpeed, colour);
			      		AquaPanel.Data.add(temp);
			        }
			      	else if (Type == 1) {
			      		Data.add(new Jellyfish(Size,0 , 0, HorSpeed, VerSpeed, colour));
			      		Jellyfish temp = new Jellyfish(Size,0 , 0, HorSpeed, VerSpeed, colour);
			      		AquaPanel.Data.add(temp);
			      	}
			      	model.addRow(SwimToString(Data.get(DataLenght)));
			      	DataLenght++;
			      	FishPanel.repaint();
			           }
			      }	// exceptions for invalid values and characters 
			      catch (NumberFormatException error) {
					JOptionPane.showMessageDialog(null, "The field can only contain numbers!!!");
			      }
			      catch (IllegalStateException error) {
						JOptionPane.showMessageDialog(null, "The size can't be under 20 or above 320!!!");
			      } 
			      catch (IllegalArgumentException error) {
						JOptionPane.showMessageDialog(null, "The speed can't be under 1 or above 10!!!");
			      }
			      }
		});
		
		
		// Sleep button code
		
		JButton SleepButton = new JButton("Sleep"); // creation of the button
		SleepButton.setBounds(150, 470, 149, 53);
		SleepButton.setFont(new Font("Tahoma", Font.PLAIN, 16)); // setting of the font and font size 
		SleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AquaPanel.sleepFish();
			}
		});
		contentPanel.add(SleepButton);
		
		// WakeUp button code
		
		JButton WakeUpButton = new JButton("Wake Up"); // creation of the button
		WakeUpButton.setBounds(294, 470, 149, 53);
		WakeUpButton.setFont(new Font("Tahoma", Font.PLAIN, 16)); // setting of the font and font size 
		WakeUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AquaPanel.wakeFish();
			}
		});
		contentPanel.add(WakeUpButton);
		
		// Reset button code
		
		JButton ResetButton = new JButton("Reset"); // creation of the button
		ResetButton.setBounds(436, 470, 149, 53);
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 16)); // setting of the font and font size 
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AquaPanel.Data.clear();
				model.setRowCount(0);
				FishPanel.repaint();
				model.addRow(new Object[]{"Animal","Colour","Size","Hor.Speed","Ver.Speed","Eat Count"});
			}
		});
		contentPanel.add(ResetButton);
		
		// Food button code
		JButton FoodButton = new JButton("Food");
		FoodButton.setBounds(575, 470, 149, 53);
		FoodButton.setFont(new Font("Tahoma", Font.PLAIN, 16)); // setting of the font and font size 
		FoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FishPanel.getWorm() == false && AquaPanel.Data.size() > 0) { // if there are no worms and there is at least one fish drop in the Aquarium
					try {
						FishPanel.MakeBarrier();
						FishPanel.setWorm();
						FishPanel.repaint();
					} catch (Exception exception) { exception.printStackTrace();}
				}
			}
		});
		contentPanel.add(FoodButton);
		
		// Info button code
		
		JButton InfoButton = new JButton("Info"); // creation of the button
		InfoButton.setBounds(715, 470, 149, 53);
		InfoButton.setFont(new Font("Tahoma", Font.PLAIN, 16)); // setting of the font and font size 
		contentPanel.add(InfoButton);
		InfoButton.addActionListener(new ActionListener() {
			int i = 1; //counter to remember how many times the button was pressed
			public void actionPerformed(ActionEvent e) {
				if(i % 2 != 0) { // if the number was pressed an odd amount show the table
					Blue.setVisible(false);
					None.setVisible(false);
					FishPanel.setVisible(false);
					FishInfo.setVisible(true);
					i = 0;
				} else { // if the number was pressed an even amount close the table
					i++;
					FishInfo.setVisible(false);
					Blue.setVisible(false);
					None.setVisible(false);
					FishPanel.setVisible(true);
				}
			}
		});
		// Exit button code
		
		JButton ExitButton = new JButton("Exit"); // creation of the button
		ExitButton.setBounds(860, 470, 149, 53);
		ExitButton.setFont(new Font("Tahoma", Font.PLAIN, 16)); // setting of the font and font size 
		ExitButton.addActionListener(new ActionListener() { // waits for a click and then closes the program
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		contentPanel.add(ExitButton);
		
		//-------------------------------------------------------------------------------//
	}}
	

	
