import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

  private class Tile {
    int x;
    int y;

    Tile(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

  int boardHeight;
  int boardWidth;
  int tileSize = 25;
  // cobra
  Tile snakeHead;
  // comida
  Tile food;
  Random random;

  // logica
  Timer gameLopp;
  int velocityX;
  int velocityY;

  SnakeGame(int boardHeight, int boardWidth) {
    this.boardWidth = boardWidth;
    this.boardHeight = boardHeight;
    setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
    setBackground(Color.black);

    snakeHead = new Tile(5, 5);

    food = new Tile(10, 10);
    random = new Random();
    placeFood();

    velocityX = -1;
    velocityY = 0;

    gameLopp = new Timer(100, this);
    gameLopp.start();

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }

  public void draw(Graphics g) {
    // grade
    for (int i = 0; i < boardWidth / tileSize; i++) {
      g.drawLine(i * tileSize, 0, i * tileSize, boardHeight);
      g.drawLine(0, i * tileSize, boardWidth, i * tileSize);
    }
    // comida
    g.setColor(Color.red);
    g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);

    g.setColor(Color.green);
    g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
  }

  public void placeFood() {
    food.x = random.nextInt(boardWidth / tileSize);
    food.y = random.nextInt(boardHeight / tileSize);
  }

  public void move() {
    snakeHead.x += velocityX;
    snakeHead.y += velocityY;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    move();
    repaint();
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
  }
}
