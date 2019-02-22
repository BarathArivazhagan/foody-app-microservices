package com.barath.app;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.barath.app.Order.PaymentType;


@Service
public class OrderService {
	
	private static final String URL = "http://localhost:8082/payment";
	private final RestTemplate restTemplate = new RestTemplate();
	private final OrderRepository orderRepository;
	
	
	
	
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}


	public Order placeOrder(Order order) {
		
		if(PaymentType.COD.equals(order.getPaymentType())){			
			order.setOrderStatus(OrderStatus.COMPLETED);
			order.setOrderId(order.getOrderId()+1);
			//this.orderRepository.save(order);
			return order;
		}
		return makePayement(order);
		
	}
	
	
	public Order makePayement(Order order) {
		
		HttpHeaders headers = new HttpHeaders();
		PaymentDTO payment = new PaymentDTO(order.getTotalPrice(), order.getOrderId(), order.getUserId(),order.getPaymentType());
		HttpEntity<Object> requestEntity = new HttpEntity<>(payment,headers);
		ResponseEntity<String> responseEntity=this.restTemplate.exchange(URL, HttpMethod.POST,requestEntity, String.class);
		if(responseEntity.getStatusCode().is2xxSuccessful()) {
			order.setOrderStatus(OrderStatus.COMPLETED);
			order.setOrderId(order.getOrderId()+1);
			//this.orderRepository.save(order);
		}else {
			System.out.println("Payment has failed");
		}
		return order;
	}
	
	public List<Order> orderHistory(){
		return this.orderRepository.findAll();
	}

}
