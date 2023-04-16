package Chain;

public class IsMirrorBinNode {
  public static void main(String[] args) {
    BinNode<Integer> node = new BinNode(0);
    BinNode<Integer> next = node;
    BinNode<Integer> previous = node;

    for (int i = 0; i < 10; i++) {
      next.setNext(new BinNode(i, next, null));
      previous.setPrevious(new BinNode(i, null, previous));

      next = next.getNext();
      previous = previous.getPrevious();
    }
    
    System.out.println(isMirrorBinNode(node));
    next.setNext(new BinNode(123, next, null));
    System.out.println(isMirrorBinNode(node));
  }
  private static boolean isMirrorBinNode(BinNode<Integer> node) {
    BinNode<Integer> next = node.getNext();
    BinNode<Integer> previous = node.getPrevious();

    while (next.hasNext() && previous.hasPrevious()) {
      if (next.getValue() != previous.getValue()) return false;
      next = next.getNext();
      previous = previous.getPrevious();
    }
    System.out.println(next.getValue());
    System.out.println(previous.getValue());
    
    if (next.hasNext() || previous.hasPrevious()) return false;

    return true;
  }
}
