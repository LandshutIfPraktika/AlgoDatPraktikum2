import Parsing.Quickunionizer;

import java.util.ArrayList;

/**
 * Created by s-gheldd on 4/17/16.
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            final ArrayList<NodeGraphComponent> graph = NodeGraphComponent.convertToNodeGraph(Quickunionizer.findGraphComponents("data//Net" + i + ".txt"));

            final GraphJoiner joiner = new GraphJoiner(graph);

            joiner.printGraphJoins();
            System.out.println("\n");
        }

    }
}
