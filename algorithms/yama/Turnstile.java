// https://leetcode.com/discuss/interview-question/853053/
import java.util.*;
public class Turnstile {
    public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {

        int[] result = new int[numCustomers];
    
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
    
        Queue<int[]> entryQ = new ArrayDeque<int[]>();
        Queue<int[]> exitQ = new ArrayDeque<int[]>();
    
        int i = 0;
    
        int turnstileDirection = -1; // default unused-1
    
        for (int a : arrTime) {
    
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<int[]>());
            }
    
            map.get(a).add(new int[] { i, direction[i] });
    
            i++;
        }
    
        i = 0; // used to determine timeStamp, 
        while (numCustomers > 0) {
    
            if (map.containsKey(i)) {
                List<int[]> customers = map.get(i);
    
                for (int[] customer : customers) {
                    if (customer[1] == 1) {
                        exitQ.add(customer);
                    } else {
                        entryQ.add(customer);
                    }
                }
            }
    
            if (entryQ.isEmpty() && exitQ.isEmpty()) {
                turnstileDirection = -1;
                i++;
                continue;
            }
    
            int[] current;
            if (!entryQ.isEmpty() && !exitQ.isEmpty()) {
    
                switch (turnstileDirection) {
                case -1: // unused
                    current = exitQ.poll();
                    result[current[0]] = i;
                    numCustomers--;
                    turnstileDirection = 1;
                    i++;
                    break;
    
                case 1: // used for exit
                    current = exitQ.poll();
                    result[current[0]] = i;
                    numCustomers--;
                    turnstileDirection = 1;
                    i++;
                    break;
    
                case 0: // used to entry
                    current = entryQ.poll();
                    result[current[0]] = i;
                    numCustomers--;
                    turnstileDirection = 0;
                    i++;
                    break;
    
                }
                continue;
            }
    
            if (!entryQ.isEmpty()) {
                current = entryQ.poll();
                result[current[0]] = i;
                numCustomers--;
                turnstileDirection = 0;
                i++;
                continue;
            }
    
            if (!exitQ.isEmpty()) {
                current = exitQ.poll();
                result[current[0]] = i;
                numCustomers--;
                turnstileDirection = 1;
                i++;
                continue;
            }
        }
    
        return result;
    }

    public static void main(String[] args) {
        Turnstile s = new Turnstile();
        int numCustomers = 2;
        int[] arrTime = {0, 0};
        int[] direction = {1, 1};
        int[] res = s.getTimes(numCustomers, arrTime, direction);
        System.out.println(Arrays.toString(res));
    }
}
