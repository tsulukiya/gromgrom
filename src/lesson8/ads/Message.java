package lesson8.ads;

import java.util.Date;

public class Message extends BaseEntity {
    User userFrom;
    User userTo;
    Date dateSend;
    Date dateRead;
    String message;

    public Message(long id, User userFrom, User userTo, String message) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.dateSend = new Date();
        this.message = message;
    }

    void setDateRead() {
        dateRead = new Date();
    }

    boolean isRead() {
        return dateRead == null;
    }
}
