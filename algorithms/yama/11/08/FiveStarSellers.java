// https://leetcode.com/discuss/interview-question/854110/
import java.util.*;
public class FiveStarSellers {
    public int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold){
        int count = 0;
        double sumRatings = 0;
        for (List<Integer> ratings : productRatings) {
            sumRatings += 100.0 * ratings.get(0) / ratings.get(1);
        }
        Queue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (calIncrease(a) > calIncrease(b)) {// a increasement > b increasement, keep the order, a first
                return -1;
            }
            else if (calIncrease(b) > calIncrease(a)) {// b increasement > a increasement, reverse order, b first
                return 1;
            }
            else {
                return 0;
            }
        });
        for (List<Integer> ratings : productRatings) {// a increasement == b increasement, don't change any order
            pq.offer(ratings);
        }
        while (sumRatings < 1.0 * ratingsThreshold * productRatings.size()) {
            List<Integer> oldRatings = pq.poll();
            List<Integer> newRatings = new ArrayList<>();
            newRatings.add(oldRatings.get(0) + 1);
            newRatings.add(oldRatings.get(1) + 1);
            pq.offer(newRatings);
            sumRatings = sumRatings - 100.0 * oldRatings.get(0) / oldRatings.get(1) + 100.0 * newRatings.get(0) / newRatings.get(1);
            count++;
        }

        return count;
    }

    private double calIncrease(List<Integer> ratings) {
        double currRating = 100.0 * ratings.get(0) / ratings.get(1);
        double newRating = 100.0 * (ratings.get(0) + 1) / (ratings.get(1) + 1);
        return newRating - currRating;
    }

    public static void main(String[] args) {
        FiveStarSellers s = new FiveStarSellers();
        List<List<Integer>> productRatings = new ArrayList<>();
        productRatings.add(Arrays.asList(4, 4));
        productRatings.add(Arrays.asList(1, 2));
        productRatings.add(Arrays.asList(3, 6));
        int count = s.fiveStarReviews(productRatings, 77);
        System.out.println(count);
    }
}
