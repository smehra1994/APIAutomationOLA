package olaBeanHelpers;

import java.io.Serializable;
import java.util.List;

public class Command_data implements Serializable {

	private String affiliate_uid;
	private List<CustomEntry> items;
	
	
	public String getaffiliate_uid()
	{
		return affiliate_uid;
	}
	
	public void setaffiliate_uid(String affiliate_uid )
	{
		this.affiliate_uid=affiliate_uid;
	}
	
	
	public List<CustomEntry> getitems()
	{
		return items;
	}
	
	public void setitems(List<CustomEntry> items )
	{
		this.items= items;
	}
	
	
	
	
}
