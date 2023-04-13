package Chain;

public class Main {
  public static void main(String[] args) {
    Node<Integer> first = new Node(15);
    Node<Integer> current = first;
    Node<Integer> previous = first;

    for (int i = 0; i < 10; i++) {
      current = new Node(i);
      previous.setNext(current);
      previous = current;
    }
    System.out.println(isInList(first, 3));
    System.out.println(isInList(first, 69));
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
}
