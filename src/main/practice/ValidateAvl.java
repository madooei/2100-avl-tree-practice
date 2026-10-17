package practice;

import tree.Node;

/** Solutions to the problem of validating an AVL tree. */
public final class ValidateAvl {


  private ValidateAvl() {
    // This class should not be instantiated!
  }

  // Returns true if the tree rooted at root is a valid AVL tree: every node
  // satisfies the binary search tree ordering property and has a balance
  // factor of -1, 0, or 1. The empty tree is valid. A duplicate value is not.
  public static <T extends Comparable<T>> boolean isValidAvl(Node<T> root) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the height of the subtree rooted at node, or INVALID if any node
  // in it breaks the ordering or the balance property. A null bound means
  // there is no bound on that side.
  private static <T extends Comparable<T>> int check(Node<T> node, T min, T max) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Same contract as isValidAvl.
  public static <T extends Comparable<T>> boolean isValidAvlTwoChecks(Node<T> root) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns true if every value in the subtree rooted at node is strictly
  // between min and max. A null bound means there is no bound on that side.
  private static <T extends Comparable<T>> boolean isOrdered(Node<T> node, T min, T max) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns true if every node in the subtree rooted at node has a balance
  // factor of -1, 0, or 1.
  private static <T> boolean isBalanced(Node<T> node) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the height of the subtree rooted at node. The empty tree has
  // height -1.
  private static <T> int height(Node<T> node) {
    if (node == null) {
      return -1;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }
}
