package com.example.nttdata.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "Customers")
@RequiredArgsConstructor 
@AllArgsConstructor
@Data
public class Product {
	private String id;
	private List<String> accountHolders;
	private Long accountNumber;
	private Double balance;
	private String type;
	private int montlyTransactionsLimit;
	private int withdrawalDepositDay;
	
}
