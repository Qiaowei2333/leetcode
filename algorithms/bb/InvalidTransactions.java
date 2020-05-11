// lc 1169
import java.util.*;
public class InvalidTransactions {
    private class Transaction {
        String name;
        String city;
        int time;
        int amount;
        String transaction;
        public Transaction(String t) {
            String[] fields = t.split(",");
            this.name = fields[0];
            this.time = Integer.valueOf(fields[1]);
            this.amount = Integer.valueOf(fields[2]);
            this.city = fields[3];
            this.transaction = t;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return null;
        }
        List<Transaction> list = new ArrayList<>();
        for (String transaction : transactions) {
            list.add(new Transaction(transaction));
        }

        Collections.sort(list, (a, b) -> a.time - b.time);

        Set<String> res = new HashSet<>();
        for (int i = 0; i < transactions.length; i++) {
            Transaction leftTrans = list.get(i);
            if (leftTrans.amount > 1000) {
                res.add(leftTrans.transaction);
            }
            for (int j = i + 1; j < transactions.length; j++) {
                Transaction rightTrans = list.get(j);
                if (rightTrans.time - leftTrans.time <= 60 && rightTrans.name.equals(leftTrans.name) && !rightTrans.city.equals(leftTrans.city)) {
                    res.add(rightTrans.transaction);
                    res.add(leftTrans.transaction);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        InvalidTransactions s = new InvalidTransactions();
        String[] transactions = new String[]{"xnova,261,1949,chicago","bob,206,1284,chicago","xnova,420,996,bangkok","chalicefy,704,1269,chicago","iris,124,329,bangkok","xnova,791,700,amsterdam","chalicefy,572,697,budapest","chalicefy,231,310,chicago","chalicefy,763,857,chicago","maybe,837,198,amsterdam","lee,99,940,bangkok","bob,132,1219,barcelona","lee,69,857,barcelona","lee,607,275,budapest","chalicefy,709,1171,amsterdam"};
        List<String> res = s.invalidTransactions(transactions);
        System.out.println(res);
    }
}
// ["bob,132,1219,barcelona","xnova,261,1949,chicago","chalicefy,709,1171,amsterdam","lee,69,857,barcelona","lee,99,940,bangkok","bob,206,1284,chicago","chalicefy,704,1269,chicago"]
// ["xnova,261,1949,chicago","bob,206,1284,chicago","chalicefy,704,1269,chicago","chalicefy,763,857,chicago","lee,99,940,bangkok","bob,132,1219,barcelona","lee,69,857,barcelona","chalicefy,709,1171,amsterdam"]