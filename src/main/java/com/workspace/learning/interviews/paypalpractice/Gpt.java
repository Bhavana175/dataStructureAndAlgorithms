package com.workspace.learning.interviews.paypalpractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Gpt {



    /* in each second i, gateway receives a request from the domain request[i],
    the gateway allows at most 2 successful request from domain within 5 seconds.
    And at most 5 successful request from domain within 30 sec.

    return String  "{status:200, message : OK}" if request is processed.
    else return "{status:429, message : too many requests}"
     */
    public static void main(String[] args) {

//        String[] requests = {"www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com",
//                "www.abc.com", "www.pqr.com", "www.pqr.com", "www.abc.com", "www.abc.com", "www.abc.com"};
        String[] requests = {"www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com",
                "www.abc.com", "www.pqr.com", "www.pqr.com",};
        String[] output = gatewayResponseForRequests(requests);
        Arrays.stream(output).forEach(System.out::println);
    }

    private static String[] gatewayResponseForRequests(String[] requests) {
        HashMap<String, Queue<Integer>> requestLogMap = new HashMap<>();
        int len = requests.length;
        String[] output = new String[len];

        for (int i = 0; i < len; i++) {
            String domain = requests[i];
            int currentTime = i;

            if (!requestLogMap.containsKey(domain)) {
                initializeRequestLogForDomain(requestLogMap, domain);
            }

            Queue<Integer> timestamps = requestLogMap.get(domain);
            cleanUpOldTimestamps(timestamps, currentTime);

            if (isAllowed(timestamps, currentTime)) {
                timestamps.offer(currentTime);
                output[i] = "{status:200, message : OK}";
            } else {
                output[i] = "{status:429, message : too many requests}";
            }
        }
        return output;
    }

    private static void initializeRequestLogForDomain(HashMap<String, Queue<Integer>> requestLog, String domain) {
        requestLog.put(domain, new LinkedList<>());
    }

    private static void cleanUpOldTimestamps(Queue<Integer> timestamps, int currentTime) {
        while (!timestamps.isEmpty() && currentTime - timestamps.peek() >= 30) {
            timestamps.poll();
        }
    }

    private static boolean isAllowed(Queue<Integer> timestamps, int currentTime) {
        long requestsInLast5Seconds = timestamps.stream().filter(ts -> currentTime - ts < 5).count();
        long requestsInLast30Seconds = timestamps.size();

        return requestsInLast5Seconds < 2 && requestsInLast30Seconds < 5;
    }
}
