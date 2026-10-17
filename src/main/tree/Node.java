package tree;

/**
 * A node in a binary tree. A null reference is the empty tree.
 *
 * @param <T> the type of value held in the node.
 */
public class Node<T> {
  public T value;
  public Node<T> left;
  public Node<T> right;

  public Node(T value) {
    this.value = value;
  }
}
