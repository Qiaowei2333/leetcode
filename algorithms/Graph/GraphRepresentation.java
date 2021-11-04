import java.util.*;
public class GraphRepresentation {
    // Graph representation https://users.monash.edu/~lloyd/tildeAlgDS/Graph/

    // use array of edges to build directed graph
    // lc 207 course schedule
    public static void buildDirectedGraphAdjacentList(int[][] edges, int n) {
        /////////////////////////////用 adjacent list来表示有向图和无向图
        // 如果知道vertex是数字（1 - n）， 可以利用 List<List<Integer>> graph
        // o/w 可以利用 Map<Node, List<Node>>

        // 假设是0，n-1, 一共n个点
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // 不管是List<List<Integer>>, 还是 Map<Integer, List<Integer>>
                                          // 都要先initialize graph里面的每个结点，之后再根据结点往里面加adjacent nodes
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            graph.get(s).add(e);
            // indegree[e]++;    // 假如要计算入度
        }
    }

    // use edges to build undirected graph
    // lc 323 无向图里面几个联通快
    public static void buildUndirectedGraphAdjacentList(int[][] edges) {
        // use a List to represent graph
        // 前面和 构造有向图一模一样，唯一不同是

        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            graph.get(s).add(e);
            graph.get(e).add(s); // 无向图，start -> end， end -> start 互相都为邻接点
        }
    }
    ///////////////////////////////////////////////////////////////



    ////////////以下两个和上面一样，区别就是用adjacent matrix来表示有向图和无向图
    // use edges to build directed graph, input是0到n - 1一个n个nodes， 和edges
    public static void buildDirectedGraphAdjacentMatrix(int[][] edges, int n) {
        int[][] matrix = new int[n][n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = 1;
        }
    }

    // use edges to build undirected graph, input是0到n - 1一个n个nodes， 和edges
    public static void buildUndirectedGraphAdjacentMatrix(int[][] edges, int n) {
        int[][] matrix = new int[n][n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
    }
    ///////////////////////////////////////////////////////////////////


    
    ///////////////构建directed weighted graph用adjacent list
    // edges = [[2,1,1],[2,3,1],[3,4,1]]
    // 2 --> 1  weight = 1
    // 2 --> 3  weight = 1
    // 3 --> 4  weight = 1
    public static void buildDirectedWeightedGraphAdjacentList(int[][] edges, int n) {
        List<List<int[]>> graph = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            graph.get(start).add(new int[]{end, weight});
        }
    }

    public static void buildUndirectedWeightedGraphAdjacentList(int[][] edges, int n) {
        List<List<int[]>> graph = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            graph.get(start).add(new int[]{end, weight});
            graph.get(end).add(new int[]{start, weight});
        }
    }
    /////////////////////////////////////


    ///////////用adjacent matrix来构建directed weighted graph
    public static void buildDirectedWeightedGraphAdjacentMatrix(int[][] edges, int n) {
        int[][] graph = new int[n + 1][n + 1];

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            graph[start][end] = weight;
        }
    }
}
