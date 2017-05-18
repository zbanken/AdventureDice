import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

// Represents a control panel for a craps "table"

public class ChoicePanel extends JPanel 
implements ActionListener 
{
    private AdventureTable table;

    // Constructor
    public ChoicePanel(AdventureTable t)
    {
        table = t;
        setLayout(new GridLayout(0,3));
        add(new JPanel());
        add(new JButton("NORTH"));
        add(new JPanel());
        add(new JButton("WEST"));
        add(new JPanel());
        add(new JButton("EAST"));
        add(new JPanel());
        add(new JButton("SOUTH"));
        add(new JPanel());
        //add(Option1);
        //add(Option2);
    }

    // Called when the roll button is clicked
    public void actionPerformed(ActionEvent e)
    {
        if (!table.diceAreRolling())
            if (e.getActionCommand().equals("Option1")) {

            } else if (e.getActionCommand().equals("Option2")) {

            }
    }
}

