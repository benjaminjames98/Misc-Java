import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class LabelButton extends Applet implements ActionListener {

  // Declare
  Button button;
  Label label;
  String string;
  Integer v;

  // Initialise
  public void init() {
    button = new Button("Click");
    add(button);
    button.addActionListener(this);

    v = new Integer(0);

    label = new Label("Label");
    add(label);
    label.setVisible(true);

    string = new String("--");
  }

  // Event Listener - checks for button click
  // First button click does nothing
  public void actionPerformed(ActionEvent e) {
    // delete first slash on following line to switch between each implementation
    //*

    //e.getSource() returns an object, therefore .equals should be used as opposed to ==
    if (!e.getSource().equals(button)) {
      return;
    }

    // This makes the logic dependent on the actual button's state, and so that state could be changed by other
    // components (i.e. another button) and this code would still work fine.
    boolean visible = !label.isVisible();
    label.setVisible(visible);

    // See ternary expression
    // value = condition ? trueResult : falseResult;
    string = visible ? "label visible" : "label invisible";
    System.out.println(string);

    // Will have to call this no matter what, and so it is better to call it at the very end and outside of any
    // control expressions, as opposed to twice within control expressions.
    repaint();

    /*/

    // Show Label on click
    if (v == 0 && e.getSource() == button) {
      label.setVisible(true);
      v = new Integer(1);
      System.out.println("Label showing");
      string = new String("Label added");
      repaint();
    } else {
      // Hide Label on click
      if (v == 1 && e.getSource() == button) {
        v = new Integer(0);
        label.setVisible(false);
        System.out.println("Label hidden" + v);
        string = new String("Label removed");
        repaint();
      }
    }

    //*/
  }

  // Draw label added / label removed string
  public void paint(Graphics g) {
    g.drawString(string, 10, 10);
  }
}