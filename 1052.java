class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int m) {
        int len = customers.length;
        int sum = 0;
        int[] unsat = new int[len];
        for(int i = 0; i < len; i++){
            if(grumpy[i]==0){
                sum += customers[i];
                unsat[i] = 0;
            }
            else{
                unsat[i] = customers[i];
                }
            }
        }
        //Maximum of all subarrays of size k  
        int unsat_sum = 0;
        for (int i = 0; i <= (len - m); i++){
            int max = 0;
            for (int j = i; j < i + m; j++){
                max = std::max(max, unsat[j]);
            }
        unsat_sum += max;
        }
        return sum+unsat_sum;
}
