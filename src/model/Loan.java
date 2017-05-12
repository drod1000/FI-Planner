package model;

public class Loan {
    static final double INTEREST_RATE = .06;
    static final int NUMBER_OF_PAYMENTS = 240;
    private final double initialAmount;
    private double principalRemaining;

    public Loan(double initialAmount) {
        this.initialAmount = initialAmount;
        this.principalRemaining = initialAmount;
    }
}
