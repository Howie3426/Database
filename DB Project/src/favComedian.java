public class favComedian
{
	protected String favComedianF;
	protected String favComedianL;
	protected int favComedianID;
	
	public favComedian()
	{
		
	}
	
    
    public String getFavComedianF()
    {
    	return favComedianF;
    }
    
    public void setfavComedianF(String favComedianF)
    {
    	this.favComedianF = favComedianF;
    }
    
    public String getFavComedianL()
    {
    	return favComedianL;
    }
    
    public void setfavComedianL(String favComedianL)
    {
    	this.favComedianL = favComedianL;
    }
    
    public int getFavComedianID()
    {
    	return favComedianID;
    }
    
    public void setfavComedianID(int favComedianID)
    {
    	this.favComedianID = favComedianID;
    }
	
	public favComedian(String favComedianF, String favComedianL, int favComedianID)
	{
		this(favComedianF, favComedianL);
		this.favComedianID = favComedianID;
	}

	
	public favComedian(String favComedianF, String favComedianL) 
	{
        this.favComedianF = favComedianF;
        this.favComedianL = favComedianL;
    }
	
}