package work.letcode;

/**
 * @author zhailzh
 * 
 * @Date 2015��11��13��������2:41:50
 * 
 * Tags��LinkedList,level1
 * 
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers num = new AddTwoNumbers();
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(8);
		l1.next.next = new ListNode(9);
		System.out.println(l1.toString());

		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		System.out.println(l2.toString());
		ListNode l3 = num.addTwoNumbers(l1, l2);
		System.out.println(l3);

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 != null && l2 != null) {
			int flag = 0;
			int value = l1.val + l2.val;
			int numc = value%10; 
			ListNode sum = new ListNode(numc);
			flag = value/10;
			ListNode temp = sum;

			while (l1.next != null && l2.next != null) {
				//ȫֵ
				int tv = l1.next.val + l2.next.val + flag;
				flag = tv/10;
				int num =tv%10;
				flag = tv/10;
				ListNode node = new ListNode(num);
				temp.next = node;
				temp = node;
				l1 = l1.next;
				l2 = l2.next;
			}

			if (l1.next != null) {
				while (l1.next != null) {
					int tv = l1.next.val + flag;
					int num =tv%10;
					flag = tv/10;
					ListNode node = new ListNode(num);
					temp.next = node;
					temp = node;
					l1 = l1.next;
					if(flag == 0){
						temp = l1.next;
						break;
					}
				}
			}

			if (l2.next != null) {
				while (l2.next != null) {
					int tv = l2.next.val + flag;
					int num =tv%10;
					flag = tv/10;
					ListNode node = new ListNode(num);
					temp.next = node;
					temp = node;
					l2 = l2.next;
					if(flag == 0){
						temp = l2.next;
						break;
					}
				}
			}

			if (l2.next == null && l1.next == null && flag != 0) {
				ListNode node = new ListNode(flag);
				temp.next = node;
				temp = node;
			}

			return sum;
		}
		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		String value  = val+"";
		ListNode temp = next;
		while (temp != null) {
			value  = value +" "+ temp.val;
			temp = temp.next;
		}
		return value;
	}
}
