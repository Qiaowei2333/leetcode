// lc 273
public class IntegerToEnglishWords {
    private final String[] dic19 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] dic90 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    // time O(1) , space O(1)
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        if (num / 1000000000 != 0) {
            convert3Digits(sb, num / 1000000000);
            sb.append(" Billion ");
            num %= 1000000000;
        }
        if (num / 1000000 != 0) {
            convert3Digits(sb, num / 1000000);
            sb.append(" Million ");
            num %= 1000000;
        }
        if (num / 1000 != 0) {
            convert3Digits(sb, num / 1000);
            sb.append(" Thousand ");
            num %= 1000;
        }
        if (num != 0) {
            convert3Digits(sb, num);
        }
        return sb.toString().trim();
    }
    // 1 - 999
    private void convert3Digits(StringBuilder sb, int num) {
        int hun = num / 100;
        int ten = (num % 100) / 10;
        int dig = (num % 100) % 10;
        if (hun != 0) {
            sb.append(dic19[hun] + " Hundred ");
        }
        if (num % 100 < 20) {
            if (num % 100 != 0) {
                sb.append(dic19[num % 100]);
            }
        }
        else {
            if (ten != 0) {
                sb.append(dic90[ten] + " ");
            }
            if (dig != 0) {
                sb.append(dic19[dig]);
            } 
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        } 
    }
    // recursion way 
    // private final String[] dic19 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // private final String[] dic90 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    // private final String[] dic1000 = {"", "Thousand", "Million", "Billion"};
    // public String numberToWords(int n) {
    //     if (n == 0) {
    //         return "Zero";
    //     }

    //     int i = 0;
    //     String res = "";
    //     while (n != 0) {
    //         if (n % 1000 != 0) {
    //             res = helper(n) + dic1000[i];
    //         }
    //         i++;
    //         n /= 1000;
    //     }
    //     return res.trim();
    // }

    // private String helper(int n) {
    //     if (n == 0) {
    //         return "";
    //     }
    //     else if (n < 20) {
    //         return dic19[n] + " ";
    //     }
    //     else if (n < 100) {
    //         return dic90[n / 10] + " " + helper(n % 10);
    //     }
    //     else { // 100 - 999
    //         return dic19[n / 100] + " Hundred " + helper(n % 100);
    //     }
    // }
}