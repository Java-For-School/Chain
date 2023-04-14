package Chain;

public class Main {
  public static void main(String[] args) {
    Node<Integer> first = new Node(0);
    Node<Integer> current = first;
    Node<Integer> previous = first;

    for (int i = 1; i < 12; i++) {
      current = new Node(i % 4);
      previous.setNext(current);
      previous = current;
    }
    printList(first);
    setSquared(first);
    printList(first);
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
  public static Node<Integer> insertIntoSortedList(Node<Integer> first, int target) {
    Node<Integer> current = first;
    Node<Integer> newNode = new Node(target);
    while (current.getNext() != null && current.getNext().getValue() < target) { current = current.getNext(); }
    if (current.getNext() == null) {
      current.setNext(newNode);
    }
    else {
      newNode.setNext(current.getNext());
      current.setNext(newNode);
    }

    return first;
  }
  public static Node<Integer> removeValueFromList(Node<Integer> first, int value) {
    Node<Integer> current = first;
    
    while (current != null) {
      if (current.getValue() == value) {
        current = current.getNext();
        first = current;
      }
      if (current.getNext().getValue() == value) {
        current.setNext(current.getNext().getNext());
      }
    }
    
    return first;
  }
  public static Node<Integer> removeDuplicates(Node<Integer> first) {
    Node<Integer> current = first;

    while (current != null) {
      current.setNext(removeValueFromList(current.getNext(), current.getValue()));
    }

    return first;
  }
  public static int getSum(Node<Integer> first) {
    int sum = 0;

    while (first != null) {
      sum += first.getValue();
      first = first.getNext();
    } 
    
    return sum;
  }
  public static void setSquared(Node<Integer> first) {
    while (first != null) {
      first.setValue((int) Math.pow(first.getValue(), 2));
      first = first.getNext();
    } 
  }
}
