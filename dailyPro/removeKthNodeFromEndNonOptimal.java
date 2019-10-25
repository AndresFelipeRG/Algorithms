
class Program {
	
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		 
		 LinkedList h = new LinkedList(head.value);
		 h = head;
		 LinkedList prev = null;
		 LinkedList temp = null;
		 while(h != null){
			 temp = h;
			 h = h.next;
			 temp.next = prev;
			 prev = temp;
			 temp = null;
			 if(h == null){
				 h = prev;
				 int count = 0;
				 
				 prev = null;
				 while( h != null){
					  LinkedList temp2 = h;
					  h = h.next;
					  temp2.next = prev;
					  prev = temp2;
					 
					  if(count < k){
					  	count += 1;
						}
					  if(count == k ){
						  
							
							LinkedList temp3 = prev;
							if(h != null){
								  temp2 = h;
									h = h.next;
								
								  temp2.next = temp3.next;
								  prev.next = null;
								  prev =  temp2;
							
							}else{
								  
								  temp2 = temp3.next;
								  prev = temp3.next;
								  break;
							}
							count = k + 1;
						}
				 }
				
				 
			 }
		 }
		 
		// head.value = prev.value;
		 head.next = prev.next;
		 head.value = prev.value;
		 
		// System.out.println(head.value);
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
