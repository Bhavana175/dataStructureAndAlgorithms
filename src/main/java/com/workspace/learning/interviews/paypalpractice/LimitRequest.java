package com.workspace.learning.interviews.paypalpractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LimitRequest {

    /* in each second i, gateway receives a request from the domain request[i],
    the gateway allows at most 2 successful request from domain within 5 seconds.
    And at most 5 successful request from domain within 30 sec.

    return String  "{status:200, message : OK}" if request is processed.
    else return "{status:429, message : too many requests}"
     */
    public static void main(String[] args) {

        String[] request = {"www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com",
                "www.abc.com", "www.pqr.com", "www.pqr.com",};

        String[] output = gatewayResponseForRequest(request);
        Arrays.stream(output).forEach(System.out::println);
        String[] output2 = gatewayResponseForRequestUsingQueue(request);
        Arrays.stream(output2).forEach(System.out::println);
    }

    private static String[] gatewayResponseForRequest(String[] request) {

        HashMap<String, Integer> mapFiveSecInterval = new HashMap<>();
        HashMap<String, Integer> mapThirtySecInterval = new HashMap<>();
       /* at most 2 successful request from domain within 5 seconds.
        at most 5 successful request from domain within 30 sec.*/
        int len = request.length;
        String[] output = new String[len];

        for (int i = 0; i < len; i++) {

            if (mapFiveSecInterval.containsKey(request[i]) && mapThirtySecInterval.containsKey(request[i])) {

                if (i >= 5) {
                    if (mapFiveSecInterval.containsKey(request[i - 5]) && mapFiveSecInterval.get(request[i - 5]) > 0) {
                        mapFiveSecInterval.put(request[i - 5], mapFiveSecInterval.get(request[i - 5]) - 1);
                    }
                }

                if (i >= 30) {
                    if (mapThirtySecInterval.containsKey(request[i - 30]) && mapFiveSecInterval.get(request[i - 30]) > 0) {
                        mapThirtySecInterval.put(request[i - 30], mapFiveSecInterval.get(request[i - 30]) - 1);
                    }
                }

                if (mapFiveSecInterval.get(request[i]) < 2 && mapThirtySecInterval.get(request[i]) < 5) {
                    mapFiveSecInterval.put(request[i], mapFiveSecInterval.getOrDefault(request[i], 0) + 1);
                    mapThirtySecInterval.put(request[i], mapThirtySecInterval.getOrDefault(request[i], 0) + 1);
                    output[i] = "{status:200, message : OK}";
                } else {
                    output[i] = "{status:429, message : Too many request}";
                }

            } else {
                mapFiveSecInterval.put(request[i], 1);
                mapThirtySecInterval.put(request[i], 1);
                output[i] = "{status:200, message : OK}";
            }
        }
        return output;
    }

    private static String[] gatewayResponseForRequestUsingQueue(String[] request) {
        System.out.println("gatewayResponseForRequestUsingQueue");
        HashMap<String, Queue<Integer>> map = new HashMap<>();
        String[] output = new String[request.length];

        // "abc.com" [1,25, 30, 31] --> [25,30,31] current-peek<=30

        for (int i = 0; i < request.length; i++) {

            if (!map.containsKey(request[i])) {
                initializeMap(map, request[i]);
            }
            Queue<Integer> timeQueue = map.get(request[i]);
            removeTimeMoreThnThirtySecond(timeQueue, i);

            if (requestIsAllowed(timeQueue, i)) {
                timeQueue.add(i);
                map.put(request[i], timeQueue);
                output[i] = "{status: 200, message:OK}";
            } else {
                output[i] = "{status: 429, message:too many request}";
            }

        }
        return output;
    }

    private static boolean requestIsAllowed(Queue<Integer> timeQueue, int i) {
        long countRequestFiveSec = timeQueue.stream().filter(t -> i - t < 5).count();
        long countThirtySec = timeQueue.size();

        return countRequestFiveSec < 2 && countThirtySec < 5;
    }

    private static void removeTimeMoreThnThirtySecond(Queue<Integer> timeQueue, int currentTime) {
        while (!timeQueue.isEmpty() && currentTime - timeQueue.peek() >= 30) {
            timeQueue.poll();
        }
    }

    private static void initializeMap(HashMap<String, Queue<Integer>> map, String s) {
        map.put(s, new LinkedList<>());
    }
}
