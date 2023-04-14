package Chain;

public class LongerThan3 {
  public static void main(String[] args) {
    StringNode first = new StringNode("WHATDUP");
    StringNode current = first;

    System.out.println(longerThan3(first));
    for (int i = 0; i < 15; i++) {
      current.setNext(new StringNode("Hey!".repeat(i)));
      current = current.getNext();
    }

    System.out.println(longerThan3(first));
  }
  public static int longerThan3(StringNode node) {
    int count = 0;
    while (node != null) {
      count++;
      node = node.getNext();
    }
    
    return count;
  }
}
