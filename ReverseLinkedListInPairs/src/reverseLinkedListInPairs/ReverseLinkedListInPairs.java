package reverseLinkedListInPairs;

// Reverse pairs of elements in a singly-linked list.

public class ReverseLinkedListInPairs {

	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// head != null && head.next != null
		ListNode next = head.next;
		ListNode newHead = reverseInPairs(next.next);
		head.next = newHead;
		next.next = head;
		return next;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack.
}
