package model.pay;

import javax.swing.JOptionPane;

<<<<<<< HEAD
import model.object.Bill;
=======
import model.system.Bill;
>>>>>>> 5552d5310d7269bf1216d8992da37cda77cffd95

public class Card implements PayOption {

	@Override
	public boolean getPay(Bill bill,double thue) {
		JOptionPane.showMessageDialog(null,
				"Đã thanh toán thành công bằng hình thức quẹt thẻ",
				"Thành công", JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

}