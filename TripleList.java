package Chain;

public class TripleList {
  public static void main(String[] args) {
    Node<Integer> node = new Node(0);
    Node<Integer> current = node;
    
    for (int i = 1; i <= 12; i++) {
      current.setNext(new Node(i % 4));
      current = current.getNext();
    }

    node = node.getNext();
    
    System.out.println(tripleList(node));
  }
  private static boolean tripleList(Node<Integer> node) {
    Node<Integer> firstCounter = node;
    Node<Integer> secondCounter = node; 
    Node<Integer> thirdCounter = node; 
    
    int listLength = 0;
    int currentPosition = 0;

    while (firstCounter != null) {
      firstCounter = firstCounter.getNext();
      listLength++;
    }

    if (listLength % 3 != 0) return false;
    firstCounter = node;
    
    while (currentPosition != listLength / 3) {
      currentPosition++;
      secondCounter = secondCounter.getNext(); 
    }
    thirdCounter = secondCounter;
    while (currentPosition != (listLength / 3) * 2) {
      currentPosition++;
      thirdCounter = thirdCounter.getNext();
    }

    while (thirdCounter != null) {
      if (thirdCounter.getValue() != secondCounter.getValue() || thirdCounter.getValue() != firstCounter.getValue()) return false;
      firstCounter = firstCounter.getNext();
      secondCounter = secondCounter.getNext();
      thirdCounter = thirdCounter.getNext();
    }

    return true;
  }
}
