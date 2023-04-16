package Chain;

class GetAcryonyms {
  public static void main(String[] args) {
    Node<String> node = new Node("National");
    
    node.setNext(new Node("Aeronautics"));
    node.getNext().setNext(new Node("Aeronautics"));
    node.getNext().getNext().setNext(new Node("Space"));
    node.getNext().getNext().getNext().setNext(new Node("Administration"));
  
    Node<Character> newNode = getAcryonyms(node);
    while (newNode != null) {
      System.out.println(newNode.getValue());
      newNode = newNode.getNext();
    }
  }
  public static Node<Character> getAcryonyms(Node<String> node) {
    Node<Character> newNode = new Node('a');
    Node<Character> current = newNode;
    
    while (node != null) {
      current.setNext(new Node<Character>(node.getValue().charAt(0)));
      current = current.getNext();
      node = node.getNext();
    }

    return newNode.getNext();
  }
}
