package com.workspace.learning.interviews.goldmansachs.practice;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class findTopIpaddress {

    /**
     * String findTopIpaddress(String[] lines)
     * Given an Apache log file, return IP address(es) which accesses the site most often.
     * <p>
     * Our log is in this format (Common Log Format). One entry per line
     * and it starts with an IP address which accessed the site,
     * followed by a whitespace.
     * <p>
     * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
     * <p>
     * Log file entries are passsed as an array.
     */

    public static String findTopIpaddress(String[] lines) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (b.getValue() - a.getValue() == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        if (lines.length == 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < lines.length; i++) {
                Stream.of(lines[i].split(" ")).findFirst().ifPresentOrElse(
                        (a) -> {
                            map.put(a, map.getOrDefault(a, 0) + 1);
                        },
                        () -> {
                            System.out.println("not found");
                        }
                );
            }
            queue.addAll(map.entrySet());
            int max = 0;
            if (!queue.isEmpty()) {
                max = queue.peek().getValue();
                while (max == queue.peek().getValue() && !queue.isEmpty()) {
                    sb.append(queue.poll().getKey());
                    sb.append(",");
                }
            }
        }
        String str2 = sb.deleteCharAt(sb.length() - 1).toString();
        System.out.println(str2);
        return str2;
    }

    /**
     * boolean doTestsPass()
     * Returns true if the test passes. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        Boolean testsPassed = true;
        String lines[] = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
        String result = findTopIpaddress(lines);
        if (!result.equals("10.0.0.1")) {
            testsPassed = false;
        }

        lines = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234",};
        result = findTopIpaddress(lines);
        if (!result.equals("10.0.0.1,10.0.0.2")) {
            testsPassed = false;
        }

        if (testsPassed) {
            System.out.println("Tests passed");
        } else {
            System.out.println("Tests failed");
        }

        return testsPassed;
    }

    public static void main(String[] args) {
        doTestsPass();
    }

}
