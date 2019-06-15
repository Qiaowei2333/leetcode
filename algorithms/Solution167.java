package src.algorithms;

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i =0; i<numbers.length; i++) {
            if (numbers[i]<=target) {
                for (int j =i+1; j<numbers.length;j++) {
                    if (numbers[i]+numbers[j]<target){
                        continue;
                    }
                    else if (numbers[i]+numbers[j]==target) {
                    	result[0]=i+1;
                    	result[1]=j+1;
                        return result;
                    }
                    else {
                        continue;
                    }
                }
            }
            else {
               result[0]=-1;
               result[1]=-1;
               return result;
            }
        }
        result[0]=-1;
        result[1]=-1;
        return result;
    }
}