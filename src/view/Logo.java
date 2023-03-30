package view;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Logo extends JLabel {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int arcSize = 35; // Kích thước bo tròn, bạn có thể thay đổi theo ý muốn.

        // Vẽ hình dạng bo tròn
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, arcSize, arcSize);
        g2.setClip(roundedRectangle);

        // Vẽ JLabel bên trong hình dạng bo tròn
        super.paintComponent(g);
    }

    // Khởi tạo lớp RoundedCornerLabel
    public Logo(String url) {
        setOpaque(false);
        this.setIcon(new ImageIcon(url));
    }
}
