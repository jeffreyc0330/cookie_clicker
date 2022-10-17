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
 *this class performs actions based on button pressed events for buttons related to and created for the achievements menu
 * Made by: Jeffrey Cheung, Michelle Wang, Vinson Zhang
 * Last edited: Jun 23, 2021
 */
public class AchievementsActionPerformer implements ActionListener{

  /**
   *executes code depending on what button was triggered. Note: all actions in this method are tied to buttons in AchievementsMenu.java only.

   *@evt when a button is pressed

   *precondition: an object of the AchievementsMenu class must have been created, buttons must be setup with the appropriate action commands
   *postcondition: depending on what button was pressed, the information for each achievement will be displayed
   */ 
  public void actionPerformed(ActionEvent evt){
    String Aaction = evt.getActionCommand();

    //clears the description panel
    AchievementsMenu.updateAchievementsWindow();
    AchievementsMenu.descriptionPanel.removeAll();
    AchievementsMenu.descriptionPanel.revalidate();
    AchievementsMenu.descriptionPanel.repaint();

    //checks which condition the action corresponds to and dsiplays the icon, title, and description accordingly
    if (Aaction.equals("alocked")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon alockedIcon2 = new ImageIcon("res/alocked.png"); // load the image to a imageIcon
      Image alockedImage2 = alockedIcon2.getImage(); // transform it 
      Image newalockedImage2 = alockedImage2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
      alockedIcon2 = new ImageIcon(newalockedImage2);  // transform it back
      JLabel alockedLabel2 = new JLabel(alockedIcon2);
      AchievementsMenu.iconPanel.add(alockedLabel2);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Achievement Locked");
      AchievementsMenu.descriptionText.setText("Keep going to unlock this achievement!");

    }

    //the first achievement
    else if (Aaction.equals("a1")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.revalidate();
      AchievementsMenu.iconPanel.repaint();

      //resizes image and adds it to the panel
      ImageIcon a1Icon = new ImageIcon("res/a1button.png"); // load the image to a imageIcon
      Image a1Image = a1Icon.getImage(); // transform it 
      Image newa1Image = a1Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a1Icon = new ImageIcon(newa1Image);  // transform it back
      JLabel a1Label = new JLabel(a1Icon);
      AchievementsMenu.iconPanel.add(a1Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Beginner's Luck");
      AchievementsMenu.descriptionText.setText("Bake your first cookie.");
      
    }

    //the second achievement
    else if (Aaction.equals("a2")){
      //clears iconPanel
      
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.revalidate();
      AchievementsMenu.iconPanel.repaint();

      //resizes image and adds it to the panel
      ImageIcon a2Icon = new ImageIcon("res/a2button.png"); // load the image to a imageIcon
      Image a2Image = a2Icon.getImage(); // transform it 
      Image newa2Image = a2Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a2Icon = new ImageIcon(newa2Image);  // transform it back
      JLabel a2Label = new JLabel(a2Icon);
      AchievementsMenu.iconPanel.add(a2Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Amateur Baker");
      AchievementsMenu.descriptionText.setText("Purchase your first upgrade.");
    }

    //the third achievement
    else if (Aaction.equals("a3")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a3Icon = new ImageIcon("res/a3button.png"); // load the image to a imageIcon
      Image a3Image = a3Icon.getImage(); // transform it 
      Image newa3Image = a3Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a3Icon = new ImageIcon(newa3Image);  // transform it back
      JLabel a3Label = new JLabel(a3Icon);
      AchievementsMenu.iconPanel.add(a3Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Aficionado");
      AchievementsMenu.descriptionText.setText("Bake 100 cookies.");
    }

    //the fourth achievement
    else if (Aaction.equals("a4")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a4Icon = new ImageIcon("res/a4button.png"); // load the image to a imageIcon
      Image a4Image = a4Icon.getImage(); // transform it 
      Image newa4Image = a4Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a4Icon = new ImageIcon(newa4Image);  // transform it back
      JLabel a4Label = new JLabel(a4Icon);
      AchievementsMenu.iconPanel.add(a4Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Cookie Connoisseur");
      AchievementsMenu.descriptionText.setText("Upgrade your cookie.");
    }

    //the fifth achievement
    else if (Aaction.equals("a5")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a5Icon = new ImageIcon("res/a5button.png"); // load the image to a imageIcon
      Image a5Image = a5Icon.getImage(); // transform it 
      Image newa5Image = a5Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a5Icon = new ImageIcon(newa5Image);  // transform it back
      JLabel a5Label = new JLabel(a5Icon);
      AchievementsMenu.iconPanel.add(a5Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Workaholic");
      AchievementsMenu.descriptionText.setText("Bake 1000 cookies.");
    }

    //the sixth Achievement
    else if (Aaction.equals("a6")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a6Icon = new ImageIcon("res/a6button.png"); // load the image to a imageIcon
      Image a6Image = a6Icon.getImage(); // transform it 
      Image newa6Image = a6Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a6Icon = new ImageIcon(newa6Image);  // transform it back
      JLabel a6Label = new JLabel(a6Icon);
      AchievementsMenu.iconPanel.add(a6Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Cookie Mogul");
      AchievementsMenu.descriptionText.setText("Bake 5000 cookies.");
    }

    //the seventh achievement
    else if (Aaction.equals("a7")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a7Icon = new ImageIcon("res/a7button.png"); // load the image to a imageIcon
      Image a7Image = a7Icon.getImage(); // transform it 
      Image newa7Image = a7Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a7Icon = new ImageIcon(newa7Image);  // transform it back
      JLabel a7Label = new JLabel(a7Icon);
      AchievementsMenu.iconPanel.add(a7Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Capitalist");
      AchievementsMenu.descriptionText.setText("Purchase one of all the upgrades.");
    }

    //the eighth achievement
    else if (Aaction.equals("a8")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a8Icon = new ImageIcon("res/a8button.png"); // load the image to a imageIcon
      Image a8Image = a8Icon.getImage(); // transform it 
      Image newa8Image = a8Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a8Icon = new ImageIcon(newa8Image);  // transform it back
      JLabel a8Label = new JLabel(a8Icon);
      AchievementsMenu.iconPanel.add(a8Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Rolling in Dough");
      AchievementsMenu.descriptionText.setText("Bake 10,000 cookies.");
    }
    
    //the ninth achievement
    else if (Aaction.equals("a9")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a9Icon = new ImageIcon("res/a9button.png"); // load the image to a imageIcon
      Image a9Image = a9Icon.getImage(); // transform it 
      Image newa9Image = a9Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a9Icon = new ImageIcon(newa9Image);  // transform it back
      JLabel a9Label = new JLabel(a9Icon);
      AchievementsMenu.iconPanel.add(a9Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Flour Army");
      AchievementsMenu.descriptionText.setText("Purchase 20 of all upgrades.");
    }

    //the tenth achievement
    else if (Aaction.equals("a10")){
      //clears iconPanel
      AchievementsMenu.iconPanel.removeAll();
      AchievementsMenu.iconPanel.updateUI();

      //resizes image and adds it to the panel
      ImageIcon a10Icon = new ImageIcon("res/a10button.png"); // load the image to a imageIcon
      Image a10Image = a10Icon.getImage(); // transform it 
      Image newa10Image = a10Image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
      a10Icon = new ImageIcon(newa10Image);  // transform it back
      JLabel a10Label = new JLabel(a10Icon);
      AchievementsMenu.iconPanel.add(a10Label);

      //displays achievement description
      AchievementsMenu.descriptionLabel.setText("Get a life");
      AchievementsMenu.descriptionText.setText("Bake 1,000,000 cookies.");
    }
    //adds updated labels back onto description panel
    AchievementsMenu.descriptionPanel.add(AchievementsMenu.descriptionLabel);
    AchievementsMenu.descriptionPanel.add(AchievementsMenu.descriptionText);
    AchievementsMenu.descriptionPanel.revalidate();
    AchievementsMenu.descriptionPanel.repaint();
  }
}