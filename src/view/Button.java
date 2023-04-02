package view;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Button extends JButton {
	private int arcSize;
	
    public Button(String title, int arcSize) {
    	this.setText(title);
		this.arcSize = arcSize;
	}

	@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Vẽ hình dạng bo tròn
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, arcSize, arcSize);
        g2.setClip(roundedRectangle);

        // Vẽ JLabel bên trong hình dạng bo tròn
        super.paintComponent(g);
    }

    // Khởi tạo lớp RoundedCornerLabel
    public Button(String url) {
        setOpaque(false);
        this.setIcon(new ImageIcon(url));
    }
}
