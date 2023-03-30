package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import view.PanelHoaDon;

public class ControlPanelHoaDon implements ActionListener {
	private PanelHoaDon panelHoaDon;

	public ControlPanelHoaDon(PanelHoaDon panelHoaDon) {
		super();
		this.panelHoaDon = panelHoaDon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if (button.getName().equals("do_an") || button.getName().equals("do_uong")) {
			panelHoaDon.removeSP(button);
		}

		if (button.getName().equals("thanh_toan")) {
			panelHoaDon.thanhToan();
		}
	}
}
