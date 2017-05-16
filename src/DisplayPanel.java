// Represents a display panel for a Craps table

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class DisplayPanel extends JPanel {
    private JTextField rollsText, healthText;
    private int wonCount, lostCount;

    
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

    int rolls = 100;

    public void update(int result, int point, ActionEvent e) {
        //if(rolls < 0)
        //   rollsText.setText("0");

        
          if(rolls > 0)

        {

            if (e.getActionCommand().equals("1Die")) {
                rolls = rolls-1;
                String currentRolls = rolls + "";
                rollsText.setText(currentRolls);
            }
        }
        else if(rolls > 1) 
        {
            if (e.getActionCommand().equals("2Die")) {
                rolls = rolls-2;
                String currentRolls2 = rolls + "";
                rollsText.setText(currentRolls2);
            }
        }

    }
}
