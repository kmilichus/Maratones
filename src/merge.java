
public class merge {

	public static void main(String[] args) {
		
//		12 -> 22 -> 27
		ListNode a = new ListNode(12);
		a.next = new ListNode(22);
		a.next.next = new ListNode(27);
		
//		7 -> 12 -> 46
		ListNode b = new ListNode(7);
		b.next = new ListNode(12);
		b.next.next = new ListNode(46);
		
		
		ListNode nueva = mergeTwoLists(a, b);
		
		while (nueva.next !=null) {
			System.out.print(nueva.val+ " --> ");
			nueva = nueva.next;
		}
		System.out.print(nueva.val+ " --> ");
		System.out.println();

	}


	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public static ListNode mergeTwoLists(ListNode a, ListNode b) {


		ListNode current = new ListNode(0);
		ListNode first = current;
		
		
		while (a!=null && b!=null){

			if(a.val <= b.val){
				current.next = new ListNode(a.val);
				a = a.next;

			}else {
				current.next = new ListNode(b.val);
				b = b.next;

			}
			current = current.next;

		}

		if(a==null){
			current.next = b;
		}else {
			current.next = a;
		}

		first = first.next;

		return first;

	}


}
