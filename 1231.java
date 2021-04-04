class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 1;
        int right = 1000000000 / (K + 1);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int cur = 0, cuts = 0;
            for (int st : sweetness) {
                cur = cur + st;
                if (cur >= mid) {
                    cur = 0;
                    cuts = cuts + 1;
                    if (cuts > K) {
                        break;
                    }
                }
            }
            if (cuts > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}
