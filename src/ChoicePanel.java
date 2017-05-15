package src;

import java.awt.event.*;
import javax.swing.*;

// Represents a control panel for a craps "table"

public class ChoicePanel extends JPanel
        implements ActionListener
{
    private AdventureTable table;

    // Constructor
    public ChoicePanel(AdventureTable t)
    {
        table = t;
        JButton Option1 = new JButton("Option 1");
        JButton Option2 = new JButton("Option 2");
        Option1.setActionCommand("Option1");
        Option2.setActionCommand("Option2");
        Option1.addActionListener(this);
        Option2.addActionListener(this);
        add(Option1);
        add(Option2);
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
