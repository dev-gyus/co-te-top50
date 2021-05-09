public class MaximumDepthOfBinaryTree {
    /**
     * Recursive, BFS, DFS 기본이되는 문제
     */
    public static void main(String[] args){
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        System.out.println(maxDepth(tree));

    }

    public static int maxDepth(TreeNode root){
        if(root == null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

}
