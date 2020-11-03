// lc 218  sweep line alg O(nlogn) https://www.youtube.com/watch?v=8Kd-Tn_Rz7s&t=650s&ab_channel=HuaHua
import java.util.*;
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<Event> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new Event(b[0], b[2], 1));
            heights.add(new Event(b[1], b[2], -1));
        }
        Collections.sort(heights, (a, b) -> {
            if (a.x == b.x) {
                // a 7  1   b 8  1    把8放前面
                // a 7 -1   b 8  -1   把7放前面
                // a 7  1   b 8  -1   把1（进入）的7放前面
                // a 7 -1   b 8  1    把1（进入）的8放前面
                return b.h * b.isEntering - a.h * a.isEntering;
            }
            else {
                return a.x - b.x;
            }
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.valueOf(b) - Integer.valueOf(a));
        pq.offer(0);
        for (Event e : heights) {
            if (e.isEntering == 1) {
                if (e.h > pq.peek()) {
                    List<Integer> keyPoint = new ArrayList<>();
                    keyPoint.add(e.x);
                    keyPoint.add(e.h);
                    res.add(keyPoint);
                }
                pq.add(e.h);
            }
            else {
                pq.remove(e.h);
                if (e.h > pq.peek()) {
                    List<Integer> keyPoint = new ArrayList<>();
                    keyPoint.add(e.x);
                    keyPoint.add(pq.peek());
                    res.add(keyPoint);
                }
            }
        }
        return res;
    }

    static class Event {
        int x;
        int h;
        int isEntering;
        public Event(int x, int h, int isEntering) {
            this.x = x;
            this.h = h;
            this.isEntering = isEntering;
        }
    }

    public static void main(String[] args) {
        int[][] buildings = {{0, 1, 7},{1, 2, 7}};
        TheSkylineProblem s = new TheSkylineProblem();
        List<List<Integer>> res = s.getSkyline(buildings);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }
}
