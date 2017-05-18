/**
 * Created by scrufulufugus on 5/18/17.
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class AdventurePanel extends JPanel {
    private JTextArea AdventureText;


    public AdventurePanel() {
        super(new GridLayout(1, 3, 10, 10));
        setBorder(new EmptyBorder(0, 0, 5, 0));

        Font displayFont = new Font("Monospaced", Font.PLAIN, 11);

        AdventureText = new JTextArea("The adventure awaits");
        AdventureText.setFont(displayFont);
        AdventureText.setEditable(false);
        AdventureText.setBackground(Color.WHITE);
        add(AdventureText);
    }
}