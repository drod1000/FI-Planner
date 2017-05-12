package model;

public class Property {
    static final double APPRECIATION_RATE = .03;
    // TODO: 5/12/17 Add depreciation expense 
    private double value;
    private final double capRate;

    public Property(double value, double capRate) {
        this.value = value;
        this.capRate = capRate;
    }
}
