package Deadlock;

class A {
    void foo(B b, Object lock) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": A.foo is trying to call B.last()");
        synchronized(lock) {
            b.last();
        }
        System.out.println(name + ": Exiting A.foo");
    }

    void last() {
        System.out.println("Inside A.last");
    }
}

class B {
    void bar(A a, Object lock) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": B.bar is trying to call A.last()");
        synchronized (lock) {
            a.last();
        }
        System.out.println(name + ": Exiting B.bar()");
    }

    void last() {
        System.out.println("Inside B.last");
    }
}

public class Deadlock {
    A a = new A();
    B b = new B();
    Object lock = new Object();

    private class Thread1 implements Runnable {
        public void run() {
            a.foo(b,lock);
        }
    }

    private class Thread2 implements Runnable {
        public void run() {
            b.bar(a, lock);
        }
    }

    public static void main(String[] args) {
        Deadlock d = new Deadlock();
        Thread t1 = new Thread(d.new Thread1(), "Thread-1");
        Thread t2 = new Thread(d.new Thread2(), "Thread-2");

        t1.start();
        t2.start();
    }
}