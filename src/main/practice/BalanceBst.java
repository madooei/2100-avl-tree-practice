package practice;

import list.ArrayList;
import list.List;
import tree.Node;

/** Solution to the problem of balancing a binary search tree. */
public final class BalanceBst {

  private BalanceBst() {
    // This class should not be instantiated!
  }

  // Returns the root of a height-balanced binary search tree that holds
  // exactly the values in sorted, which must be in ascending order. An empty
  // list gives the empty tree.
  private static <T> Node<T> buildBalanced(List<T> sorted) {
    return build(sorted, 0, sorted.size() - 1);
  }

  // Builds the balanced subtree for sorted[lo..hi] and returns its root. An
  // empty range (lo > hi) is the empty tree.
  private static <T> Node<T> build(List<T> sorted, int lo, int hi) {
    if (lo > hi) {
      return null;
    }

    int mid = (lo + hi) / 2;
    Node<T> node = new Node<>(sorted.get(mid));
    node.left = build(sorted, lo, mid - 1);
    node.right = build(sorted, mid + 1, hi);
    return node;
  }

  // Returns the root of a height-balanced binary search tree that holds
  // exactly the values of the binary search tree rooted at root. The empty
  // tree gives the empty tree.
  public static <T> Node<T> balance(Node<T> root) {
    List<T> values = new ArrayList<>();
    inOrder(root, values);
    return buildBalanced(values);
  }

  // Appends the values of the subtree rooted at node to out, in ascending
  // order.
  private static <T> void inOrder(Node<T> node, List<T> out) {
    if (node == null) {
      return;
    }
    inOrder(node.left, out);
    out.add(node.value);
    inOrder(node.right, out);
  }
}
