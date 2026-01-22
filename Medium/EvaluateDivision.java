class Solution {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, values[i]);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                res[i] = -1.0;
            } else {
                res[i] = dfs(a, b, 1.0, new HashSet<>());
            }
        }
        return res;
    }

    double dfs(String cur, String target, double val, Set<String> vis) {
        if (cur.equals(target)) return val;
        vis.add(cur);
        for (Map.Entry<String, Double> e : graph.get(cur).entrySet()) {
            if (!vis.contains(e.getKey())) {
                double res = dfs(e.getKey(), target, val * e.getValue(), vis);
                if (res != -1.0) return res;
            }
        }
        return -1.0;
    }
}
