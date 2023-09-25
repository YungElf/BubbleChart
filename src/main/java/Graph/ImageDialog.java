package Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageDialog extends JDialog {

    public ImageDialog(BufferedImage image) {
        setTitle("Flowchart");
        setSize(800, 600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel(new ImageIcon(image));
        getContentPane().add(label, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    public void show() {
        setVisible(true);
    }
}
