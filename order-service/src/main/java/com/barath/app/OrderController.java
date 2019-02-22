package com.barath.app;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	private final OrderService orderService;
	
	
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}



	@PostMapping("/place/order")
	public Order placeOrder(@RequestBody Order order) {
		
		return this.orderService.placeOrder(order);
		
	}
	
	@GetMapping("/order/history")
	public List<Order> orderHistory(){
		return this.orderService.orderHistory();
	}
	
	


}
