package src;

// Represents a display panel for a Craps table

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;


public class DisplayPanel extends JPanel
{
    private JTextField rollsText, healthText;
    private int wonCount, lostCount;

    int rolls = 100;
    // Constructor
    public DisplayPanel()
    {
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

        /*pointText = new JTextField(5);
        pointText.setFont(displayFont);
        pointText.setEditable(false);
        pointText.setBackground(Color.DARK_GRAY);
        add(pointText);*/
    }

    // Updates this display, based on the result and
    // "point" in the previous roll
    public void update(int result, int point, ActionEvent e)
    {
        if (e.getActionCommand().equals("1Die")) {
            
            String currentRolls = rolls -1 + "";
            rollsText.setText(currentRolls);
            } else if (e.getActionCommand().equals("2Die")) {
            String currentRolls2 = rolls -2 + "";
            rollsText.setText(currentRolls2);
            }
    }
}

