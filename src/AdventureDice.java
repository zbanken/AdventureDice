import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class AdventureDice extends JFrame
{
  // Constructor
  DisplayPanel display;
  public AdventureDice()
  {
    super("AdventureDice");

    display = new DisplayPanel();
    AdventureTable table = new AdventureTable(display);
    ControlPanel controls = new ControlPanel(table, this);
      ChoicePanel choice = new ChoicePanel(table);

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
      panel.setBorder(new EmptyBorder(0, 5, 0, 5));
      panel.add(display, BorderLayout.NORTH);
      panel.add(table, BorderLayout.CENTER);
      panel.add(controls, BorderLayout.SOUTH);

    Container c = getContentPane();
    c.add(panel, BorderLayout.CENTER);
      c.add(choice, BorderLayout.SOUTH);
  }
  
  public DisplayPanel getDisplay()
  {
     return display;    
  }

  public static void main(String[] args)
  {
    AdventureDice window = new AdventureDice();
    window.setBounds(100, 100, 800, 600);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
