import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    private Scanner reader;
    private ArrayList<Coin> coinList;
    private User user;

    public GUI() {
        reader = new Scanner(System.in);
        coinList = JSONinput.getCurrentPrices();
        user = new User();
    }

    public void options() {
        System.out.println("===========================");
        System.out.println("Welcome to the marketplace");
        System.out.println("===========================");
        String[] options = {": Show coins", ": Show balance", ": Show history", ": Update prices", ": Export trade history", ": Exit"};
        int optionCounter = 1;
        for (String option : options) {
            System.out.println("Option " + optionCounter + option);
            optionCounter++;
        }
        System.out.println("===========================");
        System.out.println("Please enter a number to choose your option: ");
        int choice = reader.nextInt();
        switch (choice) {
            case 1:
                showCoins();
                break;
            case 2:
                showBalance();
                options();
                break;
            case 3:
                showHistory();
                break;
            case 4:
                updatePrices();
                break;
            case 5:
                exportTradeHistory();
                break;
            case 6:
                System.out.println("Thanks for using my program.");
                break;
            default:
                System.out.println("Option not found. Try 1-6");
                options();
                break;
        }
    }

    private void showBalance() {
        System.out.println("User balance: " + user.getMoney());
        double worth = 0;
        for (Coin coin : coinList) {
            worth += coin.getCoinPrice() * coin.getAmountPossessed();
        }
        System.out.println("Possession worth: " + (user.getMoney() + worth));
    }

    private void showCoins() {
        showBalance();
        for (Coin coin : coinList) {
            System.out.println(coin.toString());
        }
        String[] options = {": Bitcoin Buy/Sell", ": Ethereum Buy/Sell", ": Binance Coin Buy/Sell", ": Bitcoin Cash Buy/Sell", ": NEO Buy/Sell", ": Litecoin Buy/Sell", ": QTUM Buy/Sell", ": Back to main menu", ": Exit"};
        int optionCounter = 1;
        for (String option : options) {
            System.out.println("Option " + optionCounter + option);
            optionCounter++;
        }
        System.out.println("===========================");
        System.out.println("Please enter a number to choose your option: ");
        int choice = reader.nextInt();
        switch (choice) {
            case 1:
                buySell(choice - 1);
                break;
            case 2:
                buySell(choice - 1);
                break;
            case 3:
                buySell(choice - 1);
                break;
            case 4:
                buySell(choice - 1);
                break;
            case 5:
                buySell(choice - 1);
                break;
            case 6:
                buySell(choice - 1);
                break;
            case 7:
                buySell(choice - 1);
                break;
            case 8:
                options();
                break;
            case 9:
                System.out.println("Thanks for using my program.");
                break;
            default:
                System.out.println("Option not found. Try 1-9");
                showCoins();
                break;
        }
    }

    private void buySell(int id) {
        System.out.println("===========================");
        System.out.println("Do you want to [b]uy or [s]ell?: ");
        String choice = reader.next();
        switch (choice.toLowerCase()) {
            case "b":
                double max = (user.getMoney() / coinList.get(id).getCoinPrice());
                System.out.println("Please enter the amount " + "(Max: " + max + ")");
                double amount = reader.nextDouble();
                Trade.buy(user, coinList.get(id), amount);
                System.out.println("You have bought " + amount + " " + coinList.get(id).getCoinName());
                break;
            case "s":
                max = coinList.get(id).getAmountPossessed();
                System.out.println("Please enter the amount " + "(Max: " + max + ")");
                amount = reader.nextDouble();
                Trade.sell(user, coinList.get(id), amount);
                System.out.println("You have sold " + amount + " " + coinList.get(id).getCoinName());
                break;
            case "m":
                options();
                break;
            case "x":
                System.out.println("Thanks for using my program.");
                break;
            default:
                System.out.println("Option not found. Try s, b, m or x");
                showCoins();
                break;
        }
        System.out.println("===========================");
        showCoins();
    }

    private void showHistory() {
//        Trade.buy(user, coinList.get(1), 10);
        for (Trade trade : user.getHistory()) {
            System.out.println("Coin: " + trade.getName() + " || Price: " + trade.getPrice() + " || Amount: " + trade.getAmount());
        }
        options();
    }

    private void updatePrices() {
        PriceChange.updatePrices(coinList, JSONinput.getCurrentPrices());
        System.out.println("Update complete.");
        options();
    }

    private void exportTradeHistory() {
        try {
            CSVoutput.createCSV(user.getHistory());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Export complete.");
        options();
    }

}
