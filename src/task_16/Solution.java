package task_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (15.02.2026)
 */
public class Solution {
    private Map<Integer, Integer> frequencyMap = new HashMap<>();
    private int maxFrequency = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                result.add(entry.getKey());
            }
        }

        // convert List<Integer> to int[]
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        int currentSum = node.val + leftSum + rightSum;

        int newFrequency = frequencyMap.getOrDefault(currentSum, 0) + 1;
        frequencyMap.put(currentSum, newFrequency);

        maxFrequency = Math.max(maxFrequency, newFrequency);

        return currentSum;
    }
}
