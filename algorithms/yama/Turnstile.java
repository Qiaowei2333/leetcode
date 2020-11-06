// https://leetcode.com/discuss/interview-question/853053/
import java.util.*;
public class Turnstile {
    public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        int[] res = new int[numCustomers];
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int time = 0;
        int i = 0; // customerId
        int lastDir = -1; // -1 not used  1 leaving   0 entering
        while (i < numCustomers || !enter.isEmpty() || !exit.isEmpty()) {
            // put customers at this time into queues
            while (i < numCustomers && arrTime[i] <= time) {
                if (direction[i] == 1) {
                    exit.offer(i);
                }
                else {
                    enter.offer(i);
                }
                i++;
            }

            // compare two queues, let one pop and go thru turnstile
            // enter not empty  exit not empty
            if (!enter.isEmpty() && !exit.isEmpty()) {
                if (lastDir == -1 || lastDir == 1) {
                    int curCus = exit.poll();
                    res[curCus] = time;
                    lastDir = 1;
                }
                else {
                    int curCus = enter.poll();
                    res[curCus] = time;
                    lastDir = 0;
                }
            }
            else if (!exit.isEmpty()) { // exit not empty  enter empty
                int curCus = exit.poll();
                res[curCus] = time;
                lastDir = 1;
            }
            else if (!enter.isEmpty()) { // enter not empty  exit empty
                int curCus = enter.poll();
                res[curCus] = time;
                lastDir = 0;
            }
            else { // enter empty   exit empty
                lastDir = -1;
                // skip time if next arrival time is longer than 1 sec
                time = arrTime[i] - 1;
            }
            time++;
        }
        return res;
    }

    public static void main(String[] args) {
        Turnstile s = new Turnstile();
        int numCustomers = 5;
        int[] arrTime = {0,1,1,3,3};
        int[] direction = {0, 1, 0, 0, 1};
        int[] res = s.getTimes(numCustomers, arrTime, direction);
        System.out.println(Arrays.toString(res));
    }
}
