import java.util.*;

class graph {
    int v;
    ArrayList<Integer> adj[];

    graph(int n) {
        v = n;
        adj = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void createGraph(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }

    void display() {
        System.out.println("Adjecency List Representation of Graph: ");
        for (int i = 0; i < v; i++) {
            System.out.println(i + " --> " + adj[i]);
        }
    }

    void degree() {
        System.out.println("Degree of vertices");
        for (int i = 0; i < v; i++) {
            System.out.println("Degree of verex : " + i + " is : " + adj[i].size());
        }
    }

    void BFS(int s) {
        boolean visited[] = new boolean[v];
        int distance[] = new int[v];
        int predecessor[] = new int[v];
        LinkedList<Integer> q = new LinkedList<Integer>();

        // System.out.print("BFS on Graph: ");

        q.add(s);
        visited[s] = true;
        System.out.println();
        while (!q.isEmpty()) {
            s = q.poll();
            // System.out.print(s + " ");
            for (int element : adj[s]) {
                if (visited[element] == false) {
                    visited[element] = true;
                    System.out.println("for element " + element + " predecessor is : " + s);
                    q.add(element);
                    predecessor[element] = s;
                    distance[element] = distance[s] + 1;
                }
            }
        }
        System.out.println();
        System.out.print("Elements:    ");
        for (int i = 0; i < v; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.print("predecessor: ");
        for (int x : predecessor) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("distance:    ");
        for (int x : distance) {
            System.out.print(x + " ");
        }

    }

    public static void main(String args[]) {
        graph g = new graph(6);
        g.createGraph(0, 1);
        g.createGraph(1, 2);
        g.createGraph(2, 3);
        g.createGraph(1, 3);
        g.createGraph(0, 4);
        g.createGraph(4, 5);
        g.createGraph(3, 4);
        g.display();
        g.degree();
        g.BFS(0);
    }
}
