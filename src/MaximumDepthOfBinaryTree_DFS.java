import java.util.Stack;

public class MaximumDepthOfBinaryTree_DFS {
    /**
     * Recursive, BFS, DFS 기본이되는 문제
     */
    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(6);
        System.out.println(maxDepth(tree));

    }

    public static int maxDepth(TreeNode root){
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);
        int max = 0;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            Integer value = valueStack.pop();

            max = Math.max(max, value);
            if(node.left != null){
                stack.push(node.left);
                valueStack.push(value + 1);
            }
            if(node.right != null){
                stack.push(node.right);
                valueStack.push(value + 1);
            }
        }
        return max;
    }

}
