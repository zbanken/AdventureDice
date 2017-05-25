import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

// Represents a control panel for a craps "table"

public class ChoicePanel extends JPanel 
implements ActionListener 
{
    private AdventureTable table;
    private Rooms map;

    // Constructor
    public ChoicePanel(AdventureTable t, Rooms currentMap)
    {
        table = t;
        map = currentMap;
        setLayout(new GridLayout(0,3));
        add(new JPanel());
        //add(new JButton("NORTH"));
        JButton northButton = new JButton("NORTH");
        northButton.setActionCommand("NORTH");
        northButton.addActionListener(this);
        add(northButton);

        add(new JPanel());
        //add(new JButton("WEST"));
        JButton westButton = new JButton("WEST");
        westButton.setActionCommand("WEST");
        westButton.addActionListener(this);
        add(westButton);

        add(new JPanel());
        //add(new JButton("EAST"));
        JButton eastButton = new JButton("EAST");
        eastButton.setActionCommand("EAST");
        eastButton.addActionListener(this);
        add(eastButton);

        add(new JPanel());
        //add(new JButton("SOUTH"));
        JButton southButton = new JButton("SOUTH");
        southButton.setActionCommand("SOUTH");
        southButton.addActionListener(this);
        add(southButton);
        
        add(new JPanel());
    }

    // Called when the roll button is clicked
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("NORTH")) {
            map.updateRoom(0, -1);
        }
        if (e.getActionCommand().equals("SOUTH")) {
            map.updateRoom(0, 1);
        }
        if (e.getActionCommand().equals("EAST")) {
            map.updateRoom(1, 0);
        }
        if (e.getActionCommand().equals("WEST")) {
            map.updateRoom(-1, 0);
        }
    }
}

