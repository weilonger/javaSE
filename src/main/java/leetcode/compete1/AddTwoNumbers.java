package main.java.leetcode.compete1;

/*题目描述
    2.两数之和
    给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
    如果我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字0之外，这两个数都不会以0开头。
 */
/*示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode l = list;
        int plus = 0;
        if (p == null && q != null) {
            return q;
        }
        if (q == null && p != null) {
            return p;
        }
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + plus;
            plus = sum / 10;
            l.next = new ListNode(sum % 10);
            l = l.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        //最后一位是进位时
        if (plus > 0) {
            l.next = new ListNode(plus);
        }
        return list.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l = a.addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}

