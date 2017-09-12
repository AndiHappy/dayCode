package work.base.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhailzh
 * 
 * @Date 2015��10��30��������1:58:00
 * 
 *       ����������
 */
public class BinarySortTree<E extends Comparable<?>> {

  public static void main(String[] args) {
    List<String> collect = new ArrayList<String>();
    collect.add("a");
    collect.add("b");
    collect.add("c");
    collect.add("d");
    collect.add("e");
    collect.add("f");
    collect.add("g");
    collect.add("h");
    BinarySortTree<String> tree = new BinarySortTree<String>(collect);
  }

  private TreeNode root = null;

  public BinarySortTree(Collection<? extends E> c) {

    for (Iterator<? extends E> iterator = c.iterator(); iterator.hasNext();) {
      E e = (E) iterator.next();
      if (root == null) {
        root = new TreeNode(null, null, e);
      } else {
        TreeNode temp = new TreeNode(null, null, e);
        addValue(root, temp);
      }
    }
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private void addValue(TreeNode node, TreeNode add) {
    if (add != null && add.getValue() != null) {
      Comparable nodev = (Comparable) node.getValue();
      Comparable adddv = (Comparable) add.getValue();
      if (nodev.compareTo(adddv) > 0) {
        if (node.getLeft() == null) {
          node.setLeft(add);
        } else {
          addValue(node.getLeft(), add);
        }
      } else {
        if (node.getRight() == null) {
          node.setRight(add);
        } else {
          addValue(node.getRight(), add);
        }

        System.out.println(adddv);
      }
    }

  }

}
