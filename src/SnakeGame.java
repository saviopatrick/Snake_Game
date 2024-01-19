import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SnakeGame extends JPanel{

  private class Tile {
    int x;
    int y;
    Tile(int x, int y){
      this.x = x;
      this.y = y;
    }
    
  }

  int boardHeight;
  int boardWidth;
  int tileSize = 25;

  Tile snakeHead;

  SnakeGame(int boardHeight,int boardWidth){
    this.boardWidth = boardWidth;
    this.boardHeight = boardHeight;
    setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
    setBackground(Color.black);

    snakeHead = new Tile(5, 5);

  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
  }
  public void draw(Graphics g){
    //grade
    for(int i = 0;i<boardWidth/tileSize;i++){
      g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
      g.drawLine(0, i*tileSize, boardWidth, i*tileSize);
    }

    g.setColor(Color.green);
    g.fillRect(snakeHead.x *tileSize, snakeHead.y * tileSize, tileSize, tileSize);
  }
}
