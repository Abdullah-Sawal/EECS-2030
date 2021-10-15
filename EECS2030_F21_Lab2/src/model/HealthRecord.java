package model;

public class HealthRecord {  
	
	private String patientName;
	private int maxNumberOfDoses;
	
	private String[] data;
	private int nod;
	
	public HealthRecord(String patientName, int maxNumberOfDoses) {
		
		this.patientName = patientName;
		this.maxNumberOfDoses = maxNumberOfDoses;
		
		this.data = new String[maxNumberOfDoses];
		this.nod = 0;
		
		
		
	}
	
	public void addRecord(Vaccine v, String hospital, String date) {
		
		this.data[nod] = String.format("%s in %s on %s",
				v, hospital, date);
				
		this.nod ++;
		
		
		
	}
	
	public String getVaccinationReceipt() {
		
		String s = "";
		
		if(this.nod == 0 ) {
			
			s = String.format("%s has not yet received any doses.",
					this.patientName);
		}
		else {
			
			String a = "";
			
			for(int i = 0; i < this.nod; i++) {
				
				a += this.data[i];
				
				if (i < this.nod -1) {
					
					a += "; ";
				}
				
				s = String.format("Number of doses %s has received: %d [%s]",
						this.patientName,this.nod, a.toString());
				
						
			}
		
		}
				return s;
		
	}
	
	public String getAppointmentStatus() {
		
String s = "";
		
		s = "No vaccination appointment for Alan yet";
				
				return s;
		
		
	}

}
