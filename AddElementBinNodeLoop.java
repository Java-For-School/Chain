package Chain;

import java.util.Scanner;

public class AddElementBinNodeLoop {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    BinNode<Integer> node = new BinNode(6);
    node.setNext(new BinNode(1, node, null));
    node.getNext().setNext((new BinNode(11, node.getNext(), null)));
    
    System.out.println(node);
    addElementBinNodeLoop(node, 5);
    System.out.println(node);
  }
  private static void addElementBinNodeLoop(BinNode<Integer> node, int amountOfElements) {
    BinNode<Integer> temp = node;

    while (node.getNext() != null) node = node.getNext(); 
    for (int i = 0; i < amountOfElements; i++) {
      int element = scanner.nextInt();
      node.setNext(new BinNode(element, node, null));
      node = node.getNext();
    }
  }
}
