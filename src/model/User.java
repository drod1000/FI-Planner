package model;

public class User {
    private final String name;
    private double annualSalary;
    private double cashOnHand = 0;

    public User(String name, double annualSalary) {
        this.name = name;
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        // TODO: 5/12/17 Update amounts with formatting for currency 
        return "User named " +
                name +
                " with an annual salary of " +
                annualSalary +
                " and " +
                cashOnHand +
                " cash on hand.";
    }
}
