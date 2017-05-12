package model;

public class Property {
    static final double APPRECIATION_RATE = .03;
    // TODO: 5/12/17 Add depreciation expense
    // Note: could potentially add rent increase percentage
    private double value;
    private final double purchasePrice;
    private final double capRate;

    public Property(double purchasePrice, double capRate) {
        this.value = purchasePrice;
        this.purchasePrice = purchasePrice;
        this.capRate = capRate;
    }

    public double yearlyCashFlow() {
        return purchasePrice * capRate;
    }

    public void yearPasses() {
        value *= 1 + APPRECIATION_RATE;
    }
}
