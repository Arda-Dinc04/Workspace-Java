package ProducerConsumer.ThreadSafe;

import java.util.LinkedList;

public class Producer extends Thread {
    LinkedList<Integer> sharedBuffer;
    int capacity;

    Producer(int size, LinkedList<Integer> sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
        this.capacity = size;
    }

    @Override
    public void run() {
        int value = 1;
        while (true) {
            synchronized (sharedBuffer) {
                while (sharedBuffer.size() >= capacity) {
                    try {
                        sharedBuffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Producer produced: " + value);
                sharedBuffer.add(value);
                value++;
                sharedBuffer.notify();
            } 
        }
    }

}
