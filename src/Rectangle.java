import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends Shape {

  private int width, height;

  public Rectangle(int x, int y, int width, int height, Color color) {
    super(x, y, color);

    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }


  public void draw(Graphics2D g2) {
    g2.setColor(getColor());
    g2.fillRect(getX(), getY(), width, height);
  }

}
