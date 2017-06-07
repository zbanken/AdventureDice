import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel
        implements ActionListener {
    private AdventureDice game;
    private EasySound buttons;
    private JButton actionButton, runAwayButton;

    // Constructor
    public ControlPanel(AdventureDice d, EasySound b) {
        buttons = b;
        game = d;
        actionButton = new JButton("Action");
        runAwayButton = new JButton("Run Away");
        actionButton.setActionCommand("Action");
        runAwayButton.setActionCommand("Run Away");
        disableButtons();
        actionButton.addActionListener(this);
        runAwayButton.addActionListener(this);
        add(actionButton);
        add(runAwayButton);
    }

    // Called when the roll button is clicked
    public void actionPerformed(ActionEvent e) {
        //buttons.playMusic("/Users/scrufulufugus/Developer/APCS/AdventureDice/src/Beep1.wav");
        if (!game.table.diceAreRolling()) {
            if (e.getActionCommand().equals("Action")) {
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

    public void setAction(String buttonText) {
        actionButton.setText(buttonText);
    }

    public void disableButtons() {
        actionButton.setEnabled(false);
        runAwayButton.setEnabled(false);
    }
    public void enableButtons() {
        actionButton.setEnabled(true);
        runAwayButton.setEnabled(true);
    }
}
