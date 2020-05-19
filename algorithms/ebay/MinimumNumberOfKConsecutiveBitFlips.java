// lc 995  greedy
public class MinimumNumberOfKConsecutiveBitFlips {
    private void flip(int[]A,int K,int i){
        for(int j=i;j<i+K;j++){
            A[j]=1-A[j];
        }
    }
    public int minKBitFlips(int[] A, int K) {
        int cnt=0;
        for(int i=0;i < A.length - K + 1;i++){
            if(A[i]==0){
                flip(A,K,i);
                cnt++;
            }
        }
        for (int i = A.length - K + 1; i < A.length; i++) {
            if (A[i] == 0) {
                return -1;
            }
        }
        return cnt;
    }
}