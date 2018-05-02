import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends Shape {

  private int radius;

  public Circle(int x, int y, int radius, Color color) {
    super(x, y, color);

    this.radius = radius;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public void draw(Graphics2D g2) {
    g2.setColor(getColor());
    int diameter = radius * 2;
    g2.fillOval(getX()-radius, getY()-radius, diameter, diameter);
  }

}

