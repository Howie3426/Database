
public class user 
{
	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String password;
	protected String age;
	protected String url;
	protected String description;
	protected String title;
	
	public user()
	{
	
	}
	
	public user(String userName)
	{
		this.userName = userName;
	}
	
	public user(String userName, String password, String firstName,
			String lastName, String age)
	{
		this(password, firstName, lastName, age);
		this.userName = userName;
	}

	
	public user(String password, String firstName,
			String lastName, String age) 
	{
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
	
    public String getuserName() {
        return userName;
    }
 
    public void setUsername(String userName) {
        this.userName = userName;
    }
    
    public String password() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String firstName() {
        return firstName;
    }
 
    public void setName(String firstName) {
        this.firstName = firstName;
    }
 
    public String lastName() {
        return lastName;
    }
 
    public void setLast(String lastName) {
        this.lastName = lastName;
    }
    
    public String age()
    {
    	return age;
    }
    
    public void setAge(String age)
    {
    	this.age = age;
    }
    
    public String url()
    {
    	return url;
    }
    
    public void setUrl(String url)
    {
    	this.url = url;
    }

    public String title()
    {
    	return title;
    }
    
    public void setTitle(String title)
    {
    	this.title = title;
    }
    
    public String description()
    {
    	return description;
    }
    
    public void setDescription(String description)
    {
    	this.description = description;
    }

}