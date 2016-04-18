import java.util.*;

/**
 * Created by s-gheldd on 4/17/16.
 */
public class GraphAnalyzer {

    final private ArrayList<NodeGraphComponent> graph;
    final private HashMap<NodeGraphComponent, Node> centerMap;
    final private HashMap<Node, Integer> maxDistancesMap;

    GraphAnalyzer(final ArrayList<NodeGraphComponent> graph) {
        this.graph = new ArrayList<NodeGraphComponent>(graph);
        centerMap = new HashMap<>();
        maxDistancesMap = new HashMap<>();
    }

    public HashMap<NodeGraphComponent, Node> findGraphCenters() {
        if (centerMap.isEmpty()) {
            for (final NodeGraphComponent graphComponent : graph) {
                centerMap.put(graphComponent, findCentre(graphComponent));
            }
        }
        return centerMap;
    }

    private Node findCentre(final NodeGraphComponent graphComponent) {
        int minMaxDistance = Integer.MAX_VALUE;
        Node minMaxNode = null;

        for (final Node node : graphComponent.getNodes()) {
            int maxDistance = getMaxDistance(node);
            if (maxDistance < minMaxDistance) {
                minMaxDistance = maxDistance;
                minMaxNode = node;
            }
        }
        return minMaxNode;
    }

    public int getMaxDistance(final Node node) {
        if (maxDistancesMap.containsKey(node)) {
            return maxDistancesMap.get(node);
        } else {
            final Map<Node, Integer> distances = new HashMap<>();
            final Queue<Node> nodeQueue = new LinkedList<>();
            distances.put(node, 0);
            nodeQueue.add(node);
            int maxDistance = 0;

            while (!nodeQueue.isEmpty()) {
                final Node currentNode = nodeQueue.poll();
                final int currentDistance = distances.get(currentNode) + 1;
                for (final Node neighbour : currentNode.getNeighbours()) {
                    if (!distances.containsKey(neighbour)) {
                        distances.put(neighbour, currentDistance);
                        nodeQueue.add(neighbour);
                        maxDistance = currentDistance;
                    }
                }
            }
            maxDistancesMap.put(node, maxDistance);
            return maxDistance;
        }
    }


}
