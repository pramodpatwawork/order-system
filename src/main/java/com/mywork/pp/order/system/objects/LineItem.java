package com.mywork.pp.order.system.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author Pramod Patwa
 * Class will be used to store Line Item instance for an order
 */
@Getter
@Setter
@NoArgsConstructor
public class LineItem {
			
	/**
	 * Item added to line item
	 */
	private Item item;

	/**
	 * total quantity of added item
	 */
	private int quantity;

	/**
	 * calculated amount before applying discount
	 */
	private double amount;
	
	/**
	 * applied discuount on a line item
	 */
	private double discountAmount;
}
