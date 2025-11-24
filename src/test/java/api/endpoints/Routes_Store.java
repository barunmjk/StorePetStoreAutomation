package api.endpoints;

public class Routes_Store {
  public static String base_Url="https://petstore.swagger.io/v2";
  
  public static String post_User=base_Url+"/store/order";
  public static String get_User=base_Url+"/store/order/{orderId}";
  public static String delete_User=base_Url+"/store/order/{orderId}";
 
}
