
class Program {
	
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		 
		 LinkedList first = head;
		 LinkedList second = head;
		 int counter = 1;
		 while(counter <= k && second!=null){
			 second = second.next;
			 counter += 1;
		 }
		 if(second == null){
			 
			 first.value = first.next == null ? null: first.next.value;
			 first.next = first.next == null ? null: first.next.next;
			 return;
		 }
		 while(second.next != null){
			  first = first.next;
			  second = second.next;
		 }
		 
		 
		 first.next = first.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
