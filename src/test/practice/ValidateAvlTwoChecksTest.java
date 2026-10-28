package practice;

import tree.Node;

/** Runs the validate-AVL scenarios against the two-checks solution. */
public class ValidateAvlTwoChecksTest extends ValidateAvlTest {

  @Override
  protected boolean isValidAvl(Node<Integer> root) {
    return ValidateAvlTwoChecks.isValidAvl(root);
  }
}
