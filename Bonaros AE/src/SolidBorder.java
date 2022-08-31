import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class SolidBorder implements Border {
  protected Color topColor = Color.white;

  protected Color bottomColor = Color.gray;

  public SolidBorder() {
  }


  public Insets getBorderInsets(Component c) {
    return new Insets(4, 4, 4, 4);
  }

  public boolean isBorderOpaque() {
    return true;
  }

  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    width--;
    height--;
    g.setColor(topColor);
    g.drawLine(x, y + height, x, y);
    g.drawLine(x , y, x + width , y);

    g.setColor(bottomColor);
    g.drawLine(x + width, y, x + width, y + height);
    g.drawLine(x , y + height, x + width, y + height);
  }

  public static void main(String[] args) {
//    JFrame frame = new JFrame("Custom Border: SolidBorder");
//    JLabel label = new JLabel("SolidBorder");
//    ((JPanel) frame.getContentPane()).setBorder(new CompoundBorder(
//        new EmptyBorder(10, 10, 10, 10), new SolidBorder()));
//    frame.getContentPane().add(label);
//    frame.setBounds(0, 0, 300, 150);
//    frame.setVisible(true);
  }
}