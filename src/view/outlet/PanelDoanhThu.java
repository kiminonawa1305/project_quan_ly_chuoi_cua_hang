package view.outlet;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import control.ControlPanelDoanhThu;
import model.beverage.Beverage;
import model.food.Food;
import model.system.Outlets;

public class PanelDoanhThu extends JPanel {
	private final Outlets OUTLETS;
	private final ControlPanelDoanhThu CONTROL;
	private JButton buttonEye, buttonDangNhap, buttonDTHomNay, buttonDTTuan, buttonDTThang, buttonDTNam;
	private JComboBox comboBoxTuan, comboBoxThang, comboBoxNam;
	private JLabel labelTitle, labelIConMoney, labelTongDoanhThu, labelShowDoanhThu, labelTongHoaDong,
			labelShowTongHoaDon, labelDate;
	private Font fontButtonOption = new Font("Tahoma", Font.BOLD, 15);
	private List<JButton> listButtonOption = new ArrayList<>();
	private JPanel panelPasswordField;
	private JTextField passwordField;
	private final Icon OPEN = new ImageIcon("icon\\open_eye_icon.png");
	private final Icon CLOSE = new ImageIcon("icon\\eye_close_icon.png");
	private JPanel panelTopDoAn;
	private JPanel panelTopDoUong;
	private JLabel labelTopTitleDoAn;
	private JLabel labelTopTitleDoUong;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Create the panel.
	 */
	public PanelDoanhThu(Outlets outlets) {
		this.OUTLETS = outlets;
		this.CONTROL = new ControlPanelDoanhThu(this);
		this.init();
		this.event();
	}

	public JButton getButtonEye() {
		return buttonEye;
	}

	public JButton getButtonDangNhap() {
		return buttonDangNhap;
	}

	public void init() {
		this.setLayout(new CardLayout());
		this.setBackground(new Color(228, 239, 231));

		JPanel panelPassword = new JPanel();
		panelPassword.setAlignmentX(140.0f);
		panelPassword.setAlignmentY(140.0f);
		panelPassword.setBackground(Color.WHITE);
		panelPassword.setPreferredSize(new Dimension(400, 400));
		this.add("pass", panelPassword);
		panelPassword.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel labelPass = new JLabel("Nhập mật khẩu");
		labelPass.setPreferredSize(new Dimension(1400, 300));
		labelPass.setVerticalAlignment(SwingConstants.BOTTOM);
		labelPass.setHorizontalAlignment(SwingConstants.CENTER);
		labelPass.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelPassword.add(labelPass);

		panelPasswordField = new JPanel(new BorderLayout(0, 0));
		panelPasswordField.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelPassword.add(panelPasswordField);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setPreferredSize(new Dimension(595, 19));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPasswordField.add(passwordField, BorderLayout.WEST);

		buttonEye = new JButton();
		buttonEye.setIcon(CLOSE);
		buttonEye.setPreferredSize(new Dimension(50, 50));
		panelPasswordField.add(buttonEye, BorderLayout.EAST);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(1400, 50));
		panelPassword.add(panel);

		buttonDangNhap = new JButton("Đăng Nhập");
		buttonDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(buttonDangNhap);

		this.add("pass", panelPassword);

