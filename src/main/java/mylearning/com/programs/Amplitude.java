package mylearning.com.programs;

public class Amplitude {


    public static void main(String[] args) {

        int[] arr = {-1, 15, 3, 4, 5, 6, 7, 9};
        Amplitude amp = new Amplitude();

        int amplitute = amp.solution(arr);
        System.out.println("max amplitude "+amplitute);

    }

    private int solution(int[] arr) {

        int n = arr.length / 4;
        int[] winter = new int[n];
        int[] spring = new int[n];
        int[] summer = new int[n];
        int[] autumn = new int[n];

        int ampW = 0;
        int ampSpring = 0;
        int ampSummer = 0;
        int ampAutumn = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i < n) {
                winter[i] = arr[i];
            }
            if (i >= n && i < (n + n)) {
                spring[i - n] = arr[i];
            }
            if (i >= (n + n) && i < (n + n + n)) {
                summer[i - (n + n)] = arr[i];
            }
            if (i >= (n + n + n) && i < (n + n + n + n)) {
                autumn[i - (n + n + n)] = arr[i];
            }
        }
        ampW = getAmp(winter);
        ampSpring = getAmp(spring);
        ampSummer = getAmp(summer);
        ampAutumn = getAmp(autumn);

        int [] ampArr= {ampW, ampSpring,ampSummer, ampAutumn};

        int maxAmp = getMaxAmp(ampArr);


        return maxAmp;

    }

    private int getMaxAmp(int[] ampArr) {
        int maxAmp = ampArr[0];
        for (int i =0; i<ampArr.length; i++){
            if(ampArr[i]>maxAmp){
                maxAmp= ampArr[i];
            }
        }

        return  maxAmp;
    }

    private int getAmp(int[] arr) {
        if(arr.length>0){
        int amp;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }if(arr[i]>max){
                max= arr[i];
            }

        }

        amp = max - min;
        return amp;}
        return  0;
    }

}
