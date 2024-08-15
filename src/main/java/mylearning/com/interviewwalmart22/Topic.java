package mylearning.com.interviewwalmart22;

import lombok.Data;

import java.util.List;
@Data
public class Topic {

    int topicId;
    List<Subscriber> subscribers;

    public Topic(int topicId, List<Subscriber> subscribers) {
        this.topicId = topicId;
        this.subscribers = subscribers;
    }
}
