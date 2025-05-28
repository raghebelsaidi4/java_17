package features.Switch_Expressions;

public class SwitchExpressionBasic {
    public static void main(String[] args) {
        int score = 2;

        String result = switch (score){
            case 1 -> "Poor";
            case 2 -> {
                System.out.println("Evaluating...");
                yield "Average";
            }
            case 3 -> "Good";
            default -> "Unknown";
        };
        System.out.println("Result "+result);
    }
}
