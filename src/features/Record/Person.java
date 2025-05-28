package features.Record;

public record Person(String name, int age) {

    // custom constructor
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    // Addition method
    public boolean isAdult() {
        return age >= 18;
    }
}
