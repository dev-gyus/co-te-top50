import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        this.val = x;
    }
}

public class LevelOrderOfBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> solve = solve(root);
        System.out.println(solve);
    }

    public static List<List<Integer>> solve(TreeNode root){
        //1 ds
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //2 for or while (algorithm)
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
