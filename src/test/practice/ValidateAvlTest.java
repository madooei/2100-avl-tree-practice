package practice;

import org.junit.jupiter.api.Test;
import tree.Node;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the validate-AVL problem. Each test is one scenario. The scenarios
 * are written once here; each solution gets its own subclass that says which
 * method to call, so you can run the suite for one solution at a time.
 */
public abstract class ValidateAvlTest {

  // Calls the solution under test.
  protected abstract boolean isValidAvl(Node<Integer> root);

  @Test
  public void emptyTreeIsValid() {
    assertTrue(isValidAvl(null));
  }

  @Test
  public void singleNodeIsValid() {
    assertTrue(isValidAvl(new Node<>(42)));
  }

  @Test
  public void duplicateValueIsInvalid() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(50);
    assertFalse(isValidAvl(root));
  }

  @Test
  public void orderedButUnbalancedIsInvalid() {
    // 20 < 30 < 50, but 50 has a balance factor of 2.
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.left.left = new Node<>(20);
    assertFalse(isValidAvl(root));
  }

  @Test
  public void smallValidTreeIsValid() {
    // 30 with children 20 and 50, and 40 under 50.
    Node<Integer> root = new Node<>(30);
    root.left = new Node<>(20);
    root.right = new Node<>(50);
    root.right.left = new Node<>(40);
    assertTrue(isValidAvl(root));
  }

  @Test
  public void balancedButUnorderedIsInvalid() {
    // Every node is balanced, but 60 sits in 50's left subtree.
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(70);
    root.left.right = new Node<>(60);
    assertFalse(isValidAvl(root));
  }

  @Test
  public void minimalAvlTreeOfHeightThreeIsValid() {
    // Every internal node has a balance factor of 1 or -1, the most an AVL tree allows.
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(60);
    root.left.left = new Node<>(20);
    root.left.right = new Node<>(40);
    root.right.right = new Node<>(70);
    root.left.left.left = new Node<>(10);
    assertTrue(isValidAvl(root));
  }

  @Test
  public void balancedRootWithUnbalancedDescendantIsInvalid() {
    // The root has two subtrees of height 2, but 30 has a balance factor of 2 and 70 has -2.
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.left.left = new Node<>(20);
    root.left.left.left = new Node<>(10);
    root.right = new Node<>(70);
    root.right.right = new Node<>(80);
    root.right.right.right = new Node<>(90);
    assertFalse(isValidAvl(root));
  }

  @Test
  public void deeperValidTreeIsValid() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(70);
    root.left.left = new Node<>(20);
    root.left.right = new Node<>(40);
    root.right.left = new Node<>(60);
    root.right.right = new Node<>(80);
    root.left.left.left = new Node<>(10);
    assertTrue(isValidAvl(root));
  }

  @Test
  public void valueOnWrongSideOfGrandparentIsInvalid() {
    // Every node is balanced, and 55 is larger than its parent 40, but it
    // sits in 50's left subtree, where every value must be smaller than 50.
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(70);
    root.left.left = new Node<>(20);
    root.left.right = new Node<>(40);
    root.left.right.right = new Node<>(55);
    root.right.left = new Node<>(60);
    root.right.right = new Node<>(80);
    assertFalse(isValidAvl(root));
  }
}
