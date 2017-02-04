import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BensCalulator extends Applet implements ActionListener {

  private TextField xField, yField, rField;

  public void init() {
    setLayout(new GridLayout(0, 2, 4, 4));

    Label xLabel = new Label("first number:");
    Label yLabel = new Label("second number:");
    Label rLabel = new Label("result:");

    xField = new TextField("x");
    yField = new TextField("y");
    rField = new TextField("result");

    Button pButton = new Button("+");
    Button mButton = new Button("-");
    Button tButton = new Button("*");
    Button dButton = new Button("/");
    Button eButton = new Button("^");

    pButton.addActionListener(this);
    mButton.addActionListener(this);
    tButton.addActionListener(this);
    dButton.addActionListener(this);
    eButton.addActionListener(this);

    add(xLabel);
    add(xField);

    add(yLabel);
    add(yField);

    add(rLabel);
    add(rField);

    add(pButton);
    add(mButton);
    add(tButton);
    add(dButton);
    add(eButton);
  }

  @Override public void actionPerformed(ActionEvent e) {
    double xValue = Double.parseDouble(xField.getText());
    double yValue = Double.parseDouble(yField.getText());

    double result = 0;
    switch (((Button) e.getSource()).getLabel()) {
      case "+":
        System.out.println(xValue + yValue);
        result = xValue + yValue;
        break;
      case "-":
        result = xValue - yValue;
        break;
      case "*":
        result = xValue * yValue;
        break;
      case "/":
        result = xValue / yValue;
        break;
      case "^":
        result = Math.pow(xValue, yValue);
        break;
      default:
        return;
    }

    rField.setText(Double.toString(result));
  }
}
