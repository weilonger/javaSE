package main.java.leetcode.compete6;

/*题目描述
    24. 两两交换链表中的节点
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
*/
/*示例:
    给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
/*
说明:
    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*/
public class SwapNodesInParids {
    //5 ms 改变节点内部的值
    public ListNode swapPairs(ListNode head) {
        ListNode l = new ListNode(0);
        l.next = head;
        ListNode s = head;
        int i = 0;
        while (s != null) {
            if (s.next != null) {
                Integer temp = s.val;
                s.val = s.next.val;
                s.next.val = temp;
                s = s.next.next;
                i += 2;
            } else {
                s = s.next;
                i++;
            }
        }
        return l.next;
    }

    //3ms 交换节点位置
    public ListNode swapPairs1(ListNode head) {
        ListNode l = new ListNode(0);
        l.next = head;
        ListNode s = l;
        while (s.next != null) {
            ListNode temp = s.next;
            //奇数点个数不交换
            if (temp.next == null) {
                return l.next;
            }
            //开始交换
            s.next = temp.next;
            temp.next = s.next.next;
            s.next.next = temp;
            s = temp;
        }
        return l.next;
    }

    public static void main(String[] args) {
        SwapNodesInParids s = new SwapNodesInParids();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(6);
        ListNode result = s.swapPairs1(l1);
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
