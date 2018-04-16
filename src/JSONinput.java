import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class JSONinput {
    public static ArrayList<Coin> getCurrentPrices() {
        JSONParser parser = new JSONParser();
        ArrayList<Coin> coins = new ArrayList<>();

        try {
            URL oracle = new URL("https://www.binance.com/api/v1/ticker/allPrices");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);

                for (Object o : a) {
                    JSONObject tutorials = (JSONObject) o;

                    String symbol = (String) tutorials.get("symbol");
                    String priceString = (String) tutorials.get("price");

                    if (symbol.contains("USD")) {
                        String name = "";
                        switch (symbol) {
                            case "BTCUSDT":
                                name = "Bitcoin";
                                break;
                            case "ETHUSDT":
                                name = "Ethereum";
                                break;
                            case "BNBUSDT":
                                name = "Binance Coin";
                                break;
                            case "BCCUSDT":
                                name = "Bitcoin Cash";
                                break;
                            case "NEOUSDT":
                                name = "NEO";
                                break;
                            case "LTCUSDT":
                                name = "Litecoin";
                                break;
                            case "QTUMUSDT":
                                name = "QTUM";
                                break;
                        }
                        double price = Double.parseDouble(priceString);
                        coins.add(new Coin(name, price, 0));
                    }
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return coins;
    }
}
