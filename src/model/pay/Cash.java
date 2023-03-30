package model.pay;

import model.system.Bill;

public class Cash implements PayOption {

	@Override
	public boolean getPay(Bill bill,double thue, double moneyReceived) {
		System.out.println("Bạn đã thanh toán bằng tiền mặt");
		return bill.getPay(thue) <= moneyReceived;
	}
}