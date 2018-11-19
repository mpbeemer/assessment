package com.routeone.interview;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class StoreRegister {
	
	public ArrayList<Component> components = new ArrayList<Component>();
 
    public void loadInventory(File inventoryFile){
    	BufferedReader br = null;
    	StringBuilder  sb = new StringBuilder();
    	String         result;
    	String[]       data;
    	String[]       fields;
    	Component      new_component;
    	
    	try {
    		br = new BufferedReader(new FileReader(inventoryFile));
    		
    		try {
    			String s;
    			while ((s = br.readLine()) != null) {
    				// add linefeed stripped by readline back to string.
    				sb.append(s);
    				sb.append("\r\n");
    			}
    		} finally {
    			br.close();
    		}
    	} catch (IOException ex) {
    		System.err.println(" Unable to ready from file: " + inventoryFile + ".");
    		System.exit(0);
    	}
    	// Parse contents of sb.toString() into inventory list.
    	result = sb.toString();
    	data = result.split("\r\n");
    	
    	for (String dataline : data) {
    		fields = dataline.split(",");
    		new_component = new Component();
    		new_component.componentName = fields[0];
    		new_component.price = Float.parseFloat(fields[1]);
    		new_component.category = fields[2];
    		components.add(new_component);
    	}
    }
 
    public Receipt checkoutOrder(List<String> items) {
        return null;
    }
}