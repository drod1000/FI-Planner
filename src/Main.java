import model.Strategy;
import model.User;

public class Main {

    public static void main(String[] args) {

        Prompter prompter = new Prompter();
        User user = prompter.getUserInfo();
        Strategy strategy = prompter.getStrategyInfo();

        user.setStrategy(strategy);
    }
}
