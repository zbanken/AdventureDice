import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel
        implements ActionListener {
    private AdventureTable table;
    private AdventureDice parent;

    // Constructor
    public ControlPanel(AdventureTable t, AdventureDice d) {
        table = t;
        parent = d;
        JButton fightButton = new JButton("Fight");
        JButton runAwayButton = new JButton("Run Away");
        fightButton.setActionCommand("Fight");
        runAwayButton.setActionCommand("Run Away");
        fightButton.addActionListener(this);
        runAwayButton.addActionListener(this);
        add(fightButton);
        add(runAwayButton);
    }

    // Called when the roll button is clicked
    public void actionPerformed(ActionEvent e) {
        if (!table.diceAreRolling())
            if (e.getActionCommand().equals("Fight")) {
                table.rollDice();
                parent.getDisplay().update(1, 1, e);
            } else if (e.getActionCommand().equals("Run Away")) {
                
                
            }
    }
}
