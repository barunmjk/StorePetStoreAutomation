package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.UserStore;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {
	 public static Response  createStore(UserStore payload){
		 Response response = given()
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(payload)
		   .when()
		   .post(Routes_Store.post_User);
		 return response;
	   }
	   public static Response readStore(int orderId) {
		Response response=   given()
		   .pathParam("orderId", orderId)
		   .when()
		   .get(Routes_Store.get_User);
		   return response;
	   }
}
