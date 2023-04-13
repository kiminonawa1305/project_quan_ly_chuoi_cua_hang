package view.outlet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.food.Food;
import model.food.Foods;
import model.system.Size;

public class PanelDoAn extends JPanel {
	private Food food;
	private JButton chon;

	public PanelDoAn(Food food) {
		this.food = food;
		this.init();
	}
	
	public ImageIcon scaledIcon(JLabel label, String url) {
		// Tạo đối tượng ImageIcon với đường dẫn đến file ảnh
		ImageIcon icon = new ImageIcon(url);

		// Lấy đối tượng hình ảnh từ ImageIcon
		Image img = icon.getImage();

		// Thay đổi kích thước của hình ảnh theo kích thước của JLabel
		Image scaledImg = img.getScaledInstance(label.getPreferredSize().width, label.getPreferredSize().height, Image.SCALE_SMOOTH);

		// Tạo đối tượng ImageIcon mới với hình ảnh đã được thay đổi kích thước
		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		return scaledIcon;
	}

	public void init() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		this.setPreferredSize(new Dimension(200, 250));
		this.setLayout(new BorderLayout(0, 0));

		JPanel panelInfCafe = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelInfCafe.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panelInfCafe.setPreferredSize(new Dimension(10, 50));
		this.add(panelInfCafe, BorderLayout.SOUTH);

		JLabel labelTen = new JLabel("Tên: " + ((Foods)food).getName());
		labelTen.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelTen.setOpaque(true);
		labelTen.setForeground(Color.white);
		labelTen.setPreferredSize(new Dimension(200, 25));
		labelTen.setBackground(Color.decode("#064420"));
		panelInfCafe.add(labelTen);

		JLabel labelGia = null;
		if (!((Foods) food).hasSize()) {
			labelGia = new JLabel("Giá: " + food.cost());
		} else {
			labelGia = new JLabel("Giá: " + food.cost() * Size.SMALL.getPercent() + " / "
					+ food.cost() * Size.MEDIUM.getPercent() + " / " + food.cost() * Size.LARGE.getPercent());
		}
		labelGia.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelGia.setPreferredSize(new Dimension(200, 25));
		labelGia.setOpaque(true);
		labelGia.setForeground(Color.white);
		labelGia.setBackground(Color.decode("#064420"));
		panelInfCafe.add(labelGia);

		JLabel image = new JLabel();
		image.setPreferredSize(new Dimension(150, 155));
		image.setIcon(scaledIcon(image, ((Foods) food).getUrlImage()));
		image.setHorizontalAlignment(JLabel.CENTER);
		this.add(image, BorderLayout.NORTH);

		chon = new JButton("Chọn");
		chon.setActionCommand(((Foods)food).getName());
		chon.setName("chonDoAn");
		chon.setPreferredSize(new Dimension(195, 25));
		this.add(chon, BorderLayout.EAST);
	}

	public JButton getChon() {
		return chon;
	}
}
