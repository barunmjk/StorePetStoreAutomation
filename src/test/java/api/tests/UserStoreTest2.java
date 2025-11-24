package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.UserStore;
import api.store.Utilities.XLDataProvider;
import io.restassured.response.Response;

public class UserStoreTest2 {
	UserStore us =new UserStore();
int Id;
	@Test(priority = 1, dataProvider = "Data1",dataProviderClass = XLDataProvider.class)
     public void userPostStoreTest(String id ,String petId ,String quantity,String shipDate,String  status,String  complete) {
		  Id= (int)Double.parseDouble(id);
		     
		  int petid= (int)Double.parseDouble(petId);
		  int Quantity= (int)Double.parseDouble(id);
		  boolean Complete= Boolean.parseBoolean(complete.toLowerCase());
       	 us.setId(Id);
       	 System.out.println(us.getId());
       	 us.setPetId(petid);
       	 System.out.println(us.getPetId());
       	 us.setQuantity(Quantity);
       	 System.out.println(us.getQuantity());
       	 us.setShipDate(shipDate);
       	 us.setStatus(status);
       	 us.setComplete(Complete);
       Response res=	 UserEndPoint.createStore(us);
       Assert.assertEquals(res.getStatusCode(), 200);
     }@Test(priority = 2)
	public void storeGetTest() {
		 
	Response res=	UserEndPoint.readStore(Id);
	  res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
	}
}
