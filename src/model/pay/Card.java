package model.pay;

import javax.swing.JOptionPane;

import model.object.Bill;

public class Card implements PayOption {

	@Override
	public boolean getPay(Bill bill,double thue) {
		JOptionPane.showMessageDialog(null,
				"Đã thanh toán thành công bằng hình thức quẹt thẻ",
				"Thành công", JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

}