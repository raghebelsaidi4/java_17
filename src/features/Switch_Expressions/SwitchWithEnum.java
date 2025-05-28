package features.Switch_Expressions;

enum DAY {
    SUNDAY,
    MONDAY,
    FRIDAY,
}

public class SwitchWithEnum {
    public static void main(String[] args) {
        DAY today = DAY.SUNDAY;

        String action = switch (today) {
            case MONDAY -> "Start working!";
            case FRIDAY -> "Get ready for the weekend!";
            case SUNDAY -> "Relax, it's Sunday!";
            default -> "Normal day.";
        };

        System.out.println(action);
    }
}
