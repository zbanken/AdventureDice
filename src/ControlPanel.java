import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel
        implements ActionListener {
    private AdventureDice game;
    private EasySound buttons;
    private JButton fightButton, runAwayButton;

    // Constructor
    public ControlPanel(AdventureDice d, EasySound b) {
        buttons = b;
        game = d;
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
        //buttons.playMusic("/Users/scrufulufugus/Developer/APCS/AdventureDice/src/Beep1.wav");
        if (!game.table.diceAreRolling()) {
            if (e.getActionCommand().equals("Fight")) {
                game.table.rollDice();
                game.currentMap.callTags();
                game.getDisplay().update(e);
            } else if (e.getActionCommand().equals("Run Away")) {
                game.currentMap.gotoLastRoom();
                disableButtons();
                game.choice.enableButtons();
            }
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
