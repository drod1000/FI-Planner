package model;

public class Strategy {
    private final double savingsRate;
    private final double capRate;
    private final double downPaymentPercentage;
    private final int buyingWindow;
    private final int yearsToFI;

    public Strategy(double savingsRate, double capRate, double downPaymentPercentage, int buyingWindow, int yearsToFI) {
        this.savingsRate = savingsRate;
        // TODO: 5/12/17 Add preferred buffer 
        this.capRate = capRate;
        this.downPaymentPercentage = downPaymentPercentage;
        // TODO: 5/12/17 Turn into double once basic functionality is finished 
        this.buyingWindow = buyingWindow;
        this.yearsToFI = yearsToFI;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "savingsRate=" + savingsRate +
                ", capRate=" + capRate +
                ", downPaymentPercentage=" + downPaymentPercentage +
                ", buyingWindow=" + buyingWindow +
                ", yearsToFI=" + yearsToFI +
                '}';
    }

    public double getSavingsRate() {
        return savingsRate;
    }

    public double getCapRate() {
        return capRate;
    }

    public double getDownPaymentPercentage() {
        return downPaymentPercentage;
    }

    public int getBuyingWindow() {
        return buyingWindow;
    }

    public int getYearsToIndepence() {
        return yearsToFI;
    }
}
