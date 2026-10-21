package practice;

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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Builds the balanced subtree for sorted[lo..hi] and returns its root. An
  // empty range (lo > hi) is the empty tree.
  private static <T> Node<T> build(List<T> sorted, int lo, int hi) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the root of a height-balanced binary search tree that holds
  // exactly the values of the binary search tree rooted at root. The empty
  // tree gives the empty tree.
  public static <T> Node<T> balance(Node<T> root) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Appends the values of the subtree rooted at node to out, in ascending
  // order.
  private static <T> void inOrder(Node<T> node, List<T> out) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
