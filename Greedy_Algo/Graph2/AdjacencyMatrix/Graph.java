import java.util.ArrayList;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;
    public Graph( ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }
    public void addUndirectedEdge(int i, int j){
        this.adjacencyMatrix[i][j] = 1;
        this.adjacencyMatrix[j][i] = 1;
    }

    public void printGraph() {
        System.out.print("   ");
        for (int i = 0; i < this.nodeList.size(); i++) {
            System.out.print(nodeList.get(i).name + " ");
        }
        System.out.println();
        for (int i = 0; i < this.nodeList.size(); i++) {
            System.out.print(nodeList.get(i).name + ": ");
            for (int j = 0; j < this.adjanceyMatrix[i].length; j++) {
                System.out.print(this.adjanceyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
