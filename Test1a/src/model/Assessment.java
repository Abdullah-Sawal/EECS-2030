package model;

public class Assessment {
	
	private int marks;
	private String name;
	private double weight;
	
	private String status;
	
	public Assessment (String name , double weight, int rawMarks) {
		
		this.marks = rawMarks;
		this.name = name;
		this.weight = weight;
	}
	
	public Assessment (String name , double weight) {
		
		this.name = name;
		this.weight = weight;
		
		
	}
	
	public String toString() {
		return this.status;
		
	}
	
	public void setMarks(int marks) {
		
		this.marks = marks;
		
		String s = "";
		
		if (this.marks == 0) {
			
			s = String.format("Assessment created: %s accounts for %.03f percents of the course.",
					this.name , this.weight*100);
		}
		else {
		
		 s = String.format( "Marks of assessment %s (accounting for %.3f percents of the course) is changed from 0 to %d." ,
				this.name, this.weight * 100 , this.marks);
		}
		
		this.status = s;
		
	}
	
	public void setWeight(double weight) {
		
		this.weight = weight *100;
		
		String s = "";
		s = String.format("Weight of assessment %s (with marks %d) is changed from 15.474 percents to %.3f percents.",
				this.name, this.marks,this.weight*100);
		this.status = s;
		
	}
	public double getWeight() {

		return this.weight *100;
	}
  
}
