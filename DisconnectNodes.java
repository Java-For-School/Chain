package Chain;

public class DisconnectNodes {
  public static void main(String[] args) {
    Node<Integer> first = new Node(0);
    Node<Integer> second = new Node(1);
    Node<Integer> commonNode = new Node(9);
    
    first.setNext(new Node(123));
    first.getNext().setNext(new Node(123123));
    first.getNext().getNext().setNext(new Node(1));

    commonNode.setNext(new Node(8));
    commonNode.getNext().setNext(new Node(7));
    commonNode.getNext().getNext().setNext(new Node(7));
  
    first.getNext().getNext().getNext().setNext(commonNode);
    second.setNext(commonNode);

    System.out.println("BEFORE:");
    printList(first);
    printList(second);
    System.out.println("AFTER:");
    disconnectNodes(first, second);
    printList(first);
    printList(second);
    first = stripLastNode(first);
    System.out.println("AFTER CHANGE:");
    printList(first);
    printList(second);
  }
  private static void printList(Node<Integer> node) {
    System.out.printf("[");
    while (node.getNext() != null) {
      System.out.printf("%d, ", node.getValue());
      node = node.getNext();
    }
    System.out.printf("%d]\n", node.getValue());
  }
  private static Node<Integer> stripLastNode(Node<Integer> node) {
    Node<Integer> currentNode = node;
    if (currentNode.getNext() == null) return null;
    else if (currentNode.getNext().getNext() == null) currentNode.setNext(null);
    else {
      while (currentNode.getNext().getNext() != null) currentNode = currentNode.getNext();
      currentNode.setNext(null);
    }

    return node;
  }
  private static Node<Integer> getLastNode(Node<Integer> node) {
    while (node.getNext() != null) node = node.getNext();
    return node;
  }
  private static Node<Integer> reverseNode(Node<Integer> node) {
    Node<Integer> reversedNode = new Node(0);
    Node<Integer> current = reversedNode;
    
    while (node != null) {
      current.setNext(new Node(getLastNode(node).getValue()));
      current = current.getNext();
      node = stripLastNode(node);
    }

    return reversedNode.getNext();
  }
  private static Node<Integer> getSameNode(Node<Integer> first, Node<Integer> second) {
    Node<Integer> sameNode = new Node(0); 
    Node<Integer> current = sameNode; 
    
    while (getLastNode(first).getValue() == getLastNode(second).getValue()) {
      current.setNext(new Node(getLastNode(first).getValue()));
      current = current.getNext();
      first = stripLastNode(first);
    }
    return reverseNode(sameNode.getNext());
  }
  private static Node<Integer> cloneNode(Node<Integer> node) {
    Node<Integer> newNode = new Node(0);
    Node<Integer> current = newNode;

    while (node != null) {
      current.setNext(new Node(node.getValue()));
      current = current.getNext();
      node = node.getNext();
    }

    return newNode;
  } 
  private static void disconnectNodes(Node<Integer> first, Node<Integer> second) {
    Node<Integer> sameNode = getSameNode(first, second);
    Node<Integer> lastNode = getLastNode(first);
    
    lastNode.setNext(sameNode);

    
    lastNode = getLastNode(second);
    Node<Integer> clonedSameNode = cloneNode(sameNode);
    lastNode.setNext(clonedSameNode);
  }
}
