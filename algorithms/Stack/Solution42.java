package src.algorithms.Stack;
 
//class Solution42 {
//    public static int trap(int[] height) {
//    int left = 0, right = height.length - 1;
//    int ans = 0;
//    int left_max = 0, right_max = 0;
//    while (left < right) {
//        if (height[left] < height[right]) {
//           if (height[left] >= left_max) 
//        	   left_max = height[left]; 
//           else
//               ans += (left_max - height[left]);
//            ++left;
//        }
//        else {
//            if(height[right] >= right_max)
//            	right_max = height[right];
//            else
//            	ans += (right_max - height[right]);
//            --right;
//        }
//    }
//    return ans;
//    }
//}

//class Solution42 {
//    public static int trap(int[] height) {
//        int ans = 0;
//        for(int i=0; i<height.length; i++){
//            int l = findHighest(height, 0, i);
//            int r = findHighest(height, i, height.length-1);
//            int d = Math.min(l,r)- height[i];
//            if (d>0) ans+=d;
//        }
//        return ans;
//    }
//    public static int findHighest(int[] height, int s, int e){
//        int max = height[s];
//        for(int i=s+1; i<=e; i++){
//            max = Math.max(max, height[i]);
//        }
//        return max;
//    }
//}
