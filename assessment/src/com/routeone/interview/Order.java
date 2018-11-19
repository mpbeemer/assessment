package com.routeone.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order implements Receipt {
	public ArrayList<Component> components = new ArrayList<Component>();
	public Float                total      = (float) 0.0;

	public String getFormattedTotal() {		
		return String.format("$%,.2f", this.total);
	}

	public List<String> getOrderedItems() {
		List<String> results = new ArrayList<String>();
		
		for (Component entry : this.components) {
			results.add(entry.componentName);
		}
		return results;
	}

	public static class OrderComparator implements Comparator<Component> {
		// Order entries by descending price or in alphabetical order if price is equal.

		public int compare(Component o1, Component o2) {
			int firstCheck = Float.compare(o1.price, o2.price);
			if ( firstCheck != 0 ) {
				return (-1 * firstCheck);
			} else {
				return o1.componentName.compareTo(o2.componentName);
			}
		}
		
	}
	
}
