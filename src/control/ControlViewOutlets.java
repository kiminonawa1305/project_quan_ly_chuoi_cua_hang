package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.outlet.GUIOutlets;

public class ControlViewOutlets implements ActionListener {
	private GUIOutlets viewOutlets;

	public ControlViewOutlets(GUIOutlets viewOutlets) {
		this.viewOutlets = viewOutlets;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if (button.equals(viewOutlets.getButtonMenu())) {
			viewOutlets.showMenuSanPham();
		}
		
		if (button.equals(viewOutlets.getButtonHoaDon())) {
			viewOutlets.updateHoaDon();
			viewOutlets.showHoaDon();
		}
		
		if (button.equals(viewOutlets.getButtonQLNV())) {
			viewOutlets.showQLNV();
		}
		
		if (button.equals(viewOutlets.getButtonDoanhThu())) {
			viewOutlets.showDoanhThu();
			viewOutlets.updateDoanThu();
		}
	}

}
