package model;

// Template for individual apple products.

public class Product {
	
	// attributes
	
	private String model;
	private String finish; // colour
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
	
	
	
	
	

}
