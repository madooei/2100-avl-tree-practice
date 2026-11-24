package demo;

import practice.ValidateAvlTwoChecks;
import tree.Node;

/** A demo of ValidateAvlTwoChecks on the three trees from the notes. */
public final class ValidateAvlTwoChecksDemo {

  private ValidateAvlTwoChecksDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // 30 at the root with children 20 and 50, and 40 as the left child of 50.
    Node<Integer> valid = new Node<>(30);
    valid.left = new Node<>(20);
    valid.right = new Node<>(50);
    valid.right.left = new Node<>(40);

    // The tree is in search order and every node is balanced. Expect true.
    System.out.println("valid tree: " + ValidateAvlTwoChecks.isValidAvl(valid));

    // A chain: 50 at the root, 30 as its left child, 20 as the left child of 30.
    Node<Integer> unbalanced = new Node<>(50);
    unbalanced.left = new Node<>(30);
    unbalanced.left.left = new Node<>(20);

    // The tree is in search order, but 50 has a balance factor of 2. Expect false.
    System.out.println("in order, not balanced: " + ValidateAvlTwoChecks.isValidAvl(unbalanced));

    // 50 at the root with children 30 and 70, and 60 as the right child of 30.
    Node<Integer> unordered = new Node<>(50);
    unordered.left = new Node<>(30);
    unordered.right = new Node<>(70);
    unordered.left.right = new Node<>(60);

    // The tree is balanced, but 60 is in 50's left subtree. Expect false.
    System.out.println("balanced, not in order: " + ValidateAvlTwoChecks.isValidAvl(unordered));
  }
}
