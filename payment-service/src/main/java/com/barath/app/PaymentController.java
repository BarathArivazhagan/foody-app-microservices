package com.barath.app;

import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	private int counter =0;
	
	@PostMapping(value="/payment")
	public Payment doPayment(@RequestBody Payment payment) {
		// integrate with online payments
		System.out.println("pay ment recevied "+Objects.toString(payment));
		if( counter % 3 == 0) {
			counter++;
			throw new RuntimeException("Transaction Failed ");
		}
		return payment;
	}
	


}
