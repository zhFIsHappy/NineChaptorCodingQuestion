public class interleavingPositiveAndNegativeNumbers {
    public void rerange(int[] A) {
        int negCnt = partition(A);
        int posCnt = A.length - negCnt;
        int left = negCnt > posCnt ? 1 : 0;
        int right = A.length - (posCnt > negCnt ? 2 : 1);
        interleave(A, left, right);
    }

    private int partition(int[] A) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            while (left <= right && A[left] < 0) {
                left++;
            }
            while (left <= right && A[right] > 0) {
                right--;
            }

            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
    /
    private void interleave(int[] A, int left, int right) {
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left += 2;
            right -= 2;
        }
    }
}
