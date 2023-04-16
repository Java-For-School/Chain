package Chain;

public class NonCapitalCharacterSum {
  public static void main(String[] args) {
    Node<String> node = new Node("alon");
    node.setNext(new Node("MOTI"));
    node.getNext().setNext(new Node("mOTI"));
    node.getNext().getNext().setNext(new Node("bafoon"));

    System.out.println(nonCapitalCharacterSum(node));

  }
  private static int nonCapitalCharacterSum(Node<String> node) {
    if (node.getNext() == null) {
      char character = node.getValue().charAt(0);
      return ('a' <= character && character <= 'z') ? 1 : 0; 
    }

    char character = node.getValue().charAt(0);
    
    return nonCapitalCharacterSum(node.getNext()) + (('a' >= character && character <= 'z') ? 1 : 0); 
  }
}
