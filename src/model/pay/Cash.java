package model.pay;

import javax.swing.JOptionPane;

import model.system.Bill;

public class Cash implements PayOption {
	private double moneyReceived;

	public Cash(double moneyReceived) {
		super();
		this.moneyReceived = moneyReceived;
	}

	@Override
	public boolean getPay(Bill bill, double thue) {
		if (moneyReceived - bill.getPay(thue) >= 0) {
			JOptionPane.showMessageDialog(null,
					"Đã thanh toán thành công bằng hình thức tiền mặt \nTiền thừa : " + (moneyReceived - bill.getPay(thue)),
					"Thành công", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Lỗi thanh toán", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return moneyReceived - bill.getPay(thue) >= 0;
	}
}