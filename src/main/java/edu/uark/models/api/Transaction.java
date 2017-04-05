package edu.uark.models.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;



public class Transaction {
	private Map <String,Integer> ProductsSold;
	private UUID transactionID;
	private float totalCost;
	private String date;
	private String employeeID;
	private String transactionType;
	
	
	public Transaction(JSONObject values)
	{
		setMap(values.getJSONArray("transaction"));
	}
	
	public void setMap(JSONArray ProductData){
		ProductsSold = new HashMap();
		for(int i = 0; i < ProductData.length(); i++){
			
		}
	}
}
