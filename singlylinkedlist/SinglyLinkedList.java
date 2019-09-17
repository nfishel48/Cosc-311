package singlylinkedlist;

/**
 *  Modified from Drozdek, Data Structures and Algorithms in Java
 *  Name: <Nathan Fishel>
 *  COSC 311  FA19
 *  hw0912
 *  URL:  <https://github.com/nfishel48/Cosc-311/blob/master/singlylinkedlist/SinglyLinkedList.java>
 */

public class SinglyLinkedList {

   public class Node {
      int   data;
      Node  next;
      
      public Node () {
         this (0, null);
      }
      
      public Node (int data) {
         this(data, null);
      }
      
      public Node(int data, Node next) {
         this.data = data;
         this.next = next;
      }
   }
   
   Node  head, tail;
   
   public SinglyLinkedList() {
      head = tail = null;
   }
   
   
   public void delete(int el) {
      if (!isEmpty() )
         if ( head == tail && el == head.data)
            head = tail = null;
         else if (el == head.data )
            head = head.next;
         else {   
            Node p, q;
            for ( p= head, q = head.next; 
                  q != null && !(q.data == el ); 
                  p = p.next, q = q.next) ;
            if (q != null) {
               p.next = q.next;
               if (q == tail )
                  tail = p;
            }
         } 
   }
   
   public void insert(int el) {
	   if(head != null)  {//check if the list is empty
		   if ( head == tail ) {//check if there is only one node in the list
			   if ( el > head.data) {    // check what number is bigger
			  Node p = new Node(el); //create the new node
			   tail = p; //make it the last node
			   head.next = p ; // make it the second node
			   }
		   }
		   
		   else if (el<= head.data) {//if the number is the first in the list 
			   Node temp = new Node(el, head);
			   head = temp;
		   }
		   else { //More then one node in the list
			   
			    Node position = head; //Pointer to the head node
				Node previous = null; //Keep track of previous node
				boolean done = false;
				Node temp; //an empty node
				
			   while(position != null && !done){//move through the list to find the place for the node
				   
	
				     if (el > position.data) {//if the number is greater than the current number
				    	 previous = position;
				    	 position = position.next;
					   }
				     else {
				    	 temp = new Node (el, position);
				    	 previous.next = temp;
				    	 done = true;
				    	 
				     }
				     if(position == null && !done) {
				    	 temp = new Node(el);
				    	 previous.next = temp;
				    	 done = true;
				     }
				    	 
					   
			   		}
				 
		   		}
	   
		   
	   }
	   else { //the list is empty so make the number the first and last node
		Node temp = new Node(el);
		head = temp;
		tail = temp;
	   }
	    
   
   }

   public boolean isEmpty() {
      return head == null;
   }
   
   public String  toString() {
      String s = "";
      if (head == null) { 
         return "Empty String" ;
      }
      for (Node p = head; p != null; p = p.next) 
         s += p.data + " ";
      return s;
   }
     
   public static void main(String[] args) {
      SinglyLinkedList list = new SinglyLinkedList();
      System.out.println("Execution begun");
      System.out.println("initial list: " + list );
          
      // testing

      list.insert(3);
      list.insert(5);
      System.out.println(list);
      
      list.insert(2);
      list.insert(2);
      list.insert(2);
      list.insert(7);
      list.insert(6);
      System.out.println("list after inserts: " + list);
      
      list.delete(2);
      list.delete(5);
      list.delete(7);
      System.out.println("list after deletes: " + list);
          
      System.out.println("Execution terminated");
        
        
   }
}

/**
 *
Execution begun
initial list: Empty String
3 5 
list after inserts: 2 2 2 3 5 6 7 
list after deletes: 2 2 3 6 
Execution terminated
 * 
 */

