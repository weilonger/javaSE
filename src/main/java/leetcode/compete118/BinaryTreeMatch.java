package main.java.leetcode.compete118;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*题目描述
    971. 翻转二叉树以匹配先序遍历
    给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。
    通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
    考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。
    （回想一下，节点的先序遍历意味着我们报告当前节点的值，然后先序遍历左子节点，再先序遍历右子节点。）
    我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。
    如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案.如果不能，则返回列表 [-1]。
 */
/*示例 1：
    输入：root = [1,2], voyage = [2,1]
    输出：[-1]
 */
/*示例 2：
    输入：root = [1,2,3], voyage = [1,3,2]
    输出：[1]
 */
/*示例 3：
    输入：root = [1,2,3], voyage = [1,2,3]
    输出：[]
 */
/*提示：
    1 <= N <= 100
 */
public class BinaryTreeMatch {
    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        Map<Integer, Integer> result;
        List<Integer> success = new ArrayList<>();
        List<Integer> error = new ArrayList<>();
        TreeNode temp = root;
        int[] array = voyage;
        int s = 0;
        result  = transfer(temp, array, s);
        if (result.size() > 0) {
            if (result.containsKey(-1)){
                error.add(-1);
                return error;
            } else {
                for (int i = 0; i < array.length; i++){
                    if (result.containsKey(i)){
                        success.add(i);
                    }
                }
                return success;
            }
        } else {
            return error;
        }
    }

    private static Map<Integer, Integer> transfer(TreeNode temp, int[] array, int s){
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Integer> error = new HashMap<>();
        if (temp != null){
            int parent = temp.val;
            TreeNode leftChild = temp.left;
            TreeNode rightChild = temp.right;
            if (s == 0 && parent == array[s]) {
                try {
                    if (leftChild != null && rightChild != null && s * 2 + 2 <= array.length) {
                        Integer status = compare(leftChild, rightChild, array, s);
                        if (status == 1) {
                            result.put(s + 1, 1);
                            Map<Integer, Integer> left = transfer(leftChild, array, 2 * (s + 1));
                            Map<Integer, Integer> right = transfer(rightChild, array, 2 * s + 1);
                            result.putAll(left);
                            result.putAll(right);
                        } else if (status == 2) {
                            Map<Integer, Integer> left = transfer(leftChild, array, 2 * s + 1);
                            Map<Integer, Integer> right = transfer(rightChild, array, 2 * (s + 1));
                            result.putAll(left);
                            result.putAll(right);
                        } else {
                            result.put(-1, -1);
                            return result;
                        }
                    }
                } catch (NullPointerException e) {
                    e.getStackTrace();
                }
            }
        }
        return result;
    }

    private static Integer compare(TreeNode leftChild, TreeNode rightChild, int[] array, int s){
        if (leftChild.val == array[2 * s + 1] && rightChild.val == array[2 * (s + 1)]){
            return 2;
        } else if (leftChild.val == array[2 * (s + 1)] && rightChild.val == array[2 * s + 1]) {
            return 1;
        } else {
            return 0;
        }
    }

    private static List<Integer> revert(TreeNode node, List<Integer> list) {
        if (node != null){
            list.add(node.val);
            if (node.left != null){
                revert(node.left, list);
            }
            if (node.right != null){
                revert(node.right, list);
            }
        }
        return list;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        int[] a = new int[]{1,2,3};
        flipMatchVoyage(node, a);
    }
}