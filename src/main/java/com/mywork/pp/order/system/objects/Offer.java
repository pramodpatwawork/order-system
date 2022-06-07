package com.mywork.pp.order.system.objects;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Pramod Patwa
 * Class will be used to hold pre configured offer instance 
 */
@Setter
@Getter
public class Offer {
	/**
	 * unique item code
	 */
	private String itemCode;
	
	/**
	 * quantity on which offer will be applied
	 */
	private  int quantity;
	
	/**
	 * discount amount
	 */
	private double discount;
	
}
