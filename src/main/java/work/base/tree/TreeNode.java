package work.base.tree;

public class TreeNode {

  private TreeNode left;
  private TreeNode right;
  private Object value;

  public TreeNode(TreeNode right, TreeNode left, Object value) {
    this.left = left;
    this.right = right;
    this.value = value;
  }

  public TreeNode() {};

  /**
   * 通过数组组建二叉树
   */
  public static TreeNode newTree(int[] arrays) {
    if (arrays == null || arrays.length == 0) {
      return null;
    }
    TreeNode root = creatTreeNode(arrays, 0);
    return root;
  }

  private static TreeNode creatTreeNode(int[] arrays, int i) {
    TreeNode node = new TreeNode();
    node.setValue(new Integer(arrays[i]));
    if (2 * i + 1 < arrays.length) {
      TreeNode left = creatTreeNode(arrays, 2 * i + 1);
      node.setLeft(left);
    }

    if (2 * i + 2 < arrays.length) {
      TreeNode right = creatTreeNode(arrays, 2 * i + 2);
      node.setRight(right);
    }
    return node;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "[ value: " + this.value.toString() + "]";
  }
}
