package gameoflife;

class MyAdapter {

  private final int width;
  private final int length;

  private boolean[][] cells;

  MyAdapter(int width, int length) {
    this.width = width;
    this.length = length;
    cells = new boolean[width][length];
  }

  boolean isLive(int x, int y) {
    return !(x < 0 || x > width || y < 0 || y > length) && cells[x][y];
  }

  void tick() {
    boolean[][] cellsBuffer = new boolean[width][length];
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < width; y++) {
        cellsBuffer[x][y] = tickCell(x, y);
      }
    }
    cells = cellsBuffer;
  }

  private boolean tickCell(int x, int y) {
    int neighbours = getNumNeighbours(x, y);

    if (cells[x][y]) {
      if (neighbours < 2 || neighbours > 3) {
        return false;
      } else if (neighbours == 2 || neighbours == 3) {
        return true;
      }
    } else {
      return neighbours == 3;
    }
    return false;
  }

  private int getNumNeighbours(int x, int y) {
    int counter = 0;

    if (x > 0 && y > 0 && cells[x - 1][y - 1]) {
      counter++;
    }
    if (y > 0 && cells[x][y - 1]) {
      counter++;
    }
    if (x < width - 1 && y > 0 && cells[x + 1][y - 1]) {
      counter++;
    }
    if (x > 0 && cells[x - 1][y]) {
      counter++;
    }
    if (x < width - 1 && cells[x + 1][y]) {
      counter++;
    }
    if (x > 0 && y < length - 1 && cells[x - 1][y + 1]) {
      counter++;
    }
    if (y < length - 1 && cells[x][y + 1]) {
      counter++;
    }
    if (x < width - 1 && y < length - 1 && cells[x + 1][y + 1]) {
      counter++;
    }

    return counter;
  }

  int getWidth() {
    return width;
  }

  int getLength() {
    return length;
  }

  void changeValueAt(int x, int y) {
    cells[x][y] = !cells[x][y];
  }
}
