import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel
        implements ActionListener {
    private AdventureTable table;
    private AdventureDice parent;
    private JButton fightButton, runAwayButton;

    // Constructor
    public ControlPanel(AdventureTable t, AdventureDice d) {
        table = t;
        parent = d;
        fightButton = new JButton("Fight");
        runAwayButton = new JButton("Run Away");
        fightButton.setActionCommand("Fight");
        runAwayButton.setActionCommand("Run Away");
        disableButtons();
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
                parent.currentMap.gotoLastRoom();
                disableButtons();
                parent.choice.enableButtons();
            }
    }

    public void disableButtons() {
        fightButton.setEnabled(false);
        runAwayButton.setEnabled(false);
    }
    public void enableButtons() {
        fightButton.setEnabled(true);
        runAwayButton.setEnabled(true);
    }
}
