package ProducerConsumer.ThreadSafe;

import java.util.LinkedList;

public class Consumer extends Thread {
    LinkedList<Integer> sharedBuffer;
    int capacity;

    Consumer(int size, LinkedList<Integer> sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
        this.capacity = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedBuffer) {
                while (sharedBuffer.size() == 0) {
                    try {
                        sharedBuffer.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumer consumed: " + sharedBuffer.poll());
                sharedBuffer.notifyAll();
            }
        }
    }

}