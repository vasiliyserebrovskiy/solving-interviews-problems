package task_14;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (13.02.2026)
 */
// O(n log n)
public class LineIntersectionsOptimal {

    public static int countIntersections(int[] q) {
        return mergeSortAndCount(q, 0, q.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int count = 0;

        count += mergeSortAndCount(arr, left, mid);
        count += mergeSortAndCount(arr, mid + 1, right);
        count += merge(arr, left, mid, right);

        return count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int swaps = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                swaps += (mid - i + 1); // counting inversions
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);

        return swaps;
    }

    public static void main(String[] args) {
        int[] q = {4, 3, 2, 1};

        System.out.println(countIntersections(q)); // 6
    }
}
