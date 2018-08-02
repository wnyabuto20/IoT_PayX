import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class CallbackController {
    public static JsonObject json = new JsonObject();
    public CallbackController(){
    }
    public static Object handleMpesa(Request req, Response res){

        return doMpesa(req, res);
    }
    private static Object doMpesa(Request req, Response res){
/**
 * the req.body is the callback and it is a json object
 * it is changed to an Mpesa object using JSON
 */
        System.out.println("Here is the confirmation:  " + req.body());

        Mpesa received = new Gson().fromJson(req.body(),Mpesa.class);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Payment Status: "+ received.getStatus());
        publisher send_0k = new publisher();
        send_0k.setContent(received.getStatus());
        send_0k.publish();
        return received;
    }

}
