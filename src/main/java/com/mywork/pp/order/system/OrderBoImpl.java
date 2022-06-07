package com.mywork.pp.order.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mywork.pp.order.system.config.loaders.ItemLoader;
import com.mywork.pp.order.system.config.loaders.OfferLoader;
import com.mywork.pp.order.system.objects.Item;
import com.mywork.pp.order.system.objects.LineItem;
import com.mywork.pp.order.system.objects.Offer;
import com.mywork.pp.order.system.objects.OrderItem;

public class OrderBoImpl implements OrderBo {

	/**
	 * line items
	 */
	private final List<LineItem> lineItems = new ArrayList<LineItem>();

	@Override
	public void scanItemsAndCheckout() {

		try (Scanner input = new Scanner(System.in)) {

			while (true) {

				System.out.print("Enter Item Code ");

				// takes input from the keyboard
				String itemCode = input.nextLine();

				System.out.print("Enter Quantity ");

				// takes input from the keyboard
				String quantity = input.nextLine();

				try {
					addOrderItem(new OrderItem(itemCode, quantity));
				} catch (IllegalArgumentException exception) {
					System.out.println("Order can not be added due to error: " + exception.getMessage() + " Try again");
				}

				System.out.println(" Do you want to add more items Y/N ");

				// takes input from the keyboard
				String moreItems = input.nextLine();

				if (moreItems != null && moreItems.length() > 0 && moreItems.equalsIgnoreCase("Y")) {
					continue;
				} else {
					break;
				}

			}
			if(lineItems.size() >0) {
				checkout();
			}else {
				System.out.println("No Item added for checkout Exiting");
			}
		}

	}

	/**
	 * add order item wit quantity.
	 */
	private boolean addOrderItem(OrderItem orderItem) {

		Item item = ItemLoader.getInstance().getItem(orderItem.getItemCode());

		if (item == null) {
			throw new IllegalArgumentException("Item code is not valid");
		}

		int quantity = Integer.parseInt(orderItem.getQuantity());
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity is not valid");
		}

		LineItem lineItem = new LineItem();

		lineItem.setItem(item);
		lineItem.setQuantity(quantity);
		lineItem.setAmount((item.getPrice() * quantity));

		Offer offer = OfferLoader.getInstance().getOffer(item.getCode());

		if (offer != null && offer.getQuantity() <= quantity) {

			int offeredQuantity = (quantity / offer.getQuantity());

			lineItem.setDiscountAmount(offer.getDiscount() * offeredQuantity);
		}

		lineItems.add(lineItem);

		return true;
	}
	
	/**
	 * Method will allow user to checkout
	 */
	private void checkout() {
		System.out.println("Item Details: ");
		double finalAmount = 0.0;
		for (LineItem lineItem : lineItems) {
			System.out.print(" Item Code: " + lineItem.getItem().getCode());
			System.out.print(", Item Name: " + lineItem.getItem().getName());
			System.out.print(", Quantity: " + lineItem.getQuantity());
			System.out.print(", Amount: " + lineItem.getAmount());
			System.out.print(", Discount: " + lineItem.getDiscountAmount());
			finalAmount = finalAmount + (lineItem.getAmount() - lineItem.getDiscountAmount());
			System.out.println();
		}
		System.out.println("Total amount to pay: " + finalAmount);
	}
}
