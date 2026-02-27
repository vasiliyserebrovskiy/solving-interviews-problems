package task_41;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (27.02.2026)
 */
public class PartitionLinkedList {
    // Class for Node
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    // The partition method
    public static ListNode partition(ListNode head, int k) {

        ListNode lessHead = null;
        ListNode lessTail = null;

        ListNode greaterHead = null;
        ListNode greaterTail = null;

        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;  // save link
            current.next = null;           // detaching the node

            if (current.value < k) {
                if (lessHead == null) {
                    lessHead = current;
                    lessTail = current;
                } else {
                    lessTail.next = current;
                    lessTail = current;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = current;
                    greaterTail = current;
                } else {
                    greaterTail.next = current;
                    greaterTail = current;
                }
            }

            current = next;
        }

        // If we did not have any elements < k
        if (lessHead == null) {
            return greaterHead;
        }

        // Merge two lists
        lessTail.next = greaterHead;

        return lessHead;
    }

    // Method for printing LinkedList
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Test solution
    public static void main(String[] args) {

        // 5 -> 1 -> 8 -> 0 -> 3
        ListNode head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(3);

        int k = 3;

        System.out.println("Before:");
        printList(head);

        head = partition(head, k);

        System.out.println("After (partition around " + k + "):");
        printList(head);
    }
}
