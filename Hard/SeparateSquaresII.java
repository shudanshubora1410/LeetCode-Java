import java.util.*;

class Solution {
    static class ST {
        int[] c;
        long[] w;
        int[] x;
        ST(int[] x) {
            this.x = x;
            int n = x.length;
            c = new int[4 * n];
            w = new long[4 * n];
        }
        void u(int i, int l, int r, int ql, int qr, int v) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) c[i] += v;
            else {
                int m = (l + r) >> 1;
                u(i * 2 + 1, l, m, ql, qr, v);
                u(i * 2 + 2, m, r, ql, qr, v);
            }
            if (c[i] > 0) w[i] = x[r] - x[l];
            else if (l + 1 == r) w[i] = 0;
            else w[i] = w[i * 2 + 1] + w[i * 2 + 2];
        }
    }

    public double separateSquares(int[][] s) {
        List<int[]> e = new ArrayList<>();
        TreeSet<Integer> xs = new TreeSet<>();
        for (int[] a : s) {
            e.add(new int[]{a[1], 1, a[0], a[0] + a[2]});
            e.add(new int[]{a[1] + a[2], -1, a[0], a[0] + a[2]});
            xs.add(a[0]);
            xs.add(a[0] + a[2]);
        }
        e.sort(Comparator.comparingInt(a -> a[0]));
        int[] x = xs.stream().mapToInt(i -> i).toArray();
        ST t = new ST(x);

        long A = 0, py = e.get(0)[0];
        for (int[] a : e) {
            long dy = a[0] - py;
            if (dy > 0) A += t.w[0] * dy;
            t.u(0, 0, x.length - 1,
                Arrays.binarySearch(x, a[2]),
                Arrays.binarySearch(x, a[3]), a[1]);
            py = a[0];
        }

        double h = A / 2.0;
        t = new ST(x);
        long cur = 0;
        py = e.get(0)[0];

        for (int[] a : e) {
            long dy = a[0] - py;
            if (dy > 0) {
                long add = t.w[0] * dy;
                if (cur + add >= h)
                    return py + (h - cur) / t.w[0];
                cur += add;
            }
            t.u(0, 0, x.length - 1,
                Arrays.binarySearch(x, a[2]),
                Arrays.binarySearch(x, a[3]), a[1]);
            py = a[0];
        }
        return py;
    }
}
