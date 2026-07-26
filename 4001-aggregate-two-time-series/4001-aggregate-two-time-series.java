 class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<Integer> timestamps = new ArrayList<>();
        int i = 0, j = 0;
        while (i < series1.length && j < series2.length) {
            int t1 = series1[i][0], t2 = series2[j][0];
            if (t1 < t2) { timestamps.add(t1); i++; }
            else if (t2 < t1) { timestamps.add(t2); j++; }
            else { timestamps.add(t1); i++; j++; }
        }
        while (i < series1.length) timestamps.add(series1[i++][0]);
        while (j < series2.length) timestamps.add(series2[j++][0]);
        
        int m = timestamps.size();
        long[] vals = new long[m];
        int p1 = series1.length - 1, p2 = series2.length - 1;
        long nextVal1 = 0, nextVal2 = 0;
        
        for (int k = m - 1; k >= 0; k--) {
            int t = timestamps.get(k);
            long v1;
            if (p1 >= 0 && series1[p1][0] == t) { v1 = series1[p1][1]; nextVal1 = v1; p1--; }
            else v1 = nextVal1;
            
            long v2;
            if (p2 >= 0 && series2[p2][0] == t) { v2 = series2[p2][1]; nextVal2 = v2; p2--; }
            else v2 = nextVal2;
            
            vals[k] = v1 + v2;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            result.add(Arrays.asList(timestamps.get(k), (int) vals[k]));
        }
        return result;
    }
}