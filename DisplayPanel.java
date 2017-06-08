

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class DisplayPanel extends JPanel {
    private JTextField rollsText, healthText;

    public DisplayPanel() {
        super(new GridLayout(2, 3, 10, 0));
        setBorder(new EmptyBorder(0, 0, 5, 0));

        add(new JLabel("    Rolls Left:"));
        add(new JLabel("    Health:"));

        Font displayFont = new Font("Monospaced", Font.BOLD, 16);

        rollsText = new JTextField("" + rolls, 15);
        rollsText.setFont(displayFont);
        rollsText.setEditable(false);
        rollsText.setBackground(Color.WHITE);
        add(rollsText);

        healthText = new JTextField("100", 5);
        healthText.setFont(displayFont);
        healthText.setEditable(false);
        healthText.setBackground(Color.WHITE);
        add(healthText);
    }

    public boolean checkHealth() {
        if (Integer.valueOf(healthText.getText()) <= 0) {
            return false;
        }
        return true;
    }

    public void addHealth(int add) {
        if (Integer.valueOf(healthText.getText())+add > 0) {
            healthText.setText(String.valueOf(Integer.valueOf(healthText.getText()) + add));
        }
        else {
            healthText.setText("0");
        }
    }

    int rolls = 100;

    public void update(ActionEvent e) {
        if (rolls > 0) {
            if (e.getActionCommand().equals("Fight")) {
                rolls = rolls - 1;
                String currentRolls = rolls + "";
                rollsText.setText(currentRolls);
            }
        }
    }
}
