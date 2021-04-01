class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int total = m * k;
        if (bloomDay.length < total) return -1;
        int left = 0, right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            int flowerCount = 0, dayCount = 0;
            for (int day : bloomDay) {
                if (day <= mid) {
                    dayCount++;
                    if (dayCount == k) {
                        flowerCount++;
                        dayCount = 0;
                    }
                } else {
                    dayCount = 0;
                }
            }

            if (flowerCount >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
