// TEXT IQ 面经
// 买股票，有一群bidder，每个人有四个值，id，想买的share，出价price，入场顺序
// 公司有n个share出售。优先卖给出价高的人，如果出价一样就每个人根据入场顺序一份一份给，要输出一份都没有买到的人的id。
// example：bidders = {{1,5,5,1}, {2,7,7,3},{3,7,5,2}, {4,10,3,0}}, share = 18
// 先卖给出价7的2号，拿走7份走人，剩下11份share
// 两个出价5的人，一份一份分，两个人轮流分5份之后，1号满足走人
// 还剩1份，3号还想要2份，拿走最后一份，剩下0份
// 输出{4}

// 复习 comparator
// (a, b) 比较结果 -1，0，1，只有1时，（a,b）需要swap顺序
// 通过控制何时return 1 来swap a，b的顺序
import java.util.*;
public class StockBidder {
    public List<Integer> findBidderNoShare(List<int[]> bidders, int shares) {
        List<Integer> res = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[2] == b[2]) {
                    return a[3] - b[3];
                }
                else {
                    if (a[2] > b[2]) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                    //return b[2] - a[2];
                }
            }
        );
        for (int[] bidder : bidders) {
            pq.offer(bidder);
        }
        while (shares > 0) {
            int[] cur = pq.poll();
            shares -= cur[1];
        }
        while (!pq.isEmpty()) {
            int[] remains = pq.poll();
            res.add(remains[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        StockBidder s = new StockBidder();
        List<int[]> bidders = new ArrayList<>();
        bidders.add(new int[]{1,5,5,1});
        bidders.add(new int[]{2,7,7,3});
        bidders.add(new int[]{3,7,5,2});
        bidders.add(new int[]{4,10,3,0});
        List<Integer> res = s.findBidderNoShare(bidders, 18);
        System.out.println(res);
    }
}