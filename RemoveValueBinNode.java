package Chain;

public class RemoveValueBinNode {
  public static void main(String[] args) {
    BinNode<Integer> node = new BinNode(1); 
    BinNode<Integer> iterator = node; 

    for (int i = 0; i <= 12; i++) {
      iterator.setNext(new BinNode(i % 3, iterator, null));
      iterator = iterator.getNext();
    }

    System.out.println(node.toString());
    removeValueBinNode(node, 2);
    System.out.println(node.toString());
  }
  private static void removeValueBinNode(BinNode<Integer> node, int target) {
    while (node.getValue() == target) node = node.getNext();
    while (node.getNext() != null) {
      if (node.getNext().getValue() == target) {
        node.setNext(node.getNext().getNext());
        node.getNext().setPrevious(node);
      }
      else {
        node = node.getNext();
      }
    }
  }
}
