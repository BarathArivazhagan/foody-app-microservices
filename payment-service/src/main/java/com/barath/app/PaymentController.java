package com.barath.app;

import java.lang.invoke.MethodHandles;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private int counter =0;
	
	@PostMapping(value="/payment")
	public Payment doPayment(@RequestBody Payment payment) {
		// integrate with online payments
		logger.info("pay ment recevied "+Objects.toString(payment));
		if( counter % 3 == 0) {
			counter++;
			throw new RuntimeException("Transaction Failed ");
		}
		return payment;
	}
	


}
