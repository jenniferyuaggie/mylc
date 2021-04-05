class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double l = 0, r = stations[stations.length - 1] - stations[0];
        while (r - l >= 1e-6) {
            double d = (r + l) / 2;
            int count = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                count += Math.ceil((stations[i + 1] - stations[i]) / d) - 1;
            }
            if (count <= k) {
                r = d;
            } else {
                l = d;
            }
        }
        return l;
    }
}
