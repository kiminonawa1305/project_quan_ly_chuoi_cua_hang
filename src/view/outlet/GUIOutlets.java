package view.outlet;

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
import model.beverage.Beverages;
import model.beverage.OtherToppingBeverage;
import model.food.Food;
import model.food.FoodDecorator;
import model.food.Foods;
import model.food.OtherToppingFood;
import model.system.Date;
import model.system.Employee;
import model.system.Outlets;
import model.system.Sex;

public class GUIOutlets extends JFrame {
	private Outlets outlets;
	private PanelQLNV panelQLNV;
	private PanelMenuSanPham panelMenuSanPham;
	private JPanel contentPane, panelCenter;
	private List<JButton> listButtonMainMenu = new ArrayList<>();
	private JButton buttonQLNV, buttonHoaDon, buttonDoanhThu, buttonMenu;
	private ControlViewOutlets control;
	private PanelHoaDon panelHoaDon;
	private PanelDoanhThu panelDoanhThu;

	/**
	 * Create the frame.
	 */
	public GUIOutlets(Outlets outlets) {
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
		this.setSize(1470, 800);
		this.setLocationRelativeTo(null);
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
		panelMenuSanPham = new PanelMenuSanPham(outlets);
		panelCenter.add("menu_sp", panelMenuSanPham);

		// Hóa đơn
		panelHoaDon = new PanelHoaDon(panelMenuSanPham, outlets);
		panelCenter.add("hoa_don", panelHoaDon);

		// Doanh thu
		panelDoanhThu = new PanelDoanhThu(outlets);
		panelCenter.add("doanh_thu", panelDoanhThu);

		// Quan ly nhan vien
		panelQLNV = new PanelQLNV(outlets.getEmployees(), outlets.getPass());
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
		panelDoanhThu.close();
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

	public void updateHoaDon() {
		panelHoaDon.upDateListSPDM();
	}

	public void updateDoanThu() {
		panelDoanhThu.update();
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

		Food f1 = new Foods("image\\food\\6PhoMaiVien45k.jpeg", "6 Phô mai viên", 45000, false);
		Food f2 = new Foods("image\\food\\BurgerGaQuay55k.jpeg", "Burger gà quay", 55000, true);
		Food f3 = new Foods("image\\food\\ComboGaRan89k.jpeg", "Combo gà rán", 89000, true);
		Food f5 = new Foods("image\\food\\MienXaoHanQuoc30k.jpeg", "Miến xào Hàn Quốc", 30000, true);
		Food f6 = new Foods("image\\food\\MiTuongDen59k.jpeg", "Mì tương đen", 59000, true);
		Food f7 = new Foods("image\\food\\MiXaoDacBiet55k.jpeg", "Mì xào đặc biệt", 55000, true);
		Food f8 = new Foods("image\\food\\PizzaBoBBQXotCayHanQuoc50k.jpeg", "Pizza bò BBQ cay Hàn Quốc", 50000, true);
		Food f9 = new Foods("image\\food\\PizzaPhuNhanHaiSanSotPesto269k.jpeg", "Pizza hải sản", 269000, true);
		Food f10 = new Foods("image\\food\\SaladHat15k.jpg", "Salad hạt", 15000, false);
		Food f11 = new Foods("image\\food\\TopokkiPhoMai50k.jpeg", "Topokki phô mai", 50000, true);
		
		listFoods.add(f1);
		listFoods.add(f2);
		listFoods.add(f3);
		listFoods.add(f5);
		listFoods.add(f6);
		listFoods.add(f7);
		listFoods.add(f8);
		listFoods.add(f9);
		listFoods.add(f10);
		listFoods.add(f11);
		
		Beverage b1 = new Beverages("image\\beverage\\Cocacola10k.jpeg", "Coca cola", 10000);
		Beverage b2 = new Beverages("image\\beverage\\DuaTuoi20k.jpeg", "Dừa tươi", 20000);
		Beverage b3 = new Beverages("image\\beverage\\NuocEpCam30k.jpeg", "Nước ép cam", 30000);
		Beverage b4 = new Beverages("image\\beverage\\RauMaDauXanhSuaDua30k.jpeg", "Rau má đậu xanh", 30000);
		Beverage b5 = new Beverages("image\\beverage\\RuouNhoDacBiet200k.jpeg", "Rượu nho đặc biệt", 20000);
		Beverage b6 = new Beverages("image\\beverage\\SinhToXoaiThanhLong30k.jpeg", "Sinh tố xoài thanh long", 30000);
		Beverage b7 = new Beverages("image\\beverage\\SuaTuoiTranChauDuongDen30k .jpeg", "Sữa tươi trân châu đương đen", 30000);
		Beverage b8 = new Beverages("image\\beverage\\TraChanhLeo20k.jpeg", "Trà chanh leo", 20000);
		Beverage b9 = new Beverages("image\\beverage\\TraOLongCamDaoDauTay30k.jpeg", "Trà cam đào dâu tây", 30000);
		Beverage b10 = new Beverages("image\\beverage\\TraTraiCayNhietDoi30k.jpeg", "Trà trái cây nhiệt đới", 30000);
		
		listBeverages.add(b1);
		listBeverages.add(b2);
		listBeverages.add(b3);
		listBeverages.add(b4);
		listBeverages.add(b5);
		listBeverages.add(b6);
		listBeverages.add(b7);
		listBeverages.add(b8);
		listBeverages.add(b9);
		listBeverages.add(b10);
		
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				emplyees.add(new Employee(i + "", "Ten " + i, new Date("13/05/2003"), Sex.NAM, "dia chi " + i,
						"0"+(855354919 + i), i, new Date("25/3/2023")));
			} else {
				if (i % 3 == 1) {
					emplyees.add(new Employee(i + "", "Ten " + i, new Date("13/05/2003"), Sex.NU, "dia chi " + i,
							"0"+(855354919 + i), i, new Date("25/3/2023")));
				} else {
					emplyees.add(new Employee(i + "", "Ten " + i, new Date("13/05/2003"), Sex.KHAC, "dia chi " + i,
							"0"+(855354919 + i), i, new Date("25/3/2023")));
				}
			}
		}

		for (int i = 1; i <= 3; i++) {
			listToppingBeverage.add(new OtherToppingBeverage("Topping đồ uống " + i, i * 1000));

			listToppingFood.add(new OtherToppingFood("Topping đồ ăn " + i, i * 5000));
		}

		Outlets outlets = new Outlets("a", "a", "abc", "1");
		outlets.setListBeverage(listBeverages);
		outlets.setListFood(listFoods);
		outlets.setEmployees(emplyees);
		outlets.setListToppingFood(listToppingFood);
		outlets.setListToppingBeverage(listToppingBeverage);

		Outlets outlets2 = new Outlets("b", "b", "abcd", "2");
		outlets2.setListBeverage(listBeverages);
		outlets2.setListFood(listFoods);
		outlets2.setEmployees(emplyees);
		outlets2.setListToppingFood(listToppingFood);
		outlets2.setListToppingBeverage(listToppingBeverage);

		GUIOutlets frame = new GUIOutlets(outlets);
	}
}
