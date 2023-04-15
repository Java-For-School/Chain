package Chain;

public class Main {
  public static void main(String[] args) {
    Node<Integer> first = new Node(0);
    Node<Integer> current = first;
    Node<Integer> previous = first;
    Node<Integer> second = new Node(0);
    
    for (int i = 1; i < 12; i++) {
      current = new Node(i * 2);
      previous.setNext(current);
      previous = current;
    }
    
    current = second;
    previous = second;

    for (int i = 1; i < 12; i++) {
      current = new Node(i);
      previous.setNext(current);
      previous = current;
    }
    Node<Integer> newList = createRandomList(20);
    Node<Integer> completion = listBuild(newList, 100);

    printList(newList);
    printList(completion);
  }

  private static void printList(Node<Integer> first) {
    System.out.print("[");
    while (first.getNext() != null) {
      System.out.printf("%d, ", first.getValue());
      first = first.getNext();
    }
    System.out.printf("%d]\n", first.getValue());
  }
  private static Node<Integer> AddElement(int value, Node<Integer> current) {
    return new Node<Integer>(value, current);
  }
  private static boolean isInList(Node<Integer> first, int target) {
    Node<Integer> current = first;

    while (current.getNext() != null) {
      if (current.getValue() == target) return true;
      current = current.getNext();
    }

    return false;
  }
  public static int getNumOfNodes(Node<Integer> first) {
    int count = 0;
    while (first != null) {
      count++;
      first = first.getNext();
    }

    return count;
  }
  public static Node<Integer> insertIntoSortedList(Node<Integer> first, int target) {
    Node<Integer> current = first;
    Node<Integer> newNode = new Node(target);
    while (current.getNext() != null && current.getNext().getValue() < target) { current = current.getNext(); }
    if (current.getNext() == null) {
      current.setNext(newNode);
    }
    else {
      newNode.setNext(current.getNext());
      current.setNext(newNode);
    }

    return first;
  }
  public static Node<Integer> removeValueFromList(Node<Integer> first, int value) {
    Node<Integer> current = first;
    
    while (current != null) {
      if (current.getValue() == value) {
        current = current.getNext();
        first = current;
      }
      else if (current.getNext().getValue() == value) {
        current.setNext(current.getNext().getNext());
      }
      else {
        current = current.getNext();
      }
    }
    
    return first;
  }
  public static Node<Integer> removeDuplicates(Node<Integer> first) {
    Node<Integer> current = first;

    while (current != null) {
      current.setNext(removeValueFromList(current.getNext(), current.getValue()));
    }

    return first;
  }
  public static int getSum(Node<Integer> first) {
    int sum = 0;

    while (first != null) {
      sum += first.getValue();
      first = first.getNext();
    } 
    
    return sum;
  }
  public static void setSquared(Node<Integer> first) {
    while (first != null) {
      first.setValue((int) Math.pow(first.getValue(), 2));
      first = first.getNext();
    } 
  }
  public static Node<Integer> createFibonacciList(int elements) {
    int first = 0;
    int second = 1;
    int temp = 0;
    
    Node<Integer> firstNode = new Node(first);
    Node<Integer> current = firstNode;

    for (int i = 1; i < elements; i++) {
      current.setNext(new Node(second)); 
      current = current.getNext();
      
      temp = second;
      second += first;
      first = temp;
    }

    return firstNode;
  }
  public static Node<Integer> splitListToEvenOdd(Node<Integer> first) {
    boolean even = first.getValue() % 2 == 0;
    
    Node<Integer> newNode = new Node(0);
    Node<Integer> current = first;
    Node<Integer> currentNewNode = newNode;
    
    while (current.getNext() != null) {
      if (even != (current.getNext().getValue() % 2 == 0)) {
        currentNewNode.setNext(current.getNext());
        currentNewNode = currentNewNode.getNext();
        current.setNext(current.getNext().getNext());
      } else {
        current = current.getNext();
      }
    }

    return newNode.getNext();
  }
  public static Node<Integer> mergeTwoSortedChains(Node<Integer> first, Node<Integer> second) {
    Node<Integer> newNode = new Node(0);
    Node<Integer> current = newNode;

    while (first != null || second != null) {
      if (first == null) {
        while (second != null) {
          current.setNext(new Node(second.getValue()));
          current = current.getNext();
          second = second.getNext();
        }
      }
      else if (second == null) {
        while (first != null) {
          current.setNext(new Node(first.getValue()));
          current = current.getNext();
          first = first.getNext();
        }
      }
      else {
        int smaller = Math.min(first.getValue(), second.getValue());
        boolean firstSmaller = smaller == first.getValue();
        current.setNext(new Node(firstSmaller ? first.getValue() : second.getValue()));
        current = current.getNext();
        if (firstSmaller) first = first.getNext();
        else second = second.getNext();
      }
    }

    return newNode.getNext();
  }
  public static Node<Integer> createRandomList(int nodes) {
    Node<Integer> first = new Node(0);
    Node<Integer> current = first;
    
    for (int i = 0; i < nodes; i ++) {
      int number = 10 + (int) Math.round(Math.random() * 89.0);
      if (number % 3 == 0) {
        number -= 1;
      }
      current.setNext(new Node(number));
      current = current.getNext();
    }

    return first.getNext();
  }
  public static Node<Integer> listBuild(Node<Integer> first, int number) {
    Node<Integer> newNode = new Node(0);
    Node<Integer> current = newNode;
    Node<Integer> firstIterator = first;
    
    for (int i = 0; i < number; i++) {
      boolean isInFirst = false;
      while (firstIterator != null) {
        if (firstIterator.getValue() == i) isInFirst = true; 
        firstIterator = firstIterator.getNext();
      }
      if (!isInFirst) {
        current.setNext(new Node(i));
        current = current.getNext();
      }
    }
    
    return first.getNext();
  }

}
