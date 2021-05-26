package olaHelpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;

import olaBaseHelpers.GlobalHelper;
import olaBeanHelpers.Command_data;
import olaBeanHelpers.CustomEntry;
import olaBeanHelpers.OlaRefund;
import olaBeanHelpers.OlaRequest;

public class OlaHelper extends GlobalHelper {

	public String OlaHelper() {
	
		String baseUrl=readFromPropertiesFile(configPath, "OLA.BASEURL");
		String OlaLogin_EXCEL_PATH=readFromPropertiesFile(configPath, "OLA_LOGIN_EXCEL_PATH");
		String Estimate_EXCEL_PATH=readFromPropertiesFile(configPath, "ESTIMATE_EXCEL_PATH");
		String BookingRide_EXCEL_PATH=readFromPropertiesFile(configPath, "BOOKING_RIDE_EXCEL_PATH");
		String TrackRide_EXCEL_PATH=readFromPropertiesFile(configPath, "TRACK_RIDE_EXCEL_PATH");
		String StateChange_EXCEL_PATH=readFromPropertiesFile(configPath, "STATE_CHANGE_EXCEL_PATH");
		String OlaRefund_EXCEL_PATH=readFromPropertiesFile(configPath, "OLA_REFUND_EXCEL_PATH");
		String currency=readFromPropertiesFile(configPath,"currency");
		String refund_amount=readFromPropertiesFile(configPath,"refund_amount");
		String DB=readFromPropertiesFile(dbConfigPath,"OLA_DB");
		String USERNAME=readFromPropertiesFile(dbConfigPath,"OLA_USERNAME");
		String PASSWORD=readFromPropertiesFile(dbConfigPath,"OLA_PASSWORD");
		String mobileNo=readFromPropertiesFile(configPath,"CUSTOMER_ID");
	
	public String olarefund(String command, String affiliate_uid, String udf1, String checksum) {
		Gson gson = new Gson();
		Command_data Command_data = new Command_data();
		OlaRefund OlaRefund = new OlaRefund();
		CustomEntry CustomEntry = new CustomEntry();

		Command_data.setaffiliate_uid(affiliate_uid);

		List<CustomEntry> items = new ArrayList<CustomEntry>();
		CustomEntry.setamount(refund_amount);
		CustomEntry.setcurrency(currency);
		CustomEntry.setref_id(TrackRide.booking_id);

		Command_data.setitems(items);

		OlaRefund.setchecksum(checksum);

		OlaRefund.setudf1(udf1);

		// return gson.toJson(OlaRefund).toString();

		return gson.toJson(OlaRefund).toString();

	}
	
	
	public String generateOlaLoginJSON(String authToken) {
		Gson gson = new Gson();
		OlaRequest olarequest=new OlaRequest();
		olarequest.setAuthToken(authToken);
		return gson.toJson(olarequest).toString();

		

	}
	
	

	/* used to generate unique string everytime */
	public static String generateString() {
		/*
		 * A GUID / UUID is a 128 bit number often represented as a series of 32 HEX
		 * values. A HEX value is base 16
		 */
		String uuid = UUID.randomUUID().toString();
		return uuid;
		// TODO Auto-generated method stub
	}

	@DataProvider
	public String[][] olaloginDataProvider() throws IOException {
		String[][] data = getTestData(OlaLogin_EXCEL_PATH, "OlaLogin");
		return data;
	}

	@DataProvider
	public String[][] estimateDataProvider() {
		String[][] data = getTestData(Estimate_EXCEL_PATH, "Estimate");
		return data;
	}

	@DataProvider
	public String[][] bookingRidedataProvider() {
		String[][] data = getTestData(BookingRide_EXCEL_PATH, "BookingRide");
		return data;
	}

	@DataProvider
	public String[][] trackRideDataProvider() {
		String[][] data = getTestData(TrackRide_EXCEL_PATH, "TrackRide");
		return data;
	}

	@DataProvider
	public String[][] stateChangeDataProvider() {
		String[][] data = getTestData(StateChange_EXCEL_PATH, "StateChange");
		return data;
	}

	@DataProvider
	public String[][] olaRefundDataProvider() {
		String[][] data = getTestData(OlaRefund_EXCEL_PATH, "OlaRefund");
		return data;
	}
	
	public String WalletBalance(String WalletQuery,String WalletBalance)
	{
		String WalletAmount=GlobalHelper.getDatafromDB(DB,USERNAME,PASSWORD,WalletQuery,rowValue);
		return WalletAmount;
	}

}

