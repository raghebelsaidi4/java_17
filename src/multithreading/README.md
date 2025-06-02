# Multithreading in Java

Multithreading in Java allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Here's a comprehensive overview:

## Creating Threads

There are two main ways to create threads in Java:

### 1. Extending Thread class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts the thread execution
    }
}
```

### 2. Implementing Runnable interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

## Thread Life Cycle

1. **New**: When thread is created but not started
2. **Runnable**: After start() is called
3. **Running**: When thread is executing
4. **Blocked/Waiting**: When thread is waiting for resources
5. **Terminated**: When thread completes execution

## Thread Methods

- `start()`: Begins thread execution
- `run()`: Contains code to be executed
- `sleep(long millis)`: Pauses thread for specified time
- `join()`: Waits for thread to die
- `interrupt()`: Interrupts the thread
- `isAlive()`: Checks if thread is alive
- `setPriority(int priority)`: Sets thread priority (1-10)
- `getPriority()`: Returns thread priority

## Synchronization

To prevent thread interference and memory consistency errors:

### Synchronized Method

```java
synchronized void printTable(int n) {
    // method body
}
```

### Synchronized Block

```java
void printTable(int n) {
    synchronized(this) {
        // block of code
    }
}
```

## Thread Communication

Using `wait()`, `notify()`, and `notifyAll()` methods:

```java
class SharedResource {
    synchronized void waitMethod() {
        try {
            wait(); // releases the lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    synchronized void notifyMethod() {
        notify(); // wakes up one waiting thread
        // notifyAll() wakes up all waiting threads
    }
}
```

## Thread Pools (Executor Framework)

Java provides thread pool implementation through Executor framework:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        
        executor.shutdown();
        while (!executor.isTerminated()) {}
        
        System.out.println("All threads finished");
    }
}
```

## Common Issues

1. **Race Conditions**: When threads access shared data concurrently
2. **Deadlocks**: When two or more threads wait forever for locks
3. **Starvation**: When a thread cannot gain access to resources

## Best Practices

1. Prefer implementing Runnable over extending Thread
2. Use thread pools instead of creating new threads manually
3. Always handle InterruptedException properly
4. Use higher-level concurrency utilities from java.util.concurrent package
5. Document thread-safety of your classes

Java's multithreading capabilities enable you to write highly efficient, concurrent applications that can take full advantage of modern multi-core processors.