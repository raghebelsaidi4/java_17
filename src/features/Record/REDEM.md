## What is a **Record** in Java?

A **Record** is a special kind of class introduced in Java 14 (as a preview) and made official in **Java 16** and later.

Records are designed to define **data carrier objects** (like DTOs or value objects) in a clean, concise, and immutable way — eliminating boilerplate code like `getters`, `equals()`, `hashCode()`, and `toString()`.

---

## Why use Records?

* To **reduce boilerplate** code.
* To represent **immutable data structures**.
* Ideal for creating **DTOs (Data Transfer Objects)** or **Value Objects**.

---

## General Syntax of a Record:

```java
public record Person(String name, int age) {}
```

This is equivalent to:

```java
public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    // equals(), hashCode(), and toString() are auto-generated
}
```

---

## Practical Example:

```java
public record Point(int x, int y) {}

public class Test {
    public static void main(String[] args) {
        Point p = new Point(10, 20);

        System.out.println("X = " + p.x());
        System.out.println("Y = " + p.y());
        System.out.println(p);  // Output: Point[x=10, y=20]
    }
}
```

---

## Important Notes:

* Record fields are **mandatory and immutable** — must be initialized at creation.
* No setters are allowed — **immutability** by design.
* You **can define custom methods** inside a record.
* Records are implicitly `final` — they **cannot be extended**.
* You **can define custom constructors** to add validation logic.

---

## Example with Custom Constructor:

```java
public record Person(String name, int age) {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
```