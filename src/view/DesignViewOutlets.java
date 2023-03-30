package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import control.ControlViewOutlets;
import model.beverage.Beverage;
import model.beverage.BeverageDecorator;
import model.beverage.Caffe;
import model.beverage.MilkTea;
import model.beverage.OtherBeverage;
import model.beverage.OtherToppingBeverage;
import model.beverage.Soda;
import model.beverage.Sugar;
import model.food.BanhMi;
import model.food.Food;
import model.food.FoodDecorator;
import model.food.FriedChicken;
import model.food.OtherFood;
import model.food.OtherToppingFood;
import model.food.Pizza;
import model.system.Bill;
import model.system.Date;
import model.system.Employee;
import model.system.Outlets;

public class DesignViewOutlets extends JFrame {
	private Outlets outlets;
	private PanelQLNV panelQLNV;
	private PanelMenuSanPham panelMenuSanPham;
	private JPanel contentPane, panelCenter;
	private List<JButton> listButtonMainMenu = new ArrayList<>();
	private JButton buttonQLNV, buttonHoaDon, buttonDoanhThu, buttonMenu;
	private ControlViewOutlets control;
	private PanelHoaDon panelHoaDon;

	/**
	 * Create the frame.
	 */
	public DesignViewOutlets(Outlets outlets) {
		this.outlets = outlets;
		this.init();
		this.event();
		this.setVisible(true);
	}

	public JButton getButtonQLNV() {
		return buttonQLNV;
	}

	public JButton getButtonHoaDon() {
		return buttonHoaDon;
	}

	public JButton getButtonMenu() {
		return buttonMenu;
	}

	public JButton getButtonDoanhThu() {
		return buttonDoanhThu;
	}

	public Outlets getOutlets() {
		return outlets;
	}

