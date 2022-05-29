public class interleavingPositiveAndNegativeNumbers {
    public void rerange(int[] A){
        int negCnt = partition(A);
        int posCnt = A.length -negCnt;
        int left = negCnt > posCnt ? 1:0
    }
}
