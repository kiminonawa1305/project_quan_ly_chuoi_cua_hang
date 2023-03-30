package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.DesignViewOutlets;

public class ControlViewOutlets implements ActionListener {
	private DesignViewOutlets viewOutlets;

	public ControlViewOutlets(DesignViewOutlets viewOutlets) {
		this.viewOutlets = viewOutlets;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if (button.equals(viewOutlets.getButtonMenu())) {
			viewOutlets.showMenuSanPham();
		}
		
		if (button.equals(viewOutlets.getButtonHoaDon())) {
			viewOutlets.upDateHoaDon();
			viewOutlets.showHoaDon();
		}
		
		if (button.equals(viewOutlets.getButtonQLNV())) {
			viewOutlets.showQLNV();
		}
		
		if (button.equals(viewOutlets.getButtonDoanhThu())) {
			viewOutlets.showDoanhThu();
		}
	}

}
