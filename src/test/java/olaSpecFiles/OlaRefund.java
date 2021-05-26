package olaSpecFiles;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import olaHelpers.OlaHelper;

public class OlaRefund extends OlaHelper {

	public static String affiliate_uid = generateString();
	public static String udf1 = generateString();
	public static String command = "refund";
	public static String salt = "XYZ123";
	public String contentType = "application/json";
	public String query = "select * from WallwtBalance";
	public String row = "WALLETBALANCE";

	@Test(dataProvider = "olaRefundDataProvider")
	public void Olarefund(String headerName1, String headerValue1, String headerName2, String headerValue2,
			String message, String status) {

		float dbStatus_before = (Float.parseFloat(WalletBalance(query, row)));
		float a = dbStatus_before;
		float b = Float.parseFloat(refund_amount);
		float c = a + b;
		System.out.println("Final Amount" + c);

		String checksumdata = affiliate_uid + "|" + TrackRide.bookingId + "refund_amount" + "currency" + salt;
		String checksum = DigestUtils.sha256Hex(checksumdata);

		String url = baseUrl;

		String Jsontransactionrefund = olarefund(command, affiliate_uid, udf1, checksum);
		System.out.println("----------REQUEST----------");
		System.out.println(Jsontransactionrefund);

		Response response = given().contentType(contentType).body(Jsontransactionrefund).log().all()
				.header(headerName1, headerValue1).header(headerName2, headerValue2).when().post(url).then().extract()
				.response();
		System.out.println("----------RESPONSE----------");

		float dbStatus_after = (Float.parseFloat(WalletBalance(query, row)));
		float d = dbStatus_after;
		Assert.assertEquals(c, d);
		System.out.println("Matched and correct");

	}
}
