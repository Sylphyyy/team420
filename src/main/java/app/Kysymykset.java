package app;

public class Kysymykset {

	protected int kysymys_id;
	protected String kysymys;
	
	  
	   
	    
    public Kysymykset(int kysymys_id, String kysymys) {

        this.kysymys_id = kysymys_id;
        this.kysymys = kysymys;
      }
	      


		public int getKysymys_id() {
	        return kysymys_id;
	    }
	 
	    public void setKysymys_id(int kysymys_id) {
	        this.kysymys_id = kysymys_id;
	    }
	    
	    public String getKysymys() {
	        return kysymys;
	    }
	 
	    public void setKysymys(String kysymys) {
	        this.kysymys = kysymys;
	    }
	    
	    
    }
