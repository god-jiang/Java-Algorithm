package leetcode.days;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 *
 * @author god-jiang
 * @date 2020/11/09 21:03
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 默认是大根堆，把它变成小根堆
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < K; i++) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; i++) {
            int temp = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (temp < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{temp, i});
            }
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[pq.poll()[1]];
        }

        return res;
    }
}
