package model;

public class Property {
    static final double APPRECIATION_RATE = .03;
    // TODO: 5/12/17 Add depreciation expense 
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
}
