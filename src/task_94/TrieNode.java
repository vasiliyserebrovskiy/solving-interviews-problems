package task_94;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (21.04.2026)
 */
public class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;

}
