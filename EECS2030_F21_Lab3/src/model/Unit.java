package model;

public class Unit {

	private String function;
	private double width;
	private double length;

	private int count;
	String a = "";


	public Unit(String function, int width, int length) {

		this.function = function;
		this.width = width;
		this.length = length;
		this.count = 0;

	}
	
	public String getFunction() {
		return this.function;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getArea() {
		
		return this.width*this.length;
	}

	public String toogleMeasurement() {

		count ++;

		if ( count % 2 != 0) {

			this.width = this.width*0.3048;
			this.length = this.length*0.3048;


			a = String.format("%.2f square meters (%.2f m wide and %.2f m long)", this.width*this.length, this.width, this.length );

		}
		else{

			this.width = this.width/0.3048;
			this.length = this.length/0.3048;

			a = String.format("%.0f square feet (%.0f' wide and %.0f' long)", this.width*this.length, this.width, this.length );

		}

		return a;
	}


	public String toString() {

		String s = "";


		if(count == 0) {

			s = String.format("A unit of %.0f square feet (%.0f' wide and %.0f' long) functioning as %s", this.width*this.length, this.width, this.length, this.function);


		}
		else {
			s = String.format("A unit of %s functioning as %s", this.a, this.function);
		}
		return s;
	}


	public boolean equals(Object obj) {

		if ( this == obj) {	
			return true;
		}
		if ( obj == null || this.getClass() != obj.getClass() ) { 
			return false;
		}


		Unit other = (Unit) obj;
		return
				this.function == other.function &&
				this.width*this.length == other.width*other.length;


	}





























}
