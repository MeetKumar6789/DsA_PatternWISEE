 import java.util.*;

class Solution {
    private int countSoldiers(int[] row) {
        int lo = 0, hi = row.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (row[mid] == 1) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]); // max-heap on count
                }
                return Integer.compare(b[1], a[1]);      // max-heap on index, tiebreak
            }
        );

        for (int i = 0; i < m; i++) {
            pq.add(new int[]{countSoldiers(mat[i]), i});
            if (pq.size() > k) {
                pq.poll(); // evict current strongest
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[1]; // fill back-to-front since heap pops largest first
        }
        return res;
    }
}