import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVoutput {
    public static void createCSV(ArrayList<Trade> history) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("tradeHistory.csv"));
        //StringBuilder ist performanter als selbst strings zusammenzufügen
        StringBuilder sb = new StringBuilder();
        sb.append("Coin");
        sb.append(';');
        sb.append("Price");
        sb.append(';');
        sb.append("Amount");
        sb.append('\n');

        for (Trade trade : history) {
            sb.append(trade.getName());
            sb.append(';');
            sb.append(trade.getPrice());
            sb.append(';');
            sb.append(trade.getAmount());
            sb.append('\n');
        }

        pw.write(sb.toString());
        pw.close();
//        System.out.println("done!");
        //Eventueller Fallstrick: Wenn der User ; eingibt etc. --> Zum Parsen Library verrwenden
    }
}
