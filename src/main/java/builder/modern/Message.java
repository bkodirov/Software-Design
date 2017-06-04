package builder.modern;

import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * Created by Beka on 04.06.17.
 */
public class Message {
    //Assume this field is must have field
    @NotNull private final String message;
    private String senderName;
    private String recieverName;
    private Date sentTime;
    private String messageType;
    private String encodingType;

    /**
     * Keep constructor private.
     */
    private Message(Builder builder) {
        this.message = builder.message;
        this.senderName = builder.senderName;
        this.recieverName = builder.recieverName;
        this.sentTime = builder.sentTime;
        this.messageType = builder.messageType;
        this.encodingType = builder.encodingType;
    }

    public static class Builder {
        //Assume this field is must have field
        @NotNull private final String message;
        private String senderName;
        private String recieverName;
        private Date sentTime;
        private String messageType;
        private String encodingType;

        /**
         * Message text is essential part of the Message Object. It can not be null
         * @param message
         */
        public Builder(String message) {
            this.message = message;
        }

        public Message build() {
            return new Message(this);
        }

        public Builder setSenderName(String senderName) {
            this.senderName = senderName;
            return this;
        }

        public Builder setRecieverName(String recieverName) {
            this.recieverName = recieverName;
            return this;
        }

        public Builder setSentTime(Date sentTime) {
            this.sentTime = sentTime;
            return this;
        }

        public Builder setMessageType(String messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder setEncodingType(String encodingType) {
            this.encodingType = encodingType;
            return this;
        }
    }
}
