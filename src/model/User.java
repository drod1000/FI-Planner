package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private double annualSalary;
    private double cashOnHand = 0;
    private Strategy strategy;
    private List<Property> properties = new ArrayList<Property>();

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

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    private void buyProperty(double downPayment) {
        double purchasingPower = downPayment / strategy.getDownPaymentPercentage();
        Property newProperty = new Property(purchasingPower, strategy.getCapRate());

        properties.add(newProperty);
        cashOnHand -= downPayment;
    }
}
