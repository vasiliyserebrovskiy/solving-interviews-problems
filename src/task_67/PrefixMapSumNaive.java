package task_67;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (25.03.2026)
 */
// Naive solution (simple but inefficient)
public class PrefixMapSumNaive {

    private Map<String, Integer> map = new HashMap<>();

    public void insert(String key, int value) {
        map.put(key, value);
    }

    public int sum(String prefix) {
        int result = 0;

        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                result += map.get(key);
            }
        }

        return result;
    }
}
