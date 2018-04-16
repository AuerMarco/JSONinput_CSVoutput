import java.text.DecimalFormat;

public class Coin {
    private String coinName;
    private double coinPrice;
    private double amountPossessed;

    public Coin(String coinName, double coinPrice, double amountPossessed) {
        this.coinName = coinName;
        this.coinPrice = coinPrice;
        this.amountPossessed = amountPossessed;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public double getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(double coinPrice) {
        if (coinPrice > 0) {
            this.coinPrice = coinPrice;
        }
    }

    public double getAmountPossessed() {
        return amountPossessed;
    }

    public void setAmountPossessed(double amountPossessed) {
        if (amountPossessed >= 0) {
            this.amountPossessed = amountPossessed;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return coinName + " || Current price: " + df.format(coinPrice) + "$ || Owned: " + amountPossessed + " || Worth: " + df.format((amountPossessed * coinPrice)) + "\n===========================";
    }
}
