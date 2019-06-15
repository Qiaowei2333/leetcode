package src.algorithms.String;

class Solution541 {
//    public String reverseStr(String s, int k) {
//        char[] arr = s.toCharArray();
//        int n = arr.length;
//        int i = 0;
//        while(i < n) {
//            int j = Math.min(i + k - 1, n - 1);
//            swap(arr, i, j);
//            i += 2 * k;
//        }
//        return String.valueOf(arr);
//    }
//    private void swap(char[] arr, int l, int r) {
//        while (l < r) {
//            char temp = arr[l];
//            arr[l++] = arr[r];
//            arr[r--] = temp;
//        }
//    }
    public static String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        int l = ss.length;
        int times = l/(2*k);
        int remains = l%(2*k);
        if(times < 1){
            if(remains>=k) swap(ss, 0, k-1);
            else swap(ss, 0, remains-1);
        }
        else{
            for(int i=0; i<times; i++){
                swap(ss, i*2*k, (k-1)+2*k*i);
            }
            if(remains>=k) swap(ss, times*2*k, (k-1)+2*k*times);
            else swap(ss, times*2*k, times*2*k+remains-1);
        }
        return new String(ss);
    }
    private static void swap (char[] ss, int head, int tail){
        char temp;
        while(head<tail){
            temp = ss[head];
            ss[head] = ss[tail];
            ss[tail] = temp;
            head++;
            tail--;
        }
    }
}