 class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        int val = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            
            if (t.val != val) {
                return false;
            }
            
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
        
        return true;
    }
}
