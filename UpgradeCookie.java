import java.awt.Color;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.*;
import javax.swing.Timer;

/**
 *this class contains methods responsible for populating the upgrade cookie window with panels, buttons, and graphical/textual descriptions. It also updates the cookie icon and resets progress whenever an upgrade is purchased
 * Made by: Michelle Wang, Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class UpgradeCookie extends JFrame implements ActionListener{

  private JPanel ucPanel = new JPanel(); //holds the upgrade cookie buttons
  private JPanel notePanel = new JPanel(); //holds the text describing what cookie upgrades do
  private static JPanel descriptorPanel = new JPanel(); //holds text to describe each cookie tuype

  //title label at the top
  private JLabel noteLabel = new JLabel("Upgrade your cookie!"); 
  //name and boost of the chocolate chip cookie
  private static JLabel ccLabel = new JLabel("Chocolate Chip (multiplier x1)"); 
  //name and boost of the double chocolate cookie
  private static JLabel dcLabel = new JLabel("Double Chocolate (x2)");
  //name and boost of the strawberry cookie
  private static JLabel ssLabel = new JLabel("Strawberry Shortcake (x4)");
  
  //chocolate chip upgrade button
  public static JButton chocChip = new JButton();
  //double chocolate chip upgrade button
  public static JButton doubleChoc = new JButton();
  //strawberry cookie upgrade button
  public static JButton strawberryShortcake = new JButton();
  
  //text areas for the note and the different cookie descriptions
  private JTextArea noteText = new JTextArea();
  private static JTextArea ccText = new JTextArea();
  private static JTextArea dcText = new JTextArea();
  private static JTextArea ssText = new JTextArea();

  /**
   *adds the information and button panels + associated buttons to the Upgrade Cookie frame

   *@title the title of the window

   *precondition: title must be a String, the Upgrade Cookie frame must already have been created
   *postcondition: the information and button panels will be added to the upgrade cookie frame and the buttons to upgrade cookies will be setup 
   */ 
  public UpgradeCookie(String title){
    super(title);

    //creates the notePanel at the top of the frame with information about what upgrade cookies will do
    notePanel.setBounds(0,0,400,77);
    notePanel.setBackground(Color.pink);
    notePanel.setLayout(new GridLayout(2,1));

    add(notePanel); //adds panel to frame

    //creates labels for the notePanel
    noteLabel.setForeground(Color.black);
    noteLabel.setFont(MyFrame.font4);

    //add description label to notePanel
    notePanel.add(noteLabel);
    
    //sets text properties for the noteText area
    noteText.setBackground(Color.pink);
    noteText.setForeground(Color.black);
    noteText.setFont(MyFrame.font2);
    noteText.setLineWrap(true);
    noteText.setWrapStyleWord(true);
    noteText.setEditable(false);
    noteText.setText("Warning: Upgrading the cookie resets your progress. You can not return to an earlier cookie.");

    //add notetext to the notepanel
    notePanel.add(noteText);    

    //creates the ucPanel for buttons
    ucPanel.setBounds(0,77,100,300);
    ucPanel.setBackground(new Color(194, 248, 255));
    ucPanel.setLayout(new GridLayout(3,1));

    //add upgrade cookie panel to the window
    add(ucPanel);

    
    resizeCookies(); //changes cookie icon size to fit buttons

    //add cookie buttons to panel
    ucPanel.add(chocChip);
    ucPanel.add(doubleChoc);
    ucPanel.add(strawberryShortcake);
    
    //sets up the descriptorPanel containing information about each cookie type
    descriptorPanel.setBackground(new Color(194,248,255));
    descriptorPanel.setLayout(null);

    add(descriptorPanel); //adds panel to frame
    
    //calls method to set descriptions for each cookie type
    cookieDescriptions();
    
    //sets up chocolate chip button
    chocChip.addActionListener(this);
    chocChip.setActionCommand("chocChip");
    ucPanel.add(chocChip);

    //sets up double chocolate button
    doubleChoc.addActionListener(this);
    doubleChoc.setActionCommand("doubleChoc");
    ucPanel.add(doubleChoc);

    //sets up strawberry shortcake button
    strawberryShortcake.addActionListener(this);
    strawberryShortcake.setActionCommand("strawberryShortcake");
    ucPanel.add(strawberryShortcake);
  }

  /**
   *places appropriate labels and textareas to name and describe each cookie onto the upgrade cookie frame

   *precondition: the descriptor panel must have already been created, the upgrade cookie frame must already exist
   *postcondition: labels and textareas describing the benefits of each cookie will be added onto the upgrade cookie frame
   */ 
  public static void cookieDescriptions(){
    //create description label for chocolate chip cookie
    ccLabel.setForeground(Color.black);
    ccLabel.setFont(MyFrame.font4);
    ccLabel.setBounds(100,77,300,30);

    //add description label to ccPanel
    descriptorPanel.add(ccLabel);
    
    //sets text and properties for the chocolate chip description
    ccText.setBackground(new Color(194, 248, 255));
    ccText.setForeground(Color.black);
    ccText.setFont(MyFrame.font2);
    ccText.setLineWrap(true);
    ccText.setWrapStyleWord(true);
    ccText.setEditable(false);
    ccText.setText("Can't go wrong with an old-fashioned chocolate chip cookie!");
    ccText.setBounds(100,107,300,70);
    

    //add chocolatechip text area to the descriptor panel
    descriptorPanel.add(ccText);    
    
    //create description label for chocolate chip cookie
    dcLabel.setForeground(Color.black);
    dcLabel.setFont(MyFrame.font4);
    dcLabel.setBounds(100,177,300,30);

    // description label to dcPanel
    descriptorPanel.add(dcLabel);
    
    //sets text and properties for the double chocolate description
    dcText.setBackground(new Color(194, 248, 255));
    dcText.setForeground(Color.black);
    dcText.setFont(MyFrame.font2);
    dcText.setLineWrap(true);
    dcText.setWrapStyleWord(true);
    dcText.setEditable(false);
    dcText.setBounds(100,207,300,70);
    dcText.setText("Double the chocolate, double the points! Exchange for 10,000 cookies.");

    //add double chocolate text area to descriptor panel
    descriptorPanel.add(dcText);

    //create description label for chocolate chip cookie
    ssLabel.setForeground(Color.black);
    ssLabel.setFont(MyFrame.font4);
    ssLabel.setBounds(100,277,300,30);

    //add description label to descriptor panel
    descriptorPanel.add(ssLabel);

    //sets text and properties for strawberry shortcake description
    ssText.setBackground(new Color(194, 248, 255));
    ssText.setForeground(Color.black);
    ssText.setFont(MyFrame.font2);
    ssText.setLineWrap(true);
    ssText.setWrapStyleWord(true);
    ssText.setEditable(false);
    ssText.setBounds(100,307,300,70);
    ssText.setText("~blueberry pie, who's gonna be your lucky guy?~ Exchange for 100,000 cookies.");

    //adds strawberry description to descriptor panel
    descriptorPanel.add(ssText);    
  }

  /**
   *resizes cookie images and sets them to be the button icon

   *precondition: the buttons for each cookie type must already exist,
   *postcondition: the buttons to upgrade cookies will be updated to display the respective cookie as its icon
   */ 
  public static void resizeCookies(){
    //creates chocolate chip cookie buttons
    ImageIcon chocChipIcon = new ImageIcon("res/cccookie1.png"); // load the image to a imageIcon
    Image chocChipImage = chocChipIcon.getImage(); // transform it 
    Image newchocChipImage = chocChipImage.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    chocChip.setIcon(new ImageIcon(newchocChipImage));
    chocChip.setBorder(null);
    chocChip.setBackground(new Color(194, 248, 255));
    
    //creates double chocolate cookie button
    ImageIcon doubleChocIcon = new ImageIcon("res/dccookie1.png"); // load the image to a imageIcon
    Image doubleChocImage = doubleChocIcon.getImage(); // transform it 
    Image newdoubleChocImage = doubleChocImage.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    doubleChoc.setIcon(new ImageIcon(newdoubleChocImage));
    doubleChoc.setBorder(null);
    doubleChoc.setBackground(new Color(194, 248, 255));
    
    //creates Strawberry Shortcake cookie button
    ImageIcon strawberryShortcakeIcon = new ImageIcon("res/sscookie1.png"); // load the image to a imageIcon
    Image strawberryShortcakeImage = strawberryShortcakeIcon.getImage(); // transform it 
    Image newstrawberryShortcakeImage = strawberryShortcakeImage.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    strawberryShortcake.setIcon(new ImageIcon(newstrawberryShortcakeImage));
    strawberryShortcake.setBorder(null);    
    strawberryShortcake.setBackground(new Color(194, 248, 255));
  }

  /**
   *executes code depending on which button was pressed

   *@evt when a button is pressed

   *precondition: a button setup with an actionlistener must already exist, the buttons must be set to issue the appropriate action commands: "chocChip", "doubleChoc", "strawberryShortcake", the myframe window must already be set up, all 6 upgrade graphic panels must already exist
   *postcondition: depending on which button was pressed (which upgrade was selected), the multiplier and cookie icons will be adjusted and all upgrades/cookies will be reset as part of the "upgrading process"
   */ 
  public void actionPerformed(ActionEvent evt){
    String action = evt.getActionCommand();
    //sets action as the action command

    //if chocolate chip upgrade is selected
    if (action.equals("chocChip")){
      MyFrame.multiplier = 1; //default multiplier
      chocChip.setEnabled(false); //disables the chocchip button so the user can't accidently upgrade twice
    }

    //if double chocolate is selected
    else if(action.equals("doubleChoc")){
      MyFrame.timer.stop(); //stops the timer
      MyFrame.multiplier = 2; //sets multiplier
      MyFrame.updateCookieIcon(); //updates the cookie icon
      
      //resets all cookies and upgrades
      Main.setDefault();

      //adjusts which cookie types are unlocked
      MyFrame.ccUnlocked = false; 
      MyFrame.dcUnlocked = true;
      MyFrame.ssUnlocked = false;
    
      MyFrame.refreshRate = 0;
      MyFrame.incRate = 0;
      
      //resets all upgrade unlocks and removes graphics
      clearUpgradePanels(); 
      MyFrame.updateUpgradeIcon(); 
      MyFrame.checkUpgradesUnlocked(); 
      
      //resets counter label to zero
      MyFrame.counterLabel.setText(" "+MyFrame.cCounter + " cookies!!");

      //resets buttons for upgrades
      MyFrame.upgrade1.setText("Auto Click");
      MyFrame.upgrade2.setText("?");
      MyFrame.upgrade3.setText("?");
      MyFrame.upgrade4.setText("?");
      MyFrame.upgrade5.setText("?");
      MyFrame.upgrade6.setText("?");

      //adjust rate of increase to one decimal place
      MyFrame.displayedIncRate = ((MyFrame.incRate + " ").substring(0,3));

      //update the rate of increase label 
      MyFrame.incRateLabel.setText(" "+MyFrame.displayedIncRate + " cookies per sec");

      //disables upgrade button so user can't upgrade twice
      doubleChoc.setEnabled(false);
      
    }

    //updates settings for strawberryShortcake
    else if (action.equals("strawberryShortcake")){
      MyFrame.timer.stop(); //stops the timer
      MyFrame.multiplier = 4; //adjusts the multiplier
      MyFrame.updateCookieIcon(); //changes the cookie icon
      
      //resets default settings and adjusts makes strawberry the only cookie unlocked
      Main.setDefault();
      MyFrame.ccUnlocked = false;
      MyFrame.dcUnlocked = false;
      MyFrame.ssUnlocked = true;
      MyFrame.refreshRate = 0;
      MyFrame.incRate = 0;
      
      //resets all upgrades and removes their upgrades
      clearUpgradePanels();
      MyFrame.updateUpgradeIcon();
      MyFrame.checkUpgradesUnlocked();
      
      //sets counter label to zero
      MyFrame.counterLabel.setText(" "+MyFrame.cCounter + " cookies!!");

      //resets upgrade buttons
      MyFrame.upgrade1.setText("Auto Click");
      MyFrame.upgrade2.setText("?");
      MyFrame.upgrade3.setText("?");
      MyFrame.upgrade4.setText("?");
      MyFrame.upgrade5.setText("?");
      MyFrame.upgrade6.setText("?");

      //adjust rate of increase to one decimal place
      MyFrame.displayedIncRate = ((MyFrame.incRate + " ").substring(0,3));

      //update the rate of increase label 
      MyFrame.incRateLabel.setText(" "+MyFrame.displayedIncRate + " cookies per sec");

      //disables button so user can't upgrade twice
      strawberryShortcake.setEnabled(false);

    }
  }

  /**
   *adds various functional display elements to the window

   *@title the title of the window

   *precondition: title must be a String, a window must have been constructed for an instance of a MyFrame object
   *postcondition: title will have been added to the window, panels and buttons will have been added to the window
   */ 
  public void clearUpgradePanels(){
    MyFrame.autoclickPanel.removeAll();
    MyFrame.autoclickPanel.revalidate();
    MyFrame.autoclickPanel.repaint();
    MyFrame.bakeryPanel.removeAll();
    MyFrame.bakeryPanel.revalidate();
    MyFrame.bakeryPanel.repaint();
    MyFrame.factoryPanel.removeAll();
    MyFrame.factoryPanel.revalidate();
    MyFrame.factoryPanel.repaint();
    MyFrame.cargoshipPanel.removeAll();
    MyFrame.cargoshipPanel.revalidate();
    MyFrame.cargoshipPanel.repaint();
    MyFrame.alienPanel.removeAll();
    MyFrame.alienPanel.revalidate();
    MyFrame.alienPanel.repaint();
    MyFrame.monsterPanel.removeAll();
    MyFrame.monsterPanel.revalidate();
    MyFrame.monsterPanel.repaint();
  }
}