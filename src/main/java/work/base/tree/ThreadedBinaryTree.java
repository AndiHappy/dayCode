package work.base.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhailz
 *
 * @Date 2015年10月21日 下午12:01:05
 * 
 *       线索二叉树
 */
public class ThreadedBinaryTree<E> {

  private ThreadedLinked root;

  // 线索二叉树的节点
  private class ThreadedLinked {
    TreeNode node;
    private int ltag;
    private int rtag;
    private ThreadedLinked rchild;
    private ThreadedLinked lchild;

    public ThreadedLinked(TreeNode node, int ltag, int rtag) {
      this.node = node;
      this.ltag = ltag;
      this.rtag = rtag;
    }

    @SuppressWarnings("unused")
    public int getLtag() {
      return ltag;
    }

    public void setLtag(int ltag) {
      this.ltag = ltag;
    }

    @SuppressWarnings("unused")
    public int getRtag() {
      return rtag;
    }

    public void setRtag(int rtag) {
      this.rtag = rtag;
    }

    public ThreadedLinked getRchild() {
      return rchild;
    }

    public void setRchild(ThreadedLinked rchild) {
      this.rchild = rchild;
    }

    public ThreadedLinked getLchild() {
      return lchild;
    }

    public void setLchild(ThreadedLinked lchild) {
      this.lchild = lchild;
    }

    public void setLeft(TreeNode midPre) {
      ThreadedLinked lc = new ThreadedLinked(midPre, 0, 0);
      setLchild(lc);
    }

    public void setRight(TreeNode midLas) {
      ThreadedLinked rc = new ThreadedLinked(midLas, 0, 0);
      setRchild(rc);
    }
  }

  // 建立中序的线索二叉树
  public ThreadedBinaryTree<E> buildMiddleThreadTree(BinaryTree<E> tree) {
    ThreadedBinaryTree<E> ttree = new ThreadedBinaryTree<E>();
    TreeNode node = tree.getRoot();
    root = new ThreadedLinked(node, 0, 0);
    root.setLchild(new ThreadedLinked(node.getLeft(), 0, 0));
    root.setRchild(new ThreadedLinked(node.getRight(), 0, 0));
    ArrayList<TreeNode> midnodes = (ArrayList<TreeNode>) tree.toMidSortNodes();

    buildThreadedTree(root, midnodes);

    return ttree;
  }

  private void buildThreadedTree(ThreadedLinked root2, ArrayList<TreeNode> midnodes) {
    if (root2 != null) {
      if (root2.getLchild() == null) {
        root2.setLtag(1);
        ThreadedLinked lchild = new ThreadedLinked(getMidPre(root2.node, midnodes), 0, 0);
        root2.setLchild(lchild);
      } else {
        root2.setLtag(0);
        buildThreadedTree(root2.getLchild(), midnodes);
      }
      if (root2.getRchild() == null) {
        root2.setRtag(1);
        ThreadedLinked rchild = new ThreadedLinked(getMidLas(root2.node, midnodes), 0, 0);
        root2.setRchild(rchild);
      } else {
        root2.setRtag(0);
        buildThreadedTree(root2.getRchild(), midnodes);
      }

    }
  }

  /**
   * node的中序遍历的后继节点
   * 
   * @param midnodes
   */
  private TreeNode getMidLas(TreeNode node, ArrayList<TreeNode> midnodes) {
    int index = midnodes.indexOf(node);
    if (index > 0 && index < midnodes.size()) {
      return midnodes.get(index + 1);
    }
    return null;
  }

  /**
   * node的中序遍历的前驱节点
   * 
   * @param midnodes
   */
  private TreeNode getMidPre(TreeNode node, ArrayList<TreeNode> midnodes) {
    int index = midnodes.indexOf(node);
    if (index > 0 && index < midnodes.size()) {
      return midnodes.get(index - 1);
    }
    return null;
  }

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
    ThreadedBinaryTree<String> thtree = new ThreadedBinaryTree<String>();
    thtree.buildMiddleThreadTree(tree);
  }

}
