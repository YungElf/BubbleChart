package Graph;

import org.graphstream.graph.Graph;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.stream.Source;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.view.GraphRenderer;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlowchartRenderer {

    public static BufferedImage renderToJpeg(Graph graph) throws IOException {
        Viewer viewer = new Viewer() {
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
        viewer.enableAutoLayout();

        // Create a JPanel to display the graph
        JPanel panel = new JPanel(new BorderLayout());
        View view = viewer.addDefaultView(false);
        panel.add((Component) view);

        // Create a JFrame to host the panel
        JFrame frame = new JFrame("Flowchart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);

        // Set the size of the frame (adjust as needed)
        frame.setSize(800, 600);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);

        // Capture the image of the panel
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        panel.paint(graphics);
        graphics.dispose();

        // Close the frame when done
        frame.dispose();

        return image;
    }
}
