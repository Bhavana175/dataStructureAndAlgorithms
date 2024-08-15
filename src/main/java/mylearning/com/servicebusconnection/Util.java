package mylearning.com.servicebusconnection;

public class Util {

    public static void main(String[] args) {

       String PVT_ENDPOINT_MSG_QUEUE = "Endpoint=sb://pune-core-rc.servicebus.windows.net/;SharedAccessKeyName=pvt-endpoint-msg-queue-auth-rule;SharedAccessKey=CDb4aZ/7uxwshhheYi4TOD/r6zIk2O84/dnUZ6eNvSc=;EntityPath=pvt-endpoint-msg-queue" ;

        String queueName = Util.fetchQueueId(PVT_ENDPOINT_MSG_QUEUE);//
        String authKeyName =   Util.fetchAuthKeyName(PVT_ENDPOINT_MSG_QUEUE);//"pvt-endpoint-msg-queue-auth-rule"
        String key =   Util.fetchKey(PVT_ENDPOINT_MSG_QUEUE);//"CDb4aZ/7uxwshhheYi4TOD/r6zIk2O84/dnUZ6eNvSc="

        System.out.println(queueName);
        System.out.println(authKeyName);
        System.out.println(key);
    }

    public static String fetchAuthKeyName(String queueString) {
        return queueString.substring(queueString.indexOf("SharedAccessKeyName=") +20,queueString.indexOf("SharedAccessKey=")-1 );
    }

    public static String fetchKey(String queueString) {
        return queueString.substring(queueString.indexOf("SharedAccessKey=") +16,queueString.indexOf("EntityPath")-1 );
    }

    public static String fetchQueueId(String queueString) {
        String id = queueString.substring(queueString.indexOf("EntityPath") + 11);
        return id;
    }

}
