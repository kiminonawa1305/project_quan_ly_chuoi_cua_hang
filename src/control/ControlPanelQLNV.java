package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.PanelQLNV;

public class ControlPanelQLNV implements ActionListener {
	private PanelQLNV panelQLNV;

	public ControlPanelQLNV(PanelQLNV panelQLNV) {
		super();
		this.panelQLNV = panelQLNV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if(panelQLNV.getButtonEyes().equals(button)) {
			panelQLNV.actionButtonEye(button);
		}
		
		if(panelQLNV.getButtonDangNhap().equals(button)) {
			panelQLNV.dangNhap();
		}
		
//		if(panelQLNV.getButtonEyes().equals(button)) {
//			panelQLNV.actionButtonEye(button);
//		}
//		
//		if(panelQLNV.getButtonEyes().equals(button)) {
//			panelQLNV.actionButtonEye(button);
//		}
	}

}
