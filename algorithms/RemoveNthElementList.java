
public class RemoveNthElementList {
	
	// data structure
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// iterative (bad version)
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null || n <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && n > 0) {
        	fast = fast.next;
        	n--;
        }
        if (n > 0) {
            return null;
        }
        if (fast == null) {
        	return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
	
	// iterative (good version)
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null || n <= 0 ) { 
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		for (int i = 0; i < n; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		while (head != null) {
			head = head.next;
			prev = prev.next;
		}
		prev.next = prev.next.next;
		return dummy.next;
	}
	
	// unit test
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		ListNode res = removeNthFromEnd(a, 1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
}
