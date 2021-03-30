class Solution {
    public int splitArray(int[] nums, int m){
		long l = 0;
		long r = 0;
		long ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++){
			r += nums[i];
			if (l < nums[i]) {
				l = nums[i];
			}
		}
		while (l <= r) {
			long mid = (l + r) / 2;
			long sum = 0;
			int count = 1;
			for (int i = 0; i < nums.length; i++){
				if (sum + nums[i] > mid){
					count++;
					sum = nums[i];
				} else{
					sum += nums[i];
				}
			}
			if (count <= m){
				ans = Long.min(ans, mid);
				r = mid - 1;
			} else{
				l = mid + 1;
			}
		}
		return (int) ans;
    }
}
