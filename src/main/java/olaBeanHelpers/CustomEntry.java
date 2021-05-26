package olaBeanHelpers;

import java.io.Serializable;

public class CustomEntry implements Serializable{

	
	private String ref_id;
	private String amount;
	private String currency;
	
	
	public String getref_id()
	{
		return ref_id;
	}
	
	public void setref_id(String ref_id)
	{
		this.ref_id=ref_id;
	}
	
	public String getamount()
	{
		return amount;
	}
	
	public void setamount(String amount)
	{
		this.amount=amount;
	}
	
	public String getcurrency()
	{
		return currency;
	}
	
	public void setcurrency(String currency)
	{
		this.currency=currency;
	}
}
