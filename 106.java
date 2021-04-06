public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int rootIndex = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, postorder.length, inorder, postorder);
    }

    private TreeNode helper(int start, int end, int[] inorder, int[] postorder) {
        if (start == end) return null;
        int rootVal = postorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        rootIndex--;
        int index = inorderMap.get(rootVal);
        root.right = helper(index + 1, end, inorder, postorder);
        root.left = helper(start, index, inorder, postorder);
        return root;
    }
}
