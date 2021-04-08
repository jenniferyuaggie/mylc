class Solution {
    public boolean isValidSerialization(String preorder) {   
        String[] split = preorder.split(",");
        int indic = 1;
        for (String str:split) {
            indic -= 1;
            if(indic < 0){
                return false;
            }
            if(!str.equals("#")){
                indic += 2;
            }
        }
        return indic == 0;
    }
}
