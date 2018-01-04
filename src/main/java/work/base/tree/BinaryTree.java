package work.base.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import work.base.ArrayQueue;


/**
 * @author zhailz
 *
 * @Date 20151019 3:45:22
 * 
 *       
 */
public class BinaryTree<E> {

  public static void main(String[] args) {
    List<String> collect = new ArrayList<String>();
    collect.add("a");
    collect.add("b");
    collect.add("c");
    collect.add("null");
    collect.add("d");
    collect.add("e");
    collect.add("f");
    collect.add("null");
    collect.add("null");
    collect.add("g");
    collect.add("h");
    BinaryTree<String> tree = new BinaryTree<String>(collect);
    System.out.println(tree.toFirstString());
    System.out.println(tree.toMiddleString());
    String nodes = tree.toMidSortNodes().toString();
    System.out.println(nodes);
    System.out.println(tree.toLastString());
    System.out.println(tree.toLevelString());
  }

  private TreeNode root = null;

  public BinaryTree(Collection<? extends E> c) {
    Object[] a = new Object[c.size()];
    c.toArray(a);
    int i = 0;
    if (root == null) {
      root = new TreeNode(null, null, a[i]);
      if (root.getLeft() == null) {
        setLeftNode(i, a, root);
      }
      if (root.getRight() == null) {
        setRightNode(i, a, root);
      }
    } else {
      throw new IllegalArgumentException("ԪزΪգֱܹӵʹüԪй");
    }

  }

  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  public TreeNode getRoot() {
    return root;
  }

  private void setLeftNode(int i, Object[] a, TreeNode temp) {
    int leftindex = 2 * i + 1;
    if (temp.getLeft() == null && leftindex < a.length) {
      if (a[leftindex].toString().equals("null")) {
        return;
      }
      TreeNode left = new TreeNode(null, null, a[leftindex]);
      temp.setLeft(left);
      setRightNode(leftindex, a, left);
      setLeftNode(leftindex, a, left);
    }
  }

  private void setRightNode(int i, Object[] a, TreeNode temp) {
    int rightindex = 2 * i + 2;
    if (temp.getRight() == null && rightindex < a.length) {
      if (a[rightindex].toString().equals("null")) {
        return;
      }
      TreeNode right = new TreeNode(null, null, a[rightindex]);
      temp.setRight(right);
      setLeftNode(rightindex, a, right);
      setRightNode(rightindex, a, right);
    }
  }

  public List<TreeNode> toFirSortNodes() {
    if (root != null) {
      List<TreeNode> firnodes = new ArrayList<TreeNode>();
      toFirSortNodes(root, firnodes);
      return firnodes;
    }
    return null;
  }

  private void toFirSortNodes(TreeNode node, List<TreeNode> firnodes) {
    if (node != null) {
      if (node.getLeft() != null) {
        toFirSortNodes(node.getLeft(), firnodes);
      }
      firnodes.add(node);
      if (node.getRight() != null) {
        toFirSortNodes(node.getRight(), firnodes);
      }
    }

  }

  private String toFirString(TreeNode node) {
    String temp = null;
    if (node != null) {
      temp = temp == null ? node.getValue().toString() : temp + node.getValue().toString();

      if (node.getLeft() != null) {
        temp = temp == null ? toFirString(node.getLeft()) : temp + toFirString(node.getLeft());
      }

      if (node.getRight() != null) {
        temp = temp == null ? toFirString(node.getRight()) : temp + toFirString(node.getRight());
      }

    }
    return temp;
  }

  /**
   * 
   */
  public String toFirstString() {

    if (root != null) {
      return toFirString(root);
    }
    return null;
  }

  private void tolasSortNodes(TreeNode node, List<TreeNode> lasnodes) {
    if (node != null) {
      if (node.getLeft() != null) {
        tolasSortNodes(node.getLeft(), lasnodes);
      }
      lasnodes.add(node);
      if (node.getRight() != null) {
        tolasSortNodes(node.getRight(), lasnodes);
      }
    }
  }

  public List<TreeNode> toLasSortNodes() {
    if (root != null) {
      List<TreeNode> lasnodes = new ArrayList<TreeNode>();
      tolasSortNodes(root, lasnodes);
      return lasnodes;
    }
    return null;
  }

  private String toLasString(TreeNode node) {
    String temp = null;
    if (node != null) {

      if (node.getLeft() != null) {
        temp = temp == null ? toLasString(node.getLeft()) : temp + toLasString(node.getLeft());
      }

      if (node.getRight() != null) {
        temp = temp == null ? toLasString(node.getRight()) : temp + toLasString(node.getRight());
      }

      temp = temp == null ? node.getValue().toString() : temp + node.getValue().toString();
    }
    return temp;
  }

  /**
   * 
   */
  public String toLastString() {

    if (root != null) {
      return toLasString(root);
    }
    return null;
  }

  private String toLeavel(ArrayQueue<TreeNode> queue) {
    String temp = null;
    while (!queue.isEmpty()) {
      TreeNode node = queue.popQueueHead();
      if (temp == null) {
        temp = node.getValue().toString();
      } else {
        temp = temp + node.getValue().toString();
      }
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }
    return temp;
  }

  /**
   * α
   */
  public String toLevelString() {
    ArrayQueue<TreeNode> queue = new ArrayQueue<TreeNode>();
    if (root != null) {
      queue.add(root);
      return toLeavel(queue);
    } else {
      throw new IllegalAccessError("ԪΪnull");
    }
  }

  /**
   * 
   */

  public String toMiddleString() {

    if (root != null) {
      return toMidString(root);
    }
    return null;
  }

  public List<TreeNode> toMidSortNodes() {
    if (root != null) {
      List<TreeNode> midnodes = new ArrayList<TreeNode>();
      toMidSortNodes(root, midnodes);
      return midnodes;
    }
    return null;
  }

  private void toMidSortNodes(TreeNode node, List<TreeNode> midnodes) {
    if (node != null) {
      if (node.getLeft() != null) {
        toMidSortNodes(node.getLeft(), midnodes);
      }
      midnodes.add(node);
      if (node.getRight() != null) {
        toMidSortNodes(node.getRight(), midnodes);
      }
    }
  }

  /**
   * 
   */
  private String toMidString(TreeNode node) {
    String temp = null;
    if (node != null) {

      if (node.getLeft() != null) {
        temp = temp == null ? toMidString(node.getLeft()) : temp + toMidString(node.getLeft());
      }
      temp = temp == null ? node.getValue().toString() : temp + node.getValue().toString();

      if (node.getRight() != null) {
        temp = temp == null ? toMidString(node.getRight()) : temp + toMidString(node.getRight());
      }

    }
    return temp;
  }

}
