public class UnionFind {

    int count;
    int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public int find(int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if(rootp == rootq) {
            return;
        }
        parent[rootp] = rootq;
        count--;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
