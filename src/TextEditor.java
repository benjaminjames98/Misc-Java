import javax.swing.*;
import java.awt.*;

/**
 * Created by Benjamin on 06/02/2017.
 */
public class TextEditor {

  JTextPane textPane = new JTextPane();

  public TextEditor() {
    SwingUtilities.invokeLater(() -> {
      // JTextPane
      textPane.setEditable(true);
      textPane.setPreferredSize(new Dimension(500, 500));

      // JMenu
      JMenuItem newItem = new JMenuItem("New");

      JMenuItem saveAsItem = new JMenuItem("Save");
      JMenuItem loadItem = new JMenuItem("load");
      JMenu fileMenu = new JMenu("File");
      fileMenu.add(newItem);
      fileMenu.add(saveAsItem);
      fileMenu.add(loadItem);
      JMenuBar menuBar = new JMenuBar();
      menuBar.add(fileMenu);

      // Frame
      JFrame frame = new JFrame("Text Editor");
      frame.add(textPane);
      frame.setJMenuBar(menuBar);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }

  public static void main(String[] args) {
    new TextEditor();
  }
}
