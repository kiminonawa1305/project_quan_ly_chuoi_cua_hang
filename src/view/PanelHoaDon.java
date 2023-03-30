package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Map.Entry;
import java.util.concurrent.Flow;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.ControlPanelHoaDon;
import model.beverage.Beverage;
import model.food.Food;
import model.pay.Card;
import model.pay.Cash;
import model.pay.Transfer;
import model.system.Bill;
import model.system.NumericInputOnlyDocument;
import model.system.Outlets;

import javax.swing.JTable;
import javax.swing.JTextArea;

public class PanelHoaDon extends JPanel {
	private Bill bill;
	private JPanel panelFrameListSP;
	private JRadioButton optionTM, optionCK, optionQT;
	private JScrollPane scrollPane;
	private JLabel labelTTHD, labelTongTien, labelPhanTramThue, labelTienThue, labelThanhTienTT;
	private ControlPanelHoaDon control;
	private ButtonGroup groupOptionTT;
	private JButton buttonThanhToan;
	private JTable table;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	/**
	 * Create the panel.
	 * 
	 * @param bill
	 */
	public PanelHoaDon(Bill bill) {
		this.bill = bill;
		this.init();
		this.upDateListSPDM();
		this.event();
	}

	public void init() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));

		control = new ControlPanelHoaDon(this);

		JPanel panelMain = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
		panelMain.setPreferredSize(new Dimension(1200, 710));
		panelMain.setBackground(Color.WHITE);
		this.add(panelMain);

		labelTTHD = new JLabel("<html>Thông tin hóa đơn<br> Mã hóa đơn: " + bill.getId() + "</html>");
		labelTTHD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelTTHD.setPreferredSize(new Dimension(1100, 50));
		panelMain.add(labelTTHD);

		panelFrameListSP = new JPanel(new BorderLayout());
		panelFrameListSP.setPreferredSize(new Dimension(1100, 415));
		panelMain.add(panelFrameListSP);

		JPanel panelLabel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 2));
		panelLabel.setPreferredSize(new Dimension(10, 50));
		panelLabel.setBackground(new Color(6, 68, 32));
		panelFrameListSP.add(panelLabel, BorderLayout.NORTH);

		JLabel labelTenMon = new JLabel("Tên món");
		labelTenMon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelTenMon.setForeground(Color.WHITE);
		labelTenMon.setPreferredSize(new Dimension(330, 45));
		panelLabel.add(labelTenMon);

		JLabel labelSoLuong = new JLabel("Số lượng");
		labelSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelSoLuong.setForeground(Color.WHITE);
		labelSoLuong.setHorizontalAlignment(SwingConstants.LEFT);
		labelSoLuong.setPreferredSize(new Dimension(230, 45));
		panelLabel.add(labelSoLuong);

		JLabel labelGia = new JLabel("Giá");
		labelGia.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelGia.setForeground(Color.WHITE);
		labelGia.setPreferredSize(new Dimension(180, 45));
		panelLabel.add(labelGia);

		JLabel labelThanhTien = new JLabel("Thành tiền");
		labelThanhTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelThanhTien.setForeground(Color.WHITE);
		labelThanhTien.setPreferredSize(new Dimension(150, 45));
		panelLabel.add(labelThanhTien);

		scrollPane = new JScrollPane();
		panelFrameListSP.add(scrollPane, BorderLayout.CENTER);

		JPanel panelFrameThanhToan = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		panelFrameThanhToan.setBackground(new Color(228, 239, 231));
		panelFrameThanhToan.setPreferredSize(new Dimension(1100, 150));
		panelMain.add(panelFrameThanhToan);

		JPanel panelTT = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 2));
		panelTT.setOpaque(false);
		panelTT.setPreferredSize(new Dimension(800, 130));
		panelFrameThanhToan.add(panelTT);

		JPanel panelOptionTT = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 4));
		panelTT.add(panelOptionTT);
		panelOptionTT.setOpaque(false);
		panelOptionTT.setBackground(Color.WHITE);
		panelOptionTT.setPreferredSize(new Dimension(155, 85));

		groupOptionTT = new ButtonGroup();

		optionTM = new JRadioButton("Tiền mặt");
		optionTM.setActionCommand("tien_mat");
		optionTM.setPreferredSize(new Dimension(140, 25));
		optionTM.setOpaque(false);
		panelOptionTT.add(optionTM);
		groupOptionTT.add(optionTM);

		optionCK = new JRadioButton("Chuyển khoản");
		optionCK.setActionCommand("chuyen_khoan");
		optionCK.setPreferredSize(new Dimension(140, 22));
		optionCK.setOpaque(false);
		panelOptionTT.add(optionCK);
		groupOptionTT.add(optionCK);

		optionQT = new JRadioButton("Quẹt thẻ");
		optionQT.setActionCommand("quet_the");
		optionQT.setPreferredSize(new Dimension(140, 25));
		optionQT.setOpaque(false);
		panelOptionTT.add(optionQT);
		groupOptionTT.add(optionQT);

		JPanel panelButtonThanhToan = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtonThanhToan.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelButtonThanhToan.setPreferredSize(new Dimension(700, 35));
		panelButtonThanhToan.setOpaque(false);
		panelTT.add(panelButtonThanhToan);

		buttonThanhToan = new JButton("Thanh Toán");
		buttonThanhToan.setName("thanh_toan");
		buttonThanhToan.setPreferredSize(new Dimension(150, 30));
		buttonThanhToan.setForeground(Color.WHITE);
		buttonThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonThanhToan.setBackground(new Color(6, 68, 32));
		panelButtonThanhToan.add(buttonThanhToan);

		JPanel panelTien = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 3));
		panelTien.setBackground(Color.WHITE);
		panelTien.setPreferredSize(new Dimension(240, 130));
		panelFrameThanhToan.add(panelTien);

		labelTongTien = new JLabel("Tổng tiền: " + bill.getTotalBill());
		labelTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTongTien.setPreferredSize(new Dimension(200, 25));
		panelTien.add(labelTongTien);

		labelPhanTramThue = new JLabel("Thuế : 0.05%");
		labelPhanTramThue.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelPhanTramThue.setPreferredSize(new Dimension(200, 25));
		panelTien.add(labelPhanTramThue);

		labelTienThue = new JLabel("Tiền thuế: " + bill.getTotalBill() * 0.05);
		labelTienThue.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTienThue.setPreferredSize(new Dimension(200, 25));
		panelTien.add(labelTienThue);

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(160, 5));
		panelTien.add(separator);

		labelThanhTienTT = new JLabel("Thành tiền: " + (bill.getTotalBill() + bill.getTotalBill() * 0.05));
		labelThanhTienTT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelThanhTienTT.setPreferredSize(new Dimension(200, 25));
		panelTien.add(labelThanhTienTT);
	}

	public void event() {
		buttonThanhToan.addActionListener(control);
	}

	/**
	 * Đọc từ bill để lấy danh sách các món ăn cũng như là số lượng các món ăn để có
	 * thể tạo ra danh sách các món ăn
	 * 
	 * @return
	 */
	public JPanel createListSPDM() {
		JPanel panelList = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		panelList.setPreferredSize(new Dimension(1080, 60 * bill.countSP()));

		for (Entry entryFood : bill.getListFood().entrySet()) {
			JPanel mon = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 3));
			mon.setPreferredSize(new Dimension(1095, 50));
			mon.setBackground(new Color(250, 241, 230));
			panelList.add(mon);

			JLabel ten = new JLabel(((Food) entryFood.getKey()).note());
			ten.setPreferredSize(new Dimension(320, 45));
			mon.add(ten);

			JLabel sl = new JLabel(entryFood.getValue() + "");
			sl.setHorizontalAlignment(SwingConstants.CENTER);
			sl.setPreferredSize(new Dimension(90, 45));
			mon.add(sl);

			JLabel gia = new JLabel(((Food) entryFood.getKey()).cost() + "");
			gia.setHorizontalAlignment(SwingConstants.CENTER);
			gia.setPreferredSize(new Dimension(330, 45));
			mon.add(gia);

			JLabel thanhTien = new JLabel((((Food) entryFood.getKey()).cost() * (int) entryFood.getValue()) + "");
			thanhTien.setHorizontalAlignment(SwingConstants.CENTER);
			thanhTien.setPreferredSize(new Dimension(90, 45));
			mon.add(thanhTien);

			JButton buttonHuy = new JButton("X");
			buttonHuy.addActionListener(control);
			buttonHuy.setActionCommand(((Food) entryFood.getKey()).note());
			buttonHuy.setName("do_an");
			buttonHuy.setBackground(Color.RED);
			buttonHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
			buttonHuy.setPreferredSize(new Dimension(45, 45));
			mon.add(buttonHuy);
		}

		for (Entry entryBeverage : bill.getListBeverage().entrySet()) {
			JPanel mon = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 3));
			mon.setPreferredSize(new Dimension(1095, 50));
			mon.setBackground(new Color(250, 241, 230));
			panelList.add(mon);

			JLabel ten = new JLabel(((Beverage) entryBeverage.getKey()).note());
			ten.setPreferredSize(new Dimension(320, 45));
			mon.add(ten);

			JLabel sl = new JLabel(entryBeverage.getValue() + "");
			sl.setHorizontalAlignment(SwingConstants.CENTER);
			sl.setPreferredSize(new Dimension(90, 45));
			mon.add(sl);

			JLabel gia = new JLabel(((Beverage) entryBeverage.getKey()).cost() + "");
			gia.setHorizontalAlignment(SwingConstants.CENTER);
			gia.setPreferredSize(new Dimension(330, 45));
			mon.add(gia);

			JLabel thanhTien = new JLabel(
					(((Beverage) entryBeverage.getKey()).cost() * (int) entryBeverage.getValue()) + "");
			thanhTien.setHorizontalAlignment(SwingConstants.CENTER);
			thanhTien.setPreferredSize(new Dimension(90, 45));
			mon.add(thanhTien);

			JButton buttonHuy = new JButton("X");
			buttonHuy.setActionCommand(((Beverage) entryBeverage.getKey()).note());
			buttonHuy.setName("do_uong");
			buttonHuy.addActionListener(control);
			buttonHuy.setBackground(Color.RED);
			buttonHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
			buttonHuy.setPreferredSize(new Dimension(45, 45));
			mon.add(buttonHuy);
		}

		return panelList;
	}

	// xóa 1 món trong hóa đơn.
	public void removeSP(JButton button) {
		if (button.getName().equals("do_an")) {
			for (Food food : bill.getListFood().keySet()) {
				if (food.note().equals(button.getActionCommand())) {
					bill.getListFood().remove(food);
				}
			}
		} else {
			for (Beverage beverage : bill.getListBeverage().keySet()) {
				if (beverage.note().equals(button.getActionCommand())) {
					bill.getListBeverage().remove(beverage);
				}
			}
		}

		upDateListSPDM();
	}

	// Cập nhật lại danh sách
	public void upDateListSPDM() {
		this.scrollPane.setViewportView(createListSPDM());
		this.labelTongTien.setText("Tổng tiền: " + bill.getTotalBill());
		this.labelTienThue.setText("Tiền thuế: " + bill.getTotalBill() * 0.05);
		this.labelThanhTienTT.setText("Thành tiền: " + (bill.getTotalBill() + bill.getTotalBill() * 0.05));
	}

	public void thanhToan() {
		try {
			if (groupOptionTT.getSelection() == null) {
				JOptionPane.showMessageDialog(null, "Chưa chọn phương thức thanh toán", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JTextField textField = new JTextField(new NumericInputOnlyDocument(), null, 0);
				int result = JOptionPane.showConfirmDialog(null, textField, "Nhập số tiền thanh toán:",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				String key = groupOptionTT.getSelection().getActionCommand();
				boolean check = false;
				switch (key) {
				case "tien_mat": {
					check = Outlets.pay(new Cash(), bill, 0.05, Double.parseDouble(textField.getText()));
					break;
				}
				case "chuyen_khoan": {
					check =  Outlets.pay(new Card(), bill, 0.05, Double.parseDouble(textField.getText()));
					break;
				}
				case "quet_the": {
					check =  Outlets.pay(new Transfer(), bill, 0.05, Double.parseDouble(textField.getText()));
					break;
				}
				}
				
				if(check) {
					bill = new Bill();
				}else {
					JOptionPane.showMessageDialog(this, "Lỗi thanh toán", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi thanh toán", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
}
