package Graph;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import model.State;
import model.Transition;

import java.util.Map;

public class WorkflowGraph {

    public static Graph createGraph(Map<String, State> states) {
        Graph graph = new SingleGraph("WorkflowFlowchart");

        for (State state : states.values()) {
            // Create a node for each state
            org.graphstream.graph.Node node = graph.addNode(state.getName());
            node.setAttribute("label", state.getName() + "\nAction: " + state.getAction());

            // Add edges for transitions
            for (Transition transition : state.getTransitions()) {
                org.graphstream.graph.Node targetNode = graph.getNode(transition.getToStateName());
                graph.addEdge(state.getName() + "_" + transition.getToStateName(), node, targetNode, true)
                        .setAttribute("label", transition.getEventType());
            }
        }

        return graph;
    }
}
