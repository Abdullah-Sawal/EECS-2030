package model;

public class Bank {
	
	private Account[] accounts;
	private int noa;
	
	public Bank() {
		
		this.accounts = new Account[5];
		
		
	}
	
	public Bank(Bank other) {
		
		this.accounts = new Account[5];
		
		for ( int i = 0; i < other.noa; i++) {
			
			this.accounts[i] = other.accounts[i];
			
		}
		this.noa = other.noa;
		
	}
	
	
	public void addAccount(Account a) {
		
		this.accounts[this.noa] = a;
		this.noa ++;
		
	}
	
	
	public void addAccounts(Account[] a) {
		
		for (int i = 0; i < 3 ; i ++) {
			
			this.accounts[noa] = new Account(a[i]);
			this.noa ++;
			
		}
		
		
		
	}
	
	public int getNumberOfAccounts() {
		
		return this.noa;
		
	}
      public Account[] getReferencesOfAccounts(){
    	  
    	  Account[] a = new Account[this.noa];
    	  
    	  for (int i = 0; i < this.noa; i ++) {
    		  
    		  
    		  a[i] = this.accounts[i];
    		  
    	  }
    	  
    	 return a;
    	  
    	  
      }
      
      public Account[] getCopiesOfAccounts() {
    	  
    	  Account[] a = new Account[this.noa];
    	  
    	  for (int i =0; i<this.noa; i++) {
    		  
    		  a[i] = new Account(this.accounts[i]);
    		  
    	  }
    	  
     	return a;
    	  
      }
      
      
      
      public boolean equals(Object obj) {
    	  

  		if (this == obj) {
  			return true;
  		}

  		if ( obj == null || this.getClass() != obj.getClass() ) { 
  			return false;
  		}
  		
  		Bank other = (Bank) obj;
  		
  		boolean b = this.noa == other.noa;
  		
  		if(b) {
  			
  			for (int i =0; i < this.noa; i ++) {
  				
  				b = this.accounts[i] == other.accounts[i];
  				
  				
  			}
  			
  			
  		}
  		
    	  return b;
    	  
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
