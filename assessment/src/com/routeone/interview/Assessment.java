package com.routeone.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Assessment {
	
	public static void main(String[] args) {
		StoreRegister  storeRegister  = new StoreRegister();
		Order          order          = new Order();
		File           inventoryFile  = null;
		BufferedReader reader         = null;
		String         orderString    = null;
		String[]       components;
		List<String>   componentList  = new ArrayList<String>();
		
		// Load inventory file into store register.
		inventoryFile = new File("sample-inventory.csv");
		storeRegister.loadInventory(inventoryFile);
		
		// Read order from standard input.
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				orderString = reader.readLine();
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
    		System.err.println("Unable to read from standard input.");
    		System.exit(0);
    	}
		
		// Parse order into order list.
		components = orderString.split(",");
		for (String candidate : components) {
			componentList.add(candidate);
		}
		order = (Order) storeRegister.checkoutOrder(componentList);
		
		// Output results.
		System.out.println(order.getFormattedTotal());
		System.out.println(order.getOrderedItems());
		
	}

}
