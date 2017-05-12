import model.Strategy;
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

    public Strategy getStrategyInfo() {
        System.out.println("Please enter your target savings rate");
        double savingsRate = in.nextFloat() /100;
        System.out.println("Please enter your target cap rate");
        double capRate = in.nextFloat() / 100;
        System.out.println("Please enter your preferred down payment percentage");
        double downPaymentPercentage = in.nextFloat() / 100;
        System.out.println("Please enter your preferred buying window");
        int buyingWindow = in.nextInt();
        System.out.println("Please enter desired years to FI");
        int yearsToFI = in.nextInt();

        Strategy strategy = new Strategy(
                savingsRate,
                capRate,
                downPaymentPercentage,
                buyingWindow,
                yearsToFI);
        return strategy;
    }
}
