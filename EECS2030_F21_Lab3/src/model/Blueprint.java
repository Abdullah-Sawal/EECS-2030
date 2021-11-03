package model;

public class Blueprint {
	
	private int numberOfFloors;
	
	private Floor[] floors;
	private int nof;
	
	public Blueprint(int numberOfFloors) {
		
		this.numberOfFloors = numberOfFloors;
		this.floors = new Floor[numberOfFloors];
		
	}
	
	public Blueprint(Blueprint other) {
		
		this (other.numberOfFloors);
		for ( int i = 0; i < other.nof; i ++ ) {
			this.floors[i] = other.floors[i];
		}
		
		this.nof = other.nof;
	}
	
	public void addFloorPlan(Floor floor) {
		
		this.floors[nof] = floor;
		this.nof ++;
		
	}
	
	public Floor[] getFloors() {
		
		Floor[] f = new Floor[this.nof];
		
		
		for (int i = 0; i < this.nof; i ++) {
			
			f[i] = new Floor(this.floors[i]);
			
		}
		return f;
		
	}
	
	public String toString() {
		
		String s = "";
		
		s = String.format("%.1f percents of building blueprint completed (%d out of %d floors)",(this.nof/ (double) this.numberOfFloors)*100 ,this.nof, this.numberOfFloors);
		
		return s;
	}

}
