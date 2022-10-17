/*
Jeffrey Cheung
Michelle Wang
Vinson Zhang

Jun 23, 2021

This program is a cookie clicker game. Click the cookie button on the left to add cookies manually. Buy upgrades on the right panel or in the upgrade window using your cookies to automatically produce more cookies. Upgrading your cookie type resets your game, but with an added multiplier for quicker progress. Try to unlock all the achievements. Remember to save your game!
*/
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
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *this class contains methods responsible for creating windows for the main menu and main game, as well as holding presets for values for important game variables
 * Made by: Jeffrey Cheung, Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class Main extends JFrame{
  
  /**
   *the main method

   *precondition: none
   
   *postcondition: none
   */ 
  public static void main(String[] args) {
    new Main();
  }
  /**
   *calls methods to set up fonts and create main menu

   *precondition: none
   *postcondition: fonts will be set up
   */ 
  public Main(){
    
    //prepare fonts
    MyFrame.makeFont();
    createMainMenu();
  }
  
  /**
   *adds various functional display elements to the window

   *@startType whether to start new game or load existing save

   *precondition: startType must either be "new" or "load"
   *postcondition: either variables will be set to defaults and a new game will be created, or the program will read in data from saveFile.txt to load a previous game, the timer will be set if applicable, if the refreshrate is not zero (if upgrades have already been bought) the timer will be started, the main wwindow will be created
   */ 
  public static void mainGame(String startType){
    
    //if the user chooses to start a new game
    if (startType.equals("new")){
      setDefault(); //sets default settings
      MyFrame.checkCookieUnlocked(); //called to disable all upgrade cookie type buttons
    }

    //if the user chooses to load a previous save
    else if (startType.equals("load")){
      loadData(); 
      
      MyFrame.updateCookieIcon(); //sets the appropriate cookie type
      MyFrame.updateUpgradeIcon(); //fills in the appropriate number of upgrade icons in the center
      MyFrame.checkCookieUnlocked(); //checks which cookie type upgrades have been unlocked and disables/enables buttons accordingly

      //starts the automatic increase
      MyFrame.setTimer();

      //starts timer if upgrades have been previously purchased
      if(MyFrame.refreshRate != 0)
        MyFrame.timer.start();
      
    }
    
    //creates the main cookie clicker game window
    MyFrame mFrame = new MyFrame("Cookie Clicker");
    mFrame.setSize(800,600);
    mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mFrame.getContentPane().setBackground(new Color(194, 248, 255));
    mFrame.setLayout(null);
    mFrame.setResizable(false);
    mFrame.setVisible(true);
  }

  /**
   *resets all game stats to default values

   *precondition: a MyFrame object must be constructed with all the variables declared
   *postcondition: all of the in-game stats, values, and conditions will be reset back to defaults
   */ 
  public static void setDefault(){
    MyFrame.cCounter = 0;
    MyFrame.incRate = 0; 
    MyFrame.timerActive = false;
    MyFrame.bakeryUnlocked = false;
    MyFrame.factoryUnlocked = false;
    MyFrame.cargoUnlocked = false;
    MyFrame.alienUnlocked = false;
    MyFrame.monsterUnlocked = false;
    MyFrame.autoNum = 0;
    MyFrame.autoPrice = 10;
    MyFrame.bakeryNum = 0;
    MyFrame.bakeryPrice = 100;
    MyFrame.factoryNum = 0;
    MyFrame.factoryPrice = 500;
    MyFrame.cargoNum = 0;
    MyFrame.cargoPrice = 1000;
    MyFrame.alienNum = 0;
    MyFrame.alienPrice = 2000;
    MyFrame.monsterNum = 0;
    MyFrame.monsterPrice = 5000;
    MyFrame.ccUnlocked = true;
    MyFrame.dcUnlocked = false;
    MyFrame.ssUnlocked = false;
  }  

  /**
   *loads data from saveFile.txt

   *precondition: a file called saveFile.txt must exist with variable values filled in the exact order that they appear in the following method, a MyFrame object with all variables declared must already exist
   *postcondition: values for each of the MyFrame variables will be read from the text file and set to restore progress from a previous save
   */ 
  public static void loadData(){
    try{
      BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));

      MyFrame.cCounter = Integer.parseInt(br.readLine());
      MyFrame.incRate = Double.parseDouble(br.readLine());
      MyFrame.timerActive = Boolean.parseBoolean(br.readLine());
      MyFrame.bakeryUnlocked = Boolean.parseBoolean(br.readLine());
      MyFrame.factoryUnlocked = Boolean.parseBoolean(br.readLine());
      MyFrame.cargoUnlocked = Boolean.parseBoolean(br.readLine());
      MyFrame.alienUnlocked = Boolean.parseBoolean(br.readLine());
      MyFrame.monsterUnlocked = Boolean.parseBoolean(br.readLine());
      MyFrame.autoNum = Integer.parseInt(br.readLine());
      MyFrame.autoPrice = Integer.parseInt(br.readLine());
      MyFrame.bakeryNum = Integer.parseInt(br.readLine());
      MyFrame.bakeryPrice = Integer.parseInt(br.readLine());
      MyFrame.factoryNum = Integer.parseInt(br.readLine());
      MyFrame.factoryPrice = Integer.parseInt(br.readLine());
      MyFrame.cargoNum = Integer.parseInt(br.readLine());
      MyFrame.cargoPrice = Integer.parseInt(br.readLine());
      MyFrame.alienNum = Integer.parseInt(br.readLine());
      MyFrame.alienPrice = Integer.parseInt(br.readLine());
      MyFrame.monsterNum = Integer.parseInt(br.readLine());
      MyFrame.monsterPrice = Integer.parseInt(br.readLine());
      MyFrame.refreshRate = Integer.parseInt(br.readLine());
      MyFrame.multiplier = Integer.parseInt(br.readLine());
      MyFrame.saveName = br.readLine();
      MyFrame.ccUnlocked = Boolean.parseBoolean(br.readLine());
      MyFrame.dcUnlocked = Boolean.parseBoolean(br.readLine());
      MyFrame.ssUnlocked = Boolean.parseBoolean(br.readLine());
      
      br.close();

    }
    catch(Exception e){

    }
  }

  /**
   *creates the main menu window

   *precondition: none
   *postcondition: a window titled "Main Menu" will be created
   */ 
  public static void createMainMenu(){
    //make the menu window
    MainMenu menuFrame = new MainMenu("Main Menu");
    menuFrame.setSize(800,600);
    menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuFrame.setLayout(null);
    menuFrame.setVisible(true);
  }
}