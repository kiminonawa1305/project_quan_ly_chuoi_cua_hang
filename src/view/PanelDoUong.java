package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.beverage.Beverage;
import model.beverage.Beverages;
import model.food.Food;
import model.food.Foods;
import model.system.Size;

public class PanelDoUong extends JPanel {
	private Beverage beverage;
	private JButton chon;

	public PanelDoUong(Beverage beverage) {
		this.beverage = beverage;
		this.init();
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

		JLabel labelTen = new JLabel("Tên: " + ((Beverages) beverage).getName());
		labelTen.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelTen.setOpaque(true);
		labelTen.setForeground(Color.white);
		labelTen.setPreferredSize(new Dimension(200, 25));
		labelTen.setBackground(Color.decode("#064420"));
		panelInfCafe.add(labelTen);

		JLabel labelGia = null;
		labelGia = new JLabel("Giá: " + beverage.cost() * Size.SMALL.getPercent() + " / "
				+ beverage.cost() * Size.MEDIUM.getPercent() + " / " + beverage.cost() * Size.LARGE.getPercent());
		labelGia.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		labelGia.setPreferredSize(new Dimension(200, 25));
		labelGia.setOpaque(true);
		labelGia.setForeground(Color.white);
		labelGia.setBackground(Color.decode("#064420"));
		panelInfCafe.add(labelGia);

		JLabel image = new JLabel();
		image.setPreferredSize(new Dimension(150, 155));
		image.setIcon(new ImageIcon(((Beverages) beverage).getUrlImage()));
		this.add(image, BorderLayout.NORTH);

		chon = new JButton("Chọn");
		chon.setPreferredSize(new Dimension(195, 25));
		chon.setName("chonDoUong");
		chon.setActionCommand(((Beverages)beverage).getName());
		this.add(chon, BorderLayout.EAST);
	}

	public JButton getChon() {
		return chon;
	}
}
