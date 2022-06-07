package com.mywork.pp.order.system.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author Pramod Patwa
 * Class will be used to hold Item instance
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Item {
	
	/**
	 * Order Item code
	 */
	private String code;
	
	/**
	 * Order Item name
	 */
	private String name;
	/**
	 * Item unit price 
	 */
	private double price;
	
	/**
	 * unit to measure item
	 */
	private UnitType unit;
	
}
