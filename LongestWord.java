package Chain;
public class LongestWord {
  public static void main(String[] args) {
    Node<String> node = new Node("1");
    node.setNext(new Node("22"));
    node.getNext().setNext(new Node("2123123"));
    node.getNext().getNext().setNext(new Node("123"));

    System.out.println(longestWord(node));
  }
  private static String longestWord(Node<String> node) {
    if (node.getNext() == null) return node.getValue();
    
    String previous = longestWord(node.getNext());

    if (node.getValue().length() > previous.length()) {
      return node.getValue();
    } else return previous;
  }
}
