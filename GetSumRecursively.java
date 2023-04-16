package Chain;

public class GetSumRecursively {
  public static void main(String[] args) {
    Node<Integer> node = new Node(0);
    Node<Integer> iterator = node;
    
    int counter = 0;

    for (int i = 0; i < 10; i++) {
      counter += i * 5;
      iterator.setNext(new Node(i * 5));
      iterator = iterator.getNext();
    }

    System.out.printf("The projected sum is: %d, the actual sum is: %d\n", getSumRecursively(node), counter);
  }
  private static int getSumRecursively(Node<Integer> node) {
    if (node.getNext() == null) return node.getValue();
    return node.getValue() + getSumRecursively(node.getNext());
  }
}
