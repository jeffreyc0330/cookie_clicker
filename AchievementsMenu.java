import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

//this class is responsible for carrying out the functions of an achievements menu window, including building the GUI and performing updates to achievements
public class AchievementsMenu extends JFrame{
  //declare boolean values for locked achievements
  public static boolean a1unlocked = false, a2unlocked = false, a3unlocked = false, a4unlocked = false, a5unlocked = false, a6unlocked = false, a7unlocked = false, a8unlocked = false, a9unlocked = false, a10unlocked = false;

  //create achievement buttons
  public static JButton a1button = new JButton();
  public static JButton a2button = new JButton();
  public static JButton a3button = new JButton();
  public static JButton a4button = new JButton();
  public static JButton a5button = new JButton();
  public static JButton a6button = new JButton();
  public static JButton a7button = new JButton();
  public static JButton a8button = new JButton();
  public static JButton a9button = new JButton();
  public static JButton a10button = new JButton();

  /**
   *create an AchievementsActionPerformer object to perform actions that correspond to the buttons in the achievements menu window
   * Made by: Michelle Wang, Vinson Zhang
   * Last edited: Jun 22, 2021
   */
  public static AchievementsActionPerformer aPerformer = new AchievementsActionPerformer();
    
  //create panels for icon, description, and achievements
  public static JPanel iconPanel = new JPanel();
  public static JPanel descriptionPanel = new JPanel();
  public static JPanel aPanel = new JPanel();

  //create label and text area for achievement description
  public static JTextArea descriptionText = new JTextArea();
  public static JLabel descriptionLabel;

  /**
   *creates the achievements menu, including descriptions of each achievements and an interface that shows which achievements have and haven't been unlocked

   *@title the title of the window

   *precondition: title must be a String, a window must have been constructed for an instance of an AchievementsMenu object in MyFrame
   *postcondition: title will have been added to the window, panels and buttons will have been added to the window. descriptions will be set and will be displayed when called.
   */
  public AchievementsMenu(String title){
    super(title);

    //set panel for maximized icon
    iconPanel.setBounds(0,0,140,130);
    iconPanel.setBackground(new Color(194, 248, 255));
    iconPanel.setLayout(new GridLayout(1,1));

    //add iconPanel to frame
    add(iconPanel);

    //set panel for description of maximized icon of achievement
    descriptionPanel.setBounds(140,0,260,130);
    descriptionPanel.setBackground(new Color(194, 248, 255));
    descriptionPanel.setLayout(new GridLayout(2,1));

    //add descriptionPanel to frame
    add(descriptionPanel);

    //set label for achievement description
    descriptionLabel = new JLabel();
    descriptionLabel.setForeground(Color.black);
    descriptionLabel.setFont(MyFrame.font4);

    //add description label to description panel
    descriptionPanel.add(descriptionLabel);
    
    //set format for descriptionText
    descriptionText.setBackground(new Color(194, 248, 255));
    descriptionText.setForeground(Color.black);
    descriptionText.setFont(MyFrame.font2);
    descriptionText.setLineWrap(true);
    descriptionText.setWrapStyleWord(true);
    descriptionText.setEditable(false);

    //add description text to the description panel
    descriptionPanel.add(descriptionText);

    //set format for aPanel
    aPanel.setBounds(0,130,400,160);
    aPanel.setBackground(Color.white);
    aPanel.setLayout(new GridLayout(2,5));
    
    //add aPanel to frame
    add(aPanel);

    //adds actionlisterners to each button
    a1button.addActionListener(aPerformer);
    a2button.addActionListener(aPerformer);
    a3button.addActionListener(aPerformer);
    a4button.addActionListener(aPerformer);
    a5button.addActionListener(aPerformer);
    a6button.addActionListener(aPerformer);
    a7button.addActionListener(aPerformer);
    a8button.addActionListener(aPerformer);
    a9button.addActionListener(aPerformer);
    a10button.addActionListener(aPerformer);
  }

