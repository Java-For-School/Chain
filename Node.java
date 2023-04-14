package Chain;

public class Node <T> {
  private T value;
  private Node<T> next;
  
  public Node(T value) {
    this.value = value;
    this.next = null;
  }
  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }
  public Node(Node<T> list) {
    Node<T> first = new Node(list.getValue());
    Node<T> current = first;
    
    list = list.getNext();

    while (list != null) {
      current.setNext(new Node(list.getValue()));
      current = current.getNext();
      list = list.getNext();
    }

    this.value = first.getValue();
    this.next = first.getNext();
  }
  public T getValue() {
    return value;
  }
  public void setValue(T value) {
    this.value = value;
  }
  public Node<T> getNext() {
    return next;
  }
  public void setNext(Node<T> next) {
    this.next = next;
  }
  public boolean hasNext() {
    return (this.next != null);
  }
  public String toString() {
    return this.value.toString();
  }
}
