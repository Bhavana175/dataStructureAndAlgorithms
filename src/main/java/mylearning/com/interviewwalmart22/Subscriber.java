package mylearning.com.interviewwalmart22;

import lombok.Data;

@Data
public class Subscriber {

    int id;
    int topicId;

    public Subscriber(int id, int topicId) {
        this.id = id;
        this.topicId = topicId;
    }

    //receive message : poll from queue


}
