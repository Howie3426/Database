
public class comedian 
{
	protected String firstName;
	protected String lastName;
	protected int date;
	protected int id;
	
	public comedian()
	{
		
	}
	
	String getFirstName()
	{
		return firstName;
	}
	
	String getLastName()
	{
		return lastName;
	}
	
	int getDate()
	{
		return date;
	}
	
	int getID()
	{
		return id;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setDate(int date)
	{
		this.date = date;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public comedian(String firstName, String lastName, int date, int id)
	{
		this(firstName, lastName, date);
		this.id = id;
	}

	
	public comedian(String firstName, String lastName, int date)
	{
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

	public Object getComedianId() {
		// TODO Auto-generated method stub
		return null;
	}
}
