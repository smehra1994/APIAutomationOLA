package olaSpecFiles;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import olaHelpers.OlaHelper;

public class TrackRide extends OlaHelper {
	
public static String bookingId=null;

	@Test(dataProvider = "estimateDataProvider")
	public void trackRide(String headerName2, String headerValue2, String responseCode,String description) {
		String url = baseUrl;
		//String url = baseUrl + BookingRide.merchantTxnId;
		String contentType = "application/json";
		String headerName1 = "customerId";
		
		Response response = given().contentType(contentType).log().all().header(headerName1, mobileNo)
				.header(headerName2, headerValue2).when().post(url).the().extract().response();
		System.out.println("---------RESPONSE------");
		
		System.out.println(response.toString());
		Assert.assertEquals(response.path("meta.code"), responseCode);
		Assert.assertEquals(response.path("meta.description"), description);
		
		bookingId = response.path("data.bookingId");
		System.out.println("Booking ID is : ");
		System.out.println(bookingId);
		}
}