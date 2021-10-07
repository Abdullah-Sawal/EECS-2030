package model;
import model.Registration;

public class Transcript {

	private Registration[] transcript;
	private int nor;
	private int MAX_REG = 60 ;
	private int marks;
    private String studentName;

	public Transcript ( String name) {
		
		this.studentName = name;
         
		this.transcript = new Registration[MAX_REG];
		this.nor = 0;

	}

	public void setMarks( String courseName, int marks) {

		for ( int  i = 0; i < this.nor; i++) {

			if (this.transcript[i].getCourseName().equals(courseName)) {

				this.transcript[i].setMarks(marks);
			}
		}
	}

	public void addRegistration(String courseName, int credits) {

		Registration rg = new Registration( courseName, credits );
		this.transcript[nor] = rg;
		this.nor ++;


	}

	public void addRegistration( Registration rg) {

		this.transcript[nor]= rg;
		this.nor ++;


	}

	public void addRegistrations( Registration[] registrations) {

		for ( int i =0; i < registrations.length ; i++) {
			this.transcript[nor] = registrations[i];
			this.nor ++;
		}
	}

	public  int getMarks(String courseName) {

		int y = 0;
		boolean nameExists = false;

		for ( int  i = 0; i < this.nor && !nameExists; i++) {

			if (this.transcript[i].getCourseName().equals(courseName)) {

				nameExists = true;
			}

			if (nameExists) {

				y = this.transcript[i].getMarks();
			}

			else {
				y = -1;
			}
		}

		return y;
	}

	public Registration[] getReport( ) {

		Registration [] rg = new Registration[this.nor];

		for (int i =0; i< this.nor; i++) {

			rg[i] = this.transcript[i];
		}
		return rg;
	}


	public double getWeightedGPA() {

		double sumGrade = 0.0;

		for ( int  i = 0; i < this.nor; i++) {


			sumGrade = sumGrade + this.transcript[i].getWeightedGradePoint();



		}

		double s = sumGrade/nor;
		return s;
	}

	public String getStudentName() {
		
		return studentName;

	}


}































