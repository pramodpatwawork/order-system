package com.mywork.pp.order.system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class OrderBoTest {

	@Test
	void testScanAndCheckoutItemsAQuantity3() {
		String userInput = "A\n3\nN\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);

		String expected = "Total amount to pay: 130.0";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);

		new OrderBoImpl().scanItemsAndCheckout();

		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];

		System.out.println("Actual result: " + actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testScanAndCheckoutItemsBQuantity2() {
		String userInput = "B\n2\nN\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);

		String expected = "Total amount to pay: 45.0";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);

		new OrderBoImpl().scanItemsAndCheckout();

		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];

		System.out.println("Actual result: " + actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testScanAndCheckoutItemsNotFound() {
		String userInput = "X\n2\nN\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);

		String expected = "No Item added for checkout Exiting";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);

		new OrderBoImpl().scanItemsAndCheckout();

		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];

		System.out.println("Actual result: " + actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testScanAndCheckoutInvalidQuantity() {
		String userInput = "X\n-2\nN\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);

		String expected = "No Item added for checkout Exiting";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);

		new OrderBoImpl().scanItemsAndCheckout();

		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[lines.length - 1];

		System.out.println("Actual result: " + actual);
		
		assertEquals(expected, actual);
	}

}
