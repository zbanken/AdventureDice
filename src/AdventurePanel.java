/**
 * Created by scrufulufugus on 5/18/17.
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdventurePanel extends JPanel {
    private JTextArea AdventureText;

    public AdventurePanel() {
        super(new GridLayout(1, 3, 10, 10));
        setBorder(new EmptyBorder(0, 0, 5, 0));

        Font displayFont = new Font("Monospaced", Font.PLAIN, 24);

        AdventureText = new JTextArea("");
        AdventureText.setFont(displayFont);
        AdventureText.setEditable(false);
        AdventureText.setBackground(Color.WHITE);
        add(AdventureText);
    }

    public void changeText(String newText) {
        AdventureText.setText(newText);
    }

    public void appendText(String newText) {
        String oldText = AdventureText.getText();
        AdventureText.setText(oldText + "\n" + newText);
    }
}