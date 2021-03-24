class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int count = arr.length-1; 
        int cur_min = 0, cur_max = arr.length-1;
        while (cur_max-1 >= 0 && arr[cur_max-1] <= arr[cur_max]) {
            cur_max--;
        }
        count = Math.min(count, cur_max); 
        if (count == 0) return count;
        int j = cur_max;
        for (cur_min = 0; cur_min < cur_max; cur_min++) {
            if (cur_min > 0 && arr[cur_min] < arr[cur_min-1]) break;
            while (j < arr.length && arr[j] < arr[cur_min]) {
                j++;
            }
            
            count = Math.min(count, j-cur_min-1);
        }
        return count;
    }
}
