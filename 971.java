class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(helper(root, voyage)) {
            return res;
        }
        return Arrays.asList(-1);
    }
    
    int i = 0;
    public boolean helper(TreeNode root, int[] v) {
        if(root == null) {
            return true;
        }
        if(root.val != v[i++]) {
            return false;
        }
        if(root.left != null && root.left.val != v[i]) {
            res.add(root.val);
            return helper(root.right, v) && helper(root.left, v);
        }
        return helper(root.left, v) && helper(root.right, v);
    }
}
