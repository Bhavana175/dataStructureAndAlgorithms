package mylearning.com.interviewwalmart22;

import lombok.Data;

@Data
public class Publisher {

    private int id;
    private int  topicId;

    public Publisher(int id, int topicId) {
        this.id = id;
        this.topicId = topicId;
    }




}
