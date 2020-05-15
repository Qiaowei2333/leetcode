// lc 1086
import java.util.*;

public class HighFive {
	public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            else {
                return b[1] - a[1];
            }
        });
        
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(items[0][0], 0));
        
        for (int i = 1; i < items.length; i++) {
            if (items[i][0] == items[i - 1][0]) {
                continue;
            }
            list.add(new Pair(items[i][0], i));
        }
        
        int[][] result = new int[list.size()][2];
        int idx = 0;
        for (Pair<Integer, Integer> entry : list) {
            int index = entry.getValue();
            int count = 5;
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += items[index + i][1];
            }
            int avg = sum / count;
            result[idx][0] = items[index][0];
            result[idx][1] = avg;
            idx++;
        }
        return result;
	}
	
	public static void main(String[] args) {
		HighFive s = new HighFive();
		int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int[][] result = s.highFive(items);
		System.out.println(Arrays.toString(result));
	}
}