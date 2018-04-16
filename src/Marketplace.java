public class Marketplace {
    public static void main(String[] args) {
//        Coin coin = new Coin("Bitcoin", 3, 0);
//        User user = new User();
//        Trade.buy(user, coin, 10);
//        Trade.buy(user, coin, 120);
//        Trade.buy(user, coin, 2);
//        Trade.buy(user, coin, 12);
//        System.out.println(coin);
//        Trade.sell(user, coin, 1);
//        System.out.println(coin);
////        System.out.println("===========================");
//        System.out.println(user.getHistory().get(0).getName());
////        System.out.println(JSONinput.getCurrentPrices());
////        try {
////            CSVoutput.createCSV(user.getHistory());
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
        GUI gui = new GUI();
        gui.options();
    }
}
