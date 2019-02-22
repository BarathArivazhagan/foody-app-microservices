package com.barath.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown=true)
public class Payment {
	
	@Id
	@GeneratedValue
	private Long paymentId;
	
	private double paymentPrice;
	
	private Long orderId;
	
	private PaymentType paymentType;
	
	private Long userId;
	
	
	public enum PaymentType{
		COD,
		NETBANKING,
		UPI
	}


	public Long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


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


	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Payment(Long paymentId, double paymentPrice, Long orderId, PaymentType paymentType) {
		super();
		this.paymentId = paymentId;
		this.paymentPrice = paymentPrice;
		this.orderId = orderId;
		this.paymentType = paymentType;
	}
	
	
	

}
