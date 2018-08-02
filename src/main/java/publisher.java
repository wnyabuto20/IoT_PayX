import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import java.util.*;
public class publisher {
String content;
public void setContent(String message){
    content = message;
}
    public void publish () {
        Date today = new Date();
        String topic        = "wayne/pay_status";
        String password = "waynenyabuto";
        char[] passWord = new char[12];
        password.getChars(0,12,passWord,0);
        int qos             = 1;
        String broker       = "tcp://sungura1-angani-ke-host.africastalking.com:10883";
        String clientId     = "ok_sender";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName("wayne");
            connOpts.setPassword(passWord);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic,message);
            System.out.println("message published");
            //System.out.println("Disconnected");
            // System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}
