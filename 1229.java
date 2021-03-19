class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));
        int idx1 = 0, idx2 = 0;
        while (idx1 < slots1.length && idx2 < slots2.length) {
            int id1 = slots1[idx1][1];
            int id2 = slots2[idx2][1];
            int t = Math.max(slots1[idx1][0], slots2[idx2][0]);    
            if (id1 > id2) {    
                if (id2 - t >= duration) {
                    return Arrays.asList(t, t + duration);
                }
                idx2++;
            } else {
                if (id1 - t >= duration) {
                    return Arrays.asList(t, t + duration);
                }
                idx1++;
            }
        }
        return new ArrayList<>();
    }
}
