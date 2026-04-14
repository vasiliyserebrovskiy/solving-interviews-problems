package task_86;

import java.util.*;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (14.04.2026)
 */
public class BucketSortExample {

    public static void main(String[] args) {
        int size = 20; // small demo size
        int maxValue = 1_000_000_000;
        int[] arr = new Random().ints(size, 0, maxValue).toArray();

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(arr));

        bucketSort(arr, maxValue, 10);

        System.out.println("\nAfter sorting:");
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr, int maxValue, int bucketCount) {
        // Create buckets
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Calculate bucket size
        int bucketSize = (maxValue + 1) / bucketCount;

        // Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = num / bucketSize;

            // Edge case: max value
            if (bucketIndex >= bucketCount) {
                bucketIndex = bucketCount - 1;
            }

            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Merge buckets back into array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
}
