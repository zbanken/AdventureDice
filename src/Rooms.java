import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;
/**
 * Write a description of class Rooms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rooms extends AdventureDice
{
    int r = 2;
    int c = 2;
    int[] currentRoom = {r,c};

    private static final String[][] roomArray = { 
            {"","", "Entrance", "", "", "", ""},
            {"","", "Ladder", "", "", "", ""},
            {"Sword in a stone","Passage with a monster", "Rocky Room", "Blazing Fire", "Locked Green Door", "Red Monster", ""},
            {"","", "", "Unlocked Purple door", "", "", ""},
            {"","", "", "Ladder going down", "", "", ""},
            {"","Room with a monster", "Tunnel", "Tall Room", "BookShelf", "Secret Room", ""},
            {"","", "", "tunnel", "", "", ""},
            {"Room with a monster","Tunnel", "Tunnel", "Narrom Room", "Tunnel", "Tunnel", "Room with a monster"},
            {"","", "", "Locked Yellow Door", "", "", ""},
            {"","Room with a well", "Tunnel", "Long Room", "Tunnel", "Large Chest", ""},
            {"","", "", "Tunnel", "", "", ""},
            {"Golden Chest","Damp Room", "Locked Door", "Smelly Room", "Locked Door", "Spike Pit", ""},
            {"","Tunnel", "", "Tunnel", "", "", ""},
            {"Bucket","Puzzle Room", "", "Grey Monster", "", "", ""},
            {"","", "", "", "", "", ""},
            {"","", "", "", "", "", ""},
            {"","", "", "", "", "", ""},
            {"","", "", "", "", "", ""},
            {"","", "", "", "", "", ""},
            {"","", "", "", "", "", ""},
            {"","", "", "", "", "", ""},

        };  

    public void updateRoom(ActionEvent n)
    {
        
        if (n.getActionCommand().equals("NORTH")) {
            if (roomArray[r - 1][c] != "")
            {
                currentRoom[0] = r-1;
                super.journey.changeText(roomArray[currentRoom[0]][currentRoom[1]]);
            }
        

       
        }
    }
    
    
}
