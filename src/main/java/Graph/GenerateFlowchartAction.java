package Graph;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.graphstream.graph.Graph;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import model.State; // Update the import for the State class

public class GenerateFlowchartAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        if (project == null) {
            return;
        }

        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            return;
        }

        try {
            // Parse the XML workflow file to extract the relevant information.
            Map<String, State> states = WorkflowParser.parseXmlWorkflowFile(file);

            // Create a graph representation of the workflow.
            Graph graph = WorkflowGraph.createGraph(states);

            // Render the flowchart as a BufferedImage.
            BufferedImage image = FlowchartRenderer.renderToJpeg(graph);

            // Display the flowchart in a UI element.
            displayFlowchartInTab(project, image);
        } catch (ParserConfigurationException | IOException ex) {
            ex.printStackTrace();
            // Handle parsing and rendering errors appropriately
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle other exceptions
        }
    }

    private void displayFlowchartInTab(Project project, BufferedImage image) {
        // Create a UI element to display the flowchart image
        ImageDialog dialog = new ImageDialog(image);

        // Show the dialog in a tab or as needed in your UI
        dialog.show();
    }
}
