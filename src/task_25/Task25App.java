package task_25;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.02.2026)
 */
public class Task25App {
    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(5);

        ListNode rotated1 = rotateRight(head1, 2);
        System.out.println(rotated1); // 3 -> 5 -> 7 -> 7

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        ListNode rotated2 = rotateRight(head2, 3);
        System.out.println(rotated2); // 3 -> 4 -> 5 -> 1 -> 2
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Finding the list length
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Bring k to the range [0, n)
        k = k % n;
        if (k == 0) return head;

        // Find a new tail (n - k)th node
        ListNode newTail = head;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }

        // New head — following newTail
        ListNode newHead = newTail.next;

        // Breaking the old connection
        newTail.next = null;

        // 6. Connecting the old tail to the old head
        tail.next = head;

        return newHead;
    }
}
