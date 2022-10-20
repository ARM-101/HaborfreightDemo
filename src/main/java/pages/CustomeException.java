package pages;

public class CustomeException extends RuntimeException {
	
	public static final String MSG = "test";
	public CustomeException()
	{
		super(MSG);
	}
	
	public CustomeException(String msg)
	{
		super(msg);
	}
	
	public CustomeException(Throwable e)
	{
		super(MSG,e);
	}

}
