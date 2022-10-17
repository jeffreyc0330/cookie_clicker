import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *this class is responsible for creating graphics variables for each upgrade type and adding them to the graphics panel on the game screen
 * Made by: Jeffrey Cheung
 * Last edited: Jun 22, 2021
 */
public class GraphicsPanel{
  //create graphics variables for each upgrade's graphic
  public static ImageIcon auto = new ImageIcon("res/auto.png");
  public static ImageIcon bakery = new ImageIcon("res/bakery.png");
  public static ImageIcon factory = new ImageIcon("res/factory.png");
  public static ImageIcon cargo = new ImageIcon("res/cargo.png");
  public static ImageIcon alien = new ImageIcon("res/alien.png");
  public static ImageIcon cookiemonster = new ImageIcon("res/cookiemonster.png");

  /**
   *adds a graphic to the graphics panel by converting an ImageIcon to a JLabel, then adding it to a panel

   *@image the graphic that is to be made into a JLabel
   *@panel the panel which the graphic is to be added to

   *precondition: image must be an ImageIcon, panel must be a JPanel, graphics panels must be constructed in MyFrame
   *postcondition: a graphic will be added to the specified graphics panel
   */
  public static void addToGraphics(ImageIcon image, JPanel panel){
    //create a JLabel using an ImageIcon image
    JLabel graphicLabel = new JLabel (image);
    //add the JLabel to the specified JPanel graphics panel 
    panel.add(graphicLabel);
  }
}