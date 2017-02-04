import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Applet implements ActionListener {

  // Declare variables
  private Integer c, x, y, answer, count;

  private TextField numField1, numField2, answerField;

  private Label numLabel1, numLabel2, answerLabel;

  private String sign, num1, num2;

  private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonPower;

  // Initialise Variables
  public void init() {

    x = new Integer(0);
    y = new Integer(0);
    c = new Integer(0);
    answer = new Integer(0);

    // Initialise Text Fields
    numField1 = new TextField("0");
    numField2 = new TextField("0");
    answerField = new TextField("0");

    // Initialise Labels
    numLabel1 = new Label("num1");
    numLabel2 = new Label("num2");
    answerLabel = new Label("Answer:");

    // Initialise Strings
    sign = new String("+");
    num1 = new String(String.valueOf(x));
    num1 = new String(String.valueOf(y));

    // Initialise Buttons
    buttonAdd = new Button("+");
    buttonSubtract = new Button("-");
    buttonMultiply = new Button("*");
    buttonDivide = new Button("/");
    buttonPower = new Button("^");

    // Diasble layout manager
    setLayout(null);

    add(numLabel1);
    numLabel1.setLocation(15, 15);
    validate();
    numLabel1.setSize(40, 20);

    // Add Components to Applet, setting their positions.
    add(numLabel2);
    numLabel2.setLocation(100, 15);
    numLabel2.setSize(40, 20);

    add(answerLabel);
    answerLabel.setLocation(185, 15);
    answerLabel.setSize(60, 20);

    add(numField1);
    numField1.setLocation(10, 40);
    numField1.setSize(50, 25);

    add(numField2);
    numField2.setLocation(95, 40);
    numField2.setSize(50, 25);

    answerField.setEditable(false);
    add(answerField);
    answerField.setLocation(180, 40);
    answerField.setSize(75, 25);

    add(buttonAdd);
    buttonAdd.addActionListener(this);
    buttonAdd.setLocation(80, 85);
    buttonAdd.setSize(25, 25);

    add(buttonSubtract);
    buttonSubtract.addActionListener(this);
    buttonSubtract.setLocation(115, 85);
    buttonSubtract.setSize(25, 25);

    add(buttonMultiply);
    buttonMultiply.addActionListener(this);
    buttonMultiply.setLocation(150, 85);
    buttonMultiply.setSize(25, 25);

    add(buttonDivide);
    buttonDivide.addActionListener(this);
    buttonDivide.setLocation(185, 85);
    buttonDivide.setSize(25, 25);

    add(buttonPower);
    buttonPower.addActionListener(this);
    buttonPower.setLocation(220, 85);
    buttonPower.setSize(25, 25);

    //Everything Loaded
    System.out.println("Started");
  }

  //Calculator mechanics
  //Unable to handle non real numbers
  public void actionPerformed(ActionEvent e) {

    // Get user inputs
    num1 = numField1.getText();
    num2 = numField2.getText();
    x = Integer.parseInt(num1);
    y = Integer.parseInt(num2);

    //If sign = +
    if (e.getSource() == buttonAdd) {
      answer = (x + y);
      sign = ("+");
      System.out.println("Add");
    }

    //If sign = -
    if (e.getSource() == buttonSubtract) {
      answer = (x - y);
      sign = ("-");
      System.out.println("Subtract");
    }

    //If sign = *
    if (e.getSource() == buttonMultiply) {
      answer = (x * y);
      sign = ("*");
      System.out.println("Multiply");
    }

    //If sign = /
    if (e.getSource() == buttonDivide) {
      answer = (x / y);
      sign = ("/");
      System.out.println("Divide");
    }

    //If sign = ^
    if (e.getSource() == buttonPower) {

      c = y;
      y = x;

      for (count = 0; count < c - 1; count++) {
        x = (x * y);
      }
      answer = x;
      sign = ("^");
      System.out.println("Power");
    }

    // Displays answer in answerField
    answerField.setText("" + answer);
    System.out.println(answer);
    repaint();
  }

  // Position + / - / * / (/) / ^ / =
  // Could also use labels for signs, but decided to use Graphics object
  public void paint(Graphics g) {
    g.drawString(sign, 75, 55);
    g.drawString("=", 120, 55);
    g.drawString("Calculator", 120, 10);
    g.drawString("Function:", 15, 100);
  }
}