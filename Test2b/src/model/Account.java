package model;



public class Account {
	
	private String name;
	private int balance;
	
	private int noVIP;
	private String Status;
	private int deposit;
	
	public Account(String name, int balance ) {
		
		this.name = name;
		this.balance = balance;
		
		
	}
	
	
	public Account( Account other) {
		
		this (other.name,other.balance);
		this.Status = other.Status;
		this.noVIP = other.noVIP;
		this.deposit = other.deposit;
		
	}
	
	public void switchToVIP(int deposit) throws InvalidStatusToSwitchException, InsufficientBalanceException{
		  
		this.deposit = deposit;
		
	   if (this.noVIP > 0) {
			
			throw new InvalidStatusToSwitchException("Already VIP");
			
		}
		
	   else if( this.balance < deposit) {
			
			throw new InsufficientBalanceException("not enough balance");
		}
		
		else {
		
		this.balance = this.balance - deposit;
		
		this.Status = String.format("A VIP account owned by %s with balance $%d ($%d deposited for maintaining the VIP stauts)",this.name,this.balance,deposit);
		this.noVIP ++;
		}
	   
	}
	   
	   public void switchToRegular() throws InvalidStatusToSwitchException{
		   
		   if (this.noVIP == 0) {
			   
			   throw new InvalidStatusToSwitchException("Not a Vip");
			   
		   }
		   
		   this.noVIP --;
		   this.balance = this.balance + this.deposit;
		  
		
	}
	
	public String toString () {
		
		String s = "";
		
		if (this.noVIP > 0) {
			
			s = this.Status;
			
		}
		
		else {
		
		s = String.format("A regular account owned by %s with balance $%d",this.name,this.balance);
		
		}
		
		return s;
	}
	
	
	public boolean equals (Object obj) {
		
		
		if (this == obj) {
			return true;
		}

		if ( obj == null || this.getClass() != obj.getClass() ) { 
			return false;
		}
		
		Account other = (Account) obj;
		
		
		return 
				this.name == other.name &&
				this.balance == other.balance &&
				this.noVIP == other.noVIP;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
