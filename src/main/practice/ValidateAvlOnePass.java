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
    return check(root, null, null) != INVALID;
  }

  // Returns the height of the subtree rooted at node, or INVALID if any node
  // in it breaks the ordering or the balance property. A null bound means
  // there is no bound on that side.
  private static <T extends Comparable<T>> int check(Node<T> node, T min, T max) {
    if (node == null) {
      return -1;  // height of an empty subtree
    }

    // ordering: the node must fall inside the bounds its ancestors set
    if (min != null && node.value.compareTo(min) <= 0) {
      return INVALID;
    }
    if (max != null && node.value.compareTo(max) >= 0) {
      return INVALID;
    }

    int left = check(node.left, min, node.value);
    if (left == INVALID) {
      return INVALID;
    }

    int right = check(node.right, node.value, max);
    if (right == INVALID) {
      return INVALID;
    }

    // balance: the two subtree heights may differ by at most one
    if (Math.abs(left - right) > 1) {
      return INVALID;
    }

    return 1 + Math.max(left, right);  // this subtree's height
  }
}
