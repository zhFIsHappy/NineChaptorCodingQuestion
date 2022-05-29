public class triangleCount {
    public int triangleCount(int[] S){
        if(S == null || S.length < 3) return 0;
        Array.sort(S);
        int cnt = 0;
        for(int i = 2; i< S.length; i++){
            cnt+=getTriangleCount(S, i);
        }
        return cnt;
    }
    private int getTriangleCount(int[] arr, int targetIndex){
        int cnt =0;
        int left = 0;
        int right = targetIndex -1;
        int targetSum = arr[targetIndex];
    }
}
