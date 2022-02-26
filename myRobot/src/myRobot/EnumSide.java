package myRobot;

public enum EnumSide
{
	Up( "Up" ),
	Down( "Down" ),
	Left( "Left" ),
	Right( "Right" );

	private String side;
	
	EnumSide( String side ) 
	{ 
		this.side = side;
	}   
	public String getSide()
	{
		return side;
	}
	public void setSide( String side )
	{
		this.side = side;
	}
} 