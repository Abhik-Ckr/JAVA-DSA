// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given 
// nodes in the BST.
// The lowest common ancestor is defined as the lowest node in the BST that has both nodes 
// as descendants (where we allow a node to be a descendant of itself)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Problem1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        int current = root.val;
        if(current > p.val && current > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(current < p.val && current < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left; 
        TreeNode q = root.right; 

        Problem1 sol = new Problem1();
        TreeNode result = sol.lowestCommonAncestor(root, p, q);

        System.out.println("LCA is : " + result.val);
    }
}