	/**
	 * 
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1470, 800);
		contentPane = new JPanel(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setResizable(false);

		control = new ControlViewOutlets(this);

		JPanel mainMenu = new JPanel();
		mainMenu.setBackground(new Color(6, 68, 32));
		mainMenu.setPreferredSize(new Dimension(200, 10));

		contentPane.add(mainMenu, BorderLayout.WEST);
		SpringLayout sl_mainMenu = new SpringLayout();
		mainMenu.setLayout(sl_mainMenu);

		Logo logo = new Logo("logo.png");
		sl_mainMenu.putConstraint(SpringLayout.NORTH, logo, 21, SpringLayout.NORTH, mainMenu);
		sl_mainMenu.putConstraint(SpringLayout.WEST, logo, 22, SpringLayout.WEST, mainMenu);
		sl_mainMenu.putConstraint(SpringLayout.SOUTH, logo, 170, SpringLayout.NORTH, mainMenu);
		sl_mainMenu.putConstraint(SpringLayout.EAST, logo, -28, SpringLayout.EAST, mainMenu);
		logo.setBackground(new Color(255, 255, 255));
		logo.setPreferredSize(new Dimension(50, 50));
		mainMenu.add(logo);

		JPanel menu = new JPanel();
		sl_mainMenu.putConstraint(SpringLayout.NORTH, menu, 32, SpringLayout.SOUTH, logo);
		sl_mainMenu.putConstraint(SpringLayout.WEST, menu, 0, SpringLayout.WEST, mainMenu);
		sl_mainMenu.putConstraint(SpringLayout.SOUTH, menu, -125, SpringLayout.SOUTH, mainMenu);
		sl_mainMenu.putConstraint(SpringLayout.EAST, menu, 0, SpringLayout.EAST, mainMenu);
		menu.setBackground(new Color(180, 231, 191));
		FlowLayout fl_menu = (FlowLayout) menu.getLayout();
		fl_menu.setVgap(0);
		fl_menu.setHgap(0);
		menu.setPreferredSize(new Dimension(150, 10));
		mainMenu.add(menu);

		buttonMenu = new JButton("Menu");
		buttonMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonMenu.setBorder(null);
		buttonMenu.setBackground(new Color(116, 187, 131));
		buttonMenu.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonMenu);
		listButtonMainMenu.add(buttonMenu);

		buttonHoaDon = new JButton("Hóa đơn");
		buttonHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonHoaDon.setBorder(null);
		buttonHoaDon.setBackground(new Color(180, 231, 191));
		buttonHoaDon.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonHoaDon);
		listButtonMainMenu.add(buttonHoaDon);

		buttonDoanhThu = new JButton("Doanh thu");
		buttonDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonDoanhThu.setBackground(new Color(180, 231, 191));
		buttonDoanhThu.setBorder(null);
		buttonDoanhThu.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonDoanhThu);
		listButtonMainMenu.add(buttonDoanhThu);

		buttonQLNV = new JButton("Quản lý nhân viên");
		buttonQLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonQLNV.setBackground(new Color(180, 231, 191));
		buttonQLNV.setBorder(null);
		buttonQLNV.setPreferredSize(new Dimension(200, 50));
		menu.add(buttonQLNV);
		listButtonMainMenu.add(buttonQLNV);

		panelCenter = new JPanel(new CardLayout(0, 0));
		panelCenter.setBackground(new Color(228, 239, 231));
		contentPane.add(panelCenter, BorderLayout.CENTER);

		// Menu sản phẩm
		panelMenuSanPham = new PanelMenuSanPham(outlets.getListFood(), outlets.getListBeverage(),
				outlets.getListToppingFood(), outlets.getListToppingBeverage());
		panelCenter.add("menu_sp", panelMenuSanPham);

		// Hóa đơn
		panelHoaDon = new PanelHoaDon(panelMenuSanPham.getBill());
		panelCenter.add("hoa_don", panelHoaDon);

		// Doanh thu
		JPanel panelDoanhThu = new JPanel();
		panelCenter.add("doanh_thu", panelDoanhThu);

		panelQLNV = new PanelQLNV(outlets.getEmployees(), outlets.getPass());
		panelQLNV.setBackground(new Color(228, 239, 231));
		this.setPreferredSize(new Dimension(1540, 930));
		panelCenter.add("qlnv", panelQLNV);
	}

	public void event() {
		buttonMenu.addActionListener(control);
		this.buttonHoaDon.addActionListener(control);
		this.buttonDoanhThu.addActionListener(control);
		this.buttonQLNV.addActionListener(control);
	}

	public void showMenuSanPham() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "menu_sp");
		setBackgroundForButtonManiMenuIsSelect(buttonMenu);
		panelQLNV.close();
	}

	public void showHoaDon() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "hoa_don");
		setBackgroundForButtonManiMenuIsSelect(buttonHoaDon);
		panelQLNV.close();
	}

	public void showQLNV() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "qlnv");
		setBackgroundForButtonManiMenuIsSelect(buttonQLNV);
		panelQLNV.close();
	}

	public void showDoanhThu() {
		((CardLayout) panelCenter.getLayout()).show(panelCenter, "doanh_thu");
		setBackgroundForButtonManiMenuIsSelect(buttonDoanhThu);
		panelQLNV.close();
	}

	public void setBackgroundForButtonManiMenuIsSelect(JButton button) {
		for (JButton b : listButtonMainMenu) {
			if (button.equals(b)) {
				b.setBackground(new Color(116, 187, 131));
			} else {
				b.setBackground(new Color(180, 231, 191));
			}
		}
	}

	public void upDateHoaDon() {
		panelHoaDon.upDateListSPDM();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		List<Food> listFoods = new ArrayList<>();
		List<Beverage> listBeverages = new ArrayList<>();
		List<Employee> emplyees = new ArrayList<>();
		List<BeverageDecorator> listToppingBeverage = new ArrayList<>();
		List<FoodDecorator> listToppingFood = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				listFoods.add(new OtherFood("", "Tên món " + i, i * 10000, true));
			} else {
				listFoods.add(new OtherFood("", "Tên món " + i, i * 10000, false));
			}

			emplyees.add(new Employee(i + "", "Ten " + i, new Date("13/05/2003"), "gioi tinh", "dia chi " + i,
					"sdt " + i, i, new Date("25/3/2023")));

			listBeverages.add(new OtherBeverage("", "Tên đồ uống " + i, i * 10000));
		}

		for (int i = 1; i <= 3; i++) {
			listToppingBeverage.add(new OtherToppingBeverage("Topping đồ uống " + i, i * 1000));

			listToppingFood.add(new OtherToppingFood("Topping đồ ăn " + i, i * 5000));
		}

		Outlets outlets = new Outlets("a", "a", "abc", "lamnguyen1305");
		outlets.setListBeverage(listBeverages);
		outlets.setListFood(listFoods);
		outlets.setEmployees(emplyees);
		outlets.setListToppingFood(listToppingFood);
		outlets.setListToppingBeverage(listToppingBeverage);
		DesignViewOutlets frame = new DesignViewOutlets(outlets);
	}
}
