package com.capg.payment_wallet_application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.payment_wallet_application.beans.BillPayment;
import com.capg.payment_wallet_application.repo.IBillPaymentRepository;

@Service
public class BillPaymentServiceImpl implements IBillPaymentService {
	
	@Autowired
	private IBillPaymentRepository billRepo;

	@Override
	public BillPayment addBillPayment(BillPayment payment) {
		BigDecimal currentBalance = payment.getWallet().getBalance();
		BigDecimal amount = (BigDecimal.valueOf(payment.getAmount()));
		currentBalance = currentBalance.subtract(amount);
		payment.getWallet().setBalance(currentBalance);
		return billRepo.save(payment);
	}

	@Override
	public List<BillPayment> viewBillPayment(BillPayment payment) {
		
		return billRepo.findAll();
	}

}
