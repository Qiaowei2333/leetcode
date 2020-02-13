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
import java.util.*;
public class TopNBuzzwords {
    private static List<String> topNBuzzwords(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        List<String> result = new LinkedList<>();
        Map<String, int[]> map = new HashMap<>();
        for (String toy : toys) {
            map.put(toy, new int[] {0, 0});
        }

        for (String quote : quotes) {
            String[] words = quote.split("\\w+");
            Set<String> set = new HashSet<>();
            for (String word : words) {
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
                return a.getValue()[0] - b.getValue()[0]; 
            }
        });

        for (Map.Entry<String, int[]> entry: map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > topToys) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        String quote = "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!";
        String[] words = quote.toLowerCase().split("\\W+");
        for (String word : words) {
            System.out.println(word);
        }
    }
}




// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(topToys(6, 2, new String[] { "elmo", "elsa", "legos", "drone", "tablet", "warcraft" }, 6,
                new String[] { "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                        "The new Elmo dolls are super high quality",
                        "Expect the Elsa dolls to be very popular this year, Elsa!",
                        "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                        "For parents of older kids, look into buying them a drone",
                        "Warcraft is slowly rising in popularity ahead of the holiday season" }));
    }

    public static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        Map<String, int[]> freq = new HashMap<>();
        for (String toy : toys) {
            freq.put(toy, new int[] { 0, 0 });
        }

        for (String quote : quotes) {
            Set<String> used = new HashSet<>();

            String[] words = quote.toLowerCase().split("\\W+");
            for (String word : words) {
                if (!freq.containsKey(word)) {
                    continue;
                }

                int[] nums = freq.get(word);

                nums[0]++;
                if (!used.contains(word)) {
                    nums[1]++;
                }

                used.add(word);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
            if (freq.get(t1)[0] != freq.get(t2)[0]) {
                return freq.get(t1)[0] - freq.get(t2)[0];
            }

            if (freq.get(t1)[1] != freq.get(t2)[1]) {
                return freq.get(t1)[1] - freq.get(t2)[1];
            }

            return t2.compareTo(t1);
        });

        if (topToys > numToys) {
            for (String toy : freq.keySet()) {
                if (freq.get(toy)[0] > 0) {
                    pq.add(toy);
                }
            }
        } else {
            for (String toy : toys) {
                pq.add(toy);

                if (pq.size() > topToys) {
                    pq.poll();
                }
            }
        }

        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }

        Collections.reverse(output);

        return output;
    }
}