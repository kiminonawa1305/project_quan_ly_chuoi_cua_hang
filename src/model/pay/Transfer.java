package model.pay;

import model.system.Bill;

public class Transfer implements PayOption {

	@Override
	public boolean getPay(Bill bill, double thue, double moneyReceived) {
		System.out.println("Bạn đã thanh toán bằng cách chuyển khoản");
		return bill.getPay(thue) <= moneyReceived;
	}
}