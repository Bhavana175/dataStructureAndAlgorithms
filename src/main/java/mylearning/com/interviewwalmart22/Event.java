package mylearning.com.interviewwalmart22;

import lombok.Data;

@Data
public class Event {
    int id;
    String msgPayload;

    Publisher publisher;

    public Event(int id, String msgPayload, Publisher publisher) {
        this.id = id;
        this.msgPayload = msgPayload;
        this.publisher = publisher;
    }



}
