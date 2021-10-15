package model;

public class VaccineDistribution {
	
	private Vaccine vaccine;
	private int numberOfDoses;
	
	public VaccineDistribution( Vaccine vaccine, int numberOfDoses ) {
		
		this.vaccine = vaccine;
		this.numberOfDoses = numberOfDoses;
		
		
	}
	
	public Vaccine getVaccine() {
		
		return this.vaccine;
	}
	
	public int getNumberOfDoses() {
		
		return this.numberOfDoses;
	}
	
	public String toString() {
		
		String s = "";
		
		s = String.format("%d doses of %s by %s",
				
				this.numberOfDoses, vaccine.getCodeName(), vaccine.getManufacturer());
		
		return s;
	}

}
