// https://leetcode.com/discuss/interview-question/376019/Twitter-or-OA-2019-or-Autoscale-Policy
import java.util.*;
public class UtilizationChecks {
    public static int finalInstance(int instances, List<Integer> averageUtil){
        if (averageUtil == null || averageUtil.size() == 0 || instances == 0) return 0;
        for (int i = 0; i < averageUtil.size(); i++) {
            if (averageUtil.get(i) < 25) {
                instances = (instances + 1) / 2; 
            }
            else if (averageUtil.get(i) >= 25 && averageUtil.get(i) <= 60) {
                continue;
            }
            else {
                if (instances <= 1e10) {
                    instances *= 2;
                }
            }
            i += 10;
        }
        return instances;
    }

    public static void main(String[] args){
        List<Integer> averageUtil = new ArrayList<>();
        // averageUtil.add(5);
        // averageUtil.add(10);
        // averageUtil.add(80);
        averageUtil.add(25);
        averageUtil.add(23);
        averageUtil.add(1);
        averageUtil.add(2);
        averageUtil.add(3);
        averageUtil.add(4);
        averageUtil.add(5);
        averageUtil.add(6);
        averageUtil.add(7);
        averageUtil.add(8);
        averageUtil.add(9);
        averageUtil.add(10);
        averageUtil.add(76);
        averageUtil.add(80);
        int res = finalInstance(2, averageUtil);
        System.out.println(res);
    }
}
