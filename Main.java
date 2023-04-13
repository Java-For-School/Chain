package Chain;

public class Main {
  public static void main(String[] args) {
    Node<Integer> first = new Node(15);
    Node<Integer> current = first;
    Node<Integer> previous = first;

    for (int i = 0; i < 12; i++) {
      current = new Node(i % 3);
      previous.setNext(current);
      previous = current;
    }
    printList(first); 
    System.out.printf("The list has: %d items.\n", getNumOfNodes(first));
    removeValueFromList(first, 10);
    removeValueFromList(first, 2);
    printList(first); 
    System.out.printf("The list has: %d items.\n", getNumOfNodes(first));
  }
  private static void printList(Node<Integer> first) {
    System.out.print("[");
    while (first.getNext() != null) {
      System.out.printf("%d, ", first.getValue());
      first = first.getNext();
    }
    System.out.printf("%d]\n", first.getValue());
  }
  private static Node<Integer> AddElement(int value, Node<Integer> current) {
    return new Node<Integer>(value, current);
  }
  private static boolean isInList(Node<Integer> first, int target) {
    Node<Integer> current = first;

    while (current.getNext() != null) {
      if (current.getValue() == target) return true;
      current = current.getNext();
    }

    return false;
  }
  public static int getNumOfNodes(Node<Integer> first) {
    int count = 0;
    while (first != null) {
      count++;
      first = first.getNext();
    }

    return count;
  }
  public static Node<Integer> removeValueFromList(Node<Integer> first, int target) {
    Node<Integer> current = first;
    Node<Integer> next; 
    

    while (current.getValue() == target) current = current.getNext();
    
    next = current.getNext();
    first = current;

    while (next != null) {
      if (next.getValue() == target) {
        current.setNext(next.getNext());
        next = current.getNext();
      }
      else {
        current = next;
        next = next.getNext();
      }
    }

    return first;
  }
}
