package leetcode.dailyquestion.dp.lcs;

public class BuildingBridgesFlipkart {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
        int [] houses ={ 1,2,3,4};
        int [] offices = {4,3,2,1};

       // Output : Maximum number of bridges = 2
        System.out.println(maxNumberOfBridesWithoutIntersection(houses, offices));

    }

    private static int maxNumberOfBridesWithoutIntersection(int[] houses, int[] offices) {
        int n = houses.length;
        int m = offices.length;
        return lcs(houses, offices, n, m);
    }

    private static int lcs(int[] houses, int[] offices, int n, int m) {
        if(n==0 || m ==0){
            return 0;
        }
        if(houses[n-1] == offices[m-1]){
            return 1+lcs(houses, offices, n-1, m-1);
        }else return Math.max(lcs(houses, offices, n-1, m), lcs(houses, offices, n, m-1));
    }
}
