package practice;

import tree.Node;

/** Solution to the problem of validating an AVL tree, in one post-order pass. */
public final class ValidateAvlOnePass {

  // A value no real height can take: heights are -1 (empty) or greater.
  private static final int INVALID = Integer.MIN_VALUE;

  private ValidateAvlOnePass() {
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
}
