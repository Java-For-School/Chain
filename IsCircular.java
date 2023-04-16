package Chain;

public class IsCircular {
  public static void main(String[] args) {
    Node<Integer> head = new Node(1);
    Node<Integer> current = head;

    for (int i = 2; i < 10; i++) {
      current.setNext(new Node(i));
      current = current.getNext();
    }

    System.out.println(isCircular(head));
    current.setNext(head); 
    System.out.println(isCircular(head));
  }
  private static boolean isCircular(Node<Integer> node) {
    Node<Integer> head = node;
    Node <Integer> iterator;

    while (head != null) {
      iterator = head.getNext();

      while (iterator != null) {
        if (iterator == head) return true;
        iterator = iterator.getNext();
      }

      head = head.getNext();
    }

    return false;
  }
}
