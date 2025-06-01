## What is a Lambda Expression in Java?
A **Lambda Expression** is a concise way to represent an **anonymous function** — a block of code that can be passed around and executed later, without having to create a full class or use boilerplate code.

Lambda expressions were introduced in **Java 8** and are a key feature for writing **functional-style** code.

---

## Why use Lambda?

| Benefit                    | Explanation                                          |
| -------------------------- | ---------------------------------------------------- |
|  Shorter code              | No need for inner or anonymous classes               |
|  Cleaner and more readable | Especially with `Streams` and `Collections`          |
|  Supports Functional Style | Works perfectly with `filter`, `map`, `reduce`, etc. |

---

## 🔧 General Syntax

```java
(parameters) -> { body }
```

Or, if the body is a single expression:

```java
(parameter) -> expression
```

---

## Basic Example

**Without Lambda:**

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Hello!");
    }
};
```

**With Lambda:**

```java
Runnable r = () -> System.out.println("Hello!");
```

---

##  Example with Comparator

```java
List<String> names = Arrays.asList("Ali", "Sara", "Kamal");

// Before Lambda:
Collections.sort(names, new Comparator<String>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});

// With Lambda:
Collections.sort(names, (a, b) -> a.compareTo(b));
```

---

##  Using Lambda with Functional Interfaces

A **Functional Interface** is an interface that has **only one abstract method**.

Example:

```java
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}
```

Using Lambda:

```java
Calculator add = (a, b) -> a + b;
System.out.println(add.operate(5, 3)); // 8
```

---

##  Common Use with Streams

```java
List<String> list = Arrays.asList("Java", "Python", "C++");

list.stream()
    .filter(s -> s.startsWith("J"))
    .forEach(s -> System.out.println(s));
```

---

## Important Notes

* Lambdas can only be used with **Functional Interfaces** (interfaces with one abstract method).
* Lambdas can access variables from the enclosing scope, **but they must be effectively final**.
* Lambdas are commonly used with the **Stream API**, **event handling**, and **callbacks**.

---

##  Summary

| Concept    | Description                                      |
| ---------- | ------------------------------------------------ |
| Introduced | Java 8                                           |
| Works with | Functional Interfaces                            |
| Reduces    | Boilerplate code                                 |
| Useful in  | Collections, Streams, Callbacks, Event Listeners |


---

##  What is the Stream API in Java?

The **Stream API** provides a way to process **sequences of elements** (like lists, arrays, or collections) using a **functional style**.

> Instead of using traditional loops, you can perform operations like filtering, mapping, and collecting in a more concise and readable way.

---

##  Why use Streams?

| Benefit                | Explanation                                     |
| ---------------------- | ----------------------------------------------- |
|  Cleaner Code          | Eliminates repetitive `for` and `if` statements |
|  High Performance      | Supports **parallel processing**                |
|  Functional Programming | Works great with Lambdas and Method References  |
|  Flexible Data Handling | Easily filter, sort, map, collect, etc.         |

---

##  General Structure of a Stream:

```java
collection.stream()
          .filter(...)     // filter items
          .map(...)        // transform items
          .sorted(...)     // sort items
          .collect(...)    // collect the results
```

---

##  Basic Example:

```java
List<String> names = List.of("Ali", "Sara", "Kamal", "Amina");

List<String> filtered = names.stream()
                             .filter(name -> name.startsWith("A"))
                             .map(String::toUpperCase)
                             .sorted()
                             .collect(Collectors.toList());

System.out.println(filtered);  // [ALI, AMINA]
```

---

## Most Common Stream Operations:

| Method      | Description                                   |
| ----------- | --------------------------------------------- |
| `filter`    | Filters elements based on a condition         |
| `map`       | Transforms each element                       |
| `sorted`    | Sorts elements                                |
| `forEach`   | Performs an action for each element           |
| `collect`   | Collects the result into a list/set/etc.      |
| `count`     | Counts the number of elements                 |
| `anyMatch`  | Checks if **any** element matches a condition |
| `allMatch`  | Checks if **all** elements match a condition  |
| `noneMatch` | Checks if **none** of the elements match      |

---

##  Example: `map`, `filter`, and `collect`

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

List<Integer> result = numbers.stream()
                              .filter(n -> n % 2 == 0)        // Keep even numbers
                              .map(n -> n * n)                // Square each number
                              .collect(Collectors.toList());  // Collect into a list

System.out.println(result);  // [4, 16, 36]
```

---

##  Parallel Stream (for performance):

```java
list.parallelStream()
    .filter(...)
    .map(...)
    .collect(...);
```

> Useful for processing large amounts of data using multiple CPU cores.

---

##  Important Notes:

* A **Stream doesn't store data** — it just processes it.
* A **Stream can be consumed only once**.
* Streams use **lazy evaluation**, meaning nothing is executed until a terminal operation like `collect()`, `forEach()`, or `count()` is called.

---

##  Summary:

| Feature           | Description                          |
| ----------------- | ------------------------------------ |
| Introduced in     | Java 8                               |
| Main Purpose      | Simplify data processing             |
| Works With        | `List`, `Set`, `Map`, `Arrays`, etc. |
| Programming Style | Functional Programming               |
