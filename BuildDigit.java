package Chain;

public class BuildDigit {
  public static void main(String[] args) {
    Node<Integer> node = new Node(123);
    Node<Integer> newNode;
    
    node.setNext(new Node(49));
    node.getNext().setNext(new Node(12398));

    newNode = buildDigit(node);

    while (newNode != null) {
      System.out.println(newNode.getValue());
      newNode = newNode.getNext();
    }
  }
  public static Node<Integer> buildDigit(Node<Integer> node) {
    Node<Integer> newNode = new Node(0);
    Node<Integer> current = newNode;
    
    while (node != null) {
      int element = node.getValue();

      while (element > 0) {
        current.setNext(new Node(element % 10));
        current = current.getNext();
        element /= 10;
      }

      current.setNext(new Node(-9));
      current = current.getNext();
      node = node.getNext();
    }

    return newNode.getNext();
  }
}
