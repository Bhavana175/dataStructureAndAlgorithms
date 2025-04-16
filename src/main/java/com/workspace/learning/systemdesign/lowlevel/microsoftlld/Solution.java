package com.workspace.learning.systemdesign.lowlevel.microsoftlld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// you can also use imports, for example:
// import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }

    // sync save packet (timestamp, size, packet, uuid)
    // delete packet ()
    // t1, t2, t3, t4 --> upto 4 request (save -> stop ) wait notify
    // save based on time and should be able to retrieve k element
    // save based on size

    // data structure
    // for a timestamp : more than 1 packets

    // asc  treeMap <Integer, List<Packet>>  size
    // asc/desc  treeMap <Integer, List<Packet>> timestamp

    // 1 packet->

    interface RetrievePacket {

        List<Packet> retrieveKPacketsBasedOnTime(int k);

    }

    interface RetrieveSmallest {

        List<Packet> retrieveKPacketsBasedOnSize(int k);

    }

    class Packet {

        UUID id;

        int size;

        int timeStamp;

        int[] bytesPacket;

        public Packet(int size, int timeStamp, int[] arr) {

            this.id = UUID.randomUUID();
            this.size = size;
            this.timeStamp = timeStamp;
            this.bytesPacket = arr;

        }

    }

    class PacketService implements RetrieveSmallest, RetrievePacket {

        TreeMap<Integer, List<Packet>> sizeMap = new TreeMap<>(); // asc

        TreeMap<Integer, List<Packet>> timeStampMap = new TreeMap<>(); // asc

        // Hashset for packet

        public synchronized void savePacket(int size, int timestamp, int[] packetArray) {

            Packet p1 = new Packet(size, timestamp, packetArray);
            sizeMap.computeIfAbsent(size, (k) -> new ArrayList<>()).add(p1);
            timeStampMap.computeIfAbsent(timestamp, (k) -> new ArrayList<>()).add(p1);

        }

        @Override
        public synchronized List<Packet> retrieveKPacketsBasedOnTime(int k) {

            List<Packet> outputList = new ArrayList<>();

            for (Map.Entry<Integer, List<Packet>> entry : timeStampMap.entrySet()) {

                List<Packet> ls = entry.getValue();
              //  ls.subList(0,k);
                while (k > 0) {

                    for (Packet p : ls) {

                        outputList.add(p);
                        k--;
                        if (k == 0) {
                            break;
                        }
                    }
                }
            }

            return outputList;
        }

        @Override
        public synchronized List<Packet> retrieveKPacketsBasedOnSize(int k) {
            Map<String, Integer> map = new ConcurrentHashMap<>() ;
            map.merge("A", 1, Integer::sum);
            return null;
        }

    }

}
