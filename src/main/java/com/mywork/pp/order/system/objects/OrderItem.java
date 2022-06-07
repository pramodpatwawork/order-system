package com.mywork.pp.order.system.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author pramod patwa
 * 
 * Class will be used to accept input while order item will be scanned/added
 *
 */
@Setter
@Getter
@AllArgsConstructor
public class OrderItem {
	
	/**
	 * Order item code
	 */
	private String itemCode;
	
	/**
	 * Item quantity
	 */
	private String quantity;
}
