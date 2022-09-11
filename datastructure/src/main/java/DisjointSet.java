
public class DisjointSet {
    private int size;
    private int[] parent;

    public DisjointSet(int size) {
        this.size = size;
        parent = new int[size];
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
        parent[xRoot] = yRoot;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
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
