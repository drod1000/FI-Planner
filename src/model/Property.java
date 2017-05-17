package model;

public class Property {
    static final double APPRECIATION_RATE = .03;
    // TODO: 5/12/17 Add depreciation expense
    // Note: could potentially add rent increase percentage
    private double value;
    private final double purchasePrice;
    private final double capRate;
    private Loan loan;

    public Property(double purchasePrice, double downPayment, double capRate) {
        this.value = purchasePrice;
        this.purchasePrice = purchasePrice;
        this.capRate = capRate;
        this.loan = new Loan(downPayment);
    }

    public double yearlyCashFlow() {
        return purchasePrice * capRate;
    }

    public void yearPasses() {
        value *= 1 + APPRECIATION_RATE;
        loan.yearPasses();
    }
}
