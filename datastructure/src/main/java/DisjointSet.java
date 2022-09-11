
public class DisjointSet {
    private int size;
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        this.size = size;
        parent = new int[size];
        rank = new int[size];
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            // In the same set already, do nothing
            return;
        }

        // Union by rank, ruled by higher rank.
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[xRoot] = yRoot;
            rank[yRoot]++;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        // Path compression
        int root = find(parent[x]);
        // Make each node point to its root
        parent[x] = root;
        return root;
    }

    public static void main(String[] args) {
        DisjointSet dset = new DisjointSet(5);
        dset.union(0, 2);
        dset.union(4, 2);
        dset.union(1, 3);

        System.out.println("True: " + (dset.find(4) == dset.find(0)));
        System.out.println("False: " + (dset.find(1) == dset.find(0)));
    }
}
