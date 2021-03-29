class Solution {
    public int maximumScore(int[] nums, int k) {
        int len = nums.length;
        int[] scores = new int[len];
        scores[k] = nums[k];
        for (int i = k - 1; i >= 0; i--)
            scores[i] = nums[i] < scores[i + 1] ? nums[i] : scores[i + 1];
        for (int i = k + 1; i < len; i++)
            scores[i] = nums[i] < scores[i - 1] ? nums[i] : scores[i - 1];
        int maxScore    = -1, left = k, right = k;
        while (true) {
            int currentScore = (scores[left] < scores[right]) ? scores[left] : scores[right];
            maxScore = (maxScore > (right - left + 1) * currentScore) ? maxScore : (right - left + 1) * currentScore;
            if (left == 0 && right == len - 1)
                break;
            if (left == 0)
                right++;                       
            else if (right == len - 1)
                left--;                         
            else if (scores[left - 1] > scores[right + 1])
                left--;                         
            else 
                right++;                      
        }

        return maxScore;
    }
}
