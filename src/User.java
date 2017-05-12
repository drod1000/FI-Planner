public class User {
    private final String name;
    private double annualSalary;
    private double cashOnHand = 0;

    public User(String name, double annualSalary) {
        this.name = name;
        this.annualSalary = annualSalary;
    }
}
