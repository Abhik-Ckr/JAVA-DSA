// Given a binary tree, find the distance between two given nodes. The distance between two 
// nodes is defined as the number of edges in the shortest path connecting them.


// 1 Find the LCA 
// 2 Find the distance between LCA and node 1 = D1
// 3 Find the distance between LCA and node 2 = D2
// 4 D1 + D2 = result

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Problem2 {
    public int distanceBetweenTwoNode(TreeNode root, int n1, int n2){
        TreeNode LCA = findLCA(root, n1, n2);
        int d1 = findDistance(LCA, n1, 0);
        int d2 = findDistance(LCA, n2, 0);
        return d1 + d2;
    }


    /**
     * 
     * @param root : what is it
     * @param n1
     * @param n2
     * @return
     * 
     * this is my persion method
     * 
     */
    public TreeNode findLCA(TreeNode root, int n1, int n2){
        if(root == null || root.val == n1 || root.val == n2){
            return root;
        }
        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);


        if(left != null && right != null){
            return root;
        }


        return (left != null) ? left : right;
    }
    
    /**
     * 
     * @param root
     * @param target
     * @param distance
     * @return
     */
    public int findDistance(TreeNode root, int target, int distance){
        if(root == null){
            return -1;
        }
        if(root.val == target) return distance;
        int left = findDistance(root.left, target, distance + 1);
        if(left != -1){
            return left;
        }
        return findDistance(root.right, target, distance + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Problem2 sol = new Problem2();
        System.out.println("Distance between 4 and 5: " + sol.findDistance(root, 4, 5)); 
        System.out.println("Distance between 4 and 6: " + sol.findDistance(root, 4, 6)); 
    }
}
