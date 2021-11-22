package model;

public class Follower {

	protected String name;
	protected String onlyName;

	protected Channel[] channels;
	protected int noc;

	protected String[] recommendedVideos;
	protected int nor;
	
	protected String type;

	private int maxFollow;


	public Follower(String name, int MAX_FOLLOW) {

		this.name = String.format("Monitor %s",name);
		this.channels = new Channel[MAX_FOLLOW];

		this.onlyName = name;

		this.maxFollow = MAX_FOLLOW;
		
		this.type = "Monitor";

	}

	public Follower(String name, int MAX_FOLLOW, int MAX_RECOMMENDED) {

		this.name = String.format("Subscriber %s",name);
		this.channels = new Channel[MAX_FOLLOW];
		this.onlyName = name;
		this.maxFollow = MAX_FOLLOW;

		this.recommendedVideos = new String[MAX_RECOMMENDED];
		this.nor = 0;
		
		this.type = "Subscriber";

	}

	public int getMaxFollow() {

		return this.maxFollow;

	}
	
	public String getType() {
		
		return this.type;
	}


	public String getName() {

		return this.name;

	}


	public String getRecommendedVideos() {

		String s = "";

		s += "<";

		for (int i =0; i< this.nor; i++) {

			s += this.recommendedVideos[i];

			if( i < this.nor -1) {

				s += ", ";

			}


		}
		
		s += ">";
		
		return s;




	}

	public String getChannels() {

		String s = "";

		s += "[";

		for (int i =0; i< this.noc; i++) {

			s += this.channels[i].getName();

			if( i < this.noc -1) {

				s += ", ";

			}

		}

		s += "]";

		return s;


	}


}
