package com.capg.payment_wallet_application.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.payment_wallet_application.beans.BillPayment;
import com.capg.payment_wallet_application.dto.BillPaymentDTO;
import com.capg.payment_wallet_application.service.IBillPaymentService;

@RestController
@RequestMapping("/bill-payment")
public class BillPaymentController {
	
	@Autowired
	IBillPaymentService billService;
	
	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value="/add_bill",consumes ="application/json")
	public BillPaymentDTO addBillPayment(@RequestBody BillPayment payment) {
		LOGGER.info("BillPayment added succesfully");
		return billService.addBillPayment(payment);
	}

	
	@GetMapping(value="/view", produces = "application/json")
	public List<BillPaymentDTO> viewBillPayment(BillPayment payment) {
		LOGGER.info("BillPayment is listed below");
		return billService.viewBillPayment(payment);
	}
}
