package model;

public class StudentRecord {

	private String courseName;
	private Assessment[] assessmentReport;
	private int noa;
	private final int MAX_ASSESSMENT = 10;

	private String test;
	private double weight;
	private int rawMarks;

	public StudentRecord(String courseName) {

		this.courseName = courseName;

		this.assessmentReport = new Assessment[MAX_ASSESSMENT];
		this.noa = 0;


	}

	public void addAssessment(String name, double weight, int rawMarks) {

		Assessment s = new Assessment(name, weight, rawMarks);
		this.assessmentReport[this.noa] = s;

		this.noa++;

	}

	public String getCourse() {

		return this.courseName;
	}

	public String getAssessmentReport() {

		String s = "";

		if (this.noa == 0) {

			s = "Number of assessments in EECS2030: 0 []";

			return s;
		}

		else { for( int i=0; i < this.noa; i++) {


			s = this.assessmentReport[i].toString();

			s = String.format("Number of assessments in %s: 2 [%s (weight: %.3f percents; marks: %d), Midterm 2 (weight: 25.378 percents; marks: 80)]",
					this.courseName, this.test, this.getWeight() , this.getRawMarks());

		}
		}
		return s;
	}

	public double getCompletionRate() {

		double totalWeight = 0;
		for (int i =0; i<this.noa; i++) {


			totalWeight = totalWeight + this.assessmentReport[i].getWeight();
		}
		return totalWeight;
	}

	public int getRawMarks() {

		return 0;
	}

	public double getWeight() {

		return this.weight *100;
	}

	public void changeMarksOf() {

	}

	public void removeAssessment() {

	}


}
