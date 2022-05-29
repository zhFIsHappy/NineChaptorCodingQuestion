public class interleavingPositiveAndNegativeNumbers {
    public void rerange(int[] A){
        int negCnt = partition(A);
        int posCnt = A.length -negCnt;
        int left = negCnt > posCnt ? 1:0;
        int right = A.length - (posCnt > negCnt ? 2:1);
        
    }
}
