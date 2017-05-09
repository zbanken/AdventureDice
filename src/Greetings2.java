/**
 * Created by scrufulufugus on 9/16/16.
 */

import java.util.Scanner;

public class Greetings2 {
    public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = kboard.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = kboard.nextLine();
        if (firstName == "" || lastName == "") {
            System.out.println("Error: NoName");
        }
        else {
            System.out.println("Hello, " + firstName + " " + lastName);
            System.out.println("Welcome to java");
        }
    }
}
