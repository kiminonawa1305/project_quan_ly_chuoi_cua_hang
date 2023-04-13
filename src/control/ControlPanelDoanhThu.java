package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

<<<<<<< HEAD
import view.outlet.PanelDoanhThu;
=======
import view.PanelDoanhThu;
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95

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
<<<<<<< HEAD
			
			if (panelDoanhThu.getButtonEye().equals(button)) {
				panelDoanhThu.actionButtonEye(button);
			}

			if (panelDoanhThu.getButtonDangNhap().equals(button)) {
				panelDoanhThu.dangNhap();
			}
=======
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95
		}
	
		if(e.getSource() instanceof JComboBox) {
			panelDoanhThu.showDTTuan();
			panelDoanhThu.showDTThang();
			panelDoanhThu.showDTNam();
		}
		
	}
	
}
