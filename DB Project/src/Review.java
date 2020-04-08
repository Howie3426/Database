
public class Review
{
	protected String url;
	protected String review;
	protected String description;
	
	public Review()
	{
		
	}
	
	String getURL()
	{
		return url;
	}
	
	String getReview()
	{
		return review;
	}
	
	String getDescription()
	{
		return description;
	}
	
	public void setURL(String url)
	{
		this.url = url;
	}
	
	public void setReview(String review)
	{
		this.review = review;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Review(String url, String review, String description)
	{
		this(review, description);
		this.url = url;
	}

	
	public Review(String review, String description) 
	{
        this.review = review;
        this.description = description;

    }
}