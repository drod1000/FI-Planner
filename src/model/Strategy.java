package model;

public class Strategy {
    private final double savingsRate;
    private final double capRate;
    private final double downPaymentPercentage;
    private final int buyingWindow;

    public Strategy(double savingsRate, double capRate, double downPaymentPercentage, int buyingWindow) {
        this.savingsRate = savingsRate;
        this.capRate = capRate;
        this.downPaymentPercentage = downPaymentPercentage;
        this.buyingWindow = buyingWindow;
    }
}
