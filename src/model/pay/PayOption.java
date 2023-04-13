package model.pay;

import model.object.Bill;
import model.system.*;

public interface PayOption {

	/**
	 * 
	 * @param bill
	 * @param moneyReceived
	 */
	boolean getPay(Bill bill, double thue);

}