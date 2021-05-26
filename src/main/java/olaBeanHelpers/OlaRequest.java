package olaBeanHelpers;

public class OlaRequest {

	private String dropLat;
	private String dropLong;
	private String category;
	private String pickupMode;
	private String merchantTxnId;
	private String booking_id;
	private String authToken;
	
	
	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getref_id()
	{
		return dropLat;
	}
	
	public void setdropLat(String dropLat)
	{
		this.dropLat=dropLat;
	}
	
	public String getdropLong()
	{
		return dropLong;
	}
	
	public void setdropLong(String dropLong)
	{
		this.dropLong=dropLong;
	}
	
	public String getcategory()
	{
		return category;
	}
	
	public void setcategory(String category)
	{
		this.category=category;
	}
	
	public String getpickupMode()
	{
		return pickupMode;
	}
	
	public void setpickupMode(String pickupMode)
	{
		this.pickupMode=pickupMode;
	}
	
	public String getmerchantTxnId()
	{
		return merchantTxnId;
	}
	
	public void setmerchantTxnId(String merchantTxnId)
	{
		this.merchantTxnId=merchantTxnId;
	}
	
	public String getbooking_id()
	{
		return booking_id;
	}
	
	public void setbooking_id(String booking_id)
	{
		this.booking_id=booking_id;
	}
	
}
