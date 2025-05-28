## What are **Switch Expressions**?

In older versions of Java, `switch` was only a **statement** — meaning it didn’t return a value. But starting from **Java 14 (officially)**, `switch` now supports **expressions**, which means it can **return a value** directly, just like `if` or `?:`.

---

## Difference Between Switch Statement and Switch Expression:

### 1. Switch Statement (Old Way — Does Not Return a Value):

```java
String day = "MONDAY";
String result;

switch (day) {
    case "MONDAY":
        result = "Start of the week";
        break;
    case "FRIDAY":
        result = "Weekend is coming";
        break;
    default:
        result = "Midweek";
}
```

---

### 2. Switch Expression (New Way — Returns a Value):

```java
String day = "MONDAY";

String result = switch (day) {
    case "MONDAY"  -> "Start of the week";
    case "FRIDAY"  -> "Weekend is coming";
    default        -> "Midweek";
};
```

>  The result is stored directly into a variable, no need for `break`.

---

## New Benefits of Switch Expressions

| Feature          | Explanation                                        |
| ---------------- | -------------------------------------------------- |
| Shorter Syntax   | Uses `->` instead of `:` and doesn't need `break`. |
|  Returns a Value | You can assign the result directly to a variable.  |
|  Supports More Types | Like `enum`, `String`, etc.                        |
| Supports `yield` | Use `yield` to return a value inside code blocks.  |

---

##  Example Using `yield`:

```java
int number = 2;

String message = switch (number) {
    case 1 -> "One";
    case 2 -> {
        System.out.println("Inside block");
        yield "Two";
    }
    default -> "Other";
};

System.out.println(message);
```

> ✅ If you use `{}` inside a `case`, you **must** use `yield` to return a value.

---

## Practical Example with `enum`:

```java
enum Day {
    MONDAY, TUESDAY, FRIDAY, SUNDAY
}

class Example {
    public static void main(String[] args) {
        Day today = Day.SUNDAY;

        String activity = switch (today) {
            case MONDAY -> "Work hard!";
            case FRIDAY -> "Almost weekend!";
            case SUNDAY -> "Rest day!";
            default     -> "Regular day.";
        };

        System.out.println(activity);
    }
}
```

---

## Important Notes:

* Don’t use `break` in switch expressions.
* `->` means each case returns a value directly.
* If using `{}` for a `case`, you **must** use `yield` to return a value.