package task_32;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.02.2026)
 */
public class FlattenDictionary {
    public static Map<String, Object> flatten(Map<String, Object> input) {
        Map<String, Object> result = new LinkedHashMap<>();
        flattenHelper(input, "", result);
        return result;
    }

    private static void flattenHelper(Map<String, Object> current,
                                      String prefix,
                                      Map<String, Object> result) {

        for (Map.Entry<String, Object> entry : current.entrySet()) {

            String newKey = prefix.isEmpty()
                    ? entry.getKey()
                    : prefix + "." + entry.getKey();

            if (entry.getValue() instanceof Map) {
                flattenHelper((Map<String, Object>) entry.getValue(),
                        newKey,
                        result);
            } else {
                result.put(newKey, entry.getValue());
            }
        }
    }
}
