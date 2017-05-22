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
        this.loan = new Loan(purchasePrice - downPayment);
    }

    public double getValue() {
        return value;
    }

    public double getPrincipalRemaining() {
        return loan.getPrincipalRemaining();
    }

    public double netWorth() {
        return value - getPrincipalRemaining();
    }

    public double yearlyNOI() {
        return purchasePrice * capRate;
    }

    private double yearlyNetIncome() {
        return yearlyNOI() - loan.yearlyInterestPaid();
    }

    private double yearlyDepreciation() {
        return (.85 * purchasePrice) / 27.5;
    }

    private double yearlyTaxableIncome() {
        return yearlyNetIncome() - yearlyDepreciation();
    }

    private double yearlyTaxDue() {
        return yearlyTaxableIncome() * .15;
    }

    public double yearlyCashFlow() {
        return yearlyNOI() - yearlyTaxDue();
    }

    public void yearPasses() {
        value *= 1 + APPRECIATION_RATE;
        loan.yearPasses();
    }
}
