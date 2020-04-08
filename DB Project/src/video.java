
public class video 
{
	protected String url;
	protected String title;
	protected String description;
	protected String tags;
	
	public video()
	{
		
	}
	
	String getURL()
	{
		return url;
	}
	
	String getTitle()
	{
		return title;
	}
	
	String getDescription()
	{
		return description;
	}
	
	String getTags()
	{
		return tags;
	}
	
	public void setURL(String url)
	{
		this.url = url;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setTags(String tags)
	{
		this.tags = tags;
	}
	
	public video(String url, String title, String description,
			String tags)
	{
		this(title, description, tags);
		this.url = url;
	}

	
	public video(String title, String description,
			String tags) 
	{
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

	public String getPoster()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
