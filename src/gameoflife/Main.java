package gameoflife;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Instant;

public class Main extends Applet {

  private final int NUM_CELLS = 10;

  private final Color DEAD_COLOR = new Color(0x90A4AE);
  private final Color LIVE_COLOR = new Color(0x4CAF50);

  private final MyAdapter MY_ADAPTER = new MyAdapter(NUM_CELLS, NUM_CELLS);

  private Label[][] labels;

  public void init() {
    setLayout(new GridLayout(0, MY_ADAPTER.getWidth(), 2, 2));

    createLabels();

    Button tickButton = new Button("tick");
    tickButton.addActionListener(e -> tick());
    add(tickButton);

    TickThread ticker = new TickThread();
    new Thread(ticker).start();

    Button startThreadButton = new Button("start");
    startThreadButton.addActionListener(e -> ticker.startRunning());
    add(startThreadButton);

    Button stopThreadButton = new Button("stop");
    stopThreadButton.addActionListener(e -> ticker.stopRunning());
    add(stopThreadButton);

    tick();
  }

  private void createLabels() {
    labels = new Label[MY_ADAPTER.getWidth()][MY_ADAPTER.getLength()];
    for (int x = 0; x < MY_ADAPTER.getWidth(); x++) {
      for (int y = 0; y < MY_ADAPTER.getLength(); y++) {
        labels[x][y] = new Label();
        labels[x][y].setSize(10, 10);
        add(labels[x][y]);

        final int x1 = x;
        final int y1 = y;

        labels[x][y].addMouseListener(new MouseListener() {
          @Override public void mouseClicked(MouseEvent e) {
            MY_ADAPTER.changeValueAt(x1, y1);
            refreshColors();
          }

          @Override public void mousePressed(MouseEvent e) {}

          @Override public void mouseReleased(MouseEvent e) {}

          @Override public void mouseEntered(MouseEvent e) {}

          @Override public void mouseExited(MouseEvent e) {}
        });
      }
    }
  }

  private synchronized void refreshColors() {
    for (int x = 0; x < MY_ADAPTER.getWidth(); x++) {
      for (int y = 0; y < MY_ADAPTER.getLength(); y++) {
        labels[x][y].setBackground(MY_ADAPTER.isLive(x, y) ? LIVE_COLOR : DEAD_COLOR);
      }
    }
  }

  private synchronized void tick() {
    MY_ADAPTER.tick();
    refreshColors();
  }

  private class TickThread implements Runnable {
    final int TICK_INTERVAL = 1;
    private boolean running = false;

    @Override public void run() {
      Instant lastTick = Instant.now();

      while (true) {
        if (Instant.now().isBefore(lastTick.plusSeconds(TICK_INTERVAL))) {
          continue;
        } else {
          lastTick = Instant.now();
        }
        if (running) {
          tick();
        }
      }
    }

    synchronized void stopRunning() {
      running = false;
    }

    synchronized void startRunning() {
      running = true;
    }
  }
}
