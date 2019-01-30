package main.java.leetcode.compete7;

/*题目描述
    25. k个一组翻转链表
    给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
*/
/*示例 :
    给定这个链表：1->2->3->4->5
    当 k = 2 时，应当返回: 2->1->4->3->5
    当 k = 3 时，应当返回: 3->2->1->4->5
*/
/*
说明:
    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*/
public class ReverseNodesInGroup {
    //7ms
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode check = head;
        int i = 0;
        int j = 0;
        //先判断当前是否满足k个值得队列
        while (check != null && i < k) {
            check = check.next;
            i++;
        }
        if (i == k) {
            while (j < k && cur != null) {
                /*
                    大致逻辑：next链表首节点为下一次翻转的节点，前边的节点为已翻转的节点，现将当前链表首节点取出来，然后将已翻转的节点pre接到当前节点的下一个节点
                    拼接之后的节点为已翻转节点，赋值给pre，最后将节点位置后移一位，也就是将next赋给当前链表
                 */
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                j++;
            }
            //如果链表还存在下一位，递归后边链表。
            if (cur != null) {
                head.next = reverseKGroup(cur, k);
            }
            return pre;
        }
        return head;
    }

    //理解错题意，将前k个值倒序
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode l  = new ListNode(0);
        l.next = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode check = head;
        int i = 0;
        int j = 0;
        while (check != null && j < k) {
            check = check.next;
            j++;
        }
        if (check != null) {
            if (head != null && i == 0) {
                pre = head;
            } else {
                return head;
            }
            while (cur.next != null && i < k - 1) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre;
                pre = temp;
                i++;
            }
            return pre;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseNodesInGroup r = new ReverseNodesInGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 3;
        ListNode result = r.reverseKGroup1(head, k);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
