package task_35;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (24.02.2026)
 */
public class Event {

    int timestamp;
    int count;
    String type;

    Event(int timestamp, int count, String type) {
        this.timestamp = timestamp;
        this.count = count;
        this.type = type;
    }

}
