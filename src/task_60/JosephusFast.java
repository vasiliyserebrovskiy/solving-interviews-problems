package task_60;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (18.03.2026)
 */
public class JosephusFast {

    public static int findSurvivorK2(int n) {
        int highestPowerOf2 = Integer.highestOneBit(n);
        int l = n - highestPowerOf2;
        return 2 * l + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(findSurvivorK2(n)); // 3
    }

}
