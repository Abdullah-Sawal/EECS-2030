package model;


public class Floor {

	private int capacity;

	private Unit[] units;
	private int nou;

	private double totalArea;
	


	public Floor(int capacity) {

		this.capacity = capacity;
		this.units = new Unit[20];
		this.totalArea = 0;
		this.nou = 0;

	}
	
	public Floor(Floor other) {
		
		this (other.capacity);
		
		for ( int i =0; i < other.nou; i++) {
			this.units[i] = other.units[i];
			
		}
		
		this.nou = other.nou;
		
	}


	public void addUnit(String function, int width, int length) throws InsufficientFloorSpaceException{

		Unit u = new Unit(function, width, length);

		if ( this.capacity - this.getTotalArea() - width*length < 0) {
			throw new InsufficientFloorSpaceException("Not enough space");

		}

		else {

			this.units[nou] = u; 
			this.nou++;
		}

	}


	public double getTotalArea() {
		
		this.totalArea = 0;

		for (int i = 0; i < this.nou; i ++) {

			totalArea += this.units[i].getArea();

		}

		return totalArea;
	}



	public String getUnits(){ 

		String s = "";

		s += "[";

		for (int i = 0; i< this.nou; i++) {

			s += String.format("%s: %.0f sq ft (%.0f' by %.0f')",this.units[i].getFunction(),this.units[i].getArea(),this.units[i].getWidth(),this.units[i].getLength());

			if (i< this.nou -1) {

				s += ", ";
			}

		}

		s += "]";
		return s;



	}

	public String toString() {

		String s = "";
		this.getTotalArea();

		s = String.format("Floor's utilized space is %.0f sq ft (%.0f sq ft remaining): %s",this.totalArea, this.capacity - this.totalArea, this.getUnits());

		return s;
	}
	
	
  public int numberOfEqualUnits (Unit u) {
	  
	  int result = 0;
	  for ( int i =0; i<this.nou; i ++) {
		  
		  if (this.units[i].equals(u)) {
			  result ++;
		  }
		  
	  }
	  
	  return result;
	  
  }

	public boolean equals(Object obj) {

		if ( this == obj) {	
			return true;
		}
		if ( obj == null || this.getClass() != obj.getClass() ) { 
			return false;
		}

		Floor other = (Floor) obj;

	 boolean equal = this.capacity == other.capacity;
	 
	 if (equal) {
		 
		 for (int i = 0; equal && i<this.nou; i++) {
			 
			 Unit u = this.units[i];
			 equal = this.numberOfEqualUnits(u) == other.numberOfEqualUnits(u);
			 
		 }
		 
		 
	 }
       return equal;	
	}
	
	
	}


