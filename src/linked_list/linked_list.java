package linked_list;

import java.awt.HeadlessException;
import java.awt.font.TextMeasurer;
import java.security.DrbgParameters.NextBytes;
import java.time.chrono.HijrahEra;
import java.time.temporal.ValueRange;

import org.w3c.dom.ls.LSOutput;

public class linked_list {
	// creation of node
public static class node {
	int data;
	node next;
	public node(int data) {
		this.data=data;
		this.next=null;
	}
}
// head node & tail node
public static node head;
public static node tail;
// for size of linked list 
public static int size;




public void addfirst(int data) {
	// yaha par maine nayi node create ke hai
	node newnode = new node(data); 
	size++;
	
	// if ll is empty then head = null
	if(head ==null) {
		head = tail = newnode;
		return;
	}
	// yaha par head ki value newnode man store kara de hai
	newnode.next = head; 
	// head yaha point kar raha hai new node ki head ki value abb new node main hai
	head = newnode; 
}
        



public void addlast(int data) {
	node newnode = new node(data);
	size++;
	if(head == null) {
		head = tail = newnode;
		return;
	}
	tail.next = newnode;
	tail = newnode;
}





public  void add_index(int idx,int data) {
	if(idx==0) {
		addfirst(data);
		return ;
	}
	node newnode = new node(data);
	size++;
	node temp = head ;
	int i=0;
	while(i<idx-1) {
		temp = temp.next;
		i++;
	}
	newnode.next = temp.next; 
	// isme main newnode connect ho raha hai tem ke next node se
	
	temp.next = newnode ;	
}





public static int remove_first() {  
	if(size==0) {
		System.out.println("linked list is empty");
		return Integer.MIN_VALUE;
	}
	else if(size==1) {
		int val = head.data;
		head = tail = null;
		size=0;
		return val;
		
	}
int val = head.data;
head=head.next;
size--;
return val;
}




public int remove_last() {
	if(size==0) {
		System.out.println("linked list is empty");
		return Integer.MIN_VALUE;
	}
	else if(size==1) {
		int val = head.data;
		head = tail = null;
		size=0;
		return val;
		
	}
	node prev = head;
	for(int i=0;i<size-2;i++) {
		prev =prev.next;
	}
	int val = prev.next.data;
	prev.next =null;
	tail =prev;
	size --;
	return val;
}
 




public void print() {
	if(head ==null) {
		System.out.println("Linked-list is empty");
		return;
		
	}
	node temp =head;
	while(temp != null) {
		System.out.print(temp.data+" >> ");
		temp=temp.next;

	}
	System.out.println("null");
}





public int itrsearch(int key) { // iterative approch
	node temp = head ;
	int i=0;
	while(temp!=null) { 
		if(temp.data==key) {
			return i;
		}
		temp =temp.next;
		i++;
	
	}
	return -1;
}





public int helper(node head,int key) {
	if(head == null) {
		return -1;
	}
	if(head.data == key) {
		return 0;
	}
	int idx = helper(head.next,key);
	if(idx == -1) {
		return -1;
	}
	return idx+1;
}
public int rec_search(int key) {
	return helper(head, key);
}



public void reverse() {
	node prev =null;
	node curr = tail = head;
	node next;
	while(curr!=null) {
		next =curr.next;
		curr.next = prev;
		prev = curr;
	
	curr = next;}
	head = prev;
}


public void delete_Nth_from_END(int n) {
	// calculate size 
	int sz=0;
	node temp = head;
	while(temp != null) {
		temp= temp.next;
		sz++;
		
	}
	if(n==sz) {
		head =head.next;
		
	}
	// sz-n
	int i=1;
	int idxtoFINd =sz-n;
	node prev =head;
	while(i<idxtoFINd) {
		prev=prev.next;
		i++;
		
	}
	prev.next=prev.next.next;
	return;
}



public node find_mid(node head) {
	node slow =head;
	node fast = head;
	
	while (fast !=null && fast.next!=null) {
		slow = slow.next ; // for +1 
		fast = fast.next ; // for +2
		
	}
	return slow;// slow is my midnnode
	
}


public boolean check_palendroom() {
	if(head==null|| head.next==null) {
		return true;
	}
	
	//step one find mid node
	node midnode =find_mid(head);
	// step 2 - reverse 2nd half
	node prev = null;
	node curr = midnode;
	node next;
	while(curr!=null) {
		next = curr.next;
		curr.next =prev;
		curr.next = prev;
		prev = curr;
		curr = next;
		
	}
	node right = prev;//right half head
	node left = head;
	
	// step 3 check left half & right half
	while(right !=null) {
		if(left.data != right.data) {
			return false;
		}
		
		left = left.next;
		right = right.next;
		
		
	}
	return true;
}

public static boolean iscycle() {
	node slow = head;
	node fast = head;
	while(fast!=null&&fast.next!=null) {
		slow = slow.next;
		fast = fast.next.next;
		if(slow==fast) {
			return true;
			
		}
	}
	return false;
}


public static void remove_a_cycle() {
	
	// detect the cycle
	node slow = head;
	node fast = head;
	boolean cycle = false;
	
	while(fast!=null&&fast.next!=null) {
		slow = slow.next;
		fast = fast.next.next;
		if(slow==fast) {
			cycle = true;
			break;
			
	}
}
	if(cycle == false) {
		return;
	}
	
	// find meeting point
	slow = head;
	node prev = null;
	while(slow!=fast) {
		prev = fast;
		slow = slow.next;
		fast = fast.next;
		prev.next=null;
		
	}
	
	}







public node mergesort_by_ll(node head) {
	if(head==null||head.next==null) {
		return head;
		
	}
	
	//find mid
	node mid =getmid(head);
	//left &right ms
	node righthead=mid.next;
	mid.next=null;
	node newleft = mergesort_by_ll(head);
	node newright = mergesort_by_ll(righthead);
	//merge
	return merge(newleft,newright);
}


private node getmid(node head) {
	node slow =head;
	node fast = head.next;
	
	while (fast !=null && fast.next!=null) {
		slow = slow.next ; // for +1 
		fast = fast.next.next ; // for +2
		
	}
	return slow;
}

private node merge(node head1,node head2) {
	node mergedll =new node(-1);
	node temp = mergedll ;
	
	while(head1!=null&&head2!=null) {
		if(head1.data<= head2.data) {
			temp.next=head1;
			head1 = head1.next;
			temp = temp.next;
		}
		else {
			temp.next=head2;
			head2 = head2.next;
			temp = temp.next;
		}
		}
		
		while(head1!=null) {
			temp.next =head1;
			head1 =head1.next;
			temp =temp.next;
			
		}
		while(head2!=null) {
			temp.next =head2;
			head2 =head2.next;
			temp =temp.next;
			
		}
		return mergedll.next;
	
}


public void zig_zag() {
	//find mid
	node slow =head;
	node fast = head.next;
	
	while (fast !=null && fast.next!=null) {
		slow = slow.next ; // for +1 
		fast = fast.next.next ; // for +2
		
	}
	node mid= slow;
	
	//reverse 2nd half
	node curr = mid.next;
	mid.next=null;
	node prev =null;
	node next;
	
	while(curr!=null) {
		next = curr.next;
		curr.next =prev;
		prev =curr;
		curr =next;
	}
	
	node left = head;
	node right = prev;
node nextl,nextR;

//alt merge zig zag merge
while(left!=null && right !=null) {
	nextl =left.next;
	left.next=right;
	nextR =right.next;
	right.next = nextl;
	left=nextl;
	right=nextR;
	
	
}

	
}
public static void main (String [] args) {
	linked_list ll = new linked_list();
//	  ll.addfirst(2);
//	  ll.addlast(2);
//	  ll.addfirst(2);
//	  ll.addlast(1);
//	  ll.add_index(2, 23);
//	ll.print();
//	ll.reverse();
//	ll.remove_last();
//	ll.print();
//	ll.delete_Nth_from_END(2);
//	ll.print();
//		System.out.println(ll.check_palendroom());
//	ll.print();
//	System.out.println(ll.remove_first());
//	
	
	
	
//	head = new node(1);
//	head.next = new node(2);
//	head.next.next = new node(3);
//	head.next.next.next = head;
//	System.out.println(iscycle());
	
//	head = new node(1);
//	node temp = new node(2);
//	head.next=temp;
//	head.next.next = new node(3);
//	head.next.next.next = temp;
//	
//	System.out.println(iscycle());
//	remove_a_cycle();
//	System.out.println(iscycle());
//
	
	
	ll.addfirst(1);
	ll.addfirst(2);
	ll.addfirst(3);
	ll.addfirst(4);
	ll.addfirst(5);
	ll.print();
	ll.head =ll.mergesort_by_ll(ll.head);
	ll.print();
}


}
