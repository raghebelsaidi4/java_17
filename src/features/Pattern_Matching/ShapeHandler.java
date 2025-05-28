package features.Pattern_Matching;

public class ShapeHandler {
    public static void main(String[] args) {

        printShapeInfo("Rectangle");
        printShapeInfo(100);
        printShapeInfo(100.0); // Unknown shape
        printShapeInfo(null);

    }

    static void printShapeInfo(Object shape) {
        String result = switch (shape) {
            case String s -> "Shape name: " + s;
            case Integer i -> "Shape code: " + (i + 100);
            case null -> "Null Shape !";
            default -> "Unknown Shape type.";
        };
        System.out.println(result);
    }
}
