package mylearning.com.question.string;

import java.util.PriorityQueue;

public class SortCharSolution {

    /**
     * sneh ka solution
     * @param args
     */


    public static void main(String[] args) {

        SortCharSolution obj = new SortCharSolution();

        String str = "tttreerrerrr";
        System.out.println("input : " + str);
        System.out.println("output  : " + obj.frequencySort(str));

    }
        public String frequencySort(String s) {
            int[] freq = new int[128];

            for (char ch : s.toCharArray()) {
                freq[ch]++;
            }
            PriorityQueue<CharFreq> pq = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
            for (int i = 0; i < 128; i++) {
                if (freq[i] > 0) {
                    pq.add(new CharFreq((char)i, freq[i]));
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                CharFreq charFreq = pq.poll();
                for (int i = 0; i < charFreq.freq; i++) {
                    sb.append(charFreq.ch);
                }
            }
            return sb.toString();
        }

        class CharFreq {
            char ch;
            int freq;

            CharFreq() {
            }

            CharFreq(char ch, int freq) {
                this.ch = ch;
                this.freq = freq;
            }
        }
    }