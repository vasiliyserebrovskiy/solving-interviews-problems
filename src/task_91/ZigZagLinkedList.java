package task_91;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (20.04.2026)
 */
public class ZigZagLinkedList {

    public static void rearrange(ListNode head) {
        if (head == null || head.next == null) return;

        // This flag indicates expected relation:
        // true  -> current < next
        // false -> current > next
        boolean expectLess = true;

        ListNode current = head;

        while (current.next != null) {
            if (expectLess) {
                // Expect current < next
                if (current.val > current.next.val) {
                    // Swap values
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
            } else {
                // Expect current > next
                if (current.val < current.next.val) {
                    // Swap values
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
            }

            // Move forward
            current = current.next;

            // Flip expectation
            expectLess = !expectLess;
        }
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        rearrange(head);
        printList(head); // Expected: 1 -> 3 -> 2 -> 5 -> 4 -> null
    }

}
