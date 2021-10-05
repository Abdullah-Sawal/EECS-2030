package model;

import java.util.Arrays;


public class Log {


	private String version;
	private int numberOfFixes;
	private String[] fixes ;
	private final int MAX_FIXES = 10;
	
	
   	
	
	 
	public Log (String version) {
		
		this.fixes = new String[MAX_FIXES];
		this.version = version;
		this.numberOfFixes = 0;

	}


	public String getVersion () {
		return this.version;
	}

	public int getNumberOfFixes() {

		return this.numberOfFixes;

	}

	public void addFix( String NewFix) {


		this.fixes[numberOfFixes] = NewFix;
		numberOfFixes ++;
	}

	public String getFixes() {


		String s = "";
		
		s += "[";
		
		for ( int i = 0; i< this.numberOfFixes; i++) {
			
			s += this.fixes[i];
			
			if (i< this.numberOfFixes -1) {
				
			s += ", ";
			}
	
		}
		
		s += "]";
		
		return s;

	} 


	public String toString() {

		String s = "";

		s += "Version" + " " + this.version + " " + "contains" + " " + numberOfFixes + " " + "fixes"+  " "  + getFixes();

		return s;
	}

}




	

























