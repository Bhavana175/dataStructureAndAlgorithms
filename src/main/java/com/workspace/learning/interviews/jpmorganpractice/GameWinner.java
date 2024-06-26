    package com.workspace.learning.interviews.jpmorganpractice;

    public class GameWinner {

        //https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/

        public static void main(String[] args) {

         //   String colors = "AAABABB";
         //   boolean output = winnerOfGame(colors);
        //    System.out.println(output);
            boolean output1 = winnerOfGame("ABBBBBBBAAA");
            System.out.println(output1);


        }

        public static boolean winnerOfGame(String colors) {

            if (colors == null || colors.length() < 3) {
                return false;
            }

            char[] arr = colors.toCharArray();

            int aCount =0;
            int bCount =0;

            for (int i = 0; i < arr.length-2; i++) {
                if(arr[i] == 'A' && arr[i+1]=='A' && arr[i+2]=='A'){
                    aCount++;
                }
                if(arr[i] == 'B' && arr[i+1]=='B' &&arr[i+2]=='B'){
                    bCount++;
                }
            }

            if(aCount>bCount){
                return true;
            }
            return false;
        }

    }
