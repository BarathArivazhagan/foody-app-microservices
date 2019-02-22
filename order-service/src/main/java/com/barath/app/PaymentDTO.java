package com.barath.app;

import com.barath.app.Order.PaymentType;

public class PaymentDTO {
	
	
	
	private double paymentPrice;
	
	private Long orderId;
	
	private Long userId;
	
	private PaymentType paymentType;



	public double getPaymentPrice() {
		return paymentPrice;
	}


	public void setPaymentPrice(double paymentPrice) {
		this.paymentPrice = paymentPrice;
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public PaymentType getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public PaymentDTO(double paymentPrice, Long orderId, Long userId, PaymentType paymentType) {
		super();

		this.paymentPrice = paymentPrice;
		this.orderId = orderId;
		this.userId = userId;
		this.paymentType = paymentType;
	}



	
	
	
	

}
