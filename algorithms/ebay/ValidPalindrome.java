// lc 125
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i <= j; j--, i++) {
            while (i <= j && !validChar(arr[i])) {i++;}
            while (i <= j && !validChar(arr[j])) {j--;}
            if (i <= j && arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean validChar(char a) {
        if (a - '0' >=0 && a - '0' <= 9) {
            return true;
        }
        if (a - 'a' >=0 && a - 'a' <= 26) {
            return true;
        }
        return false;
    }
}