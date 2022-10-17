import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

/**
 *this class is responsible for performing actions for various mouse events for buttons created in MyFrame
 * Made by: Jeffrey Cheung, Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class MouseDetector implements MouseListener{

  //for when the mouse is clicked
  @Override
  public void mouseClicked(MouseEvent e){

  }
  /**
   *performs actions when the mouse is pressed

   *@e mouse clicked event

   *precondition: the button must be constructed in MyFrame
   *postcondition: the graphic for the cookie button will have been changed
   */
  @Override
  public void mousePressed(MouseEvent e){
    //get the button that was pressed
    JButton b = (JButton)e.getSource();

    //for if the button pressed was the cookie button
    if(b == MyFrame.cButton){
      //change the cookie graphic to the second graphics variable
      MyFrame.cButton.setIcon(MyFrame.cookieGraphic2);
    }
  }
  /**
   *performs actions when the mouse is released

   *@e mouse released event

   *precondition: button must be constructed in MyFrame
   *postcondition: the graphic for the cookie button will have changed
   */ 
  @Override
  public void mouseReleased(MouseEvent e){
    //get the button that was released
    JButton b = (JButton)e.getSource();

    //if the button released is the cookie button
    if(b == MyFrame.cButton){
      //change the the cookie graphic to the first graphic variable
      MyFrame.cButton.setIcon(MyFrame.cookieGraphic1);
    }
  }
  /**
   *performs actions when the mouse enters a button

   *@e mouse entered event

   *precondition: button must be constructed by MyFrame
   *postcondition: the description for the corresponding upgrade will be displayed in the description box
   */ 
  @Override
  public void mouseEntered(MouseEvent e){
    //get the button entered
    JButton b = (JButton)e.getSource();

    //if the button was for the first upgrade
    if(b == MyFrame.upgrade1){
      //update the description panel to be visible with the corresponding informtation for the upgrade
      MyFrame.descriptorPanel.setVisible(true);
      MyFrame.descriptionText.setText("Auto Click\nprice: " + MyFrame.autoPrice + " cookies\nAutomatically clicks once every ten seconds");
    }
    //if the button was for the second upgrade
    else if(b == MyFrame.upgrade2){
      MyFrame.descriptorPanel.setVisible(true);
      //for if the upgrade is unlocked
      if (!MyFrame.bakeryUnlocked){
        //set desrciption to be "locked"
        MyFrame.descriptionText.setText("locked");
      }
      else{
        //update the description panel to be visible with the corresponding informtation for the upgrade
        MyFrame.descriptionText.setText("Bakery\nprice: " + MyFrame.bakeryPrice + " cookies\nProduces " + 1*MyFrame.multiplier + " cookie per second");
      }  
    }
    //if the button was for the third upgrade
    else if(b == MyFrame.upgrade3){
      MyFrame.descriptorPanel.setVisible(true);
      //for if the upgrade is unlocked
      if (!MyFrame.factoryUnlocked){
        //set desrciption to be "locked"
        MyFrame.descriptionText.setText("locked");
      }
      else{
        //update the description panel to be visible with the corresponding informtation for the upgrade
        MyFrame.descriptionText.setText("Factory\nprice: " + MyFrame.factoryPrice + " cookies\nProduces " + 5*MyFrame.multiplier +" cookie per second");
      }
    }
    //if the button was for the fourth upgrade
    else if(b == MyFrame.upgrade4){
      MyFrame.descriptorPanel.setVisible(true);
      //for if the upgrade is unlocked
      if (!MyFrame.cargoUnlocked){
        //set desrciption to be "locked"
        MyFrame.descriptionText.setText("locked");
      }
      else{
        //update the description panel to be visible with the corresponding informtation for the upgrade
        MyFrame.descriptionText.setText("Cargo Ship\nprice: " + MyFrame.cargoPrice + " cookies\nProduces " + 10*MyFrame.multiplier +" cookie per second");
      }
    }
    //if the button was for the fifth upgrade
    else if(b == MyFrame.upgrade5){
      MyFrame.descriptorPanel.setVisible(true);
      //for if the upgrade is unlocked
      if (!MyFrame.alienUnlocked){
        //set desrciption to be "locked"
        MyFrame.descriptionText.setText("locked");
      }
      else{
        //update the description panel to be visible with the corresponding informtation for the upgrade
        MyFrame.descriptionText.setText("Alien Tech\nprice: " + MyFrame.alienPrice + " cookies\nProduces " + 15*MyFrame.multiplier +" cookie per second");
      }
    }
    //if the button was for the sixth upgrade
    else if(b == MyFrame.upgrade6){
      MyFrame.descriptorPanel.setVisible(true);
      //for if the upgrade is unlocked
      if (!MyFrame.monsterUnlocked){
        //set desrciption to be "locked"
        MyFrame.descriptionText.setText("locked");
      }
      else{
        //update the description panel to be visible with the corresponding informtation for the upgrade
        MyFrame.descriptionText.setText("Cookie Monster\nprice: " + MyFrame.monsterPrice + " cookies\nProduces " + 20*MyFrame.multiplier +" cookie per second");
      }
    }
  }
  
  /**
   *performs actions when the mouse exits button

   *@e mouse exited event

   *precondition: button must be constructed by MyFrame
   *postcondition: the description box will become empty
   */
  @Override
  public void mouseExited(MouseEvent e){
    //get button that was exited
    JButton b = (JButton)e.getSource();
    
    //make the description panel disappear
    MyFrame.descriptorPanel.setVisible(false);

    //nullify the description text
    if(b == MyFrame.upgrade1 || b == MyFrame.upgrade2 || b == MyFrame.upgrade3 || b == MyFrame.upgrade4 || b == MyFrame.upgrade5 || b == MyFrame.upgrade6){
      MyFrame.descriptionText.setText(null);
    }
  }
}