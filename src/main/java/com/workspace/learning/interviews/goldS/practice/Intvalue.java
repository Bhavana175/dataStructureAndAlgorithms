package com.workspace.learning.interviews.goldS.practice;

public class Intvalue {

    /**
     * Takes a string str and returns the int value represented by
     * the string. For example, atoi("42") returns 42.
     */
    public static int atoi(String str)
    {
        int result = 0;
        int strLength = str.length();
        int multiplier = 1;
        int i = 0;
        if (strLength != 0 && str.charAt(0) == '-')
        {
            // negative number
            multiplier = -1;
            i++;
        }

        for( ;i < strLength; i++)
        {
          char ch = str.charAt(i);
          if(ch<'0' || ch >'9'){
              break;
          }
            result = result*10 + ch-'0';
        }
        System.out.println(result);
        return result*multiplier;
    };


    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass()
    {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        boolean result = true;
        result = result && atoi("0") == 0;
        result = result && atoi("1") == 1;
        result = result && atoi("123") == 123;
        result = result && atoi("-1") == -1;
        result = result && atoi("-123") == -123;
        result = result && atoi("123a") == 123;
        result = result && atoi("a111") == 0;

        String intMax = String.valueOf(Integer.MAX_VALUE);
        result = result && atoi(intMax) == Integer.MAX_VALUE;

        String intMin = String.valueOf(Integer.MIN_VALUE);
        result = result && atoi(intMin) == Integer.MIN_VALUE;

        return result;

    };


    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }
    }

}
