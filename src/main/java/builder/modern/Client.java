package builder.modern;

import java.util.Date;

/**
 * Created by Beka on 04.06.17.
 */
public class Client {
    public static void main(String[] args) {
        Message message=new Message.Builder("This is a message")
                .setMessageType("outgoing")
                .setEncodingType("base64")
                .setRecieverName("Joe")
                .setSenderName("Anna")
                .setSentTime(new Date())
                .build();
    }
}
