package util;

public class FizzBuzz {
    public static String fizzBuzz(int n){
        //String result = "";
        // if(n % 3 == 0) return result += "Fizz";
        // if(n % 5 == 0) return result += "Buzz";
        //return result.isEmpty() ? String.valueOf(n) : result;

        //Refactor:
        String result = "";
        boolean divisible = false;
        if(n % 3 == 0){
            result += "Fizz";
            divisible = true;
        }
        if(n % 5 == 0){
            result += "Buzz";
            divisible = true;
        }
        return divisible ? result: "" + n;

    }
}
