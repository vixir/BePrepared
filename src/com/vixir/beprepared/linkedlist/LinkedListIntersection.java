package com.vixir.beprepared.linkedlist;

public class LinkedListIntersection {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(4);
		ListNode g = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		f.next = g;
		g.next = c;
					  /* a(1)    f(4)      
						   \     /
						  b(2)  g(5)
						     \ /
						     c(3)
						       \
						       d(4)
						         \
						         e(5)
		 */
		System.out.println(intersection(a, f).val);

	}

	public static ListNode intersection(ListNode a, ListNode b) {
		int countA = 0;
		int countB = 0;
		ListNode aTemp = a;
		ListNode bTemp = b;

		if (null == a | null == b) {
			return null;
		}
		
		while (aTemp != null) {
			aTemp = aTemp.next;
			countA++;
		}

		while (bTemp != null) {
			bTemp = bTemp.next;
			countB++;
		}
		
		aTemp = a;
		bTemp = b;
		int dif = Math.abs(countA - countB);
		if (countA > countB) {
			while (dif-- > 0) {
				aTemp = aTemp.next;
			}
		} else {
			while (dif-- > 0) {
				bTemp = bTemp.next;
			}
		}

		while (!aTemp.equals(bTemp)) {
			aTemp = aTemp.next;
			bTemp = bTemp.next;
		}

		return bTemp;
	}

}
