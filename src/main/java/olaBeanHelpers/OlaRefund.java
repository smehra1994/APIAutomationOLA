package olaBeanHelpers;

import java.io.Serializable;

public class OlaRefund implements Serializable {

	private String command;
	private String command_data;
	private String udf1;
	private String checksum;
	
	public String getcommand()
	{
		return command;
	}
	
	public void setcommand(String command)
	{
		this.command=command;
	}
	
	public String getcommand_data()
	{
		return command_data;
	}
	
	public void setcommand_data(String command_data)
	{
		this.command_data=command_data;
	}
	
	public String getudf1()
	{
		return udf1;
	}
	
	public void setudf1(String udf1)
	{
		this.udf1=udf1;
	}
	
	public String getchecksum()
	{
		return checksum;
	}
	
	public void setchecksum(String checksum)
	{
		this.checksum=checksum;
	}

}
