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

/**
 *this class is responsible for perfoming actions in response to button pressed events for buttons created in MyFrame, including purchasing upgrades, opening an achievements or upgrade cookie window, and saving the game
 * Made by: Jeffrey Cheung, Michelle Wang, Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class ActionPerformer implements ActionListener{
  //declare writeFile object to append String to the saveFile text file, without clearing the data
  private WriteFile data = new WriteFile("saveFile.txt", true);
  //declares writeFile object to clear the file in order to add new data
  private WriteFile clearData = new WriteFile("saveFile.txt", false);

  /**
   *performs various functions depending on which button has been pressed. these actions correspond to buttons made in MyFrame.java

   *@e the button pressed event

   *precondition: buttons must be constructed and accessible to the user. they must have action listeners added and action commands declared, MyFrame object has been made
   *postcondition: the corresponding function of each button will have been performed
   */ 
  public void actionPerformed(ActionEvent e){
    //store the action command of the button pressed
    String action = e.getActionCommand();

    //perform the function that the action command is set for
    //for when user clicks the cookie
    if (action.equals ("Click")){
      //update cookie counter and label
      MyFrame.cCounter += MyFrame.multiplier;
      MyFrame.counterLabel.setText
      (MyFrame.cCounter + " cookies!!");
      
      //for if the game is loaded with an inactive timer (ie conditions do not get automatically incrementally checked)
      if(!MyFrame.timerActive){
        //check for upgrades, achievement, and cookie type, and update values and elements correspondingly
        MyFrame.checkUpgradesUnlocked();
        MyFrame.checkAchievements();
        MyFrame.checkCookieUnlocked();
      }
    }

    //for when user clicks the auto click upgrade
    if (action.equals ("Auto")){
      //check if the user meets the requirement to purchase the upgrade. deducts cookie counter if successful 
      checkUpgrade("Auto", MyFrame.autoPrice, 5, 0.1, true);
      
      //for if the user can purchase the upgrade
      if(MyFrame.successfulUpgrade){
        //updates the price of Auto
        MyFrame.autoPrice += 5;
        //updates the number of Auto upgrades
        MyFrame.autoNum++;
        //updates the upgrade button
        upgradeButton(MyFrame.upgrade1, "Auto", MyFrame.autoNum);
        //add a auto click graphic
        GraphicsPanel.addToGraphics(GraphicsPanel.auto, MyFrame.autoclickPanel);
      }
    }

    //for when user clicks the bakery upgrade
    if (action.equals ("Bakery")){
      //check if the user meets the requirement to purchase the upgradev. deducts cookie counter if successful 
      checkUpgrade("Bakery", MyFrame.bakeryPrice, 50, 1, MyFrame.bakeryUnlocked);
      
      //for if the user can purchase the upgrade
      if(MyFrame.successfulUpgrade){
        //updates the price of Bakery 
        MyFrame.bakeryPrice += 50;
        //updates the number of Bakery upgrades
        MyFrame.bakeryNum++;
        //updates the upgrade button
        upgradeButton(MyFrame.upgrade2, "Bakery", MyFrame.bakeryNum);
        //add a bakery graphic
        GraphicsPanel.addToGraphics(GraphicsPanel.bakery, MyFrame.bakeryPanel);
      }
    }

    //for when the user clicks the factory upgrade
    if (action.equals ("Factory")){
      //check if the user meets the requirement to purchase the upgrade. deducts cookie counter if successful 
      checkUpgrade("Factory", MyFrame.factoryPrice, 200, 5, MyFrame.factoryUnlocked);
      
      //for if the user can purchase the upgrade
      if(MyFrame.successfulUpgrade){
        //updates the price of Bakery
        MyFrame.factoryPrice += 200;
        //updates the number of Bakery upgrades
        MyFrame.factoryNum++;
        //updates the factory button
        upgradeButton(MyFrame.upgrade3, "Factory", MyFrame.factoryNum);
        //add a factory graphic
        GraphicsPanel.addToGraphics(GraphicsPanel.factory, MyFrame.factoryPanel);
      }
    }

    //for when the user clicks the cargo ship upgrade
    if (action.equals ("CargoShip")){
      //check if the user meets the requirement to purchase the upgrade. deducts cookie counter if successful 
      checkUpgrade("Cargo Ship", MyFrame.cargoPrice, 500, 10, MyFrame.cargoUnlocked);
      
      if(MyFrame.successfulUpgrade){
        //updates the price of cargoship
        MyFrame.cargoPrice += 500;
        //updates the number of cargoship upgrades
        MyFrame.cargoNum++;
        //updates the cargo ship button
        upgradeButton(MyFrame.upgrade4, "Cargo Ship", MyFrame.cargoNum);
        //add a cargo ship graphic
        GraphicsPanel.addToGraphics(GraphicsPanel.cargo, MyFrame.cargoshipPanel);
      }
    }

    //for when the user clicks the alien tech upgrade
    if (action.equals ("AlienTech")){
      //check if the user meets the requirement to purchase the upgrade. deducts cookie counter if successful 
      checkUpgrade("Alien Tech", MyFrame.alienPrice, 1000, 15, MyFrame.alienUnlocked);
      
      //for if the user can purchase the upgrade
      if(MyFrame.successfulUpgrade){
        //updates the price of alien tech
        MyFrame.alienPrice += 1000;
        //updates the number of alien tech upgrades
        MyFrame.alienNum++;
        //updates the alien tech button
        upgradeButton(MyFrame.upgrade5, "Alien", MyFrame.alienNum);
        //add a alien graphic
        GraphicsPanel.addToGraphics(GraphicsPanel.alien, MyFrame.alienPanel);
      }
    }


    //for when the user clicks the cookie monster upgrade
    if (action.equals("CookieMonster")){
      //check if the user meets the requirement to purchase the upgrade. deducts cookie counter if successful 
      checkUpgrade("Cookie Monster", MyFrame.monsterPrice, 2000, 10, MyFrame.monsterUnlocked);
      
      //for if the user can purchase the upgrade
      if(MyFrame.successfulUpgrade){
        //updates the price of Cookie Monster 
        MyFrame.monsterPrice += 2000;
        //updates the number of Cookie Monster upgrades
        MyFrame.monsterNum++;
        //updates the cookie monster button
        upgradeButton(MyFrame.upgrade6, "Cookie Monster", MyFrame.monsterNum);
        //add a cookie monster graphic
        GraphicsPanel.addToGraphics(GraphicsPanel.cookiemonster, MyFrame.monsterPanel);
      }
    }
    
    
    //for if the user presses the achievements button
    if (action.equals("openAchievements")){
      //clears the top half of the achievementswindow
      AchievementsMenu.descriptionText.setText("");
      AchievementsMenu.descriptionPanel.removeAll();
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.descriptionPanel.revalidate();
      AchievementsMenu.descriptionPanel.repaint();
      AchievementsMenu.iconPanel.revalidate();
      AchievementsMenu.iconPanel.repaint();

      //update achievement completetion status and buttons when the user opens an achievements window
      AchievementsMenu.updateAchievementsWindow();

      //create an AchievementsMenu object and set the window parameters
      AchievementsMenu aMenu = new AchievementsMenu("Achievements");
      aMenu.setSize(400,310);
      aMenu.getContentPane().setBackground(Color.black);
      aMenu.setLayout(null);
      aMenu.setVisible(true);
      aMenu.setResizable(false);
      MyFrame.newAchievement = false;
      MyFrame.aButton.setText("Achievements");

    }

    //for when the user clicks the save button
    if (action.equals("saveGame")){
      //call the saveData method to write the save file
      saveData();
    }
    

    //for when the user clicks the save and quit button
    if(action.equals("quitGame")){
      //call the saveData method to write the save file
      saveData();

      //close the game
      System.exit(0);

      
    }
  
    //for when the user clicks the upgrade cookie button
    if(action.equals("upgradeCookie")){
      //create an UpgradeCookie object and set window parameters
      UpgradeCookie ucMenu = new UpgradeCookie("Upgrade Cookie");
      ucMenu.setSize(400,400);
      ucMenu.setVisible(true);
      ucMenu.setResizable(false);
      ucMenu.setLayout(null);
    }
  }

  public void checkUpgrade (String upgrade, int purchasePrice, int priceIncrease, double increaseRate, boolean isUnlocked){
    //checks if the user can afford it
    if(MyFrame.cCounter >= purchasePrice){
      //deducts purchase price
      MyFrame.cCounter -= purchasePrice;

      MyFrame.successfulUpgrade = true;

      //increase the subsequent purchase price
      purchasePrice += priceIncrease; //THIS IS FOR INTERNAL METHOD USE ONLY. This will NOT update the price in the actual program, MyFrame.______Price += x; will still need to be used
      

      //update cookie counter label
      MyFrame.counterLabel.setText(MyFrame.cCounter + " cookies!!");
      //update the description description
      MyFrame.descriptionText.setText(upgrade+"\nprice: " + purchasePrice + " cookies\nProduces "+increaseRate+" cookies per second");

      //update auto increase rate
      MyFrame.incRate += increaseRate*MyFrame.multiplier;
      //update timer to add more cookies per second
      MyFrame.updateTimer();
    }
    //if unlocked but not enough cookies
    else if (isUnlocked){
      MyFrame.descriptionText.setText("not enough cookies!");
      MyFrame.successfulUpgrade = false;
    }
    else if (!isUnlocked){
      MyFrame.descriptionText.setText("not even unlocked!");
      MyFrame.successfulUpgrade = false;
    }
  }

  //this method is used in conjunction with the checkUpgrade() to update the cookie counter button
  public void upgradeButton(JButton targetButton, String upgradeName, int upgradeQuantity){
    targetButton.setText(upgradeName+" ("+upgradeQuantity+")");
  }

  public void saveData(){
    //writes MyFrame.cCounter and clears file
    try{
      clearData.writeToFile(Integer.toString(MyFrame.cCounter));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.incRate
    try{
      data.writeToFile(Double.toString(MyFrame.incRate));
    }
    catch(Exception g){
      System.out.print("File write error");
    }
      
    //writes MyFrame.timerActive
    try{
      data.writeToFile(Boolean.toString(MyFrame.timerActive));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.bakeryUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.bakeryUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.factoryUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.factoryUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.cargoUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.cargoUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.alienUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.alienUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.monsterUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.monsterUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.autoNum
    try{
      data.writeToFile(Integer.toString(MyFrame.autoNum));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.autoPrice
    try{
      data.writeToFile(Integer.toString(MyFrame.autoPrice));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.bakeryNum
    try{
      data.writeToFile(Integer.toString(MyFrame.bakeryNum));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.bakeryPrice
    try{
      data.writeToFile(Integer.toString(MyFrame.bakeryPrice));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.factoryNum
    try{
      data.writeToFile(Integer.toString(MyFrame.factoryNum));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.factoryPrice
    try{
      data.writeToFile(Integer.toString(MyFrame.factoryPrice));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.cargoNum
    try{
      data.writeToFile(Integer.toString(MyFrame.cargoNum));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.cargoPrice
    try{
      data.writeToFile(Integer.toString(MyFrame.cargoPrice));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.alienNum
    try{
      data.writeToFile(Integer.toString(MyFrame.alienNum));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.alienPrice
    try{
      data.writeToFile(Integer.toString(MyFrame.alienPrice));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.monsterNum
    try{
      data.writeToFile(Integer.toString(MyFrame.monsterNum));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.monsterPrice
    try{
      data.writeToFile(Integer.toString(MyFrame.monsterPrice));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.refreshRate
    try{
      data.writeToFile(Integer.toString(MyFrame.refreshRate));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.multiplier
    try{
      data.writeToFile(Integer.toString(MyFrame.multiplier));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.saveName
    try{
      data.writeToFile(MyFrame.saveName);
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.ccUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.ccUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.dcUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.dcUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }

    //writes MyFrame.ssUnlocked
    try{
      data.writeToFile(Boolean.toString(MyFrame.ssUnlocked));
    }
    catch(Exception g){
      System.out.print("File write error");
    }



    //gives success notice on description panel
    MyFrame.descriptionText.setText("Save Successful!");
  }
}