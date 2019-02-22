package com.barath.app;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Order {
	
	@Id
	private Long orderId;
	
	@OneToMany
	private List<OrderItem> items;
	
	@Column
	private Long restaurant;
	
	@Column
	private double totalPrice;
	
	@Column
	private double deliveryPrice;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	public enum PaymentType{
		COD,
		NETBANKING,
		UPI
	}
	

    @Embedded
	private Address deliveyAddress;
    
    private Long userId;
    
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Long getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Long restaurant) {
		this.restaurant = restaurant;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	
	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + ", restaurant=" + restaurant + ", totalPrice="
				+ totalPrice + ", deliveryPrice=" + deliveryPrice + ", deliveyAddress=" + deliveyAddress
				+ ", orderStatus=" + orderStatus + "]";
	}

	public Order(Long orderId, List<OrderItem> items, Long restaurant, double totalPrice, double deliveryPrice,
			Address deliveyAddress, OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.restaurant = restaurant;
		this.totalPrice = totalPrice;
		this.deliveryPrice = deliveryPrice;
		this.deliveyAddress = deliveyAddress;
		this.orderStatus = orderStatus;
	}

	public Address getDeliveyAddress() {
		return deliveyAddress;
	}

	public void setDeliveyAddress(Address deliveyAddress) {
		this.deliveyAddress = deliveyAddress;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	

	public Order(Long orderId, List<OrderItem> items, Long restaurant, double totalPrice, double deliveryPrice,
			PaymentType paymentType, Address deliveyAddress, Long userId, OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.restaurant = restaurant;
		this.totalPrice = totalPrice;
		this.deliveryPrice = deliveryPrice;
		this.paymentType = paymentType;
		this.deliveyAddress = deliveyAddress;
		this.userId = userId;
		this.orderStatus = orderStatus;
	}

	public Order() {
		super();
	
	}
	
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	

}
