package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private double annualSalary;
    private double cashOnHand = 0;
    private int yearsPassed = 0;
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

    // TODO: 5/17/17 This should go in Display class
    public void generateCashFlowOutcome() {
        reset();
        for(int i = 1; i <= strategy.getYearsToIndepence(); i++) {
            yearPasses();
            System.out.printf(
                    "Year: %s, From Savings: %s, From Properties: %s, Cash: %s%n",
                    i,
                    yearlyCashFlowfromSavings(),
                    yearlyCashFlowFromProperties(),
                    cashOnHand);
        }
    }

    // TODO: 5/17/17 This should go in Display class
    public void generateBalanceSheetOutcome() {
        reset();
        for(int i = 1; i <= strategy.getYearsToIndepence(); i++) {
            yearPasses();
            System.out.printf("Year: %s, Cash: %s, Net Worth From Properties: %s, Total Net Worth: %s",
                    i,
                    cashOnHand,
                    netWorthFromProperties(),
                    totalNetWorth());
            // TODO: 5/17/17 Might want to pull this out into a detailed look
            for(Property property: properties) {
                System.out.printf("Property Value: %s, Property Principal: %s, Property Net: %s",
                        property.getValue(),
                        property.getPrincipalRemaining(),
                        property.netWorth());
            }
            System.out.printf("%n");
        }
    }

    private void reset() {
        cashOnHand = 0;
        yearsPassed = 0;
        properties = new ArrayList();
    }

    private void yearPasses() {
        if(yearsPassed > 0 && yearsPassed % strategy.getBuyingWindow() == 0) {
            // Note: Will change if preferred buffer is added
            buyProperty(cashOnHand);
        }

        cashOnHand += yearlyCashFlowfromSavings() + yearlyCashFlowFromProperties();

        for(Property property : properties) {
            property.yearPasses();
        }
        yearsPassed++;

    }

    private double yearlyCashFlowfromSavings() {
        return annualSalary * strategy.getSavingsRate();
    }

    private double yearlyCashFlowFromProperties() {
        double totalCashFlow = 0;

        for(Property property : properties) {
            totalCashFlow += property.yearlyCashFlow();
        }
        return totalCashFlow;
    }

    private void buyProperty(double downPayment) {
        double purchasingPower = downPayment / strategy.getDownPaymentPercentage();
        Property newProperty = new Property(purchasingPower, downPayment, strategy.getCapRate());

        properties.add(newProperty);
        cashOnHand -= downPayment;
    }

    private double netWorthFromProperties() {
        double total = 0;
        for(Property property : properties) {
            total += property.netWorth();
        }
        return total;
    }

    private double totalNetWorth() {
        return cashOnHand + netWorthFromProperties();
    }
}
