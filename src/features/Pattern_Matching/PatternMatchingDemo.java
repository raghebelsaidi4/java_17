package features.Pattern_Matching;

public class PatternMatchingDemo {
    public static void main(String[] args) {
        Object value = "Hello Pattern Matching!";

        if (value instanceof String s){
            System.out.println("Length of the string is " + s.length());
            System.out.println("Lower case of the string is " + s.toLowerCase());
        }else {
            System.out.println("Value is not a string");
        }
    }
}
