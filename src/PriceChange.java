import java.util.ArrayList;

public class PriceChange {

    public static void updatePrices(ArrayList<Coin> coinList, ArrayList<Coin> currentCoins) {
        int counter = 0;
        for (Coin coin : coinList) {
            coin.setCoinPrice(currentCoins.get(counter).getCoinPrice());
            counter++;
        }
    }
}
