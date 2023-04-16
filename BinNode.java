package Chain;

public class BinNode<T> {
  private T value;
  private BinNode<T> previous;
  private BinNode<T> next;

  public BinNode(T value) {
    this.value = value;
    this.previous = null;
    this.next = null;
  }
  public BinNode(T value, BinNode<T> previous, BinNode<T> next) {
    this.value = value;
    this.previous = previous;
    this.next = next;
  }
  public T getValue() { return this.value; }
  public BinNode<T> getPrevious() { return this.previous; }
  public BinNode<T> getNext() { return this.next; }
  public void setValue(T value) { this.value = value; }
  public void setPrevious(BinNode<T> previous) { this.previous = previous; }
  public void setNext(BinNode<T> next) { this.next = next; }
  public boolean hasPrevious() { return this.previous != null; }
  public boolean hasNext() { return this.next != null; }
  @Override
  public String toString() {
    if (value == null) return "null";
    if (this.getNext() != null) return value + " -->" + this.getNext().toString();
    else return value + " -->";
  }
  

}
