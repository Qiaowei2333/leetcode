// https://leetcode.com/discuss/interview-question/861453/
import java.util.*;
public class ItemsInContainers {
    // time O(m + n) m: length of s, n: size of startIndices
    public static List<Integer> numberOfItems(String s, List<Integer> start, List<Integer> end) {
        List<Integer> res = new ArrayList<>();
        char[] sc = s.toCharArray();
        int[] twLeft = new int[sc.length];
        int[] twRight = new int[sc.length];
        int[] preSum = new int[sc.length];
        
        int compartPos = -1;
        for (int i = 0; i < twLeft.length; i++) {
            if (sc[i] == '|') {
                compartPos = i;
            }
            twLeft[i] = compartPos;
        }

        compartPos = -1;
        for (int i = twRight.length - 1; i >= 0; i--) {
            if (sc[i] == '|') {
                compartPos = i;
            }
            twRight[i] = compartPos;
        }
        
        int countSt = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (sc[i] == '*') countSt++;
            preSum[i] = countSt; 
        }

        for (int i = 0; i < start.size(); i++) {
            int left = start.get(i) - 1;
            int right = end.get(i) - 1;
            int leftBound = twRight[left];
            int rightBound = twLeft[right];
            int numOfStars = preSum[rightBound] - preSum[leftBound];
            res.add(numOfStars); 
        }
        
        return res;
    }

    public static void main(String[] args) {
        ItemsInContainers s = new ItemsInContainers();
        String str = "**|***|***";
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        start.add(1);
        start.add(1);
        start.add(3);

        end.add(5);
        end.add(6);
        end.add(7);

        List<Integer> res = s.numberOfItems(str, start, end);
        System.out.println(res);
    }
}
