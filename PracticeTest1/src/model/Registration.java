package model;

public class Registration {

	private String courseName;
	private int credits;
	private int rawMarks;
	
	

	public Registration (String courseName, int credits) {

		this.courseName = courseName;
		this.credits = credits;

	}


	public Registration ( String courseName , int credits, int rawMarks) {

		this.courseName = courseName;
		this.credits = credits;
		this.rawMarks = rawMarks;

	}

	public void setMarks( int marks) {

		this.rawMarks = marks;
	}

	public String getCourseName() {

		return this.courseName;
	}

	public int getNumberOfCredits() {

		return this.credits;
	}

	public int getMarks() {

		return this.rawMarks;
	}

	public String getLetterGrade( ) {

		String s = "";

		if ( rawMarks >= 90) {

			s ="A+";
		}

		else if ( rawMarks >= 80) {

			s ="A";
		}
		else if ( rawMarks >= 70) {

			s ="B";
		}
		else if ( rawMarks >= 60) {

			s ="C";
		}
		else if ( rawMarks >= 50) {

			s ="D";
		}

		else if(rawMarks <= 50){

			s = "F";
		}
		return s;

	}

	public int getWeightedGradePoint() {

		int g = 0;

		if (this.getLetterGrade().equals("A+")) {

			g = 9 * this.credits;
		}
		if (this.getLetterGrade().equals("A")) {

			g = 8 * this.credits;
		}
		if (this.getLetterGrade().equals("B")) {

			g = 7 * this.credits;
		}
		if (this.getLetterGrade().equals("C")) {

			g = 6 * this.credits;
		}
		if (this.getLetterGrade().equals("D")) {

			g = 5 * this.credits;
		}
		if (this.getLetterGrade().equals("F")) {

			g = 0;
		}
		
		return g;
	}
}





















































