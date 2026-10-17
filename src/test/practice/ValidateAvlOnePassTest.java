package practice;

import tree.Node;

/** Runs the validate-AVL scenarios against the one-pass solution. */
public class ValidateAvlOnePassTest extends ValidateAvlTest {

  @Override
  protected boolean isValidAvl(Node<Integer> root) {
    return ValidateAvl.isValidAvl(root);
  }
}
