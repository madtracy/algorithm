package tracy.algorithm.binaryTree;

/**
 * User: tracy
 * Date: 14-8-4
 * Time: 上午8:38
 * LeetCode 110.Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        return maxDepth(root)!=-1;
    }
    private int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
