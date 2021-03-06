// Represents the craps table with two rolling dice

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AdventureTable extends JPanel
        implements ActionListener {
    private RollingDie die1, die2;
    private final int delay = 20;
    private Timer clock;
    private DisplayPanel display;
    int total;

    // Constructor
    public AdventureTable(DisplayPanel displ) {
        setBackground(Color.GREEN.darker());
        setBorder(new LineBorder(Color.BLACK, 3));
        display = displ;
        die1 = new RollingDie();
        die2 = new RollingDie();
        clock = new Timer(delay, this);
    }

    // Rolls the dice (called when the "Roll" button
    // is clicked)
    public void rollDice() {
        RollingDie.setBounds(3, getWidth() - 3, 3, getHeight() - 3);
        die1.roll();
        clock.start();
        total = die1.getNumDots();
    }

    public void rollTwoDice() {
        RollingDie.setBounds(3, getWidth() - 3, 3, getHeight() - 3);
        die1.roll();
        die2.roll();
        clock.start();
        total = die1.getNumDots() + die2.getNumDots();
    }

    public int updateRoll() {
        int realTotal = total;
        total = 0;
        return realTotal;
    }

    // Processes timer events
    public void actionPerformed(ActionEvent e) {
        if (diceAreRolling()) {
            if (!clock.isRunning())
                clock.restart();
            if (die1.isRolling())
                die1.avoidCollision(die2);
            else if (die2.isRolling())
                die2.avoidCollision(die1);
        } else {
            clock.stop();
        }
        repaint();
    }

    // returns true if dice are still rolling; otherwise
    // returns false
    public boolean diceAreRolling() {
        return die1.isRolling() || die2.isRolling();
    }

    // Called automatically after a repaint request
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        die1.draw(g);
        die2.draw(g);
    }
}


