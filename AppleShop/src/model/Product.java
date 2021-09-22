package model;

// Template for individual apple products.

public class Product {
	
	// attributes
	
	private String model;
	private String finish; 
	private int storage;
	private boolean hasCellularConnectivity;
	private double originalPrice;
	private double discountValue;
	
	// constructors
	
	public Product() {
		
	}
	
	public Product(String model, double originalPrice) { 
		
		this.model = model;
		this.originalPrice = originalPrice;
 	}
	
	// accessors and mutators 
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
	 this.model = model;
	}

	public String getFinish() {
		return this.finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public int getStorage() {
		return this.storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public boolean hasCellularConnectivity() {
		return this.hasCellularConnectivity;
	}

	public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
		this.hasCellularConnectivity = hasCellularConnectivity;
	}

	public double getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountValue() {
		return this.discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}
	
	public double getPrice() {
		double price = 0.0;
				
		 price = this.originalPrice - this.discountValue;
		
		return price;
	}
	
	public String toString() {
		String s = "";
		
		s += model + " " + finish + " " + storage + "GB"  
		 + " (cellular connectivity: " + hasCellularConnectivity + "): $(" + String.format("%.2f", originalPrice) 
		+ " - " + String.format("%.2f", discountValue) + ")";
		
		/*
		 * s = String.format("%s %s %dGB (cellular connectivity: %s): $(%.2f - %.2f)",
		 * this.model, this.finish, this.storage, this.hasCellularConnectivity,
		 * this.originalPrice, this.discountValue);
		 */
	
		return s;
	}
	
	
	
	
	
	
	

}
