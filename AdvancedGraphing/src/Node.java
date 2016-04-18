import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by s-gheldd on 4/18/16.
 */
public class Node {
    final private int vertex;
    final private Set<Node> neighbours;

    public Node(int vertex) {
        this.vertex = vertex;
        neighbours = new LinkedHashSet<>();
    }

    public int getVertex() {
        return vertex;
    }

    public Set<Node> getNeighbours() {
        return neighbours;
    }

    public void addNode(final Node node) {
        neighbours.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                ", neighbours=" + neighbourVertexString() +
                '}';
    }

    private String neighbourVertexString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[");
        int i = 0;
        for (final  Node node : neighbours) {
            builder.append(node.getVertex());
            if (i < neighbours.size()-1) {
                builder.append(",");
            }
            i++;
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return vertex == node.vertex;

    }

    @Override
    public int hashCode() {
        return vertex;
    }
}
