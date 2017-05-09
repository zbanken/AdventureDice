import java.util.*;

public class ComputerPlayer
{
    private AdventureGame game;
    private Die redDie;
    private Die blackDie;
    private int winTotal;
    private int lossTotal;
    private int gameNum = 0;
    private ArrayList<Integer> rollLength = new ArrayList<Integer>();
    
    public ComputerPlayer()
    {
        System.out.println("$>________________________________");
        redDie = new Die();
        blackDie = new Die();
        game = new AdventureGame();
    }
    public void rollTheDice() {
        int total;
        String twoRolls;
        int rollNum = 0;
        int winLoss = 0;
        
        while (winLoss == 0) {
        
            redDie.roll();
            blackDie.roll();
            total = redDie.getNumDots() + blackDie.getNumDots();
            twoRolls = " (" + redDie.getNumDots() + ", " + blackDie.getNumDots() + ")";
            winLoss = game.processRoll(total);
            
            rollNum += 1;
            System.out.println("The total for roll " + rollNum + " is a " + total + twoRolls);
            
            if (winLoss == -1) {
                lossTotal += 1;
                System.out.println("Computer lost on roll " + rollNum);
            }
            else if (winLoss == 1) {
                winTotal += 1;
                System.out.println("Computer won on roll " + rollNum);
            }
        }
        rollLength.add(rollNum);
        gameNum += 1;
    }
    public double getWins0Loss() {
        double wL;
        if (lossTotal == 0){
            wL = (double)winTotal;
        }
        else {
            wL = ((double)winTotal / lossTotal);
        }
        return Double.parseDouble(String.format("%.2g%n", wL));
    }
    public int getAverageRollNum() {
        int advRollNum = 0;
        for (Integer number : rollLength) {
            advRollNum += number;
        }
        advRollNum = advRollNum / rollLength.size();
        
        return advRollNum;
    }
    public static void main(String[] args)
    {
        ComputerPlayer player = new ComputerPlayer();
        int i = 0;
        while (i < 1000) {
            player.rollTheDice();
            i += 1;
        }
        System.out.println("Computer's W/L rate was: " + player.getWins0Loss());
        System.out.println("Computer's average roll length was: " + player.getAverageRollNum());
    }
}