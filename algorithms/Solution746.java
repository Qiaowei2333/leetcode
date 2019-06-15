package src.algorithms;

class Solution746 { // dynamic programming
    public int minCostClimbingStairs(int[] cost) {
        int d[] = new int[cost.length+1];
        d[0]=0;
        d[1]=0;
        for(int i=2;i<cost.length+1;i++){
            d[i]=Math.min(d[i-1]+cost[i-1],d[i-2]+cost[i-2]);
        }
        return d[cost.length];
    }
}
