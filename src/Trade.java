public class Trade {
    private String name;
    private double price;
    private double amount;

    public Trade(Coin coin, double amount) {
        this.name = coin.getCoinName();
        this.price = coin.getCoinPrice();
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static void buy(User user, Coin coin, double amount) {
        if (user.getMoney() > 0 && user.getMoney() >= (coin.getCoinPrice() * amount)) {
            coin.setAmountPossessed(coin.getAmountPossessed() + amount);
            user.setMoney(user.getMoney() - coin.getCoinPrice() * amount);
            user.getHistory().add(new Trade(coin, amount));
        }
    }

    public static void sell(User user, Coin coin, double amount) {
        if (coin.getAmountPossessed() >= amount) {
            user.setMoney(user.getMoney() + (coin.getCoinPrice() * amount));
            coin.setAmountPossessed(coin.getAmountPossessed() - amount);
            user.getHistory().add(new Trade(coin, -amount));
        }
    }
}
