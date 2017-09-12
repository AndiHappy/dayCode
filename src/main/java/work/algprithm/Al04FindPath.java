package work.algprithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import work.base.tree.TreeNode;

/**
 * @author zhailzh
 */
public class Al04FindPath {

  public static void main(String[] args) {
    int[] ary = new int[] { 10, 12, 14, 8, 14, 12, 11, 6, 10 };
    TreeNode root = TreeNode.newTree(ary);
    int value = 36;
    List<String> res = findPath(root, value);
    System.out.println(res.toString());
  }

  private static List<String> findPath(TreeNode root2, int value) {

    List<String> res = new ArrayList<String>();
    Stack<Integer> stack = new Stack<Integer>();
    judge(root2, value, res, stack);
    return res;
  }

  private static void judge(TreeNode root, int value, List<String> res, Stack<Integer> stack) {
    int nodev = (Integer) root.getValue();
    if (value < nodev) {
      return;
    } else if (value > nodev) {
      if (root.getLeft() != null) {
        stack.push(nodev);
        judge(root.getLeft(), value - nodev, res, stack);
        stack.pop();
      }
      if (root.getRight() != null) {
        stack.push(nodev);
        judge(root.getRight(), value - nodev, res, stack);
        stack.pop();
      }
    } else {
      stack.push(value);
      res.add(stack.toString());
      stack.pop();

    }
  }
}
