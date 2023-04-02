package model.pay;

import javax.swing.JOptionPane;

import model.system.Bill;

public class Transfer implements PayOption {

	@Override
	public boolean getPay(Bill bill, double thue) {
		JOptionPane.showMessageDialog(null,
				"Đã thanh toán thành công bằng hình thức chuyển khoản",
				"Thành công", JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
}