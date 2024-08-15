package mylearning.com.interviewwalmart22;

public class PubSub {


    /*


    The Pub-Sub system should allow publishers to publish messages to specific topics.
    Subscribers should be able to subscribe to topics of interest and receive messages
    published to those topics.
   The system should support multiple publishers and subscribers.
   Messages should be delivered to all subscribers of a topic in real-time.

    1. Functional requirement
        publisher sends the message (Event)--->identify the queue-> publish msg on queue
        subscriber polls the message from the queue
        one consumer can subscriber to multiple queue

     Assume
        multiple queue
        in memory data structure

    Classes

    Event
    id: serial id, uuid
    msgPayload : String
    queueId : uuid

    Topic
    queueId : uuid
    queueName : String
    queueDetail: String






     */

}
