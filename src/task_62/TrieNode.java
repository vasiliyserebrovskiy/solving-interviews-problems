package task_62;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (19.03.2026)
 */
public class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();
    String word = null; // if is a work end

}
