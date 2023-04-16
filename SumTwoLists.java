package Chain;

public class SumTwoLists {
  public static void main(String[] args) {
    Node<Integer> node = new Node(0);
    Node<Integer> current = node;

    for (int i = 0; i < 10; i++) {
      current.setNext(new Node(i));
      current = current.getNext();
    } 


    Node<Integer> secondNode = new Node(0);
    current = secondNode;


    for (int i = 0; i < 10; i++) {
      current.setNext(new Node(i * 3 - 1));
      current = current.getNext();
    } 
    
    Node<Integer> sumNode = sumTwoLists(node, secondNode);

    while (sumNode != null) {
      System.out.println(sumNode.getValue());
      sumNode = sumNode.getNext();
    }
  }
  private static Node<Integer> sumTwoLists(Node<Integer> first, Node<Integer> second) {
    Node<Integer> newNode = new Node(0);
    Node<Integer> current = newNode;

    while (first != null && second != null) {
      current.setNext(new Node(first.getValue() + second.getValue()));
      first = first.getNext();
      second = second.getNext();
      current = current.getNext();
    }
      
    while (first != null) {
      current.setNext(new Node(first.getValue()));
      first = first.getNext();
    }

    while (second != null) {
      current.setNext(new Node(second.getValue()));
      second = second.getNext();
    }

    return newNode.getNext();
  }
}
