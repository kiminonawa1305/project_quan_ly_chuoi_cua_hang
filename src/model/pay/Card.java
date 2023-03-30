package model.pay;

import model.system.Bill;

public class Card implements PayOption {

	@Override
	public boolean getPay(Bill bill,double thue, double moneyReceived) {
		System.out.println("Bạn đã thanh toán bằng thể");
		return bill.getPay(thue) <= moneyReceived;
	}

}