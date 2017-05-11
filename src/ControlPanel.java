import java.awt.event.*;
import javax.swing.*;

// Represents a control panel for a craps "table"

public class ControlPanel extends JPanel
        implements ActionListener
{
    private AdventureTable table;

    // Constructor
    public ControlPanel(AdventureTable t)
    {
        table = t;
        JButton rollButton = new JButton("Roll 1");
        JButton roll2Button = new JButton("Roll 2");
        rollButton.setActionCommand("1Die");
        roll2Button.setActionCommand("2Die");
        rollButton.addActionListener(this);
        roll2Button.addActionListener(this);
        add(rollButton);
        add(roll2Button);
    }

    // Called when the roll button is clicked
    public void actionPerformed(ActionEvent e)
    {
        if (!table.diceAreRolling())
            if (e.getActionCommand().equals("1Die")) {
                table.rollDice();
            } else if (e.getActionCommand().equals("2Die")) {
                table.rollTwoDice();
            }
    }
}
