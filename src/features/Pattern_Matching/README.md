## What is **Pattern Matching** in Java?

**Pattern Matching** is a feature that allows you to **combine type checking (`instanceof`) with automatic casting into a variable** — making code simpler, shorter, and safer.

---

## Before Java 16 (Old Way):

```java
Object obj = "Hello";

if (obj instanceof String) {
    String s = (String) obj;  // Manual casting needed
    System.out.println(s.toLowerCase());
}
```

---

## From Java 16 Onwards (New Way):

```java
Object obj = "Hello";

if (obj instanceof String s) {
    System.out.println(s.toLowerCase());  // No casting needed!
}
```

> The code is cleaner and the compiler ensures type safety.

---

## Practical Example: Pattern Matching with `instanceof`

```java
public class Test {
    public static void main(String[] args) {
        Object obj = 42;

        if (obj instanceof Integer i) {
            System.out.println("Double the value: " + (i * 2));
        } else {
            System.out.println("Not an Integer.");
        }
    }
}
```

---

## Pattern Matching with `switch` (Since Java 17 as a preview feature)

Allows you to write a smart `switch` that handles multiple types:

```java
static String handle(Object o) {
    return switch (o) {
        case String s   -> "String: " + s.toUpperCase();
        case Integer i  -> "Integer: " + (i * i);
        case null       -> "Null value";
        default         -> "Unknown type";
    };
}
```
 **Very useful** when dealing with multiple possible types in one variable.

---

## Important Notes:

* The pattern variable (like `s` or `i`) is **only available inside the matching block**.
* You **cannot use it outside** the `if` or `switch`.

---

## Why Use Pattern Matching?

| Benefit           | Explanation                                      |
| ----------------- | ------------------------------------------------ |
|  Less Code        | No need for manual casting                       |
|  Safer            | The compiler checks the type for you             |
|  Better Performance | Matching happens only once                       |
|  Cleaner Code     | Especially useful with `instanceof` and `switch` |
