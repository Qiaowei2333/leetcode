package src.algorithms;

public class Solution {
    public int hammingDistance(int x, int y) {
        int Xor = x^y;
       // return Integer.bitCount(Xor);
        int count=0;
        while(Xor!=0){
          count += Xor & 1;
          Xor >>= 1;
        }
        
        return count;
       
    }
}