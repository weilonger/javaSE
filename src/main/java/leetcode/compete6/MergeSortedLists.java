package main.java.leetcode.compete6;

/*题目描述
    23. 合并K个排序链表
    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
/*示例:
    输入:
        [
          1->4->5,
          1->3->4,
          2->6
        ]
    输出: 1->1->2->3->4->4->5->6
 */
public class MergeSortedLists {
    //193ms
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode mergeList = new ListNode(0);
        ListNode temp = mergeList;
        ListNode ln = null;
        if (len == 0) {
            return temp.next;
        }
        for (int i = 0; i < len; i++) {
            ln = mergeTwoLists(ln, lists[i]);
        }
        temp.next= ln;
        return mergeList.next;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        MergeSortedLists m = new MergeSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{l1,l2,l3};
        ListNode result = m.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
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
