import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *this class is responsible for adding the text, graphics, and button elements to a main menu window. it also contains the action performer for the class' buttons
 * Made by: Jeffrey Cheung, Michelle Wang, Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class MainMenu extends JFrame implements ActionListener{

  private JPanel welcomePanel = new JPanel(); //game logo panel
  private JPanel startPanel = new JPanel(); //panel for buttons
  private JPanel warningPanel = new JPanel(); //panel for overwrite warning

  //label for overwrite warning
  public static JLabel warningLabel = new JLabel(); 

  //tracks how many times start menu button has been pressed for overwrite confirmation
  private int overwriteConfirmed = 0;

  //button declarations
  private JButton startButton = new JButton("Start new game");
  private JButton loadButton;
  private JButton quitButton = new JButton("Quit");
  
  /**
   *sets up the various panels, buttons and other objects on the main menu frame. Reads the save game name to set up the load game button

   *@title the title of the window

   *precondition: title must be a String, a main menu frame must have been created
   *postcondition: all three panels and all buttons will be added to the main menu frame. the previous saved game name will be added to the load game button
   */ 
  public MainMenu(String title){
    super(title); //sets frame title

    //sets the main menu background
    setContentPane(new JLabel (new ImageIcon("res/mainmenu.png")));

    //reads the previous saved game name from save file
    try{
      BufferedReader menuBr = new BufferedReader(new FileReader("saveFile.txt"));

      //loops through the text file to get to the saveName line (23)
      for(int x = 0; x < 22; x++){
        menuBr.readLine();
      }
      
      MyFrame.saveName = menuBr.readLine(); //sets saveName as whatever is on line 23
  
      menuBr.close();
    }
    catch (Exception z){}

    loadButton = new JButton("Load "+MyFrame.saveName+"'s Bakery"); //puts saved name on load button

    //creates welcome panel for title
    welcomePanel.setBounds(212,0,375,375);
    welcomePanel.setOpaque(false);
    welcomePanel.setVisible(true);

    add(welcomePanel); //adds welcome panel to frame

    ImageIcon welcomeIcon = new ImageIcon("res/welcome2.png"); // load the title image to a imageIcon
    Image welcomeImage = welcomeIcon.getImage(); // transform it 
    Image newwelcomeImage = welcomeImage.getScaledInstance(375, 375,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
    welcomeIcon = new ImageIcon(newwelcomeImage);  // transform it back
    JLabel welcomeLabel = new JLabel(welcomeIcon);
    welcomePanel.add(welcomeLabel);

    //creates start panel for buttons
    startPanel.setBounds(225,350,375,150);
    startPanel.setOpaque(false);
    startPanel.setLayout(new GridLayout(3,1,0,20));
    
    add(startPanel); //adds start panel to frame

    //creates warningpanel
    warningPanel.setBounds(80,500,620,30);
    warningPanel.setLayout(new FlowLayout());
    warningPanel.setBackground(Color.pink);
    warningPanel.setVisible(false);

    //adds warning panel
    add(warningPanel);

    //sets up warningLabel 
    warningLabel.setForeground(Color.black);
    warningLabel.setFont(MyFrame.font2);

    warningPanel.add(warningLabel); //adds warning label to the warningpanel 

    //set button for start new game
    startButton.addActionListener(this);
    startButton.setFont(MyFrame.font1);
    startButton.setFocusPainted(false);
    startButton.setActionCommand("startGame");

    startPanel.add(startButton); //adds button to start panel

    //set button for load existing game
    loadButton.addActionListener(this);
    loadButton.setFont(MyFrame.font1);
    loadButton.setFocusPainted(false);
    loadButton.setActionCommand("loadGame");

    //determines whether to gray out button if there is no previous load
    if (MyFrame.saveName.equals("noName")){
      loadButton.setText("Load Bakery");
      loadButton.setEnabled(false);
    }

    startPanel.add(loadButton); //adds load game button to panel
    
    //set button for quit game
    quitButton.setFont(MyFrame.font1);
    quitButton.setFocusPainted(false);
    quitButton.addActionListener(this);
    quitButton.setActionCommand("quitGame");

    startPanel.add(quitButton); //adds quit game button to panel
    
  }

  /**
   *executes various code depending on which button was pressed on main menu

   *@evt when button is pressed

   *precondition: the main menu must have been created and associated buttons set up with action listeners and appropriate action commands
   *postcondition: the game will either send a warning and create a new game, load the previous game, or quit the application
   */ 
  public void actionPerformed(ActionEvent evt){
    String action = evt.getActionCommand();

    //start new game
    if (action.equals("startGame")){
      warningPanel.setVisible(true);
      warningLabel.setText(String.format("Warning! This will overwrite your previous save. Press button again to confirm.")); //warns the user
      overwriteConfirmed++; //part of two-click confirmation system

      //if the user presses new game twice (acts as confirmation)
      if(overwriteConfirmed >= 2){
        //creates the name save panel
        NameSave nameFrame = new NameSave("Save Name");
        nameFrame.setSize(400,150);
        nameFrame.getContentPane().setBackground(new Color(194, 248, 255));
        nameFrame.setResizable(false);
        nameFrame.setLayout(null);

        nameFrame.setVisible(true);
      }
    }

    //load existing game
    else if(action.equals("loadGame")){

      Main.setDefault(); //sets default settings
      Main.mainGame("load");
    }
    //quit
    else if (action.equals("quitGame")){
      System.exit(0); //exits program
    }
  }
}