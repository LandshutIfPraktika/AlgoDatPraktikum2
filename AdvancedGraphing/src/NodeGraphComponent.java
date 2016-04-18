import Parsing.AdjacencyList;
import Parsing.GraphComponent;

import java.util.*;

/**
 * Created by s-gheldd on 4/18/16.
 */
public class NodeGraphComponent {
    private final int id;
    private final Set<Node> nodes;

    NodeGraphComponent(final int n) {
        id = n;
        nodes = new LinkedHashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeGraphComponent that = (NodeGraphComponent) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    NodeGraphComponent(final GraphComponent graphComponent) {
        this(graphComponent.getId());
        final Map<Integer, Node> nodeMap = new HashMap<>();
        for (final AdjacencyList nb : graphComponent.getNodes()) {
            final int vertex = nb.getVertex();
            final Node node = nodeMap.containsKey(vertex) ? nodeMap.get(vertex) : new Node(vertex);

            for (final int nbVertex : nb.getNbs()) {
                final Node nbNode = nodeMap.containsKey(nbVertex) ? nodeMap.get(nbVertex) : new Node(nbVertex);
                node.addNode(nbNode);
                nodeMap.put(nbVertex, nbNode);
            }
            nodeMap.put(vertex, node);
            nodes.add(node);

        }
    }

    public int getId() {
        return id;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "NodeGraphComponent{" +
                "id=" + id +
                ", nodes=" + nodes +
                '}';
    }

    public static ArrayList<NodeGraphComponent> convertToNodeGraph(final List<GraphComponent> graph) {
        final ArrayList<NodeGraphComponent> erg = new ArrayList<>();
        for (final GraphComponent component : graph) {
            erg.add(new NodeGraphComponent(component));
        }
        return erg;
    }
}
