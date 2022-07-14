class LinkedList{
  Node head; 
  static class Node{
    int data;
    Node next;
    Node(int d){
      data = d;
      next = null;
    }
  }
  public void printList(){
    Node tempNode = head;
    while (tempNode!= null) {
      System.out.print(tempNode.data + " " );
      tempNode = tempNode.next;
    }
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.head = new Node(5);
    Node secondNode = new Node(6);
    Node thirdNode = new Node(7);
    list.head.next = secondNode;
    secondNode.next = thirdNode;
    list.printList();
  }
}
