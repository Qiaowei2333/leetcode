package src.algorithms;

class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int result=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==1){
                count++;
                result = Math.max(count, result);
            }
            else count=0;
        }
        return result;
    }
}
//class Solution485 {
//    public int findMaxConsecutiveOnes(int[] nums) {
//        int sum;
//        ArrayList<Integer> l = new ArrayList<Integer>();  //Integer not int, Integer is object
//        if(nums[0]==1){
//            sum=1;
//        }
//        else{
//            sum=0;
//        }
//        for(int i=0; i<nums.length-1; i++){
//            if(nums[i]==0 && nums[i+1]==0){
//                continue;
//            }
//            else if(nums[i]==0 && nums[i+1]==1){
//                sum=1;
//                if(i==(nums.length-2)){
//                    l.add(sum);
//                }
//                continue;
//            }
//            else if(nums[i]==1 && nums[i+1]==0){
//                l.add(sum);
//                sum=0;
//                continue;
//            }
//            else {
//                sum++;
//                if(i==(nums.length-2)){
//                    l.add(sum);
//                }
//                continue;
//            }
//        }
//        if(l.isEmpty()){
//        	return sum;
//        }
//        else {
//            Collections.sort(l); // sort ArrayList
//            return l.get(l.size()-1);
//        }
//
//        
//    }
//}