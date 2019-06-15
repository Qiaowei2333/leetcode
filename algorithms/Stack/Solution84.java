package src.algorithms.Stack;

import java.util.Stack;

//class Solution84 {
//    public static int largestRectangleArea(int[] heights) {
//        if(heights==null||heights.length==0) return 0;
//        int area = 0;
//        for(int i=0; i<heights.length; i++){
//            if(i==heights.length-1 || heights[i]>heights[i+1]){//最大值是不可能存在 在一个i点， i+1的值大于i的值，排除这些后，剩下的就是可能产生最大矩阵的位置了，对剩下的位置，每个都求一下以当前位置为边界的最大矩阵面积
//                int minh = heights[i];
//                for(int j=i; j>=0; j--){ 
//                    minh = Math.min(minh, heights[j]);
//                    area = Math.max(area,(i-j+1)*minh);
//                }                
//            }
//        }
//        return area;
//    }
//}
class Solution84 {
    public static int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        for(int i=0; i<heights.length; i++){
            if(stack.empty()||heights[stack.peek()]<=heights[i]) {
                stack.push(i);
            }
            else {
                int currheight = heights[stack.pop()];
                int width = stack.empty()? i:i-1-stack.peek();  
                area = Math.max(area, currheight*width);
                i--;
            }
        }
        int right = stack.peek()+1;
        while(!stack.empty()){
            int currheight = heights[stack.pop()];
            int width = stack.empty()? right:right-1-stack.peek();  
            area = Math.max(area, currheight*width);
        }
        return area;
    }
}