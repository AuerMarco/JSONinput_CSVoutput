import java.util.ArrayList;

public class User {
    private double money;
    private ArrayList<Trade> history;
    private double profit;

    public User() {
        this.money = 10000;
        this.history = new ArrayList<>();
        this.profit = 0;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        }
    }

    public ArrayList<Trade> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Trade> history) {
        this.history = history;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        if (profit >= 0) {
            this.profit = profit;
        }
    }
}
