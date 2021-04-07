package com.capg.payment_wallet_application.service;

import java.util.List;

import com.capg.payment_wallet_application.beans.BenificiaryDetails;
import com.capg.payment_wallet_application.beans.Customer;
import com.capg.payment_wallet_application.beans.Wallet;
import com.capg.payment_wallet_application.dto.BenificiaryDetailsDTO;

public interface IBenificiaryService {

	public BenificiaryDetailsDTO addBenificiary(BenificiaryDetails bd);

	public BenificiaryDetailsDTO updateBenificiary(BenificiaryDetails bd);

	public String deleteBenificiary(BenificiaryDetails bd);

	public BenificiaryDetailsDTO viewBenificiary(String mobileNo);

	public List<BenificiaryDetailsDTO> viewAllBenificiary(int walletId);

}
