import model.User;

import java.util.Scanner;

public class Prompter {
    Scanner in = new Scanner(System.in);

    public User getUserInfo() {
        System.out.println("Please enter your name");
        String name = in.nextLine();
        System.out.println("Please enter your annual salary");
        double annualSalary = in.nextDouble();

        User user = new User(name, annualSalary);

        return user;
    }
}