		// Phần show
		JPanel panelShowDoanhThu = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 30));
		panelShowDoanhThu.setBackground(new Color(228, 239, 231));
		this.add("show", panelShowDoanhThu);

		JPanel panelMain = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelMain.getLayout();
		flowLayout_1.setVgap(10);
		panelMain.setBackground(Color.WHITE);
		panelMain.setPreferredSize(new Dimension(1200, 710));
		panelShowDoanhThu.add(panelMain);

		JLabel lblNewLabel = new JLabel(
				"<html>Mã chi nhánh: " + OUTLETS.getID() + "<br>Địa chỉ: " + OUTLETS.getAddress() + "</html>");
		lblNewLabel.setPreferredSize(new Dimension(1100, 50));
		panelMain.add(lblNewLabel);

		JPanel panelOptionDT = new JPanel();
		panelOptionDT.setBackground(new Color(250, 241, 230));
		panelOptionDT.setPreferredSize(new Dimension(1000, 100));
		panelMain.add(panelOptionDT);

		JPanel panelButtonOption = new JPanel();
		FlowLayout fl_panelButtonOption = (FlowLayout) panelButtonOption.getLayout();
		fl_panelButtonOption.setHgap(15);
		panelButtonOption.setOpaque(false);
		panelButtonOption.setPreferredSize(new Dimension(990, 40));
		panelOptionDT.add(panelButtonOption);

		buttonDTHomNay = new JButton("Hôm nay");
		buttonDTHomNay.setActionCommand("action");
		buttonDTHomNay.setFont(fontButtonOption);
		buttonDTHomNay.setBorder(null);
		panelButtonOption.add(buttonDTHomNay);
		buttonDTHomNay.setPreferredSize(new Dimension(150, 30));
		listButtonOption.add(buttonDTHomNay);

		buttonDTTuan = new JButton("Tuần");
		buttonDTHomNay.setActionCommand("");
		buttonDTTuan.setFont(fontButtonOption);
		buttonDTTuan.setBorder(null);
		panelButtonOption.add(buttonDTTuan);
		buttonDTTuan.setPreferredSize(new Dimension(150, 30));
		listButtonOption.add(buttonDTTuan);

		buttonDTThang = new JButton("Tháng");
		buttonDTHomNay.setActionCommand("");
		buttonDTThang.setFont(fontButtonOption);
		buttonDTThang.setBorder(null);
		buttonDTThang.setEnabled(true);
		panelButtonOption.add(buttonDTThang);
		buttonDTThang.setPreferredSize(new Dimension(150, 30));
		listButtonOption.add(buttonDTThang);

		buttonDTNam = new JButton("Năm");
		buttonDTHomNay.setActionCommand("");
		buttonDTNam.setFont(fontButtonOption);
		buttonDTNam.setBorder(null);
		buttonDTNam.setEnabled(true);
		panelButtonOption.add(buttonDTNam);
		buttonDTNam.setPreferredSize(new Dimension(150, 30));
		listButtonOption.add(buttonDTNam);

		JPanel panelChooseTime = new JPanel();
		panelChooseTime.setOpaque(false);
		FlowLayout fl_panelChooseTime = (FlowLayout) panelChooseTime.getLayout();
		fl_panelChooseTime.setHgap(20);
		panelChooseTime.setPreferredSize(new Dimension(990, 40));
		panelOptionDT.add(panelChooseTime);

		comboBoxTuan = new JComboBox();
		comboBoxTuan.setModel(new DefaultComboBoxModel(new String[] { "Tuần 1", "Tuần 2", "Tuần 3", "Tuần 4" }));
		comboBoxTuan.setPreferredSize(new Dimension(150, 30));
		panelChooseTime.add(comboBoxTuan);

		comboBoxThang = new JComboBox();
		comboBoxThang.setModel(new DefaultComboBoxModel(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4",
				"Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
		comboBoxThang.setPreferredSize(new Dimension(150, 30));
		panelChooseTime.add(comboBoxThang);

		String[] nam = new String[101];
		for (int i = 2023; i <= 2123; i++) {
			nam[i - 2023] = i + "";
		}
		comboBoxNam = new JComboBox(new DefaultComboBoxModel(nam));
		comboBoxNam.setPreferredSize(new Dimension(150, 30));
		panelChooseTime.add(comboBoxNam);

		setBackgroundForButtonSelect(buttonDTHomNay);
		lockChooseTime(buttonDTHomNay);

		JPanel panelFrameMainShowDT = new JPanel();
		FlowLayout fl_panelFrameMainShowDT = (FlowLayout) panelFrameMainShowDT.getLayout();
		fl_panelFrameMainShowDT.setHgap(50);
		fl_panelFrameMainShowDT.setVgap(10);
		panelFrameMainShowDT.setOpaque(false);
		panelFrameMainShowDT.setPreferredSize(new Dimension(1000, 520));
		panelMain.add(panelFrameMainShowDT);

		JPanel panelFrameShowDT = new JPanel();
		FlowLayout fl_panelFrameShowDT = (FlowLayout) panelFrameShowDT.getLayout();
		fl_panelFrameShowDT.setVgap(25);
		panelFrameShowDT.setBackground(new Color(180, 231, 191));
		panelFrameShowDT.setPreferredSize(new Dimension(550, 500));
		panelFrameMainShowDT.add(panelFrameShowDT);

		labelTitle = new JLabel();
		labelTitle.setVerticalAlignment(SwingConstants.TOP);
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTitle.setPreferredSize(new Dimension(500, 25));
		panelFrameShowDT.add(labelTitle);

		labelDate = new JLabel();
		labelDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelDate.setHorizontalAlignment(SwingConstants.CENTER);
		labelDate.setPreferredSize(new Dimension(300, 50));
		panelFrameShowDT.add(labelDate);

		JPanel panelFrameTongDoanhThu = new JPanel();
		panelFrameTongDoanhThu.setOpaque(false);
		FlowLayout fl_panelFrameTongDoanhThu = (FlowLayout) panelFrameTongDoanhThu.getLayout();
		fl_panelFrameTongDoanhThu.setAlignment(FlowLayout.LEFT);
		fl_panelFrameTongDoanhThu.setVgap(40);
		fl_panelFrameTongDoanhThu.setHgap(10);
		panelFrameTongDoanhThu.setPreferredSize(new Dimension(500, 125));
		panelFrameShowDT.add(panelFrameTongDoanhThu);

		labelIConMoney = new JLabel();
		labelIConMoney.setIcon(new ImageIcon("icon\\dola.png"));
		labelIConMoney.setPreferredSize(new Dimension(75, 75));
		panelFrameTongDoanhThu.add(labelIConMoney);

		JPanel panelTongDoanhThu = new JPanel();
		panelTongDoanhThu.setOpaque(false);
		FlowLayout fl_panelTongDoanhThu = (FlowLayout) panelTongDoanhThu.getLayout();
		fl_panelTongDoanhThu.setVgap(0);
		panelTongDoanhThu.setPreferredSize(new Dimension(400, 75));
		panelFrameTongDoanhThu.add(panelTongDoanhThu);

		labelTongDoanhThu = new JLabel();
		labelTongDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTongDoanhThu.setPreferredSize(new Dimension(400, 25));
		panelTongDoanhThu.add(labelTongDoanhThu);

		labelShowDoanhThu = new JLabel(FormatNumber(123456789));
		labelShowDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelShowDoanhThu.setPreferredSize(new Dimension(400, 50));
		panelTongDoanhThu.add(labelShowDoanhThu);

		labelTongHoaDong = new JLabel();
		labelTongHoaDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTongHoaDong.setVerticalAlignment(SwingConstants.BOTTOM);
		labelTongHoaDong.setPreferredSize(new Dimension(400, 75));
		panelFrameShowDT.add(labelTongHoaDong);

		JPanel panelTongHoaDon = new JPanel();
		panelTongHoaDon.setOpaque(false);
		FlowLayout fl_panelTongHoaDon = (FlowLayout) panelTongHoaDon.getLayout();
		fl_panelTongHoaDon.setAlignment(FlowLayout.LEFT);
		fl_panelTongHoaDon.setVgap(0);
		fl_panelTongHoaDon.setHgap(25);
		panelTongHoaDon.setPreferredSize(new Dimension(400, 50));
		panelFrameShowDT.add(panelTongHoaDon);

		JLabel labelIcConBill = new JLabel();
		labelIcConBill.setIcon(new ImageIcon("icon\\bill.png"));
		labelIcConBill.setPreferredSize(new Dimension(50, 50));
		panelTongHoaDon.add(labelIcConBill);

		labelShowTongHoaDon = new JLabel();
		labelShowTongHoaDon.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelShowTongHoaDon.setPreferredSize(new Dimension(300, 50));
		panelTongHoaDon.add(labelShowTongHoaDon);

		JPanel panelTop = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTop.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panelTop.setBackground(new Color(228, 239, 231));
		panelTop.setPreferredSize(new Dimension(350, 500));
		panelFrameMainShowDT.add(panelTop);

		panelTopDoAn = new JPanel();
		FlowLayout fl_panelTopDoAn = (FlowLayout) panelTopDoAn.getLayout();
		fl_panelTopDoAn.setHgap(0);
		panelTopDoAn.setPreferredSize(new Dimension(350, 249));
		panelTop.add(panelTopDoAn);

		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setPreferredSize(new Dimension(350, 2));
		panelTop.add(separator);

		panelTopDoUong = new JPanel();
		FlowLayout fl_panelTopDoUong = (FlowLayout) panelTopDoUong.getLayout();
		fl_panelTopDoUong.setHgap(0);
		panelTopDoUong.setPreferredSize(new Dimension(350, 249));
		panelTop.add(panelTopDoUong);

		showDTHomNay();
	}

	public void event() {
		this.buttonDTHomNay.addActionListener(CONTROL);
		this.buttonDTTuan.addActionListener(CONTROL);
		this.buttonDTThang.addActionListener(CONTROL);
		this.buttonDTNam.addActionListener(CONTROL);
		this.comboBoxTuan.addActionListener(CONTROL);
		this.comboBoxThang.addActionListener(CONTROL);
		this.comboBoxNam.addActionListener(CONTROL);
		this.buttonEye.addActionListener(CONTROL);
		this.buttonDangNhap.addActionListener(CONTROL);
		passwordField.registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhap();

			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
	}

	public void dangNhap() {
		if (this.passwordField.getText().equals(this.OUTLETS.getPass())) {
			((CardLayout) this.getLayout()).show(this, "show");
			this.passwordField.setText("");
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Sai mật khẩu", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void close() {
		((CardLayout) this.getLayout()).show(this, "pass");
	}

	public void showPass() {
		panelPasswordField.remove(passwordField);
		this.passwordField = new JTextField(passwordField.getText());
		passwordField.setBorder(null);
		passwordField.setPreferredSize(new Dimension(595, 19));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPasswordField.add(passwordField, BorderLayout.WEST);
		buttonEye.setIcon(OPEN);
		passwordField.registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhap();

			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		this.validate();
	}

	public void hiddenPass() {
		panelPasswordField.remove(passwordField);
		this.passwordField = new JPasswordField(passwordField.getText());
		passwordField.setBorder(null);
		passwordField.setPreferredSize(new Dimension(595, 19));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPasswordField.add(passwordField, BorderLayout.WEST);
		buttonEye.setIcon(CLOSE);
		passwordField.registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhap();

			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		this.validate();
	}

	public void actionButtonEye(JButton button) {
		if (button.equals(buttonEye)) {
			if (this.passwordField instanceof JPasswordField) {
				this.showPass();
			} else {
				this.hiddenPass();
			}
		}
	}

	public String FormatNumber(double number) {
		String formattedNumber = "";
		int count = 0;
		String input = (int) number + "";
		for (int i = input.length() - 1; i >= 0; i--) {
			formattedNumber = input.charAt(i) + formattedNumber;
			count++;
			if (count == 3 && i != 0) {
				formattedNumber = "." + formattedNumber;
				count = 0;
			}
		}

		return formattedNumber;
	}

	public void setBackgroundForButtonSelect(JButton button) {
		for (JButton bt : listButtonOption) {
			if (bt.equals(button)) {
				bt.setBackground(new Color(6, 68, 32));
				bt.setForeground(Color.WHITE);
				bt.setActionCommand("action");
			} else {
				bt.setBackground(new Color(228, 239, 231));
				bt.setForeground(Color.BLACK);
				bt.setActionCommand("");
			}
		}
	}

	public void lockChooseTime(JButton button) {
		if (button.equals(buttonDTHomNay)) {
			comboBoxTuan.setEnabled(false);
			comboBoxThang.setEnabled(false);
			comboBoxNam.setEnabled(false);
			return;
		}

		if (buttonDTTuan.equals(button)) {
			comboBoxTuan.setEnabled(true);
			comboBoxThang.setEnabled(true);
			comboBoxNam.setEnabled(true);
			return;
		}

		if (buttonDTThang.equals(button)) {
			comboBoxTuan.setEnabled(false);
			comboBoxThang.setEnabled(true);
			comboBoxNam.setEnabled(true);
			return;
		}

		if (buttonDTNam.equals(button)) {
			comboBoxTuan.setEnabled(false);
			comboBoxThang.setEnabled(false);
			comboBoxNam.setEnabled(true);
			return;
		}
	}

	public void showDTHomNay() {
		if (buttonDTHomNay.getActionCommand().equals("action")) {
			this.labelTitle.setText("Kết quả bán hàng hôm nay");
			LocalDate now = LocalDate.now();
			this.labelDate.setText(now.getDayOfMonth() + "-" + now.getMonthValue() + "-" + now.getYear());
			this.labelTongDoanhThu.setText("Tổng doanh thu hôm nay");
			this.labelShowDoanhThu.setText(FormatNumber(OUTLETS.getTotalTurnoverByToday()));
			this.labelTongHoaDong.setText("Tổng hóa đơn hôm nay");
			this.labelShowTongHoaDon.setText(FormatNumber(OUTLETS.getCountBIllByToday()));
			showDSTopSellHomNay();
		}
	}

	public void showDTTuan() {
		if (buttonDTTuan.getActionCommand().equals("action")) {
			int tuan = Integer.parseInt(((String) comboBoxTuan.getSelectedItem()).split(" ")[1]);
			int thang = Integer.parseInt(((String) comboBoxThang.getSelectedItem()).split(" ")[1]);
			int nam = Integer.parseInt((String) comboBoxNam.getSelectedItem());
			this.labelTitle.setText("Kết quả bán hàng tuần " + tuan + " tháng " + thang + " năm " + nam);
			this.labelDate.setText("Tuần " + tuan + "-" + thang + "-" + nam);
			this.labelTongDoanhThu.setText("Tổng doanh thu tuần " + tuan + " tháng " + thang + " năm " + nam);
			this.labelShowDoanhThu.setText(FormatNumber(OUTLETS.getTotalTurnoverByWeekOfMonth(tuan, thang, nam)));
			this.labelTongHoaDong.setText("Tổng hóa đơn tuần " + tuan + " tháng " + thang + " năm " + nam);
			this.labelShowTongHoaDon.setText(FormatNumber(OUTLETS.getCountBIllByWeekOfMonth(tuan, thang, nam)));
			showDSTopSellTuan(tuan, thang, nam);
		}
	}

	public void showDTThang() {
		if (buttonDTThang.getActionCommand().equals("action")) {
			int thang = Integer.parseInt(((String) comboBoxThang.getSelectedItem()).split(" ")[1]);
			int nam = Integer.parseInt((String) comboBoxNam.getSelectedItem());
			this.labelTitle.setText("Kết quả bán hàng tháng " + thang + " năm " + nam);
			this.labelDate.setText(thang + "-" + nam);
			this.labelTongDoanhThu.setText("Tổng doanh thu tháng " + thang + " năm " + nam);
			this.labelShowDoanhThu.setText(FormatNumber(OUTLETS.getTotalTurnoverByMonth(thang, nam)));
			this.labelTongHoaDong.setText("Tổng hóa đơn tháng " + thang + " năm " + nam);
			this.labelShowTongHoaDon.setText(FormatNumber(OUTLETS.getCountBIllByMonth(thang, nam)));
			showDSTopSellThang(thang, nam);
		}
	}

	public void showDTNam() {
		if (buttonDTNam.getActionCommand().equals("action")) {
			int nam = Integer.parseInt((String) comboBoxNam.getSelectedItem());
			this.labelTitle.setText("Kết quả bán hàng năm " + nam);
			this.labelDate.setText(nam + "");
			this.labelTongDoanhThu.setText("Tổng doanh thu năm " + nam);
			this.labelShowDoanhThu.setText(FormatNumber(OUTLETS.getTotalTurnoverByYear(nam)));
			this.labelTongHoaDong.setText("Tổng hóa đơn năm " + nam);
			this.labelShowTongHoaDon.setText(FormatNumber(OUTLETS.getTotalTurnoverByYear(nam)));
			showDSTopSellTNam(nam);
		}
	}

	public void showDSTopSellHomNay() {
		this.panelTopDoAn.removeAll();
		this.panelTopDoUong.removeAll();
		LocalDate now = LocalDate.now();

		labelTopTitleDoAn = new JLabel("Top đồ ăn");
		labelTopTitleDoAn.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoAn.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoAn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoAn.add(labelTopTitleDoAn);
		
		labelTopTitleDoUong = new JLabel("Top đồ uống");
		labelTopTitleDoUong.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoUong.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoUong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoUong.add(labelTopTitleDoUong);
		
		for (Food food : OUTLETS.getTopFoodToday()) {
			JLabel label = new JLabel(food.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoAn.add(label);
		}

		for (Beverage beverage : OUTLETS.getTopBeverageToday()) {
			JLabel label = new JLabel(beverage.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoUong.add(label);
		}
	}
	
	public void showDSTopSellTuan(int week, int month, int year) {
		this.panelTopDoAn.removeAll();
		this.panelTopDoUong.removeAll();

		labelTopTitleDoAn = new JLabel("Top đồ ăn");
		labelTopTitleDoAn.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoAn.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoAn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoAn.add(labelTopTitleDoAn);
		
		labelTopTitleDoUong = new JLabel("Top đồ uống");
		labelTopTitleDoUong.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoUong.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoUong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoUong.add(labelTopTitleDoUong);
		
		for (Food food : OUTLETS.getTopFoodByWeekOfMonth(week, month, year)) {
			JLabel label = new JLabel(food.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoAn.add(label);
		}

		for (Beverage beverage : OUTLETS.getTopBeverageByWeekOfMonth(week, month, year)) {
			JLabel label = new JLabel(beverage.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoUong.add(label);
		}
	}
	
	public void showDSTopSellThang(int month, int year) {
		this.panelTopDoAn.removeAll();
		this.panelTopDoUong.removeAll();

		labelTopTitleDoAn = new JLabel("Top đồ ăn");
		labelTopTitleDoAn.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoAn.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoAn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoAn.add(labelTopTitleDoAn);
		
		labelTopTitleDoUong = new JLabel("Top đồ uống");
		labelTopTitleDoUong.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoUong.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoUong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoUong.add(labelTopTitleDoUong);
		
		for (Food food : OUTLETS.getTopFoodByMonth(month, year)) {
			JLabel label = new JLabel(food.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoAn.add(label);
		}

		for (Beverage beverage : OUTLETS.getTopBeverageByMonth(month, year)) {
			JLabel label = new JLabel(beverage.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoUong.add(label);
		}
	}
	
	public void showDSTopSellTNam(int year) {
		this.panelTopDoAn.removeAll();
		this.panelTopDoUong.removeAll();

		labelTopTitleDoAn = new JLabel("Top đồ ăn");
		labelTopTitleDoAn.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoAn.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoAn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoAn.add(labelTopTitleDoAn);
		
		labelTopTitleDoUong = new JLabel("Top đồ uống");
		labelTopTitleDoUong.setHorizontalAlignment(SwingConstants.CENTER);
		labelTopTitleDoUong.setPreferredSize(new Dimension(350, 35));
		labelTopTitleDoUong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTopDoUong.add(labelTopTitleDoUong);
		
		for (Food food : OUTLETS.getTopFoodByYear(year)) {
			JLabel label = new JLabel(food.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoAn.add(label);
		}

		for (Beverage beverage : OUTLETS.getTopBeverageByYear(year)) {
			JLabel label = new JLabel(beverage.toString());
			label.setPreferredSize(new Dimension(250, 60));
			panelTopDoUong.add(label);
		}
	}

	public void update() {
		showDTHomNay();
		showDTTuan();
		showDTThang();
		showDTNam();
		LocalDate now = LocalDate.now();
		// Tính toán tuần thứ mấy
		int tuan = (now.getDayOfMonth() - 1) / 7 + 1;
		int thang = now.getMonthValue();
		int nam = now.getYear();
		comboBoxTuan.setSelectedIndex(tuan - 1);
		comboBoxThang.setSelectedIndex(thang - 1);
		comboBoxNam.setSelectedIndex(2023 - nam);
	}
}
