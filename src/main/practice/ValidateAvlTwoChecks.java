package practice;

import tree.Node;

/** Solution to the problem of validating an AVL tree, with two separate checks. */
public final class ValidateAvlTwoChecks {

  private ValidateAvlTwoChecks() {
    // This class should not be instantiated!
  }

  // Returns true if the tree rooted at root is a valid AVL tree: every node
  // satisfies the binary search tree ordering property and has a balance
  // factor of -1, 0, or 1. The empty tree is valid. A duplicate value is not.
  public static <T extends Comparable<T>> boolean isValidAvl(Node<T> root) {
    return isOrdered(root, null, null) && isBalanced(root);
  }

  // Returns true if every value in the subtree rooted at node is strictly
  // between min and max. A null bound means there is no bound on that side.
  private static <T extends Comparable<T>> boolean isOrdered(Node<T> node, T min, T max) {
    if (node == null) {
      return true;
    }
    if (min != null && node.value.compareTo(min) <= 0) {
      return false;
    }
    if (max != null && node.value.compareTo(max) >= 0) {
      return false;
    }
    return isOrdered(node.left, min, node.value)
        && isOrdered(node.right, node.value, max);
  }

  // Returns true if every node in the subtree rooted at node has a balance
  // factor of -1, 0, or 1.
  private static <T> boolean isBalanced(Node<T> node) {
    if (node == null) {
      return true;
    }
    int bf = height(node.left) - height(node.right);
    if (Math.abs(bf) > 1) {
      return false;
    }
    return isBalanced(node.left) && isBalanced(node.right);
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
