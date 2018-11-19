package com.routeone.interview;

import java.io.File;

public class Assessment {
	
	public static StoreRegister storeRegister = new StoreRegister();

	public static void main(String[] args) {
		File inventoryFile = new File("sample-inventory.csv");
		storeRegister.loadInventory(inventoryFile);
	}

}
