class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = 0;
        for (int wt : weights) {
            lo = Math.max(lo, wt);
            hi += wt;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int curr = 0, days = 1;
            for (int wt : weights) {
                if (curr + wt > mid) {
                    days++;
                    curr = 0;
                }
                curr += wt;
            }
            if (days > D) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
} 
