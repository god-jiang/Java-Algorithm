public class Leetcode134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                if (i == j)
                    return i;
            }
        }
        return -1;
    }
}
