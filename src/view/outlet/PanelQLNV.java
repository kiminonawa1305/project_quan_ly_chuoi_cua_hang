package view.outlet;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import control.CareControlQLNV;
import control.ControlPanelQLNV;
import model.system.Date;
import model.system.Employee;
import model.system.NumericInputOnlyDocument;
import model.system.Sex;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class PanelQLNV extends JPanel {
	private ControlPanelQLNV control;
	private CareControlQLNV careControlQLNV;
	private JTextField passwordField;
	private JButton buttonEye, buttonDangNhap;
	private JPanel panelPasswordField, panelShowListNV;
	private JTextField textFieldID, textFieldHoTen, textFieldNgaySinh, textFieldDiaChi, textFieldSDT,
			textFieldLuongCoBan, textFieldNgayBD, textFieldSearchName, textFieldSearchID, textFieldSearchSDT;
	private JButton buttonLuu, buttonSearch;
	private Font fontLabel = new Font("Times New Roman", Font.BOLD, 20),
			fontInf = new Font("Times New Roman", Font.PLAIN, 15);
	private JComboBox<Sex> comboBoxGioiTinh;
	private List<Employee> listEmployees;
	private String pass;
	private JScrollPane scrollPane;
	private final Icon OPEN = new ImageIcon("icon\\open_eye_icon.png");
	private final Icon CLOSE = new ImageIcon("icon\\eye_close_icon.png");
	private final Icon EDIT = new ImageIcon("icon\\editIcon.png");
	private final Icon DELETE = new ImageIcon("icon\\remove_02.png");
	private Employee nvDangDuocSuaTT = null;

	/**
	 * Create the panel.
	 */
	public PanelQLNV(List<Employee> listEmployees, String pass) {
		this.pass = pass;
		this.listEmployees = listEmployees;
		this.init();
		this.event();
	}

	public JButton getButtonEyes() {
		return buttonEye;
	}

	public JButton getButtonLuu() {
		return buttonLuu;
	}

	public JButton getButtonSearch() {
		return buttonSearch;
	}

	public JButton getButtonDangNhap() {
		return buttonDangNhap;
	}

	public void init() {
		this.setLayout(new CardLayout());
		this.setBackground(new Color(228, 239, 231));

		control = new ControlPanelQLNV(this);
		careControlQLNV = new CareControlQLNV(this);

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

		// Phân show
		JPanel panelShowQLNV = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 30));
		panelShowQLNV.setBackground(new Color(228, 239, 231));
		this.add("show", panelShowQLNV);

		JPanel panelFrameShowListNV = new JPanel(new BorderLayout());
		panelFrameShowListNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		panelFrameShowListNV.setPreferredSize(new Dimension(1200, 550));
		panelFrameShowListNV.setBackground(Color.ORANGE);
		panelFrameShowListNV.setBorder(
				new TitledBorder(null, "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelShowQLNV.add(panelFrameShowListNV);

		JPanel panelSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		panelSearch.setBorder(new TitledBorder("Tìm kiếm"));
		panelSearch.setPreferredSize(new Dimension(10, 75));
		panelSearch.setBackground(Color.GRAY);
		panelFrameShowListNV.add(panelSearch, BorderLayout.NORTH);

		FlowLayout fl_panelTextFieldSearch = new FlowLayout(FlowLayout.LEFT);
		JPanel panelTextFieldSearch = new JPanel(fl_panelTextFieldSearch);
		panelTextFieldSearch.setOpaque(false);
		panelTextFieldSearch.setPreferredSize(new Dimension(950, 50));
		panelSearch.add(panelTextFieldSearch);

		textFieldSearchID = new JTextField();
		textFieldSearchID.setName("id");
		textFieldSearchID.setBorder(new TitledBorder("ID nhân viên"));
		textFieldSearchID.setPreferredSize(new Dimension(7, 40));
		textFieldSearchID.setColumns(20);
		panelTextFieldSearch.add(textFieldSearchID);

		textFieldSearchName = new JTextField();
		textFieldSearchName.setName("name");
		textFieldSearchName.setBorder(new TitledBorder("Họ tên"));
		textFieldSearchName.setPreferredSize(new Dimension(7, 40));
		panelTextFieldSearch.add(textFieldSearchName);
		textFieldSearchName.setColumns(20);

		textFieldSearchSDT = new JTextField();
		textFieldSearchSDT.setName("sdt");
		textFieldSearchSDT.setBorder(new TitledBorder("Số điện thoại"));
		textFieldSearchSDT.setPreferredSize(new Dimension(7, 40));
		textFieldSearchSDT.setColumns(20);
		panelTextFieldSearch.add(textFieldSearchSDT);

		JPanel panelButtonSearch = new JPanel();
		panelButtonSearch.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panelButtonSearch.getLayout();
		flowLayout_3.setHgap(10);
		panelButtonSearch.setPreferredSize(new Dimension(190, 50));
		panelSearch.add(panelButtonSearch);

		buttonSearch = new JButton("Tìm kiếm");
		buttonSearch.setFont(new Font("Times New Roman", Font.BOLD, 17));
		buttonSearch.setForeground(Color.WHITE);
		buttonSearch.setBackground(new Color(6, 68, 32));
		buttonSearch.setPreferredSize(new Dimension(150, 35));
		panelButtonSearch.add(buttonSearch);

		JPanel panelListNV = new JPanel(new BorderLayout());
		panelFrameShowListNV.add(panelListNV, BorderLayout.CENTER);

		JPanel panelLaybel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 2));
		panelLaybel.setPreferredSize(new Dimension(10, 35));
		panelLaybel.setBackground(new Color(6, 68, 32));
		panelListNV.add(panelLaybel, BorderLayout.NORTH);

		JLabel labelID = new JLabel("ID NV");
		labelID.setHorizontalAlignment(SwingConstants.CENTER);
		labelID.setFont(fontLabel);
		labelID.setForeground(Color.WHITE);
		labelID.setPreferredSize(new Dimension(100, 30));
		panelLaybel.add(labelID);

		JLabel labelTen = new JLabel("Họ tên");
		labelTen.setHorizontalAlignment(SwingConstants.CENTER);
		labelTen.setFont(fontLabel);
		labelTen.setForeground(Color.WHITE);
		labelTen.setPreferredSize(new Dimension(150, 30));
		panelLaybel.add(labelTen);

		JLabel labelNgaySinh = new JLabel("Ngày sinh");
		labelNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		labelNgaySinh.setFont(fontLabel);
		labelNgaySinh.setForeground(Color.WHITE);
		labelNgaySinh.setPreferredSize(new Dimension(100, 30));
		panelLaybel.add(labelNgaySinh);

		JLabel labelGioiTInh = new JLabel("Giới tính");
		labelGioiTInh.setHorizontalAlignment(SwingConstants.CENTER);
		labelGioiTInh.setFont(fontLabel);
		labelGioiTInh.setForeground(Color.WHITE);
		labelGioiTInh.setPreferredSize(new Dimension(100, 30));
		panelLaybel.add(labelGioiTInh);

		JLabel labelDiaChi = new JLabel("Địa chỉ");
		labelDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		labelDiaChi.setFont(fontLabel);
		labelDiaChi.setForeground(Color.WHITE);
		labelDiaChi.setPreferredSize(new Dimension(180, 30));
		panelLaybel.add(labelDiaChi);

		JLabel labelSDT = new JLabel("Số điện thoại");
		labelSDT.setHorizontalAlignment(SwingConstants.CENTER);
		labelSDT.setFont(fontLabel);
		labelSDT.setForeground(Color.WHITE);
		labelSDT.setPreferredSize(new Dimension(150, 30));
		panelLaybel.add(labelSDT);

		JLabel labelLuongCB = new JLabel("Lương cơ bản");
		labelLuongCB.setHorizontalAlignment(SwingConstants.CENTER);
		labelLuongCB.setFont(fontLabel);
		labelLuongCB.setForeground(Color.WHITE);
		labelLuongCB.setPreferredSize(new Dimension(125, 30));
		panelLaybel.add(labelLuongCB);

		JLabel labelNgayBD = new JLabel("Ngày bắt đầu");
		labelNgayBD.setHorizontalAlignment(SwingConstants.CENTER);
		labelNgayBD.setFont(fontLabel);
		labelNgayBD.setForeground(Color.WHITE);
		labelNgayBD.setPreferredSize(new Dimension(125, 30));
		panelLaybel.add(labelNgayBD);

		JLabel labelTuyChinh = new JLabel("Tùy chỉnh");
		labelTuyChinh.setHorizontalAlignment(SwingConstants.CENTER);
		labelTuyChinh.setFont(fontLabel);
		labelTuyChinh.setForeground(Color.WHITE);
		labelTuyChinh.setPreferredSize(new Dimension(150, 30));
		panelLaybel.add(labelTuyChinh);

		scrollPane = new JScrollPane();
		panelListNV.add(scrollPane, BorderLayout.CENTER);
		createListNV();
		scrollPane.setViewportView(panelShowListNV);

		JPanel panelThongTinNhanVien = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 0));
		panelThongTinNhanVien.setBorder(
				new TitledBorder(null, "Thông tin nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelThongTinNhanVien.setPreferredSize(new Dimension(1200, 140));
		panelThongTinNhanVien.setBackground(new Color(192, 192, 192));
		panelShowQLNV.add(panelThongTinNhanVien);

		JPanel panelLayThongTin = new JPanel();
		panelLayThongTin.setOpaque(false);
		FlowLayout fl_panelLayThongTin = (FlowLayout) panelLayThongTin.getLayout();
		fl_panelLayThongTin.setVgap(8);
		fl_panelLayThongTin.setHgap(25);
		fl_panelLayThongTin.setAlignment(FlowLayout.LEFT);
		panelLayThongTin.setPreferredSize(new Dimension(950, 130));
		panelThongTinNhanVien.add(panelLayThongTin);

		textFieldID = new JTextField(18);
		textFieldID.setPreferredSize(new Dimension(208, 45));
		textFieldID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldID.setBorder(new TitledBorder("ID nhân viên"));
		panelLayThongTin.add(textFieldID);

		textFieldHoTen = new JTextField(18);
		textFieldHoTen.setPreferredSize(new Dimension(208, 45));
		textFieldHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHoTen.setBorder(new TitledBorder("ID nhân viên"));
		panelLayThongTin.add(textFieldHoTen);

		textFieldNgaySinh = new JTextField(18);
		textFieldNgaySinh.setToolTipText("dd/mm/yyyy");
		textFieldNgaySinh.setPreferredSize(new Dimension(208, 45));
		textFieldNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldNgaySinh.setBorder(new TitledBorder("Ngày sinh"));
		panelLayThongTin.add(textFieldNgaySinh);

		comboBoxGioiTinh = new JComboBox<Sex>();
		comboBoxGioiTinh.addItem(Sex.NAM);
		comboBoxGioiTinh.addItem(Sex.NU);
		comboBoxGioiTinh.addItem(Sex.KHAC);
		comboBoxGioiTinh.setBorder(new TitledBorder("Giới tính"));
		comboBoxGioiTinh.setPreferredSize(new Dimension(208, 45));
		panelLayThongTin.add(comboBoxGioiTinh);

		textFieldDiaChi = new JTextField(18);
		textFieldDiaChi.setPreferredSize(new Dimension(208, 45));
		textFieldDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldDiaChi.setBorder(new TitledBorder("Địa chỉ"));
		panelLayThongTin.add(textFieldDiaChi);

		textFieldSDT = new JTextField(new NumericInputOnlyDocument(), null, 18);
		textFieldSDT.setPreferredSize(new Dimension(208, 45));
		textFieldSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldSDT.setBorder(new TitledBorder("Số điện thoại"));
		panelLayThongTin.add(textFieldSDT);

		textFieldLuongCoBan = new JTextField(new NumericInputOnlyDocument(), null, 18);
		textFieldLuongCoBan.setPreferredSize(new Dimension(208, 45));
		textFieldLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldLuongCoBan.setBorder(new TitledBorder("Lương cơ bản"));
		panelLayThongTin.add(textFieldLuongCoBan);

		textFieldNgayBD = new JTextField(18);
		textFieldNgayBD.setToolTipText("dd/mm/yyyy");
		textFieldNgayBD.setPreferredSize(new Dimension(208, 45));
		textFieldNgayBD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldNgayBD.setBorder(new TitledBorder("Ngày bắt đầu"));
		panelLayThongTin.add(textFieldNgayBD);

		JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 25));
		panelButton.setOpaque(false);
		panelButton.setPreferredSize(new Dimension(160, 130));
		panelThongTinNhanVien.add(panelButton);

		buttonLuu = new JButton("Lưu");
		buttonLuu.setForeground(new Color(255, 255, 255));
		buttonLuu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		buttonLuu.setBackground(Color.decode("#064420"));
		buttonLuu.setPreferredSize(new Dimension(125, 55));
		panelButton.add(buttonLuu);
	}

	public void event() {
		this.buttonEye.addActionListener(control);
		this.buttonDangNhap.addActionListener(control);
		passwordField.registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhap();

			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		this.buttonSearch.addActionListener(control);
		this.buttonLuu.addActionListener(control);
		textFieldSearchID.addCaretListener(careControlQLNV);
		textFieldSearchName.addCaretListener(careControlQLNV);
		textFieldSearchSDT.addCaretListener(careControlQLNV);
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

	public void createListNV() {
		panelShowListNV = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
		panelShowListNV.setPreferredSize(new Dimension(1170, listEmployees.size() * 60));
		for (Employee employee : this.listEmployees) {
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
			panel.setBackground(new Color(250, 241, 230));
			panel.setPreferredSize(new Dimension(1180, 50));
			panelShowListNV.add(panel);

			JLabel lb1 = new JLabel(employee.getId());
			lb1.setHorizontalAlignment(SwingConstants.CENTER);
			lb1.setFont(fontInf);
			lb1.setPreferredSize(new Dimension(100, 48));
			panel.add(lb1);

			JLabel lb2 = new JLabel(employee.getName());
			lb2.setHorizontalAlignment(SwingConstants.CENTER);
			lb2.setFont(fontInf);
			lb2.setPreferredSize(new Dimension(150, 48));
			panel.add(lb2);

			JLabel lb3 = new JLabel();
			if (employee.getBirthDate() == null) {
				lb3.setText(null);
			} else {
				lb3.setText(employee.getBirthDate().toString());
			}
			lb3.setHorizontalAlignment(SwingConstants.CENTER);
			lb3.setFont(fontInf);
			lb3.setPreferredSize(new Dimension(100, 48));
			panel.add(lb3);

			JLabel lb4 = new JLabel(employee.getSex().toString());
			lb4.setHorizontalAlignment(SwingConstants.CENTER);
			lb4.setFont(fontInf);
			lb4.setPreferredSize(new Dimension(100, 48));
			panel.add(lb4);

			JLabel lb5 = new JLabel(employee.getAddress());
			lb5.setHorizontalAlignment(SwingConstants.CENTER);
			lb5.setFont(fontInf);
			lb5.setPreferredSize(new Dimension(180, 48));
			panel.add(lb5);

			JLabel lb6 = new JLabel(employee.getNumberPhone());
			lb6.setHorizontalAlignment(SwingConstants.CENTER);
			lb6.setFont(fontInf);
			lb6.setPreferredSize(new Dimension(150, 48));
			panel.add(lb6);

			JLabel lb7 = new JLabel(employee.getBaseSalary() + "");
			lb7.setHorizontalAlignment(SwingConstants.CENTER);
			lb7.setFont(fontInf);
			lb7.setPreferredSize(new Dimension(125, 48));
			panel.add(lb7);

			JLabel lb8 = new JLabel(employee.getDateStart().toString());
			lb8.setHorizontalAlignment(SwingConstants.CENTER);
			lb8.setFont(fontInf);
			lb8.setPreferredSize(new Dimension(125, 48));
			panel.add(lb8);

			JPanel panelTuyChinh = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 2));
			panelTuyChinh.setOpaque(false);
			panelTuyChinh.setPreferredSize(new Dimension(150, 48));
			panelTuyChinh.setFont(fontLabel);
			panelTuyChinh.setForeground(Color.WHITE);
			panel.add(panelTuyChinh);

			JButton buttonSua = new JButton(EDIT);
			buttonSua.addActionListener(control);
			buttonSua.setActionCommand("sua	" + employee.getId());
			buttonSua.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonSua);

			JButton buttonXoa = new JButton(DELETE);
			buttonXoa.addActionListener(control);
			buttonXoa.setActionCommand("xoa	" + employee.getId());
			buttonXoa.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonXoa);
		}
	}

	public void createSearchList(List<Employee> employees) {
		panelShowListNV = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
		panelShowListNV.setPreferredSize(new Dimension(1170, employees.size() * 60));
		for (Employee employee : employees) {
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
			panel.setBackground(new Color(250, 241, 230));
			panel.setPreferredSize(new Dimension(1180, 50));
			panelShowListNV.add(panel);

			JLabel lb1 = new JLabel(employee.getId());
			lb1.setHorizontalAlignment(SwingConstants.CENTER);
			lb1.setFont(fontInf);
			lb1.setPreferredSize(new Dimension(100, 48));
			panel.add(lb1);

			JLabel lb2 = new JLabel(employee.getName());
			lb2.setHorizontalAlignment(SwingConstants.CENTER);
			lb2.setFont(fontInf);
			lb2.setPreferredSize(new Dimension(150, 48));
			panel.add(lb2);

			JLabel lb3 = new JLabel();
			if (employee.getBirthDate() == null) {
				lb3.setText(null);
			} else {
				lb3.setText(employee.getBirthDate().toString());
			}
			lb3.setHorizontalAlignment(SwingConstants.CENTER);
			lb3.setFont(fontInf);
			lb3.setPreferredSize(new Dimension(100, 48));
			panel.add(lb3);

			JLabel lb4 = new JLabel(employee.getSex().toString());
			lb4.setHorizontalAlignment(SwingConstants.CENTER);
			lb4.setFont(fontInf);
			lb4.setPreferredSize(new Dimension(100, 48));
			panel.add(lb4);

			JLabel lb5 = new JLabel(employee.getAddress());
			lb5.setHorizontalAlignment(SwingConstants.CENTER);
			lb5.setFont(fontInf);
			lb5.setPreferredSize(new Dimension(180, 48));
			panel.add(lb5);

			JLabel lb6 = new JLabel(employee.getNumberPhone());
			lb6.setHorizontalAlignment(SwingConstants.CENTER);
			lb6.setFont(fontInf);
			lb6.setPreferredSize(new Dimension(150, 48));
			panel.add(lb6);

			JLabel lb7 = new JLabel(employee.getBaseSalary() + "");
			lb7.setHorizontalAlignment(SwingConstants.CENTER);
			lb7.setFont(fontInf);
			lb7.setPreferredSize(new Dimension(125, 48));
			panel.add(lb7);

			JLabel lb8 = new JLabel(employee.getDateStart().toString());
			lb8.setHorizontalAlignment(SwingConstants.CENTER);
			lb8.setFont(fontInf);
			lb8.setPreferredSize(new Dimension(125, 48));
			panel.add(lb8);

			JPanel panelTuyChinh = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 2));
			panelTuyChinh.setOpaque(false);
			panelTuyChinh.setPreferredSize(new Dimension(150, 48));
			panelTuyChinh.setFont(fontLabel);
			panelTuyChinh.setForeground(Color.WHITE);
			panel.add(panelTuyChinh);

			JButton buttonSua = new JButton(EDIT);
			buttonSua.setActionCommand("sua\t" + employee.getId());
			buttonSua.addActionListener(control);
			buttonSua.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonSua);

			JButton buttonXoa = new JButton(DELETE);
			buttonXoa.setActionCommand("xoa\t" + employee.getId());
			buttonXoa.addActionListener(control);
			buttonXoa.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonXoa);
		}
	}

	// Xóa nhân viên
	public void xoaNhanVien(JButton button) {
		// Duyệt qua các phần tử của tập hợp bằng Iterator và sử dụng remove() để xóa các phần tử
		Iterator<Employee> iterator = listEmployees.iterator();
		while (iterator.hasNext()) {
		    Employee employee = iterator.next();
		    if (employee.equalsID(button.getActionCommand().split("\t")[1])) {
		      
		        int dialogResult = JOptionPane.showInternalConfirmDialog(null, "Bạn có muốn xóa nhân viên có ID: " + employee.getId() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
		        if (dialogResult == JOptionPane.YES_OPTION) {
		        	  iterator.remove(); // Xóa phần tử "b" khỏi tập hợp
		        } else {
		            return;
		        }

		    }
		}


		createSearchList(this.listEmployees);
		scrollPane.setViewportView(panelShowListNV);
	}

	// Sửa nhân viên
	public void suaNhanVien(JButton button) {
		for (Employee employee : this.listEmployees) {
			if (employee.equalsID(button.getActionCommand().split("\t")[1])) {
				this.textFieldID.setText(employee.getId());
				this.textFieldID.setEditable(false);
				this.textFieldHoTen.setText(employee.getName());
				if (employee.getBirthDate() != null) {
					this.textFieldNgaySinh.setText(employee.getBirthDate().toString());
				}
				this.comboBoxGioiTinh.setSelectedItem(employee.getSex());
				this.textFieldDiaChi.setText(employee.getAddress());
				this.textFieldSDT.setText(employee.getNumberPhone());
				this.textFieldLuongCoBan.setText("" + employee.getBaseSalary() + "");
				this.textFieldNgayBD.setText(employee.getDateStart().toString());
				this.buttonLuu.setActionCommand("luu sua");
				nvDangDuocSuaTT = employee;
			}
		}
	}

	public void luuSua() {
		try {
			nvDangDuocSuaTT.setName(this.textFieldHoTen.getText());
			nvDangDuocSuaTT.setBirthDate(new Date(this.textFieldNgaySinh.getText()));
			nvDangDuocSuaTT.setSex((Sex) this.comboBoxGioiTinh.getSelectedItem());
			nvDangDuocSuaTT.setAddress(this.textFieldDiaChi.getText());
			nvDangDuocSuaTT.setNumberPhone(this.textFieldSDT.getText());
			nvDangDuocSuaTT.setBaseSalary(Integer.parseInt(this.textFieldLuongCoBan.getText()));
			nvDangDuocSuaTT.setDateStart(new Date(this.textFieldNgayBD.getText()));

			this.textFieldID.setText("");
			this.textFieldID.setEditable(true);
			this.textFieldHoTen.setText("");
			this.textFieldNgaySinh.setText("");
			this.comboBoxGioiTinh.setSelectedItem(Sex.NAM);
			this.textFieldDiaChi.setText("");
			this.textFieldSDT.setText("");
			this.textFieldLuongCoBan.setText("");
			this.textFieldNgayBD.setText("");
			this.buttonLuu.setActionCommand("them");
			nvDangDuocSuaTT = null;

			createSearchList(this.listEmployees);
			scrollPane.setViewportView(panelShowListNV);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi kiểu dữ liệu đầu vào", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Thêm nhân viên
	public void themNhanVien() {
		if (!this.textFieldID.getText().equals("") && !hasEmployee(this.textFieldID.getText())) {
			try {
				Employee em = new Employee();
				em.setId(this.textFieldID.getText());
				em.setName(this.textFieldHoTen.getText());
				if (textFieldNgaySinh.getText().equals("")) {
					em.setBirthDate(null);
				} else {
					em.setBirthDate(new Date(this.textFieldNgaySinh.getText()));
				}
				em.setSex((Sex) this.comboBoxGioiTinh.getSelectedItem());
				em.setAddress(this.textFieldDiaChi.getText());
				// kiểm tra trường sdt
				if (this.textFieldSDT.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Trường SDT đang bị trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					em.setNumberPhone(this.textFieldSDT.getText());
				}
				// Kiểm tra trường lương cơ bản
				if (this.textFieldLuongCoBan.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Trường tiền lương cb đang bị trống", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					em.setBaseSalary(Integer.parseInt(this.textFieldLuongCoBan.getText()));
				}
				// Nếu trường này bắt đầu bó tróng thì đó là ngày hôm nay
				if (textFieldNgayBD.getText().equals("")) {
					LocalDate now = LocalDate.now();
					em.setDateStart(new Date(now.getDayOfMonth(), now.getMonthValue(), now.getYear()));
				} else {
					em.setDateStart(new Date(this.textFieldNgayBD.getText()));
				}
				this.listEmployees.add(em);

				this.textFieldID.setText("");
				this.textFieldHoTen.setText("");
				this.textFieldNgaySinh.setText("");
				this.comboBoxGioiTinh.setSelectedItem(Sex.NAM);
				this.textFieldDiaChi.setText("");
				this.textFieldSDT.setText("");
				this.textFieldLuongCoBan.setText("");
				this.textFieldNgayBD.setText("");

				createSearchList(this.listEmployees);
				scrollPane.setViewportView(panelShowListNV);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi kiểu dữ liệu đầu vào", "Lỗi", JOptionPane.ERROR_MESSAGE);
				System.out.println(e);
			}
		} else {
			if (!this.textFieldID.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Trường id đang bị trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Nhân viên có số id trên đã tồn tại trong hệ thông", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public boolean hasEmployee(String id) {
		for (Employee em : this.listEmployees) {
			if (em.getId().equals(id)) {
				return true;
			}
		}

		return false;
	}

	public void dangNhap() {
		if (this.passwordField.getText().equals(this.pass)) {
			((CardLayout) this.getLayout()).show(this, "show");
			this.passwordField.setText("");
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Sai mật khẩu", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void close() {
		((CardLayout) this.getLayout()).show(this, "pass");
	}

	/**
	 * find NV by TextFiled
	 */
	public void findNVByTextField() {
		if (textFieldSearchID.getText().equals("") && textFieldSearchName.getText().equals("")
				&& textFieldSearchSDT.getText().equals("")) {
			createListNV();
			scrollPane.setViewportView(panelShowListNV);
		} else {
			ArrayList<Employee> listEmployee = new ArrayList<>();

			// Tìm theo id
			if (!textFieldSearchID.getText().equals("") && textFieldSearchName.getText().equals("")
					&& textFieldSearchSDT.getText().equals("")) {
				for (Employee em : this.listEmployees) {
					if (em.getId().indexOf(textFieldSearchID.getText()) >= 0) {
						listEmployee.add(em);
					}
				}
			}

			// Tìm theo tên
			if (textFieldSearchID.getText().equals("") && !textFieldSearchName.getText().equals("")
					&& textFieldSearchSDT.getText().equals("")) {
				for (Employee em : this.listEmployees) {
					if (em.getName().indexOf(textFieldSearchName.getText()) >= 0) {
						listEmployee.add(em);
					}
				}
			}

			// Tìm theo số điện thoại
			if (textFieldSearchID.getText().equals("") && textFieldSearchName.getText().equals("")
					&& !textFieldSearchSDT.getText().equals("")) {
				for (Employee em : this.listEmployees) {
					if (em.getNumberPhone().indexOf(textFieldSearchSDT.getText()) >= 0) {
						listEmployee.add(em);
					}
				}
			}

			// Tìm theo id và tên
			if (!textFieldSearchID.getText().equals("") && !textFieldSearchName.getText().equals("")
					&& textFieldSearchSDT.getText().equals("")) {
				for (Employee em : this.listEmployees) {
					if (em.getId().indexOf(textFieldSearchID.getText()) >= 0
							&& em.getName().indexOf(textFieldSearchName.getText()) >= 0) {
						listEmployee.add(em);
					}
				}
			}

			// Tìm theo tên và số điện thoại
			if (textFieldSearchID.getText().equals("") && !textFieldSearchName.getText().equals("")
					&& !textFieldSearchSDT.getText().equals("")) {
				for (Employee em : this.listEmployees) {
					if (em.getName().indexOf(textFieldSearchName.getText()) >= 0
							&& em.getNumberPhone().indexOf(textFieldSearchSDT.getText()) >= 0) {
						listEmployee.add(em);
					}
				}
			}

			// Tìm theo id và số điện thoại
			if (!textFieldSearchID.getText().equals("") && textFieldSearchName.getText().equals("")
					&& !textFieldSearchSDT.getText().equals("")) {
				for (Employee em : this.listEmployees) {
					if (em.getId().indexOf(textFieldSearchID.getText()) >= 0
							&& em.getNumberPhone().indexOf(textFieldSearchSDT.getText()) >= 0) {
						listEmployee.add(em);
					}
				}
			}

			// Tìm theo id, tên và số điện thoại
			if (!textFieldSearchID.getText().equals("") && !textFieldSearchName.getText().equals("")
					&& !textFieldSearchSDT.getText().equals("")) {
				for (Employee em : this.listEmployees) {
					if (em.getId().indexOf(textFieldSearchID.getText()) >= 0
							&& em.getName().indexOf(textFieldSearchName.getText()) >= 0
							&& em.getNumberPhone().indexOf(textFieldSearchSDT.getText()) >= 0) {
						listEmployee.add(em);
					}
				}
			}

			createSearchList(listEmployee);
			scrollPane.setViewportView(panelShowListNV);
		}
	}
}
