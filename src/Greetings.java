/**
 * Created by scrufulufugus on 9/16/16.
 */
public class Greetings {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Not enough Vars");
        }
        else {
            String firstName = args[0];
            String lastName = args[1];
            System.out.println("Hello, " + firstName + " " + lastName);
            System.out.println("Congrats on you 1,000,000,000 program");
        }
    }
}
