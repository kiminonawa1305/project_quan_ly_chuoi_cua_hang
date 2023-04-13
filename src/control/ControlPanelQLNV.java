package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.outlet.PanelQLNV;

public class ControlPanelQLNV implements ActionListener {
	private PanelQLNV panelQLNV;

	public ControlPanelQLNV(PanelQLNV panelQLNV) {
		super();
		this.panelQLNV = panelQLNV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if (panelQLNV.getButtonEyes().equals(button)) {
			panelQLNV.actionButtonEye(button);
		}

		if (panelQLNV.getButtonDangNhap().equals(button)) {
			panelQLNV.dangNhap();
		}

		if (button.getActionCommand().split("\t")[0].equals("sua")) {
			panelQLNV.suaNhanVien(button);
		}
		
		if (button.getActionCommand().split("\t")[0].equals("xoa")) {
			panelQLNV.xoaNhanVien(button);
		}

		if (panelQLNV.getButtonLuu().equals(button)) {
			if (button.getActionCommand().equals("luu sua")) {
				panelQLNV.luuSua();
			}else {
				panelQLNV.themNhanVien();
			}
		}
	}

}
