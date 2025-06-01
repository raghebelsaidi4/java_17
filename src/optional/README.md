## What is `Optional` in Java?

`Optional` is a **wrapper class** introduced in **Java 8** to represent a **value that may or may not be present**. It helps reduce the need to use `null` and minimizes the chance of encountering `NullPointerException`.

---

##  Why Use `Optional`?

| Benefit                     | Explanation                                         |
| --------------------------- | --------------------------------------------------- |
|  Avoids NullPointerException | Provides a safer way to handle possibly null values |
|  Clearer code               | Explicitly shows that a value may be missing        |
|  Encourages Functional Style | Works well with Streams and Lambdas                 |

---

##  Practical Examples

###  Creating an Optional

```java
Optional<String> name = Optional.of("Java");
Optional<String> empty = Optional.empty(); // No value
Optional<String> maybeNull = Optional.ofNullable(null); // Might be null
```

---

###  Checking if a Value Exists

```java
if (name.isPresent()) {
    System.out.println(name.get()); // "Java"
}
```

> ️ Use `.get()` **only** when you're sure the value is present!

---

###  Using `ifPresent`

```java
name.ifPresent(n -> System.out.println("Hello, " + n));
```

---

###  Using `orElse`

```java
String result = maybeNull.orElse("Default");
System.out.println(result); // "Default"
```

---

###  Using `orElseGet` (Lazy Alternative)

```java
String value = maybeNull.orElseGet(() -> "Generated Default");
```

---

###  Using `orElseThrow`

```java
String value = maybeNull.orElseThrow(() -> new RuntimeException("No value"));
```

---

###  Using `map` and `flatMap`

```java
Optional<String> upper = name.map(String::toUpperCase);
System.out.println(upper.get()); // "JAVA"
```

---

##  Full Practical Example

```java
public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> maybeName = Optional.ofNullable(getName());

        String finalName = maybeName
                .map(String::toUpperCase)
                .orElse("UNKNOWN");

        System.out.println(finalName);
    }

    static String getName() {
        return null; // simulate null
    }
}
```

---

##  Common Optional Methods

| Method              | Description                                           |
| ------------------- | ----------------------------------------------------- |
| `of(value)`         | Creates an Optional with a non-null value             |
| `ofNullable(value)` | Creates an Optional that may contain `null`           |
| `empty()`           | Creates an empty Optional                             |
| `isPresent()`       | Checks if a value is present                          |
| `ifPresent()`       | Executes a lambda if the value is present             |
| `get()`             | Returns the value if present                          |
| `orElse(x)`         | Returns the value or a default value                  |
| `orElseGet(() -> )` | Returns the value or a lazily generated default       |
| `orElseThrow()`     | Throws an exception if no value is present            |
| `map()`             | Transforms the value if present                       |
| `flatMap()`         | Same as `map`, but flattens nested `Optional` results |

---

##  Pro Tip

You **should not use `Optional`**:

* As fields in classes (especially in DTOs or entities).
* In performance-critical paths where `null` handling is preferred.
