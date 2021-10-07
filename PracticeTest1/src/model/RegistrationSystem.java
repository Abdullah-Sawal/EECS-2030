package model;

import model.Transcript;

public class RegistrationSystem {

	private Transcript[] transcripts;
	private int not;
	private final int MAX_TRANSCRIPTS = 500;

	public RegistrationSystem() {

		this.transcripts = new Transcript[MAX_TRANSCRIPTS];
		this.not = 0;

	}

	public void addTranscript(Transcript name) {

		this.transcripts[not] = name;
		this.not ++;


	}

	public Transcript[] getReport() {

		Transcript [] ts = new Transcript[this.not];

		for ( int i=0; i < this.not; i++) {

			ts[i] = transcripts[i];
		}
		return ts;
	}

	public int getMarks(String studentName, String courseName) {

		int y = -1;

		for ( int i = 0; i < this.not; i++) {

			if (transcripts[i].getStudentName().equals(studentName)) {
				
				y = transcripts[i].getMarks(courseName);

			}
		}
		return y;
	}





}
