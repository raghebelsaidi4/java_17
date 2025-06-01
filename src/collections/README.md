## What are Collections in Java?

**Collections** in Java are part of the **Java Collections Framework**, which provides **data structures and algorithms** to store, manage, and manipulate groups of objects.

It includes interfaces like `List`, `Set`, `Queue`, and classes like `ArrayList`, `HashSet`, `LinkedList`, `HashMap`, etc.

---

## Import Statement

```java
import java.util.*;
```

---

## Collections Hierarchy (Simplified)

```
             Collection (Interface)
             /     |       \
          List    Set     Queue
           |       |        |
     ArrayList  HashSet  LinkedList
     LinkedList TreeSet  PriorityQueue
```

>  `Map` (e.g., `HashMap`, `TreeMap`) is **not a subtype of Collection**, but it is part of the collections framework.

---

## Main Types of Collections

### 1. **List** – Ordered, allows duplicates

* `ArrayList`: Fast for access, slow for insert/remove in the middle.
* `LinkedList`: Good for frequent insertions/removals.
* `Vector`: Synchronized, legacy class.

 Example:

```java
List<String> names = new ArrayList<>();
names.add("Ali");
names.add("Sara");
System.out.println(names); // [Ali, Sara]
```

---

### 2. **Set** – Unordered, no duplicates

* `HashSet`: No guaranteed order.
* `LinkedHashSet`: Maintains insertion order.
* `TreeSet`: Sorted in natural order or custom comparator.

 Example:

```java
Set<Integer> numbers = new HashSet<>();
numbers.add(3);
numbers.add(1);
numbers.add(3); // Duplicate, ignored
System.out.println(numbers); // [1, 3]
```

---

### 3. **Queue** – FIFO structure

* `LinkedList`: Can be used as a queue.
* `PriorityQueue`: Orders elements based on priority.
* `ArrayDeque`: Efficient double-ended queue.

 Example:

```java
Queue<String> queue = new LinkedList<>();
queue.add("First");
queue.add("Second");
System.out.println(queue.poll()); // First
```

---

### 4. **Map** – Key-value pairs

* `HashMap`: Unordered.
* `LinkedHashMap`: Maintains insertion order.
* `TreeMap`: Sorted by keys.
* `Hashtable`: Synchronized, legacy.

 Example:

```java
Map<String, Integer> ages = new HashMap<>();
ages.put("Ali", 30);
ages.put("Sara", 25);
System.out.println(ages.get("Ali")); // 30
```

---

## 🛠️ Utility Methods (from `Collections` class):

```java
Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);
Collections.max(list);
Collections.min(list);
```

---

## ️ Comparison Table

| Type | Allows Duplicates | Maintains Order        | Allows null     |
| ---- | -------------- | ---------------------- | --------------- |
| List |  Yes           |  Yes                   |  Yes            |
| Set  |  No            | (except LinkedHashSet) |  Yes            |
| Map  |  (values only) |  (except LinkedHashMap) | Only in HashMap |

---

##  When to Use Each Type

| Requirement                           | Recommended Collection |
| ------------------------------------- | ---------------------- |
| Ordered list with duplicates allowed  | `ArrayList`            |
| No duplicates                         | `HashSet` or `TreeSet` |
| Maintain order without duplicates     | `LinkedHashSet`        |
| Key-value pairs                       | `HashMap` or `TreeMap` |
| Fast insertion/removal from both ends | `ArrayDeque`           |
