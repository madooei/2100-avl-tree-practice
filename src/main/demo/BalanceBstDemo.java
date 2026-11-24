package demo;

import practice.BalanceBst;
import tree.Node;

/** A demo of BalanceBst on the skewed tree of 20 through 80 from the notes. */
public final class BalanceBstDemo {

  private BalanceBstDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // Inserting 20 through 80 in order makes each value the right child of the one before it.
    Node<Integer> root = new Node<>(20);
    Node<Integer> last = root;
    for (int value = 30; value <= 80; value += 10) {
      last.right = new Node<>(value);
      last = last.right;
    }
    System.out.println("before:");
    printTree(root);

    // Expect 50 at the root, 30 and 70 below it, and 20, 40, 60, 80 as leaves.
    Node<Integer> balanced = BalanceBst.balance(root);
    System.out.println("after:");
    printTree(balanced);
  }

  // Prints each node in pre-order with its two children, "-" for an empty child.
  private static void printTree(Node<Integer> node) {
    if (node == null) {
      return;
    }
    System.out.println("  " + node.value + ": left " + label(node.left) + ", right " + label(node.right));
    printTree(node.left);
    printTree(node.right);
  }

  // Returns the node's value as text, or "-" for an empty child.
  private static String label(Node<Integer> node) {
    if (node == null) {
      return "-";
    }
    return String.valueOf(node.value);
  }
}
