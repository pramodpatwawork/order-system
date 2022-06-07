package com.mywork.pp.order.system;

public interface OrderBo {

	/**
	 * Method should be used to scan and add order items in bucket and process
	 *  checkout once items will be added
	 */
	public void scanItemsAndCheckout();	
}
