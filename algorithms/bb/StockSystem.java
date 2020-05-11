import java.util.*;
public class StockSystem {

    //Solution2 TreeMap
    Map<String, Stock> map = new HashMap<>();
    Map<Stock, Integer> sortedMap = new TreeMap<>((a, b) -> {
        if (b.volume > a.volume) {
            return 1;
        } 
        else if (b.volume < a.volume) {
            return -1;
        }
        else {
            return a.name.compareTo(b.name);
        }
    });
    public void buy(String name, int vol) {
        if (map.containsKey(name)) {
            Stock cur = map.get(name);
            vol += cur.volume;
            Stock st = new Stock(name, vol);
            map.put(name, st);
            sortedMap.remove(cur);
            sortedMap.put(st, 1);
        } else {
            Stock st = new Stock(name, vol);
            map.put(name, st);
            sortedMap.put(st, 1);
        }
    }

    public List<Stock> getTopK(int k) {
        List<Stock> result = new LinkedList<>();
        for (Map.Entry<Stock, Integer> entry : sortedMap.entrySet()) {
            if (k == 0) {
                break;
            }
            result.add(entry.getKey());
            k--;
        }
        return result;
    }
    // Solution1 map and priority queue
    // Map<String, Stock> map = new HashMap<>();

    // public void buy(Stock stock) {
    //     if (map.containsKey(stock.name)) {
    //         int val = map.get(stock.name).volume;
    //         map.put(stock.name, new Stock(stock.name, stock.volume + val));
    //     } else {
    //         map.put(stock.name, stock);
    //     }
    // }

    // public List<Stock> getTopK(int k) {
    //     PriorityQueue<Map.Entry<String, Stock>> pq = new PriorityQueue<>((a, b) -> {
    //         return a.getValue().volume - b.getValue().volume;
    //     });

    //     for (Map.Entry<String, Stock> entry : map.entrySet()) {
    //         pq.offer(entry);
    //         if (pq.size() > k) {
    //             pq.poll();
    //         }
    //     }

    //     List<Stock> result = new LinkedList<>();
    //     while (!pq.isEmpty()) {
    //         Map.Entry<String, Stock> temp = pq.poll();
    //         result.add(0, temp.getValue());
    //     }
    //     return result;
    // }

    static class Stock {
        String name;
        int volume;
        public Stock(String name, int volume) {
            this.name = name;
            this.volume = volume;
        }
    }

    public static void main(String[] args) {
        StockSystem s = new StockSystem();
        // Stock st4 = new Stock("c", 4);
        // Stock st1 = new Stock("a", 4);
        // Stock st2 = new Stock("b", 2);
        // Stock st3 = new Stock("a", 2);
        // Map<Stock, Integer> sortedMap1 = new TreeMap<>((a, b) -> {
        //     if (b.volume > a.volume) {
        //         return 1;
        //     } 
        //     else if (b.volume < a.volume) {
        //         return -1;
        //     }
        //     else {
        //         return a.name.compareTo(b.name);
        //     }
        // });
        // sortedMap1.put(st4, 1);
        // sortedMap1.put(st1, 1);
        // sortedMap1.put(st2, 1);
        // sortedMap1.put(st3, 1);
        s.buy("c", 4);
        s.buy("a", 2);
        s.buy("b", 2);
        s.buy("a", 2);
        List<Stock> result = s.getTopK(2);
        for (Stock st : result) {
            System.out.println(st.name + ": " + st.volume);
        }

    }
}