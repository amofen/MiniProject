package tdm.miniproject.managers;

import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;

/**
 * Created by amine on 26/06/2016.
 */
public class RequestManager {
    public static final String localUrl= "http://192.168.43.186:8080/";


    public static String getRequestProductListWP(String density, Category category, Consumer consumer){
        try{
            String request = localUrl+
                    "getProducts?"+
                    "density="+density+
                    "&category="+ URLEncoder.encode(category.toString(),"UTF-8")+
                    "&consumer="+URLEncoder.encode(consumer.toString(),"UTF-8");
            return request;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static String getRequestCartCheck(){
        return localUrl+"cartOperation";
    }

    public static String getRequestAuthen(){return localUrl+"authenticateUser";}

    public static String getRequestGetOrders(){return localUrl+"getOrders";}

    public static String getRequestValidateOrders(){return localUrl+"validateOrder";}

    public static String getPhotoRequest(String productName,String density){
        String req=null;
        try{
            req = localUrl
                    +"getProductPhoto"
                    + "?product_name="
                    +URLEncoder.encode(productName,"UTF-8")
                    +"&density="
                    +density;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return req;
    }
}
