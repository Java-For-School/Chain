package Chain;

public class AverageBinNode {
  public static void main(String[] args) {
    BinNode<Integer> node = new BinNode(0);
    BinNode<Integer> iterator = node;
    
    int sum = 0;
    int size = 0;
    
    for (int i = 0; i < 100; i++) {
      sum += i;
      size++;
      iterator.setNext(new BinNode(i, iterator, null));
      iterator = iterator.getNext();
    }

    System.out.println(sum / size);
    System.out.println(averageBinNode(node));
  }
  private static int averageBinNode(BinNode<Integer> node) {
    BinNode<Integer> previous = node;
    BinNode<Integer> next = node.getNext();

    int sum = 0;
    int size = 0;

    while (previous.hasPrevious()) {
      sum += previous.getValue();
      size++;
      previous = previous.getPrevious();
    }

    while (next.hasNext()) {
      sum += next.getValue();
      size++;
      next = next.getNext();
    }

    return sum / size;
  }
}
