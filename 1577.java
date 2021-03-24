class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int match = 0;
        if(nums1.length ==1 || nums2.length ==1) return 0;
        HashMap<Long, Integer> nums1Sq = new HashMap<Long, Integer>();
        HashMap<Long, Integer> nums2Sq = new HashMap<Long, Integer>();
        
        for(int i = 0; i < nums1.length; i++) {
        	long mul = (long) (nums1[i] * nums1[i]);
        	nums1Sq.put(mul, nums1Sq.getOrDefault(mul, 0) + 1);
        }
        for(int i = 0; i < nums2.length; i++) {
        	long mul = (long) (nums2[i] * nums2[i]);
        	nums2Sq.put(mul, nums2Sq.getOrDefault(mul, 0) + 1);
        }
        
        for(int i = 0; i < nums1.length - 1; i++) {
        	for(int j = i+1; j < nums1.length; j++) {
        		long mul = (long)(nums1[i] * nums1[j]);
        		if(nums2Sq.containsKey(mul)) match += nums2Sq.get(mul);
        	}
        }
        for(int i = 0; i < nums2.length-1; i++) {
        	for(int j = i+1; j<nums2.length; j++) {
        		long mul = (long)(nums2[i] * nums2[j]);
        		if(nums1Sq.containsKey(mul)) match += nums1Sq.get(mul);
        	}
        }
        
        return match;
    }
}
