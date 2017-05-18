
public class Die {
    private int number;

    public void roll() {
        // Generate random number from 1 to 6
        number = (int) (Math.random() * 6 + 1);
    }

    public int getNumDots() {
        return number;
    }

    public static void main(String[] args) {
        Die redDie = new Die();
        redDie.roll();
    }
}
