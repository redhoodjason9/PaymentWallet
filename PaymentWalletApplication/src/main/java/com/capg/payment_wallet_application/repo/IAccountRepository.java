package com.capg.payment_wallet_application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.payment_wallet_application.beans.AccountId;
import com.capg.payment_wallet_application.beans.BankAccount;
import com.capg.payment_wallet_application.dto.WalletDTO;

public interface IAccountRepository extends JpaRepository<BankAccount, AccountId> {
	
    @Query("select ba from BankAccount ba where ba = :bacc")
    public WalletDTO viewAccount(@Param(value="bacc")BankAccount bacc);
  
	@Query("select bacc from BankAccount bacc where bacc = :bacc")
	public BankAccount findByBankAccount(@Param(value="bacc") BankAccount bacc);

	@Query("select bacc from BankAccount bacc where bacc.wallet.walletId=:walletId")
	public List<BankAccount> findByWalletId(@Param("walletId") int walletId);
	
	
}
