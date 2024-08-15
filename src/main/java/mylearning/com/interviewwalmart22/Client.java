package mylearning.com.interviewwalmart22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {

   public static  HashMap<Integer, Topic> topicMap = new HashMap<>();
   public static HashMap<Publisher, Event> eventMap = new HashMap<>();

    public static void main(String[] args) {



        Topic t1 = new Topic(1, new ArrayList<>());
        Subscriber s1 = new Subscriber(20, 1 );
        Subscriber s2 = new Subscriber(21, 1 );
        Subscriber s3 = new Subscriber(22, 1 );

        List<Subscriber> list = t1.getSubscribers();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        topicMap.put(t1.getTopicId(), t1);


        Publisher p1 = new Publisher(50, 1);

        Event event = new Event(777, "Message event from publisher", p1);

        eventMap.put(p1, event);

        sendMessage(event, p1);



    }

    public static boolean sendMessage(Event event, Publisher publisher){

        int topicId = publisher.getTopicId();
        if(topicMap.containsKey(topicId)){

            List<Subscriber> subList = topicMap.get(topicId).getSubscribers();

            for (Subscriber s: subList
                 ) {
                System.out.println(s+"  "+event.msgPayload);
            }
        }

        return true;
    }

    /*
    duplicate employee
    not a primary key empid
    duplicate entry entry

    find empid

    unique
    not in

    select empid from employee where empid not in (
    select unique(empid) from employee ;
    )

     */
}
