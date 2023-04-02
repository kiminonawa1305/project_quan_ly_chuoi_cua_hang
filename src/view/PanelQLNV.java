package view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import control.CareControlQLNV;
import control.ControlPanelQLNV;
import model.system.Date;
import model.system.Employee;
import model.system.Outlets;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.DefaultComboBoxModel;

public class PanelQLNV extends JPanel {
	private ControlPanelQLNV control;
	private CareControlQLNV careControlQLNV;
	private JTextField passwordField;
	private JButton buttonXoa, buttonEdit; // Code Edit

	private JButton buttonEye, buttonDangNhap;
	private JPanel panelPasswordField, panelShowListNV;
	private JTextField textFieldID, textFieldHoTen, textFieldNgaySinh, textFieldDiaChi, textFieldSDT,
			textFieldLuongCoBan, textFieldNgayBD, textFieldSearchName, textFieldSearchID, textFieldSearchSDT;
	private JButton buttonLuu;
	private Font fontLabel = new Font("Times New Roman", Font.BOLD, 20),
			fontInf = new Font("Times New Roman", Font.PLAIN, 15);
	private JComboBox<String> comboBoxGioiTinh;
	private List<Employee> listEmployees;
	private String pass;
	private JScrollPane scrollPane;
	private final Icon OPEN = new ImageIcon("icon\\open_eye_icon.png");
	private final Icon CLOSE = new ImageIcon("icon\\eye_close_icon.png");
	private final Icon EDIT = new ImageIcon("icon\\editIcon.png");
	private final Icon DELETE = new ImageIcon("icon\\remove_02.png");
	private String idStep;
	private boolean coLenh = false;

