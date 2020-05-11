import java.util.*;
// UDP packet ordering
// input: 一个pair 有 sequence number (int) 和 data (string)
// output: 按顺序拍好的string
// 举个栗子:
// input:
// {1,"aaa"}, {3,"ccc"}, {2,"bbb"}, {4,"ddd"}
// output:
// "aaa", "", "bbb ccc", "ddd"

//               time complexity      space complexity
//  worst case   O(n)                  O(n)
//  best case    O(1)                  O(1)
interface udp {
    public String order_packet(Pair<Integer, String> input);
}

public class SequenceNumber implements udp {
    int seq = 1;
    Map<Integer, String> buffer = new HashMap<>();

    public String order_packet(Pair<Integer, String> input) {
        int curSeq = input.getKey();
        String curStr = input.getValue();
        if (curSeq == seq) {
            seq++;
            // out put until no
            while (buffer.containsKey(seq)) {
                curStr += " " + buffer.remove(seq);
                seq++;
            }
            return curStr; 
        } else {
            buffer.put(curSeq, curStr);
            return null;
        }

    }

    public static void main(String[] args) {
        SequenceNumber s = new SequenceNumber();
        Pair<Integer, String> input1 = new Pair<>(2, "bbb"); 
        String output1 = s.order_packet(input1);
        System.out.println(output1);

        Pair<Integer, String> input2 = new Pair<>(3, "ccc"); 
        String output2 = s.order_packet(input2);
        System.out.println(output2);

        Pair<Integer, String> input3 = new Pair<>(1, "aaa"); 
        String output3 = s.order_packet(input3);
        System.out.println(output3);

        // Pair<Integer, String> input4 = new Pair<>(1, "a"); 
        // String output4 = s.order_packet(input4);
        // System.out.println(output4);
    }
}