package edu.uark.models.api;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class Transaction {
	public enum Transactiontype{
		RETURN,SALE;
	}
	
	private Map <String, Double> ProductsSold; //added
	private UUID transactionID; //added
	private Double totalCost; //added
	private String date; //added
	private String employeeID; //added
	private  Transactiontype transactionType;
	
	
	public Transaction(JSONObject values) throws JSONException
	{
		setTransactionType(values.getString("transactionType"));
		setDate(values.getString("date"));
		setEmployeeID(values.getString("employeeID"));
		setTransactionID(UUID.fromString(values.getString("transactionID")));
		setMap(values.getJSONArray("transaction"));
		setTotalCost(values.getString("totalCost"));
		
	}
	
	private void setMap(JSONArray ProductData){
		String product;
		double amount;
		ProductsSold = new HashMap<>();
		for(int i = 0; i < ProductData.length(); i++){
			product = ProductData.getJSONObject(i).getString("productID");
			amount = ProductData.getJSONObject(i).getDouble("price");
			ProductsSold.put(product, amount);
		}
	}
	
	private void setTransactionType(String transaction){
		if(transaction.equals("Return")){
			this.transactionType = Transactiontype.RETURN;
		} else {
			this.transactionType = Transactiontype.SALE;
		}
	}
	
	public UUID getTransactionID(){
		return transactionID;
	}
	
	private void setDate(String date) {
		this.date = date;
	}
	
	private void setTotalCost(String totalCost){
		this.totalCost = Double.parseDouble(totalCost);
	}
	
	private void setEmployeeID(String employeeID){
		this.employeeID = employeeID;
	}
	
	private void setTransactionID(UUID transactionID){
		this.transactionID = transactionID;
	}
	
}
