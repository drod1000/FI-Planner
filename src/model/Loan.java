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
}
