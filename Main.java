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
    System.out.println(first);
    first = AddElement(69, first);
    System.out.println(first);
  }
  private static Node<Integer> AddElement(int value, Node<Integer> current) {
    return new Node<Integer>(value, current);
  }
}
