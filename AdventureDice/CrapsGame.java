// Implements the game of Craps logic

public class CrapsGame
{
  private int point = 0;
  private int firstRollDone = 0;
  /**
   *  Calculates the result of the next dice roll in the Craps game.
   *  The parameter total is the sum of dots on two dice.
   *  point is set to the saved total, if the game continues,
   *  or 0, if the game has ended.
   *  Returns 1 if player won, -1 if player lost,
   *  0 if player continues rolling.
   */
  public int processRoll(int total)
  {
      
    int result;

    if (firstRollDone == 0) {
        /*
        if (total == 2 || total == 3 || total == 12) {
            // Lose
            result = -1;
        }
        else if (total == 7 || total == 11) {
            // Win
            result = 1;
        }
        else {
            point = total;
            result = 0;
        }*/
        switch (total) {
            case 2:
            case 3:
            case 12:
                // Lose
                result = -1;
                break;
            case 7:
            case 11:
                // Win
                result = 1;
                break;
            default:
                point = total;
                result = 0;
        }
        firstRollDone = 1;
    }
    else {
        if (total == 7) {
            // Lose
            result = -1;
        }
        else if (total == point) {
            // Win
            result = 1;
        }
        else {
            point = total;
            result = 0;
        }
    }

    return result;
  }

  /**
   *  Returns the saved point
   */
  public int getPoint()
  {
    return point;
  }
}

