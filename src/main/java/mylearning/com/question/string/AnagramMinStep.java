package mylearning.com.question.string;

public class AnagramMinStep {

    public static void main(String[] args) {

        AnagramMinStep obj = new AnagramMinStep();

        System.out.println("output : "+ obj.minSteps("leet", "leet"));

    }

    public int minSteps(String s, String t) {

        //all small alphabets
        int[] freqArr = new int[26];

        for (char ch : s.toCharArray()) {
            freqArr[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            freqArr[ch - 'a']--;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum = sum + Math.abs(freqArr[i]);
        }
        return sum;
    }

    public int minStepsWithMap(String s, String t) {

        //all small alphabets
        int[] freqArr = new int[26];

        for (char ch : s.toCharArray()) {
            freqArr[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            freqArr[ch - 'a']--;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum = sum + Math.abs(freqArr[i]);
        }
        return sum;
    }

}