  /**
   *updates the achievements window, greys out unlocked achievements, fills in unlocked achievements, allows user to click on achievements to view descriptions

   *precondition: a window must have been constructed for an instance of an AchievementsMenu object in MyFrame
   *postcondition: panels and buttons for achievements will be created
   */
  public static void updateAchievementsWindow(){

    //resize image of icon to show locked achievement
    ImageIcon alockedIcon = new ImageIcon("res/alocked.png"); // load the image to a imageIcon
    Image alockedimage = alockedIcon.getImage(); // transform it 
    Image newalockedimage = alockedimage.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    
    //display locked icon if achievement 1 is locked
    if(!a1unlocked){
      a1button.setIcon(new ImageIcon(newalockedimage));
      //a1button.addActionListener(aPerformer);
      a1button.setActionCommand("alocked");
    }
    //display achievement 1 icon if unlocked
    else if(a1unlocked){
      a1button.setIcon(new ImageIcon("res/a1button.png"));
      //a1button.addActionListener(aPerformer);
      a1button.setActionCommand("a1");
    }
    a1button.setBorder(null);

    //add achievement 1 button to achievement panel
    aPanel.add(a1button);

    //display locked icon if achievement 2 is locked
    if(!a2unlocked){
      a2button.setIcon(new ImageIcon(newalockedimage));
      //a2button.addActionListener(aPerformer);
      a2button.setActionCommand("alocked");
    }
    //display achievement 2 icon if unlocked
    else if(a2unlocked){
      a2button.setIcon(new ImageIcon("res/a2button.png"));
      //a2button.addActionListener(aPerformer);
      a2button.setActionCommand("a2");
    }
    a2button.setBorder(null);

    //add achievement 2 button to achievement panel
    aPanel.add(a2button);

    //display locked icon if achievement 3 is locked
    if(!a3unlocked){
      a3button.setIcon(new ImageIcon(newalockedimage));
      a3button.addActionListener(aPerformer);
      a3button.setActionCommand("alocked");
    }
    //display achievement 3 icon if unlocked
    else if(a3unlocked){
      a3button.setIcon(new ImageIcon("res/a3button.png"));
      a3button.addActionListener(aPerformer);
      a3button.setActionCommand("a3");
    }
    a3button.setBorder(null);

    //add achievement 3 button to achievement panel
    aPanel.add(a3button);    

    //display locked icon if achievement 4 is locked
    if(!a4unlocked){
      a4button.setIcon(new ImageIcon(newalockedimage));
      a4button.addActionListener(aPerformer);
      a4button.setActionCommand("alocked");
    }
    //display achievement 4 icon if unlocked
    else if(a4unlocked){
      a4button.setIcon(new ImageIcon("res/a4button.png"));
      a4button.addActionListener(aPerformer);
      a4button.setActionCommand("a4");
    }
    a4button.setBorder(null);

    //add achievement 4 button to achievement panel
    aPanel.add(a4button);

    //display locked icon if achievement 5 is locked
    if(!a5unlocked){
      a5button.setIcon(new ImageIcon(newalockedimage));
      a5button.addActionListener(aPerformer);
      a5button.setActionCommand("alocked");
    }
    //display achievement 5 icon if unlocked
    else if(a1unlocked){
      a5button.setIcon(new ImageIcon("res/a5button.png"));
      a5button.addActionListener(aPerformer);
      a5button.setActionCommand("a5");
    }
    a5button.setBorder(null);

    //add achievement 5 button to achievement panel
    aPanel.add(a5button);  

    //display locked icon if achievement 6 is locked
    if(!a6unlocked){
      a6button.setIcon(new ImageIcon(newalockedimage));
      a6button.addActionListener(aPerformer);
      a6button.setActionCommand("alocked");
    }
    //display achievement 6 icon if unlocked
    else if(a6unlocked){
      a6button.setIcon(new ImageIcon("res/a6button.png"));
      a6button.addActionListener(aPerformer);
      a6button.setActionCommand("a6");
    }
    a6button.setBorder(null);

    //add achievement 6 button to achievement panel
    aPanel.add(a6button);  

    //display locked icon if achievement 7 is locked
    if(!a7unlocked){
      a7button.setIcon(new ImageIcon(newalockedimage));
      a7button.addActionListener(aPerformer);
      a7button.setActionCommand("alocked");
    }
    //display achievement 7 icon if unlocked
    else if(a7unlocked){
      a7button.setIcon(new ImageIcon("res/a7button.png"));
      a7button.addActionListener(aPerformer);
      a7button.setActionCommand("a7");
    }
    a7button.setBorder(null);

    //add achievement 7 button to achievement panel
    aPanel.add(a7button);  

    //display locked icon if achievement 8 is locked
    if(!a8unlocked){
      a8button.setIcon(new ImageIcon(newalockedimage));
      a8button.addActionListener(aPerformer);
      a8button.setActionCommand("alocked");
    }
    //display achievement 8 icon if unlocked
    else if(a8unlocked){
      a8button.setIcon(new ImageIcon("res/a8button.png"));
      a8button.addActionListener(aPerformer);
      a8button.setActionCommand("a8");
    }
    a8button.setBorder(null);

    //add achievement 8 button to achievement panel
    aPanel.add(a8button);  

    //display locked icon if achievement 9 is locked
    if(!a9unlocked){
      a9button.setIcon(new ImageIcon(newalockedimage));
      a9button.addActionListener(aPerformer);
      a9button.setActionCommand("alocked");
    }
    //display achievement 9 icon if unlocked
    else if(a9unlocked){
      a9button.setIcon(new ImageIcon("res/a9button.png"));
      a9button.addActionListener(aPerformer);
      a9button.setActionCommand("a9");
    }
    a9button.setBorder(null);

    //add achievement 9 button to achievement panel
    aPanel.add(a9button);

    //display locked icon if achievement 10 is locked
    if(!a10unlocked){
      a10button.setIcon(new ImageIcon(newalockedimage));
      a10button.addActionListener(aPerformer);
      a10button.setActionCommand("alocked");
    }
    //display achievement 10 icon if unlocked
    else if(a1unlocked){
      a10button.setIcon(new ImageIcon("res/a10button.png"));
      a10button.addActionListener(aPerformer);
      a10button.setActionCommand("a10");
    }
    a10button.setBorder(null);

    //add achievement 10 button to achievement panel
    aPanel.add(a10button);
  }
}