package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.ControlPanelDoanhThu;
import model.system.Outlets;

public class PanelDoanhThu extends JPanel {
	private final Outlets OUTLETS;
	private final ControlPanelDoanhThu CONTROL;
	private JButton buttonDTHomNay, buttonDTTuan, buttonDTThang, buttonDTNam;
	private JComboBox comboBoxTuan, comboBoxThang, comboBoxNam;
	private JLabel labelTitle, labelIConMoney, labelTongDoanhThu, labelShowDoanhThu, labelTongHoaDong,
			labelShowTongHoaDon, labelDate;
	private Font fontButtonOption = new Font("Tahoma", Font.BOLD, 15);
	private List<JButton> listButtonOption = new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public PanelDoanhThu(Outlets outlets) {
		this.OUTLETS = outlets;
		this.CONTROL = new ControlPanelDoanhThu(this);
		this.init();
		this.event();
	}

	public void init() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
		this.setBackground(new Color(228, 239, 231));

		JPanel panelMain = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelMain.getLayout();
		flowLayout_1.setVgap(10);
		panelMain.setBackground(Color.WHITE);
		panelMain.setPreferredSize(new Dimension(1200, 710));
		this.add(panelMain);

		JLabel lblNewLabel = new JLabel("<html>Mã chi nhánh: " + OUTLETS.getID() + "<br>Địa chỉ: " + OUTLETS.getAddress() +"</html>");
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
		fl_panelFrameMainShowDT.setVgap(25);
		panelFrameMainShowDT.setOpaque(false);
		panelFrameMainShowDT.setPreferredSize(new Dimension(1000, 500));
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

		showDTHomNay();

		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(228, 239, 231));
		panelTop.setPreferredSize(new Dimension(350, 500));
		panelFrameMainShowDT.add(panelTop);
	}

	public void event() {
		this.buttonDTHomNay.addActionListener(CONTROL);
		this.buttonDTTuan.addActionListener(CONTROL);
		this.buttonDTThang.addActionListener(CONTROL);
		this.buttonDTNam.addActionListener(CONTROL);
		this.comboBoxTuan.addActionListener(CONTROL);
		this.comboBoxThang.addActionListener(CONTROL);
		this.comboBoxNam.addActionListener(CONTROL);
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