	/**
	 * Create the panel.
	 */
	public PanelQLNV(List<Employee> listEmployees, String pass) {
		this.pass = pass;
		this.listEmployees = listEmployees;
		this.init();
		this.event();
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @return the buttonSua
	 */
	public JButton getButtonSua() {
		return buttonEdit;
	}

	/**
	 * @return the panelShowListNV
	 */
	public JPanel getPanelShowListNV() {
		return panelShowListNV;
	}

	/**
	 * code Edit check ID Employee
	 * 
	 * @param src
	 * @return
	 */
	public boolean checkIDEmlpoyee(String src) {
		for (Employee employee : listEmployees) {
			if (employee.getId().equals(src)) {
				return true;
			}
		}
		return false;
	}

	public JButton getButtonXoa() { // code Edit
		return buttonXoa;
	}

	/**
	 * @return the buttonXoa
	 */
	public JButton getButtonEyes() {
		return buttonEye;
	}

	public JButton getButtonLuu() {
		return buttonLuu;
	}

	public JButton getButtonDangNhap() {
		return buttonDangNhap;
	}

	/**
	 * @return the textFieldSearchName
	 */
	public JTextField getTextFieldSearchName() {
		return textFieldSearchName;
	}

	/**
	 * @return the textFieldSearchID
	 */
	public JTextField getTextFieldSearchID() {
		return textFieldSearchID;
	}

	/**
	 * @return the textFieldSearchSDT
	 */
	public JTextField getTextFieldSearchSDT() {
		return textFieldSearchSDT;
	}

	/**
	 * @return the listEmployees
	 */
	public List<Employee> getListEmployees() {
		return listEmployees;
	}
	
	/**
	 * @return the coLenh
	 */
	public boolean isCoLenh() {
		return coLenh;
	}

	/**
	 * @param coLenh the coLenh to set
	 */
	public void setCoLenh(boolean coLenh) {
		this.coLenh = coLenh;
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
		panelTextFieldSearch.setPreferredSize(new Dimension(750, 50)); // Code Edit
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
		panelButtonSearch.setPreferredSize(new Dimension(390, 50)); // Code Edit
		panelSearch.add(panelButtonSearch);
		
		/**
		 * phần hiển thị danh sách nhân viên
		 */
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
		textFieldHoTen.setBorder(new TitledBorder("Tên nhân viên")); // Code Edit
		panelLayThongTin.add(textFieldHoTen);

		textFieldNgaySinh = new JTextField(18);
		textFieldNgaySinh.setPreferredSize(new Dimension(208, 45));
		textFieldNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldNgaySinh.setBorder(new TitledBorder("Ngày sinh"));
		panelLayThongTin.add(textFieldNgaySinh);

		comboBoxGioiTinh = new JComboBox<>();
		comboBoxGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ", "Khác" }));
		comboBoxGioiTinh.setBorder(new TitledBorder("Giới tính"));
		comboBoxGioiTinh.setPreferredSize(new Dimension(208, 45));
		panelLayThongTin.add(comboBoxGioiTinh);

		textFieldDiaChi = new JTextField(18);
		textFieldDiaChi.setPreferredSize(new Dimension(208, 45));
		textFieldDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldDiaChi.setBorder(new TitledBorder("Địa chỉ"));
		panelLayThongTin.add(textFieldDiaChi);

		textFieldSDT = new JTextField(18);
		textFieldSDT.setPreferredSize(new Dimension(208, 45));
		textFieldSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldSDT.setBorder(new TitledBorder("Số điện thoại"));
		panelLayThongTin.add(textFieldSDT);

		textFieldLuongCoBan = new JTextField(18);
		textFieldLuongCoBan.setPreferredSize(new Dimension(208, 45));
		textFieldLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldLuongCoBan.setBorder(new TitledBorder("Lương cơ bản"));
		panelLayThongTin.add(textFieldLuongCoBan);

		textFieldNgayBD = new JTextField(18);
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

	/**
	 * Code Edit
	 */
	public void event() {
		this.buttonEye.addActionListener(control);
		passwordField.registerKeyboardAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhap();

			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		enterFieldAdd();

		this.buttonLuu.addActionListener(control);
		this.buttonDangNhap.addActionListener(control);
		this.buttonEdit.addActionListener(control);

		this.buttonXoa.addActionListener(control);
		textFieldSearchID.addCaretListener(careControlQLNV);
		textFieldSearchName.addCaretListener(careControlQLNV);
		textFieldSearchSDT.addCaretListener(careControlQLNV);
	}

	/**
	 * Code Edit tao su kien cho JTextField by Enter
	 * 
	 * @param button
	 */
	private void enterFieldAdd() {
		ArrayList<JTextField> fieldEnter = new ArrayList<>();
		fieldEnter.add(textFieldID);
		fieldEnter.add(textFieldHoTen);
		fieldEnter.add(textFieldNgaySinh);
		fieldEnter.add(textFieldDiaChi);
		fieldEnter.add(textFieldSDT);
		fieldEnter.add(textFieldLuongCoBan);
		fieldEnter.add(textFieldNgayBD);
		for (JTextField jTextField : fieldEnter) {
			jTextField.registerKeyboardAction(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					buttonLuu.doClick();
				}
			}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		}
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

			JLabel lb3 = new JLabel(employee.getBirthDate().toString());
			lb3.setHorizontalAlignment(SwingConstants.CENTER);
			lb3.setFont(fontInf);
			lb3.setPreferredSize(new Dimension(100, 48));
			panel.add(lb3);

			JLabel lb4 = new JLabel(employee.getSex());
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

			buttonEdit = new JButton(EDIT);
			buttonEdit.setActionCommand(employee.getId());
			buttonEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton jButton = (JButton) e.getSource();
					if (jButton.getActionCommand().equals(employee.getId())) {
						putInTheEditPlace(jButton, employee);
						idStep = employee.getId();
						coLenh = true;
					}
					
				}
			});
			buttonEdit.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonEdit);

			buttonXoa = new JButton(DELETE);
			buttonXoa.setActionCommand(employee.getId());
			buttonXoa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					listEmployees.remove(employee);
					panelShowListNV.remove(panel);
					panelShowListNV.revalidate();
					panelShowListNV.repaint();

				}
			});
			buttonXoa.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonXoa);
		}
	}

	/*
	 * Code Edit
	 */
	public void createSearchList(List<Employee> list) {
		panelShowListNV = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
		panelShowListNV.setPreferredSize(new Dimension(1170, list.size() * 60));
		for (Employee employee : list) {
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

			JLabel lb3 = new JLabel(employee.getBirthDate().toString());
			lb3.setHorizontalAlignment(SwingConstants.CENTER);
			lb3.setFont(fontInf);
			lb3.setPreferredSize(new Dimension(100, 48));
			panel.add(lb3);

			JLabel lb4 = new JLabel(employee.getSex());
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

			buttonEdit = new JButton(EDIT);
			buttonEdit.setActionCommand(employee.getId());
			buttonEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton jButton = (JButton) e.getSource();
					if (jButton.getActionCommand().equals(employee.getId())) {
						putInTheEditPlace(jButton, employee);
						idStep = employee.getId();
						coLenh = true;
					}
					
				}
			});
			buttonEdit.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonEdit);

			buttonXoa = new JButton(DELETE);
			buttonXoa.setActionCommand(employee.getId());
			buttonXoa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					listEmployees.remove(employee);
					panelShowListNV.remove(panel);
					panelShowListNV.revalidate();
					panelShowListNV.repaint();

				}
			});
			buttonXoa.setPreferredSize(new Dimension(45, 45));
			panelTuyChinh.add(buttonXoa);
		}
		// repaint panel list NV
		panelShowListNV.revalidate();
		panelShowListNV.repaint();

	}

	/*
	 * Put in the edit place
	 */
	public void putInTheEditPlace(JButton jButton, Employee e) {
		if (jButton.getActionCommand().equals(e.getId())) {
			textFieldID.setText(e.getId());
			textFieldHoTen.setText(e.getName());
			textFieldNgaySinh.setText(e.getBirthDate().toString());
			comboBoxGioiTinh.setSelectedItem(e.getSex());
			textFieldDiaChi.setText(e.getAddress());
			textFieldSDT.setText(e.getNumberPhone());
			textFieldLuongCoBan.setText(String.valueOf(e.getBaseSalary()));
			textFieldNgayBD.setText(e.getDateStart().toString());
			idStep = this.textFieldID.getText();
		}
	}

	/**
	 * Edit employee
	 */
	public void editEmployee() {
		try {
			int count = 0;
			for (Employee employee : this.listEmployees) {
				if (employee.getId().equals(this.idStep)) {
					for (Employee employee_01 : listEmployees) {
						count++;
						if(!this.textFieldID.getText().equals(employee_01.getId())){
							SetNV(employee);
							return;
						} 
					}
					if(count == this.listEmployees.size()){
						this.coLenh = true;
						JOptionPane.showMessageDialog(new JFrame(), "ID Nhân viên đã có", "Lỗi", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Lỗi sai kiểu dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
			
	}

	private void SetNV(Employee e) {
		e.setId(this.textFieldID.getText());
		e.setName(this.textFieldHoTen.getText());
		e.setBirthDate(new Date(this.textFieldNgaySinh.getText()));
		e.setSex((String) this.comboBoxGioiTinh.getSelectedItem());
		e.setAddress(this.textFieldDiaChi.getText());
		e.setNumberPhone(this.textFieldSDT.getText());
		e.setBaseSalary(Double.valueOf(this.textFieldLuongCoBan.getText()));
		e.setDateStart(new Date(this.textFieldNgayBD.getText()));
		
		createListNV();
		scrollPane.setViewportView(panelShowListNV);
		this.coLenh = false;
	}

	/**
	 * add employees
	 */
	public void themNhanVien() {
		try {

			if (!isHasEmployee(this.listEmployees)) {
				this.listEmployees.add(new Employee(this.textFieldID.getText(), this.textFieldHoTen.getText(),
						new Date(this.textFieldNgaySinh.getText()), (String) this.comboBoxGioiTinh.getSelectedItem(),
						this.textFieldDiaChi.getText(), this.textFieldSDT.getText(),
						Double.parseDouble(this.textFieldLuongCoBan.getText()),
						new Date(this.textFieldNgayBD.getText())));
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Nhân viên đã có", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Lỗi sai kiểu dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}

		// repaint panel list NV
		createListNV();
		scrollPane.setViewportView(panelShowListNV);
	}

	/**
	 * Code Edit check ID NV
	 */
	private boolean isHasEmployee(List<Employee> list) {
		for (Employee employee : list) {

			if (employee.getId().equals(this.textFieldID.getText())) {
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
		ArrayList<Employee> listEmployee = new ArrayList<>();
		if (!getTextFieldSearchID().getText().equals("") || !getTextFieldSearchName().getText().equals("")
				|| !getTextFieldSearchSDT().getText().equals("")) {
			/*
			 * start ID
			 */
			if (!getTextFieldSearchID().getText().equals("")) {
				// name and phone number null
				if (getTextFieldSearchName().getText().equals("") && getTextFieldSearchSDT().getText().equals("")) {

					for (Employee em : getListEmployees()) {
						if (em.getId().indexOf(getTextFieldSearchID().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				// name not null and phone number null
				if (!getTextFieldSearchName().getText().equals("") && getTextFieldSearchSDT().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if (em.getId().indexOf(getTextFieldSearchID().getText()) >= 0
								&& em.getName().indexOf(getTextFieldSearchName().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				// name null and phone number not null
				if (getTextFieldSearchName().getText().equals("") && !getTextFieldSearchSDT().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if (em.getId().indexOf(getTextFieldSearchID().getText()) >= 0
								&& em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				// name and phone number not null
				if (!getTextFieldSearchName().getText().equals("") && !getTextFieldSearchSDT().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if ((em.getId().indexOf(getTextFieldSearchID().getText()) >= 0
								&& em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0
								&& em.getName().indexOf(getTextFieldSearchName().getText()) >= 0)) {

							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				createSearchList(listEmployee);
				getScrollPane().setViewportView(getPanelShowListNV());
				if (listEmployee.size() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Không tìm thấy nhân viên", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
			/*
			 * start Phone number
			 */
			if (!getTextFieldSearchSDT().getText().equals("")) {
				// name and ID null
				if (getTextFieldSearchName().getText().equals("") && getTextFieldSearchID().getText().equals("")) {

					for (Employee em : getListEmployees()) {
						if (em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}

					}
				}
				// name not null and ID null
				if (!getTextFieldSearchName().getText().equals("") && getTextFieldSearchID().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if (em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0
								&& em.getName().indexOf(getTextFieldSearchName().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				// name null and ID not null
				if (getTextFieldSearchName().getText().equals("") && !getTextFieldSearchID().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if (em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0
								&& em.getId().indexOf(getTextFieldSearchID().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				// name and ID not null
				if (!getTextFieldSearchName().getText().equals("") && !getTextFieldSearchID().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if ((em.getId().indexOf(getTextFieldSearchID().getText()) >= 0
								&& em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0
								&& em.getName().indexOf(getTextFieldSearchName().getText()) >= 0)) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				createSearchList(listEmployee);
				getScrollPane().setViewportView(getPanelShowListNV());
				if (listEmployee.size() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Không tìm thấy nhân viên", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			/*
			 * start Name
			 */
			if (!getTextFieldSearchName().getText().equals("")) {
				// ID and phone number null
				if (getTextFieldSearchID().getText().equals("") && getTextFieldSearchSDT().getText().equals("")) {

					for (Employee em : getListEmployees()) {
						if (em.getName().indexOf(getTextFieldSearchName().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}

					}
				}
				// ID not null and phone number null
				if (!getTextFieldSearchID().getText().equals("") && getTextFieldSearchSDT().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if (em.getId().indexOf(getTextFieldSearchID().getText()) >= 0
								&& em.getName().indexOf(getTextFieldSearchName().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				// ID null and phone number not null
				if (getTextFieldSearchID().getText().equals("") && !getTextFieldSearchSDT().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if (em.getName().indexOf(getTextFieldSearchName().getText()) >= 0
								&& em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0) {
							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				// ID and phone number not null
				if (!getTextFieldSearchID().getText().equals("") && !getTextFieldSearchSDT().getText().equals("")) {
					for (Employee em : getListEmployees()) {
						if ((em.getId().indexOf(getTextFieldSearchID().getText()) >= 0
								&& em.getNumberPhone().indexOf(getTextFieldSearchSDT().getText()) >= 0
								&& em.getName().indexOf(getTextFieldSearchName().getText()) >= 0)) {

							if (!listEmployee.contains(em)) {
								listEmployee.add(em);
							}
						}
					}
				}
				
				createSearchList(listEmployee);
				getScrollPane().setViewportView(getPanelShowListNV());
				if (listEmployee.size() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Không tìm thấy nhân viên", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		} else {
			
			createListNV();
			getScrollPane().setViewportView(getPanelShowListNV());
		}

	}

}