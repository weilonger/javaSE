package main.java.leetcode.compete6;

/*题目描述
    21. 合并两个有序链表
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
*/
/*示例:
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    //13 ms
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l4.next = l1;
                l1 = l1.next;
            } else {
                l4.next = l2;
                l2 = l2.next;
            }
            l4 = l4.next;
        }
        if (l1 == null) {
            l4.next = l2;
        } else if (l2 == null) {
            l4.next = l1;
        }
        return l3.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        ListNode l3 = m.mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
