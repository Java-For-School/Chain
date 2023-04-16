package Chain;

class InsertToSortedStringList {
  public static void main(String[] args) {
    Node<String> node = new Node("Alon");
    node.setNext(new Node("Berta"));
    node.getNext().setNext(new Node("Gilad"));
    node.getNext().getNext().setNext(new Node("Hila"));

    node = insertToSortedStringList(node, "Connor");

    while (node != null) {
      System.out.println(node.getValue());
      node = node.getNext();
    }

  }
  private static Node<String> insertToSortedStringList(Node<String> node, String string) {
    Node<String> newNode = new Node("null", node);
    boolean isInserted = false;
    
    while (!isInserted) {
      System.out.println(newNode.getNext().getValue());
      if (newNode.getNext() == null) {
        isInserted = true;
        newNode.setNext(new Node(string));
      }
      else if (string.compareTo(newNode.getNext().getValue()) == 0) {
        newNode.setNext(new Node(string, newNode.getNext()));
        isInserted = true;
      }
      else if (string.compareTo(newNode.getNext().getValue()) > 0) {
        newNode = newNode.getNext();
      }
      else {
        isInserted = true;
        newNode.setNext(new Node<String>(string, newNode.getNext()));
      }
    }

    return node;
  }
}
