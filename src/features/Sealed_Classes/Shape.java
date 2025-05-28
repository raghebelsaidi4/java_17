package features.Sealed_Classes;

public sealed interface Shape permits Circle, Rectangle {
    double area();
}
