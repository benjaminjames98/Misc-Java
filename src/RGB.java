import java.awt.*;
import java.applet.Applet;

public class RGB extends Applet {

  public void paint(Graphics g) {
    // Says 'Hello' to Ben.
    g.drawString("Hello BobCat98, I need to practice my maths :/", 10, 10);

    // Triangle RedFilled
    g.setColor(Color.red);
    int xRedpoints[] = {50, 75, 100};
    int yRedpoints[] = {93, 50, 93};
    int nRedpoints = 3;

    g.fillPolygon(xRedpoints, yRedpoints, nRedpoints);

    // Triangle GreenFilled
    g.setColor(Color.green);
    int xGreenpoints[] = {150, 175, 200};
    int yGreenpoints[] = {93, 50, 93};
    int nGreenpoints = 3;

    g.fillPolygon(xGreenpoints, yGreenpoints, nGreenpoints);

    // Triangle BlueFilled
    g.setColor(Color.blue);
    int xBluepoints[] = {250, 275, 300};
    int yBluepoints[] = {93, 50, 93};
    int nBluepoints = 3;

    g.fillPolygon(xBluepoints, yBluepoints, nBluepoints);

    // Triangle RedOutline
    g.setColor(Color.red);
    g.drawLine(50, 243, 75, 200);
    g.drawLine(100, 243, 75, 200);
    g.drawLine(100, 243, 50, 243);

    // Triangle GreenOutline
    g.setColor(Color.green);
    g.drawLine(150, 243, 175, 200);
    g.drawLine(200, 243, 175, 200);
    g.drawLine(200, 243, 150, 243);

    // Triangle BlueOutline
    g.setColor(Color.blue);

    g.drawLine(250, 243, 275, 200);
    g.drawLine(300, 243, 275, 200);
    g.drawLine(300, 243, 250, 243);
  }
}