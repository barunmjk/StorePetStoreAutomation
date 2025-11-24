package api.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.UserStore;
import io.restassured.response.Response;

public class UserStoreTest {
     UserStore payload;
     @BeforeClass
     public void setUp() {
    	 payload=new UserStore();
    	   Faker fakedata=new Faker();
    	    payload.setId(fakedata.number().numberBetween(1, 9999));
    	    payload.setPetId(fakedata.number().numberBetween(1, 9999));
    	    payload.setQuantity(fakedata.number().numberBetween(1, 5));
 
    	    Date future = fakedata.date().future(30, java.util.concurrent.TimeUnit.DAYS);
    	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	    payload.setShipDate(sdf.format(future));
 
    	    payload.setStatus("placed");
    	    payload.setComplete(true);

    	 
     }
     @Test(priority = 1)
     public  void storeCreateTest() {
    Response res =	UserEndPoint.createStore(this.payload);
    res.then().log().all();
    
    Assert.assertEquals(res.getStatusCode(), 200);
     }
     @Test(priority = 2)
     public void readStoreTest() {
    	 Response res =	UserEndPoint.readStore(this.payload.getId());
    	    res.then().log().all();
    	    Assert.assertEquals(res.getStatusCode(), 200);
     }
}
