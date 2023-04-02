package control;


import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import view.PanelQLNV;

public class CareControlQLNV implements CaretListener {
	private PanelQLNV panelQLNV;

	public CareControlQLNV(PanelQLNV panelQLNV) {
		super();
		this.panelQLNV = panelQLNV;
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		
		JTextField text = (JTextField) e.getSource();
		if( text.getName().equals("id") || text.getName().equals("name") || text.getName().equals("sdt")) {
			panelQLNV.findNVByTextField();
			
		}
	}
}
