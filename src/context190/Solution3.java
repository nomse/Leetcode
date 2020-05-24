package context190;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    int res = 0;

    private void back(TreeNode root, List<Integer> output) {
        if (root == null) return;
        output.add(root.val);
        // 到达根节点
        if (root.left == null && root.right == null) {
            isPseudoPalindromic(output);
            return;
        }
        // 分别搜寻左右子树
        back(root.left, output);
        back(root.right, output);
    }

    private void isPseudoPalindromic(List<Integer> output) {
        int[] to = new int[9];
        for (Integer o : output) {
            to[o]++;
        }
        int count = 0;
        for (int t: to) {
            if (t % 2 != 0) {
                count++;
            }
        }
        if (count <= 1) {
            res++;
        }

    }

    public int pseudoPalindromicPaths(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        back(root, output);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}