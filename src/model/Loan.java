package model;

public class Loan {
    static final double INTEREST_RATE = .06;
    static final int NUMBER_OF_PAYMENTS = 240;
    private final double initialAmount;
    private double principalRemaining;
    private final double payment;

    public Loan(double initialAmount) {
        this.initialAmount = initialAmount;
        this.principalRemaining = initialAmount;
        this.payment = ((INTEREST_RATE / 12) * initialAmount) /
                (1 - Math.pow((1 + INTEREST_RATE/12), -NUMBER_OF_PAYMENTS));
    }

    public double getPrincipalRemaining() {
        return principalRemaining;
    }

    public void yearPasses() {
        // TODO: 5/17/17 Need check for once loan is paid off
        principalRemaining -= yearlyPrincipalPaid();
    }

    private double yearlyDebtService() {
        return payment * 12;
    }

    private double yearlyInterestPaid() {
        double totalInterest = 0;
        for(int i = 1; i <= 12; i++) {
            double monthlyInterest = principalRemaining * (INTEREST_RATE / 12);
            totalInterest += monthlyInterest;
        }
        return totalInterest;
    }

    private double yearlyPrincipalPaid() {
        return yearlyDebtService() - yearlyInterestPaid();
    }
}
