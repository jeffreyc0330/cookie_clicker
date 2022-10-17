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
import java.awt.event.*;
import javax.swing.*;

/**
 *this class contains methods responsible for populating the save name window with panels and buttons, as well as getting the user input for save name
 * Made by: Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class NameSave extends JFrame implements ActionListener{
  
  //label to prompt user to name their cookie empire
  private JLabel header = new JLabel("Name your cookie empire: ");

  //field for user to enter name
  private JTextField name = new JTextField(10);

  //button to confirm 
  private JButton confirm = new JButton("Lets go!");

  //jpanel to place header, field and button on
  private JPanel namePanel = new JPanel();

  /**
   *sets up the namePanel and confirm button, and adds it to the NameSave frame

   *@title the title of the NameSave frame to be created

   *precondition: title must be a String
   *postcondition: title will have been added to the window, panels and buttons will have been added to the window
   */ 
  public NameSave(String title){
    super(title); //sets the name of the frame

    namePanel.setBounds(0,25,400,150);
    namePanel.setBackground(new Color(194, 248, 255));
    namePanel.setLayout(new FlowLayout());
    
    add(namePanel);
    
    confirm.addActionListener(this);

    namePanel.add(header);
    namePanel.add(name);
    namePanel.add(confirm);
  }

  /**
   *sets the save name and creates a new game when the confirm button is pressed

   *@evt the button pressed event

   *precondition: a NameSave frame with the confirm button must already be set up
   *postcondition: the save name will be obtained from the user and a new game session will be created 
   */ 

  public void actionPerformed(ActionEvent evt){
    MyFrame.saveName = name.getText();
      
    
    //ADD CODE TO MAKE WINDOW AUTOCLOSE
    Main.mainGame("new");
  }
}