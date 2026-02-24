package task_32;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (23.02.2026)
 */
public class Task32App {
    public static void main(String[] args) {

        Map<String, Object> input = new LinkedHashMap<>();

        Map<String, Object> foo = new HashMap<>();
        foo.put("a", 5);

        Map<String, Object> bar = new HashMap<>();
        bar.put("baz", 8);

        foo.put("bar", bar);

        input.put("key", 3);
        input.put("foo", foo);

        Map<String, Object> flattened = FlattenDictionary.flatten(input);

        System.out.println(flattened);
    }

}

