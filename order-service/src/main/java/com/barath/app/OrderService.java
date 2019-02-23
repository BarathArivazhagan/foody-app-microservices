package com.barath.app;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.barath.app.Order.PaymentType;


@Service
public class OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String URL = "http://localhost:8082/payment";
	private final RestTemplate restTemplate;
	private final OrderRepository orderRepository;
	
	
		
	public OrderService(OrderRepository orderRepository,RestTemplate restTemplate) {
		super();
		this.orderRepository = orderRepository;
		this.restTemplate = restTemplate;
	}


	public Order placeOrder(Order order) {
			
		logger.info(" Placing Order"+order);
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
