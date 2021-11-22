package model;

public class Monitor extends Follower{

	public Monitor(String name, int MAX_FOLLOW) {

		super(name, MAX_FOLLOW);
	}

	public String toString() {

		String s = "";

		if( this.noc == 0) {

			s = String.format("Monitor %s follows no channels.",this.onlyName);

		}

		else {


			s = String.format("Monitor %s follows %s.",this.onlyName ,this.getChannels());

		}
		return s;
	}

}
