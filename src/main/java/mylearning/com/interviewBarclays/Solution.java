package mylearning.com.interviewBarclays;

import java.util.Arrays;
import java.util.List;

public class Solution {
    //Barclays
    //17-04-2024
    public static void main(String[] args) {

        //CICD, Doker, kubernetes, EKS ECS,load balancing autoscaling,
        // spring actuators, spring security, sqs , optional
        //sealed apis

        //list print contains char 's'

        List<String> list = Arrays.asList("bhavana", "ram", "shayam", "sita");

        list.stream().filter(s->s.indexOf('s')>=0).forEach(System.out::println);

        //nums, find 3rd largest num

        List<Integer> list1 = Arrays.asList(2, 44, 66, 77, 12, 70, 100);

        list1.stream()
                .sorted((a, b) -> b - a)
                .skip(2)
                .findFirst()
                .ifPresentOrElse(System.out::println, ()-> System.out.println("not found"));

    }

}
