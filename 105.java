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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length, preorder, inorder);
    }

    private TreeNode helper(int start, int end, int[] preorder, int[] inorder) {
        if (start == end) return null;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int index = inorderMap.get(preorder[rootIndex]);
        rootIndex++;
        root.left = helper(start, index, preorder, inorder);
        root.right = helper(index + 1, end, preorder, inorder);
        return root;
    }
}
