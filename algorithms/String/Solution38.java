package src.algorithms.String;

class Solution38 {
    public static String countAndSay(int n) {
        if(n==1) return 1+"";
        String preS = countAndSay(n-1);
        char[] preArr = preS.toCharArray();
        StringBuilder res = new StringBuilder();
        int count = 1;
        for(int i = 1; i<preArr.length; i++) {
            if(preArr[i-1]==preArr[i]) count++;
            else {
                res.append(count);
                count = 1;
                res.append(preArr[i-1]);
            }
        }
        res.append(count);
        res.append(preArr[preArr.length-1]);
        return res.toString();
    }
}
