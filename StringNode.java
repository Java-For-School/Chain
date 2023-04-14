package Chain;

public class StringNode {
  private String value;
  private StringNode next;

  public StringNode(String value) {
    this.value = value;
  }
  public StringNode(String value, StringNode next) {
    this.value = value;
    this.next = next;
  }
  public boolean hasNext() { return this.next != null; } 
  public String getValue() { return this.value; }
  public StringNode getNext() { return this.next; }
  public void setValue(String value) { this.value = value; }
  public void setNext(StringNode next) { this.next = next;}
  public String toString() { return this.value; }
}
