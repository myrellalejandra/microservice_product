package com.example.nttdata.model;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.nttdata.controller.ProductController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "Products")
@RequiredArgsConstructor 
@AllArgsConstructor
@Data
public class Product {
	@Id
	private String id;
	private Double balance;
	private String type;
	private List<String> accountHolders;
	private List<String> authorizedSigner;
	private Long accountNumber;
	private Long dni;
	private int montlyTransactionsLimit;
	private Double maintenanceCost;
	private int withdrawalDepositDay;
	private Double creditLimit;	
}

/* 1.Company account 
  	 	Account holders
  	 	1.1Pyme
  	 		it must :
  	 			1.1.1 checking
  	 			1.1.2 personal_credit (credit card)
   2. personal 
   		2.1credit without accountNumber , DNI
   		2.2 VIP
   			it must :
   			2.2.1 checking , minimum balance : 5000
   			2.2.2 credit card 
 * */


/*
 * type : 
 * 		1.Passive product 
 * 			1.1 Savings
 * 					montlyTransactionsLimit = ?
 * 			1.2 checking
 * 					maintenanceCost = ?
 * 					montlyTransactionsLimit = 0				
 * 			1.3 fixed_term
 * 					maintenanceCost = 0
 * 					withdrawalDepositDay = ?
 * 		2. Active product
 * 			2.1 personal_credit
 * 			2.2 company_credit
 */