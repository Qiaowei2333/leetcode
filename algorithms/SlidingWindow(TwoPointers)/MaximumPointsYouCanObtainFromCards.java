// lc 1423 和 windsum lint604 类似
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for (int p : cardPoints) {
            sum += p;
        }
        if (n == k) return sum;
        int m = n - k;
        int minSum = 0;
        int tempSum = 0;
        for (int i = 0; i < n; i++) {
            if (i < m) {
                tempSum += cardPoints[i];
                if (i == m - 1) minSum = tempSum;
            }
            else {
                tempSum += (cardPoints[i] - cardPoints[i - m]);
                minSum = Math.min(minSum, tempSum);
            }
        }
        return sum - minSum;
    }
}
