package Graph;

import com.intellij.openapi.vfs.VirtualFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import model.State;
import model.Transition;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException; // Import SAXException
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkflowParser {

    public static Map<String, State> parseXmlWorkflowFile(VirtualFile file) throws ParserConfigurationException, IOException, SAXException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file.getInputStream());

            Element rootElement = document.getDocumentElement();
            NodeList stateElements = rootElement.getElementsByTagName("state");

            Map<String, State> states = new HashMap<>();
            for (int i = 0; i < stateElements.getLength(); i++) {
                Element stateElement = (Element) stateElements.item(i);
                String stateName = stateElement.getAttribute("name");
                String action = stateElement.getElementsByTagName("action").item(0).getTextContent();

                NodeList transitionElements = stateElement.getElementsByTagName("transition");
                List<Transition> transitions = new ArrayList<>();
                for (int j = 0; j < transitionElements.getLength(); j++) {
                    Element transitionElement = (Element) transitionElements.item(j);
                    String fromStateName = transitionElement.getElementsByTagName("from-state").item(0).getTextContent();
                    String toStateName = transitionElement.getElementsByTagName("to-state").item(0).getTextContent();
                    String eventType = transitionElement.getElementsByTagName("event-type").item(0).getTextContent();

                    Transition transition = new Transition(fromStateName, toStateName, eventType);
                    transitions.add(transition);
                }

                State state = new State(stateName, action, transitions);
                states.put(stateName, state);
            }

            return states;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // Handle exceptions appropriately
            throw e; // Rethrow the exception or handle it as needed
        }
    }
}
