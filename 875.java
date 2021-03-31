class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0 || h < 1) {
            return 0;
        }
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int lo = 1, hi = max;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int hours = 0;
            for (int pile : piles) {
                hours += ((pile % mid == 0) ? pile / mid : pile / mid + 1);
            }
            if (hours > h) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
