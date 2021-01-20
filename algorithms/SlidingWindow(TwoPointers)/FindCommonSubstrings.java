import java.util.*;
// instabase 店面
public class FindCommonSubstrings {
    //   String doc1 = " Grocery Store Receipt\n(860) 834-2359\nNikon Camera:    $45.98\nBatteries:        $9.21\nDog Food:        $11.54\nSub Total:       $55.19\nTotal:           $56.87";
    // String doc2 = "   Grocery Store Receipt\n(860) 834-2359\nChips:            $2.50\nSoda:             $1.50\nSub Total:        $4.00\nTotal:            $4.32";
    public static List<String> find_common_subtrings(String str1, String str2) {
        Set<String> res = new HashSet<>();
        int left = 0;
        String newStr = "";
        for (int i = 0; i < str1.length(); i++) {
            newStr = str1.substring(left, i + 1);
            if (!str2.contains(newStr)) {
                String lastGoodStr = str1.substring(left, i);
                if (!lastGoodStr.isEmpty()) res.add(lastGoodStr);
                while (left <= i) {
                    String temp = str1.substring(left, i + 1);
                    if (str2.contains(temp)) {
                        break;
                    }
                    left++;
                }
            }
        }
        if (!newStr.isEmpty() && str2.contains(newStr)) res.add(newStr);
        return new ArrayList<>(res);
    }
    
    public static void main(String[] args) {
      String str1 = " Grocery Store Receipt\n(860) 834-2359\nNikon Camera:    $45.98\nBatteries:        $9.21\nDog Food:        $11.54\nSub Total:       $55.19\nTotal:           $56.87";
      String str2 = "   Grocery Store Receipt\n(860) 834-2359\nChips:            $2.50\nSoda:             $1.50\nSub Total:        $4.00\nTotal:            $4.32";
      List<String> res = find_common_subtrings(str1, str2);
      
      int i = 1;
      for (String s : res) {
        System.out.println("lines" + i + " " + s);
        i++;
      }
    }
}
