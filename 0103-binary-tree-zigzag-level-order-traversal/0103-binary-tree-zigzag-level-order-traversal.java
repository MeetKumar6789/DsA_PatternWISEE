class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;

        queue.add(root);
        boolean leftToRight = true; 

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>(size); 

            while (size > 0) {  
                TreeNode t = queue.element(); 
                queue.remove();
                tmp.add(t.val);
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
                size--;
            }
            if (leftToRight == false) { 
                Collections.reverse(tmp);
            } 
            res.add(tmp);
            leftToRight = !leftToRight; 
        }
        return res;
    }
}
