package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import view.PanelDoanhThu;

public class ControlPanelDoanhThu implements ActionListener{
	private PanelDoanhThu panelDoanhThu;

	public ControlPanelDoanhThu(PanelDoanhThu panelDoanhThu) {
		super();
		this.panelDoanhThu = panelDoanhThu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			
			panelDoanhThu.setBackgroundForButtonSelect(button);
			panelDoanhThu.lockChooseTime(button);
			panelDoanhThu.update();
		}
	
		if(e.getSource() instanceof JComboBox) {
			panelDoanhThu.showDTTuan();
			panelDoanhThu.showDTThang();
			panelDoanhThu.showDTNam();
		}
		
	}
	
}
