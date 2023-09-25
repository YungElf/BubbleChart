package Graph;

import com.intellij.openapi.project.Project;
import org.graphstream.graph.Graph;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.stream.Source;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.layout.Layout;
import org.graphstream.ui.layout.springbox.implementations.LinLog;
import org.graphstream.ui.view.GraphRenderer;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

public class FlowchartLayout {

    public static void generateLayout(Graph graph, Project project) {
        // Create a viewer for the graph
        Viewer viewer;
        viewer = new Viewer() {
            @Override
            public String getDefaultID() {
                return null;
            }

            @Override
            public void init(GraphicGraph graph, ProxyPipe ppipe, Source source) {

            }

            @Override
            public void close() {

            }

            @Override
            public GraphRenderer<?, ?> newDefaultGraphRenderer() {
                return null;
            }
        };

        // Set up the layout algorithm (e.g., LinLog)
        Layout layout = new LinLog();
        viewer.enableAutoLayout(layout);

        // Add a viewer listener to handle events (you can leave it empty)
        viewer.addDefaultView(false).setMouseManager(null);

        // Start the viewer
        viewer.enableAutoLayout();

        // Wait for the viewer to close (or handle it in your UI)
        ViewerPipe viewerPipe = viewer.newViewerPipe();
        viewerPipe.addAttributeSink(graph);
        viewerPipe.pump();
    }
}
