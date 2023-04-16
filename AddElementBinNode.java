package Chain;

public class AddElementBinNode {
  public static void main(String[] args) {
    BinNode<Integer> node = new BinNode(1);
    node.setNext(new BinNode(4, node, null));
    node.getNext().setNext(new BinNode(5, node.getNext(), null));
    node.getNext().getNext().setNext(new BinNode(9, node.getNext().getNext(), null));
    addElement(node, 69, 4);

    System.out.println(node.toString());
  }
  private static void addElement(BinNode<Integer> node, int element, int index) {
    for (int i = 1; i < index - 1; i++) {
      node = node.getNext();
    }

    node.getNext().setPrevious(new BinNode(element, node, node.getNext()));
    node.setNext(node.getNext().getPrevious());
  }
}
