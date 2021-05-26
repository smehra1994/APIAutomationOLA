package olaSpecFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import olaHelpers.OlaHelper;

public class OlaLogin extends OlaHelper {

	@Test(dataProvider = "olaRefundDataProvider")
	public void Olarefund(String headerName2, String headerValue2, String authToken, String responseCode,
			String description) {
		String url = baseUrl;
		String contentType = "application/json";
		String headerName1 = "customerId";

		String olajson = generateOlaLoginJSON(authToken);
		System.out.println("-----------REQUEST-------");
		System.out.println(olajson);

		Response response = given().contentType(contentType).log().all().body(olajson).header(headerName1, mobileNo)
				.header(headerName2, headerValue2).when().post(url).the().extract().response();
		System.out.println("---------RESPONSE------");

		System.out.println(response.toString());
		Assert.assertEquals(response.path("meta.code"), responseCode);
		Assert.assertEquals(response.path("meta.description"), description);

	}

}