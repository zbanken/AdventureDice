import java.awt.event.*;
import javax.swing.*;

// Represents a control panel for a craps "table"

public class ControlPanel extends JPanel
        implements ActionListener
{
    private AdventureTable table;
    private AdventureDice parent;

    // Constructor
    public ControlPanel(AdventureTable t, AdventureDice d)
    {
        table = t;
        parent = d;
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
                parent.getDisplay().update(1,1,e);
            } else if (e.getActionCommand().equals("2Die")) {
                table.rollTwoDice();
                parent.getDisplay().update(1,1,e);
            }
    }
}
