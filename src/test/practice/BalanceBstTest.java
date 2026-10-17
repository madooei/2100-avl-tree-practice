package practice;

import list.ArrayList;
import list.List;
import org.junit.jupiter.api.Test;
import tree.Node;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for the balance-a-BST problem and its buildBalanced step. */
public class BalanceBstTest {

  @Test
  public void buildBalancedOfEmptyListIsEmptyTree() {
    assertNull(BalanceBst.buildBalanced(new ArrayList<Integer>()));
  }

  @Test
  public void buildBalancedPicksTheMiddleAsRoot() {
    Node<Integer> root = BalanceBst.buildBalanced(range(20, 80, 10));
    assertEquals(50, root.value);
    assertEquals(30, root.left.value);
    assertEquals(70, root.right.value);
  }

  @Test
  public void buildBalancedKeepsTheSortedOrder() {
    List<Integer> sorted = range(20, 80, 10);
    assertSameValues(sorted, inOrder(BalanceBst.buildBalanced(sorted)));
  }

  @Test
  public void buildBalancedIsBalancedForEverySize() {
    for (int n = 1; n <= 40; n++) {
      Node<Integer> root = BalanceBst.buildBalanced(range(1, n, 1));
      assertTrue(isBalanced(root), "n = " + n);
      assertEquals(floorLog2(n), height(root), "n = " + n);
    }
  }

  @Test
  public void balanceOfEmptyTreeIsEmptyTree() {
    assertNull(BalanceBst.balance(null));
  }

  @Test
  public void balanceRebuildsARightChain() {
    Node<Integer> root = rightChain(20, 80, 10);
    Node<Integer> balanced = BalanceBst.balance(root);
    assertEquals(50, balanced.value);
    assertEquals(2, height(balanced));
    assertTrue(isBalanced(balanced));
    assertSameValues(range(20, 80, 10), inOrder(balanced));
  }

  @Test
  public void balanceRebuildsALeftChain() {
    // 80 -> 70 -> ... -> 20, each the left child of the last.
    Node<Integer> root = new Node<>(80);
    Node<Integer> curr = root;
    for (int value = 70; value >= 20; value -= 10) {
      curr.left = new Node<>(value);
      curr = curr.left;
    }
    Node<Integer> balanced = BalanceBst.balance(root);
    assertEquals(50, balanced.value);
    assertEquals(2, height(balanced));
    assertTrue(isBalanced(balanced));
    assertSameValues(range(20, 80, 10), inOrder(balanced));
  }

  @Test
  public void balanceOfSingleNodeIsSingleNode() {
    Node<Integer> balanced = BalanceBst.balance(new Node<>(42));
    assertEquals(42, balanced.value);
    assertNull(balanced.left);
    assertNull(balanced.right);
  }

  @Test
  public void balanceKeepsAnAlreadyBalancedTreeBalanced() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(70);
    root.left.left = new Node<>(20);
    root.left.right = new Node<>(40);
    Node<Integer> balanced = BalanceBst.balance(root);
    assertTrue(isBalanced(balanced));
    assertSameValues(list(20, 30, 40, 50, 70), inOrder(balanced));
  }

  // Returns the list start, start + step, ..., end.
  private static List<Integer> range(int start, int end, int step) {
    List<Integer> out = new ArrayList<>();
    for (int value = start; value <= end; value += step) {
      out.add(value);
    }
    return out;
  }

  private static List<Integer> list(int... values) {
    List<Integer> out = new ArrayList<>();
    for (int value : values) {
      out.add(value);
    }
    return out;
  }

  // Builds start -> start + step -> ... -> end, each the right child of the last.
  private static Node<Integer> rightChain(int start, int end, int step) {
    Node<Integer> root = new Node<>(start);
    Node<Integer> curr = root;
    for (int value = start + step; value <= end; value += step) {
      curr.right = new Node<>(value);
      curr = curr.right;
    }
    return root;
  }

  private static List<Integer> inOrder(Node<Integer> root) {
    List<Integer> out = new ArrayList<>();
    inOrder(root, out);
    return out;
  }

  private static void inOrder(Node<Integer> node, List<Integer> out) {
    if (node == null) {
      return;
    }
    inOrder(node.left, out);
    out.add(node.value);
    inOrder(node.right, out);
  }

  private static void assertSameValues(List<Integer> expected, List<Integer> actual) {
    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++) {
      assertEquals(expected.get(i), actual.get(i));
    }
  }

  private static int height(Node<Integer> node) {
    if (node == null) {
      return -1;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }

  private static boolean isBalanced(Node<Integer> node) {
    if (node == null) {
      return true;
    }
    if (Math.abs(height(node.left) - height(node.right)) > 1) {
      return false;
    }
    return isBalanced(node.left) && isBalanced(node.right);
  }

  private static int floorLog2(int n) {
    int log = 0;
    while (n > 1) {
      n /= 2;
      log++;
    }
    return log;
  }
}
