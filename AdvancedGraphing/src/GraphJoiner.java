import java.util.ArrayList;
import java.util.Map;

/**
 * Created by s-gheldd on 4/18/16.
 */
public class GraphJoiner {
    private final ArrayList<NodeGraphComponent> graph;
    private final GraphAnalyzer analyzer;

    public GraphJoiner(ArrayList<NodeGraphComponent> graph) {
        this.graph = graph;
        this.analyzer = new GraphAnalyzer(graph);
    }

    public void printGraphJoins() {
        final StringBuilder builder = new StringBuilder();
        final Map<NodeGraphComponent, Node> centers = analyzer.findGraphCenters();
        Node centreVertex = null;
        int maxLength = Integer.MIN_VALUE;
        int secondMaxLength = Integer.MIN_VALUE;
        for (final Node node : centers.values()) {
            int length = analyzer.getMaxDistance(node);
            if (length >= maxLength) {
                secondMaxLength = maxLength;
                maxLength = length;
                if (length > secondMaxLength || centreVertex.getVertex() > node.getVertex()) {
                    centreVertex = node;
                }
            }
        }
        builder.append("List of new edges:\n");
        for (final Node node : centers.values()) {
            if (node != centreVertex) {
                builder.append("(").append(centreVertex.getVertex()).append(",").append(node.getVertex()).append(") ");
            }
        }
        builder.append("\nFinal center vertex: ").append(centreVertex.getVertex()).append("\n");
        builder.append("MinMax path length: ").append(maxLength == secondMaxLength ? maxLength + 1 : maxLength);
        System.out.println(builder.toString());

    }
}
