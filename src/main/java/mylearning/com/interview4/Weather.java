package mylearning.com.interview4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Weather {

    private String place;
    private double temp;

    public Weather(String place, double temp) {
        this.place = place;
        this.temp = temp;
    }
    public Weather() {
    }
    public String getPlace() {
        return place;
    }

    public double getTemp() {
        return temp;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "place='" + place + '\'' +
                ", temp=" + temp +
                '}';
    }

    public static void main(String[] args) {

        List<Weather> weathers = new ArrayList<>();
        weathers.add(new Weather("Sunny", 35.0));
        weathers.add(new Weather("Rainy", 17.0));
        weathers.add(new Weather("Cloudy", 23.0));
        weathers.add(new Weather("Cold", 3.0));
        weathers.add(new Weather("Snowy", 0.0));
        weathers.add(new Weather("Freezing", -15.0));

        weathers.stream().sorted(Comparator.comparingDouble(Weather::getTemp)).forEach(System.out::println);

        List<int[]> collect = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(8)
                .collect(Collectors.toList());

        collect.forEach(ints -> System.out.println(Arrays.toString(ints)));
              /*  .map(x->x[0])
                .collect(Collectors.toList())
                .stream()
                .distinct()
                .filter(i->i%2==0)
                .mapToInt(i->i)
                .sum();*/

     //   System.out.println("sum : "+sum);

    }
}
