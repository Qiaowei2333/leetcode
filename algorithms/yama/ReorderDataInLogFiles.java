// lt 937 
// 明白"1" < "A" < "a" 在 String 比较中
// String比较是一位一位的比，比到有差就结束
// 如"echo" compareTo "echmpppp" 比到 "o" 和 "m" 结束了，顺序为 "echmpppp", "echo", 因为 "m" < "o"  
import java.util.*;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0)
                    return split1[0].compareTo(split2[0]);
                else
                    return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                // first is letter, second is digit. keep them in this order.
                return -1;
            }
        });

        String[] nums = {"1", "2", "3"};
        Arrays.sort(nums, (a, b) -> {return -1;});
        return logs;

    }

    // remove all spaces, compare all splits one by one
    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split("\\s+");
            String[] split2 = s2.split("\\s+");
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // both letter-logs.
                int length1 = split1.length;
                int length2 = split2.length;
                int i = 1, j = 1;
                while (i < length1 && j < length2) {
                    String curStr1 = split1[i++];
                    String curStr2 = split2[j++];
                    int curCompare = curStr1.compareTo(curStr2);
                    if (curCompare != 0) {
                        return curCompare;
                    }
                }
                if (i == length1 && j == length2) {
                    return split1[0].compareTo(split2[0]);
                } else if (i != length1) {
                    return 1;
                } else {
                    return -1;
                }

            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1;
            } else {
                // first is letter, second is digit. keep them in this order.
                return -1;
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String s1 = "a         o:and:foo";
        String s2 = "a";
        ReorderDataInLogFiles s = new ReorderDataInLogFiles();
        System.out.println(Arrays.toString(s1.split("\\s+")));
        String[] result = s.reorderLogFiles(new String[] {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
        System.out.println(s1.compareTo(s2));

    }
}