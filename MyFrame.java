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
import java.text.DecimalFormat;

/**
 *this class is responsible for creating important game variables as well as adding the text, graphics, button elements for the cookie, upgrades panel, and menu panel on the main game screen. it also contains various update methods for variable values and graphics
 * Made by: Jeffrey Cheung, Michelle Wang, Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class MyFrame extends JFrame{

  //declare variables for various counters and values
  public static int cCounter, autoNum, autoPrice, bakeryNum, bakeryPrice, factoryPrice, factoryNum, cargoPrice, cargoNum, alienPrice, alienNum, monsterPrice, monsterNum;

  public static int refreshRate;
  public static double incRate;

  public static int multiplier = 1; //for cookie upgrades
  public static String displayedIncRate;
  public static boolean timerActive, bakeryUnlocked, factoryUnlocked, cargoUnlocked, alienUnlocked, monsterUnlocked, newAchievement, cookieUpgraded, ccUnlocked, dcUnlocked, ssUnlocked;
  public static boolean successfulUpgrade; //used in the checkUpgrade() method
  public static JLabel counterLabel, incRateLabel, saveNameLabel;

  public static String saveName;

  //declare font presets
  public static Font font1, font2, font3, font4;

  //declare graphics to be referenced in other classes
  public static ImageIcon cookieGraphic1;
  public static ImageIcon cookieGraphic2;

  //declare variables for repeately used images
  public static ImageIcon cccookie1 = new ImageIcon("res/cccookie1.png");
  public static ImageIcon cccookie2 = new ImageIcon("res/cccookie2.png");
  public static ImageIcon dccookie1 = new ImageIcon("res/dccookie1.png");
  public static ImageIcon dccookie2 = new ImageIcon("res/dccookie2.png");
  public static ImageIcon sscookie1 = new ImageIcon("res/sscookie1.png");
  public static ImageIcon sscookie2 = new ImageIcon("res/sscookie2.png");

  //declare variables to perform ActionPerfored methods
  public static ActionPerformer performer = new ActionPerformer();
  MouseDetector detector = new MouseDetector();

  static Timer timer;

  //create buttons to be added to the window. titled with default names
  public static JButton cButton = new JButton();
  public static JButton upgrade1 = new JButton("Auto Click");
  public static JButton upgrade2 = new JButton("?");
  public static JButton upgrade3 = new JButton("?");
  public static JButton upgrade4 = new JButton("?");
  public static JButton upgrade5 = new JButton("?");
  public static JButton upgrade6 = new JButton("?");
  public static JButton sButton = new JButton("Save");
  public static JButton aButton = new JButton("Achievements");
  public static JButton qButton = new JButton("Save & Quit");
  public static JButton ucButton = new JButton("Upgrade Cookie");

  //create panels for the cookie, stats, and graphics. these are public panels that need to be accessed from different classes
  public static JPanel cPanel = new JPanel();
  public static JPanel autoclickPanel = new JPanel();
  public static JPanel bakeryPanel = new JPanel();
  public static JPanel factoryPanel = new JPanel();
  public static JPanel cargoshipPanel = new JPanel();
  public static JPanel alienPanel = new JPanel();
  public static JPanel monsterPanel = new JPanel();
  public static JPanel descriptorPanel = new JPanel();

  //these are private panels that are only ever altered in the current class
  private JPanel upgradesPanel = new JPanel();
  private JPanel menuPanel = new JPanel();
  private JPanel counterPanel = new JPanel();
  
  //create text area for descriptions of upgrades
  public static JTextArea descriptionText = new JTextArea();

  /**
   *adds various functional display elements to the window

   *@title the title of the window

   *precondition: title must be a String, a window must have been constructed for an instance of a MyFrame object
   *postcondition: title will have been added to the window, panels and buttons will have been added to the window
   */ 
  public MyFrame(String title){
    super(title);

    //set background image
    setContentPane(new JLabel (new ImageIcon("res/background.png")));
    
    //set panel for cookie button
    cPanel.setBounds(15,185,200,200);
    cPanel.setOpaque(false);
    
    //add cookie panel to the window
    add(cPanel);
    
    //add listners and set parameters for the cookie button
    cButton.addActionListener(performer);
    cButton.addMouseListener(detector);
    cButton.setBorder(null);
    cButton.setActionCommand("Click");
    cButton.setFocusPainted(false);
    cButton.setBorder(null);
    cButton.setContentAreaFilled(false);

    //sets cookie image to the cookie type currently selected
    updateCookieIcon();

    //set panel for cookie counter and cookies per second stats
    counterPanel.setBounds(0,45,255,120);
    counterPanel.setOpaque(false);
    counterPanel.setLayout(new GridLayout(3,1));
    
    //add counter and cookies per second panel to the window 
    add(counterPanel);

    //set label for the save name of the game
    saveNameLabel = new JLabel("<html> "+ MyFrame.saveName+"'s<br>Cookie Empire</html>");
    saveNameLabel.setForeground(Color.black);
    saveNameLabel.setFont(font3);

    //add saveName label to counter panel
    counterPanel.add(saveNameLabel);

    //set label for cookie counter
    counterLabel = new JLabel(" "+cCounter + " cookies!!");
    counterLabel.setForeground(Color.black);
    counterLabel.setFont(font1);

    //add cookie count label to counter panel
    counterPanel.add(counterLabel);

    //set label for cookies per second
    incRateLabel = new JLabel(" "+incRate + " cookies per sec");
    incRateLabel.setForeground(Color.black);
    incRateLabel.setFont(font2);
    
    //add cookies per second stat to counter panel
    counterPanel.add(incRateLabel);

    //set panel for autoclick upgrade graphics
    autoclickPanel.setBounds(255,32,34,560);
    autoclickPanel.setOpaque(false);
    autoclickPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //add autoclick graphics panel
    add(autoclickPanel);

    //set panel for bakery upgrade graphics
    bakeryPanel.setBounds(289,37,306,112);  bakeryPanel.setOpaque(false);
    bakeryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //add bakery graphics panel
    add(bakeryPanel);

    //set panel for factory upgrade graphics
    factoryPanel.setBounds(289,144,306,112);
    factoryPanel.setOpaque(false);
    factoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    //add factory graphics panel
    add(factoryPanel);

    //set panel for cargoship upgrade graphics
    cargoshipPanel.setBounds(289,256,306,112);
    cargoshipPanel.setOpaque(false);
    cargoshipPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //add cargo ship graphics panel
    add(cargoshipPanel);

    //set panel for alien tech upgrades graphics
    alienPanel.setBounds(289,368,306,112);
    alienPanel.setOpaque(false);
    alienPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //add alien tech graphics panel
    add(alienPanel);

    //set panel for cookie monster upgrade graphics
    monsterPanel.setBounds(289,480,306,56);
    monsterPanel.setOpaque(false);
    monsterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

    //add cookie monster graphics panel
    add(monsterPanel);

    //set panel for buttons to purchase upgrades
    upgradesPanel.setBounds(600, 132, 200, 440);
    upgradesPanel.setOpaque(false);
    upgradesPanel.setLayout(new GridLayout(6,1));

    //add upgrade button panel
    add(upgradesPanel);

    //set button for the auto-click upgrade
    upgrade1.setFont(font3);
    upgrade1.setFocusPainted(false);
    upgrade1.addActionListener(performer);
    upgrade1.addMouseListener(detector);
    upgrade1.setActionCommand("Auto");
    //update the button's text to show the quantity purchased if at least one has been purchased. otherwise, keep the text as the default
    if (autoNum > 0){
      upgrade1.setText("Auto Click (" + autoNum + ")");
    }

    //add auto-click upgrade button to the upgrades panel
    upgradesPanel.add(upgrade1);

    //set button for the bakery upgrade
    upgrade2.setFont(font3);
    upgrade2.setFocusPainted(false);
    upgrade2.addActionListener(performer);
    upgrade2.addMouseListener(detector);
    upgrade2.setActionCommand("Bakery");
    //update the button's text to show the quantity purchased if at least one has been purchased. otherwise, keep the text as the default
    if (bakeryUnlocked){
      upgrade2.setText("Bakery (" + bakeryNum + ")");
    }

    //add bakery upgrade button to the upgrades panel
    upgradesPanel.add(upgrade2);

    //set button for the factory upgrade
    upgrade3.setFont(font3);
    upgrade3.setFocusPainted(false);
    upgrade3.addActionListener(performer);
    upgrade3.addMouseListener(detector);
    upgrade3.setActionCommand("Factory");
    //update the button's text to show the quantity purchased if at least one has been purchased. otherwise, keep the text as the default
    if (factoryUnlocked){
      upgrade3.setText("Factory (" + factoryNum + ")");
    }

    //add factory upgrade button to the upgrades panel
    upgradesPanel.add(upgrade3);

    //set button for the exploitation upgrade
    upgrade4.setFont(font3);
    upgrade4.setFocusPainted(false);
    upgrade4.addActionListener(performer);
    upgrade4.addMouseListener(detector);
    upgrade4.setActionCommand("CargoShip");
    //update the button's text to show the quantity purchased if at least one has been purchased. otherwise, keep the text as the default
    if (cargoUnlocked){
      upgrade4.setText("Cargo Ship (" + cargoNum +")");
    }
    

    //add ? upgrade button to the upgrades panel
    upgradesPanel.add(upgrade4);

    //set button for the auto-click upgrade
    upgrade5.setFont(font3);
    upgrade5.setFocusPainted(false);
    upgrade5.addActionListener(performer);
    upgrade5.addMouseListener(detector);
    upgrade5.setActionCommand("AlienTech");
    //update the button's text to show the quantity purchased if at least one has been purchased. otherwise, keep the text as the default
    if (alienUnlocked){
      upgrade5.setText("Alien Tech (" + alienNum +")");
    }

    //add auto-click upgrade button to the upgrades panel
    upgradesPanel.add(upgrade5);

    //set button for the cookie monster upgrade
    upgrade6.setFont(font3);
    upgrade6.setFocusPainted(false);
    upgrade6.addActionListener(performer);
    upgrade6.addMouseListener(detector);
    upgrade6.setActionCommand("CookieMonster");
    //update the button's text to show the quantity purchased if at least one has been purchased. otherwise, keep the text as the default
    if (monsterUnlocked){
      upgrade6.setText("Cookie Monster (" + monsterNum + ")");
    }

    //add factory upgrade button to the upgrades panel
    upgradesPanel.add(upgrade6);

    //set panel to show a given description for an upgrade
    descriptorPanel.setBounds(600,32,200,100);
    descriptorPanel.setBackground(Color.pink);
    descriptorPanel.setVisible(false);

    //add the description text panel to the window
    add(descriptorPanel);

    //set decription text parameters
    descriptionText.setBounds(603,34,200,110);
    descriptionText.setForeground(Color.black);
    descriptionText.setBackground(Color.pink);
    descriptionText.setFont(font2);
    descriptionText.setLineWrap(true);
    descriptionText.setWrapStyleWord(true);
    descriptionText.setEditable(false);

    //add description text to the panel
    descriptorPanel.add(descriptionText);

    //set panel for menu bar buttons
    menuPanel.setBounds(0, 0, 800, 32);
    menuPanel.setBackground(Color.gray);
    menuPanel.setLayout(new GridLayout(1,6));
    
    //add the menu panel to the window
    add(menuPanel);

    //set save game button and add listener    
    sButton.setFont(font3);
    sButton.setFocusPainted(false);
    sButton.addActionListener(performer);
    sButton.setActionCommand("saveGame");

    //add the save button to the menu panel
    menuPanel.add(sButton);

    //set achievements button and add listener
    aButton.setFont(font3);
    aButton.setFocusPainted(false);
    aButton.addActionListener(performer);
    aButton.setActionCommand("openAchievements");

    //add achievements button to the menu panel
    menuPanel.add(aButton);

    //set quit game button and add listener
    qButton.setFont(font3);
    qButton.setFocusPainted(false);
    qButton.addActionListener(performer);
    qButton.setActionCommand("quitGame");

    //add quit button to the menu panel
    menuPanel.add(qButton);

    //set upgrade cookie button
    ucButton.setFont(font3);
    ucButton.setFocusPainted(false);
    ucButton.addActionListener(performer);
    ucButton.setActionCommand("upgradeCookie");

    //add upgrade cookie button to the menu panel
    menuPanel.add(ucButton);
  }

  /**
   *If an achievement is locked, checks to see if conditions are met to unlock it and alerts the user if that is so.

   *precondition: variables for achievement requirements must have values
   *postcondition: if an achievement has been unlocked, the variable for pinging a notification and the boolean value for the particular achievement will be set to true 
   */ 
  public static void checkAchievements(){
    //checks if achievement 1 is locked
    if(!AchievementsMenu.a1unlocked){
      //checks if requirements for achievement 1 are met
      if(cCounter>=1){
        newAchievement = true;
        //unlocks achievement 1
        AchievementsMenu.a1unlocked = true;
      }
    }
    //checks if achievement 2 is locked
    if(!AchievementsMenu.a2unlocked){
      //checks if requirements for achievement 2 are met
      if(autoNum > 0 || bakeryNum > 0 || factoryNum > 0 || cargoNum > 0 || alienNum > 0 || monsterNum > 0){
        newAchievement = true;
        //unlocks achievement 2
        AchievementsMenu.a2unlocked = true;
      }
    }
    //checks if achievement 3 is locked
    if(!AchievementsMenu.a3unlocked){
      //checks if requirements for achievement 3 are met
      if(cCounter >= 100){
        newAchievement = true;
        //unlocks achievement 3
        AchievementsMenu.a3unlocked = true;
      }
    }    
    //checks if achievement 4 is locked
    if(!AchievementsMenu.a4unlocked){
      //checks if requirements for achievement 4 are met
      if(cookieUpgraded){
        newAchievement = true;
        //unlocks achievement 4
        AchievementsMenu.a4unlocked = true;
      }
    }    
    //checks if achievement 5 is locked    
    if(!AchievementsMenu.a5unlocked){
      //checks if requirements for achievement 5 are met
      if(cCounter>=1000){
        newAchievement = true;
        //unlocks achievement 5
        AchievementsMenu.a5unlocked = true;
      }
    }        
    //checks if achievement 6 is locked    
    if(!AchievementsMenu.a6unlocked){
      //checks if requirements for achievement 6 are met
      if(cCounter>=5000){
        newAchievement = true;
        //unlocks achievement 6
        AchievementsMenu.a6unlocked = true;
      }
    }
    //checks if achievement 7 is locked
    if(!AchievementsMenu.a7unlocked){
      //checks if requirements for achievement 7 are met
      if(autoNum>0 && bakeryNum>0 && factoryNum>0 && cargoNum>0 && alienNum>0 && monsterNum>0){
        newAchievement = true;
        //unlocks achievement 7
        AchievementsMenu.a7unlocked = true;
      }
    }
    //checks if achievement 8 is locked  
    if(!AchievementsMenu.a8unlocked){
      //checks if requirements for achievement 8 are met
      if(cCounter>=10000){
        newAchievement = true;
        //unlocks achievement 8
        AchievementsMenu.a8unlocked = true;
      }
    }
    //checks if achievement 9 is locked
    if(!AchievementsMenu.a9unlocked){
      //checks if requirements for achievement 9 are met
      if(autoNum>20 && bakeryNum>20 && factoryNum>20 && cargoNum>20 && alienNum>20 && monsterNum>20){
        newAchievement = true;
        //unlocks achievement 9
        AchievementsMenu.a9unlocked = true;
      }
    }
    //checks if achievement 10 is locked    
    if(!AchievementsMenu.a10unlocked){
      //checks if requirements for achievement 10 are met
      if(cCounter>=100000){
        newAchievement = true;
        //unlocks achievement 10
        AchievementsMenu.a10unlocked = true;
      }
    }
    //alerts user of new achievement 
    if(newAchievement){
      aButton.setText("Achievements (new)");
    }
  }

  /**
   *processes the incremental addition of cookies to the cookie counter and updates the cookies accumulated stat

   *precondition: a refresh rate must be established
   *postcondition: the cookie counter variable and cookies accumulated label will be updated and upgrades, cookie upgrades, and achievement requirements will have all been checked
   */ 
  public static void setTimer(){
    //set timer to incremetally add cookies based on the refresh rate
    timer = new Timer(refreshRate, new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e){
        //add a cookie to the counter
        cCounter++;
        //update the label to reflect the amount of cookies the user has accumulated
        counterLabel.setText(" "+cCounter + " cookies!!");
        //check if upgrades, cookie types, and achievement requirements have been unlocked
        checkUpgradesUnlocked();
        checkCookieUnlocked();
        checkAchievements();
      }
    });
  }

  /**
   *updates the rate at which the timer refreshes, thus updating the rate at which cookies are added and updates the cookies per second stat

   *precondition: an increase rate must be established
   *postcondition: the timer will be updated with the correct rate of performance, and the label for cookies per second will be updated 
   */ 
  public static void updateTimer(){
    //for when the timer has not yet started (ie no upgrades have been applied)
    if(!timerActive){
      //turn the timer on
      timerActive = true;
    }
    //for when the timer is already on
    else if(timerActive){
      //momentarily stop the timer
      timer.stop();
    }

    //calculate the refresh rate for the timer
    refreshRate = (int)(Math.round((1/incRate) * 1000));

    //adjust rate of increase to one decimal place
    DecimalFormat df = new DecimalFormat("#.##");
    displayedIncRate = df.format(incRate);

    //update the rate of increase label 
    incRateLabel.setText(" "+displayedIncRate + " cookies per sec");

    //restart the timer with the updated values
    setTimer();
    timer.start();
  }

  /**
   *checks if upgrades have been unlocked and updates the button labels correspondingly

   *precondition: none
   *postcondition: if upgrades have been unlocked, their corrsponding button labels will have been changed 
   */
  public static void checkUpgradesUnlocked(){
    //for if the bakery upgrade has not yet been unlocked
    if(!bakeryUnlocked){
      //check if the user has 100 cookies
      if(cCounter >= 100){
        //unlock the bakery and update the button label
        bakeryUnlocked = true;
        upgrade2.setText("Bakery (0)");
      }
    }
    
    //for if the factory upgrade has not yet been unlocked
    if(!factoryUnlocked){
      //check if the user has 500 cookies
      if(cCounter >= 500){
        //unlock the factory and update the button label
        factoryUnlocked = true;
        upgrade3.setText("Factory (0)");
      }
    }

    //for if the cargo ship upgrade has not yet been unlocked
    if(!cargoUnlocked){
      //check if the user has 1000 cookies
      if(cCounter >= 1000){
        //unlock the cargo ship upgrade and update the button label
        cargoUnlocked = true;
        upgrade4.setText("Cargo Ship (0)");
      }
    }

    //for if the alien tech upgrade has not yet been unlocked
    if(!alienUnlocked){
      //check if the user has 2000 cookies
      if(cCounter >= 2000){
        //unlock the alien tech upgrade and update the button label
        alienUnlocked = true;
        upgrade5.setText("Alien Tech (0)");
      }
    }

    //for if the cookie monster upgrade has not yet been unlocked
    if(!monsterUnlocked){
      //check if the user has 5000 cookies
      if(cCounter >= 5000){
        //unlock the cookie monster upgrade and update the button label
        monsterUnlocked = true;
        upgrade6.setText("Cookie Monster (0)");
      }
    }     
  }

  /**
   *checks if each cookie type has been unlocked and disables other upgrade buttons accordingly so the user can only press a specific cookie upgrade

   *precondition: none
   *postcondition: if the user has sufficient cookies, the next cookie type will be unlocked, its button enabled, and the other cookie types disabled permanently.
   */ 
  public static void checkCookieUnlocked(){
    //if ONLY the chocolate chip cookie is unlocked (this is the default circumstance)
    if(ccUnlocked && !dcUnlocked && !ssUnlocked){
      //all buttons are disabled since there is nothing to upgrade
      UpgradeCookie.chocChip.setEnabled(false);
      UpgradeCookie.doubleChoc.setEnabled(false);
      UpgradeCookie.strawberryShortcake.setEnabled(false);
    }
    //if neither the double chocolate or strawberry cookies have been unlocked
    if(!dcUnlocked && !ssUnlocked){
      //check to see if the user has met the conditions to unlock the double chocolate cookie (10000+)
      if(cCounter >= 10000){
        dcUnlocked = true;
        ccUnlocked = false;
        //disables the chocolate chip and strawberry buttons, enables the double chocolate buttons to allow user to upgrade
        UpgradeCookie.chocChip.setEnabled(false);
        UpgradeCookie.doubleChoc.setEnabled(true);
        UpgradeCookie.strawberryShortcake.setEnabled(false);
      }
    }
    //if strawberry is not unlocked and user has already upgraded past choclolate chip
    if(!ssUnlocked && !ccUnlocked){
      //if the user meets the requirements for strawberry cookies (20000+)
      if(cCounter >= 20000){
        ssUnlocked = true;
        dcUnlocked = false;
        //disables all buttons other than strawberry cookie button
        UpgradeCookie.chocChip.setEnabled(false);
        UpgradeCookie.doubleChoc.setEnabled(false);
        UpgradeCookie.strawberryShortcake.setEnabled(true);
      }
    }
  }

  /**
   *creates font presets to be used throughout the program

   *precondition: none
   *postcondition: none
   */ 
  public static void makeFont(){
    font1 = new Font("TimesRoman", Font.BOLD, 24);
    font2 = new Font("Helvetica", Font.PLAIN, 16);
    font3 = new Font("TimesRoman", Font.PLAIN, 12);
    font4 = new Font("TimesRoman", Font.BOLD, 16);
  }

  /**
   *updates the image displayed for the cookie button depending on which cookie type is currently in use and adds an updated button

   *precondition: a multiplier variable must be set; must be 1, 2, or 4
   *postcondition: the graphics variables for the cookie button will be updated to correspond to the cookie type selected and the button icon will be updated
   */ 
  public static void updateCookieIcon(){
    //for if the current cookie is the chocolate chip cookie
    if(multiplier == 1){
      //update the current icon to the correct graphic
      cButton.setIcon(cccookie1);
      //set the graphic variables to the correct graphics
      cookieGraphic1 = cccookie1;
      cookieGraphic2 = cccookie2;
    }  
    //for if the current cookie is the double chocolate chip cookie
     else if (multiplier == 2){
      //update the current icon to the correct graphic
      cButton.setIcon(dccookie2);
      //set cookieUpgraded boolean to true
      cookieUpgraded = true;
      //set the graphic variables to the correct graphics
      cookieGraphic1 = dccookie1;
      cookieGraphic2 = dccookie2;
    }
    //for if the current cookie is the strawberry shortcake cookie
    else if (multiplier == 4){
      //update the current icon to the correct graphic
      cButton.setIcon(sscookie1);
      //set cookieUpgraded boolean to true
      cookieUpgraded = true;
      //set the graphic variables to the correct graphics
      cookieGraphic1 = sscookie1;
      cookieGraphic2 = sscookie2;
    }
    //add an updated instance of the cookie button to the panel
    cPanel.add(cButton);
  }

  /**
   *adds the correct quantity of graphics to the graphics panel for each upgrade type

   *precondition: a grphics panel for each upgrade type must be contructed, variables for the quantity of each upgrade must be set to a value
   *postcondition: the correct quantity of graphics for each ugrade type will have been added to the graphics panel
   */ 
  public static void updateUpgradeIcon(){
    //add graphics for auto click upgrade
    //loop through however many times in correspondence to number of the upgrade purchased
    for(int i = 0; i < autoNum; i++){
      //add the auto click upgrade graphic to the auto click graphic panel
      GraphicsPanel.addToGraphics(GraphicsPanel.auto, MyFrame.autoclickPanel);
    }
    //add graphics for bakery upgrade
    //loop through however many times in correspondence to number of the upgrade purchased
    for(int j = 0; j < bakeryNum; j++){
      //add the bakery upgrade graphic to the bakery graphic panel
      GraphicsPanel.addToGraphics(GraphicsPanel.bakery, MyFrame.bakeryPanel);
    }
    //add graphics for factory upgrade
    //loop through however many times in correspondence to number of the upgrade purchased
    for(int k = 0; k < factoryNum; k++){
      //add the factory upgrade graphic to the factory graphic panel
      GraphicsPanel.addToGraphics(GraphicsPanel.factory, MyFrame.factoryPanel);
    }
    //add graphics for cargo ship upgrade
    //loop through however many times in correspondence to number of the upgrade purchased
    for(int l = 0; l < cargoNum; l++){
      //add the cargo ship upgrade graphic to the cargo ship graphic panel
      GraphicsPanel.addToGraphics(GraphicsPanel.cargo, MyFrame.cargoshipPanel);
    }
    //add graphics for alien tech upgrade
    //loop through however many times in correspondence to number of the upgrade purchased
    for(int m = 0; m < alienNum; m++){
      //add the alien tech upgrade graphic to the alien tech graphic panel
      GraphicsPanel.addToGraphics(GraphicsPanel.alien, MyFrame.alienPanel);
    }
    //add graphics for cookie monster upgrade
    //loop through however many times in correspondence to number of the upgrade purchased
    for(int n = 0; n < monsterNum; n++){
      //add the cookie monster upgrade graphic to the cookie monster graphic panel
      GraphicsPanel.addToGraphics(GraphicsPanel.cookiemonster, MyFrame.monsterPanel);
    }
  }
}