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

import edu.uark.models.api.enums.TransactionApiRequestStatus;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;


public class Transaction {
	public enum TransactionType{
		RETURN,SALE;
	}
	
	private Map <String, Double> ProductsSold; //added
	private UUID transactionID; //added
	private Double totalCost; //added
	private String date; //added
	private String employeeID; //added
	private  String transactionType;
	
	public Transaction(JSONObject values) throws JSONException
	{
		setTransactionType(values.getString("transactionType"));
		setDate(values.getString("date"));
		setEmployeeID(values.getString("employeeID"));
		setTransactionID(UUID.fromString(values.getString("transactionID")));
		setMap(values.getJSONArray("transaction"));
		setTotalCost(values.getString("totalCost"));
		
	}
	public Transaction()
	{
		transactionType = null;
		transactionID = null;
		totalCost = 0.0;
		date = "";
		employeeID = "";
		ProductsSold = new HashMap<String, Double>();
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
		if(transaction.equals("return")){
			this.transactionType = TransactionFieldNames.RETURN;
		} else {
			this.transactionType = TransactionFieldNames.SALE;
		}
	}
	
	public UUID getTransactionID(){
		return transactionID;
	}
	public double getTotalCost()
	{
		return this.totalCost;
	}
	public String getEmployeeId()
	{
		return this.employeeID;
	}
	public String getDate()
	{
		return this.date;
	}
	public String getTransactionType()
	{
		return this.transactionType;
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
	public UUID getId()
	{
		return this.transactionID;
	}
	public Boolean isBlank()
	{
		return (employeeID.isEmpty() || transactionType == null || date.isEmpty() || totalCost == 0.0 || ProductsSold.isEmpty());
		
	}

	public Transaction setApiRequestStatus(TransactionApiRequestStatus invalidInput) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
