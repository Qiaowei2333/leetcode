// yama oa
// Input:
// numToys = 6
// topToys = 2
// toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
// numQuotes = 6
// quotes = [
// "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
// "The new Elmo dolls are super high quality",
// "Expect the Elsa dolls to be very popular this year, Elsa!",
// "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
// "For parents of older kids, look into buying them a drone",
// "Warcraft is slowly rising in popularity ahead of the holiday season"
// ];

// Output:
// ["elmo", "elsa"]

// Explanation:
// elmo - 4
// elsa - 4
// "elmo" should be placed before "elsa" in the result because "elmo" appears in 3 different quotes and "elsa" appears in 2 different quotes.
// 
import java.util.*;
public class TopNBuzzwords {
    private static List<String> topNBuzzwords(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        List<String> result = new LinkedList<>();
        Map<String, int[]> map = new HashMap<>();
        for (String toy : toys) {
            map.put(toy, new int[] {0, 0});
        }

        for (String quote : quotes) {
            String[] words = quote.toLowerCase().split("\\W+");
            Set<String> set = new HashSet<>();
            for (String word : words) {
                if (!map.containsKey(word)) {
                    continue;
                }
                int[] curNums = map.get(word);
                if (!set.contains(word)) {
                    curNums[0]++;
                }
                curNums[1]++;
                set.add(word);
            }
        }

        PriorityQueue<Map.Entry<String, int[]>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue()[1] == b.getValue()[1]) {
                if (b.getValue()[0] != a.getValue()[0]) {
                    return a.getValue()[0] - b.getValue()[0];
                } else {
                    return b.getKey().compareTo(a.getKey());
                }
            } else {
                return a.getValue()[1] - b.getValue()[1]; 
            }
        });

        for (Map.Entry<String, int[]> entry: map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > topToys) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            Map.Entry<String, int[]> curEntry = queue.poll();
            if (curEntry.getValue()[1] > 0) {
                result.add(0, curEntry.getKey());
            }    
        }

        return result;
    }

    public static void main(String[] args) {
        int topToys = 5;
        int numToys = 0;
        // String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        String[] toys = {};
        int numQuotes = 6;
        String[] quotes = {
            "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
            "The new Elmo dolls are super high quality",
            "Expect the Elsa dolls to be very popular this year, Elsa!",
            "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
            "Elsa For parents of older kids, look into buying them a drone",
            "Warcraft is slowly rising in popularity ahead of the holiday season" 
        };

        List<String> result = topNBuzzwords(numToys, topToys, toys, numQuotes, quotes);
        System.out.println(result);
    }
}