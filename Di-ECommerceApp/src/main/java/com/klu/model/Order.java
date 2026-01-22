package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Order {
	private int orderId;
	private String customerName;
	private String productName;
	@Value("4")
	private int quantity;
	
	public Order(@Value("101")int orderId, @Value("Karthik")String customerName) {
		this.orderId=orderId;
		this.customerName=customerName;
	}
	@Value("Mobile")
	public void setProductName(String productName) {
		this.productName=productName;
	}
	public void display() {
		System.out.println("following is order details: ");
		System.out.println("OrderId"+orderId);
		System.out.println("CustomerName:"+customerName);
		System.out.println("PRoductName:"+productName);
		System.out.println("Quantity:"+quantity);
	}
	



}
