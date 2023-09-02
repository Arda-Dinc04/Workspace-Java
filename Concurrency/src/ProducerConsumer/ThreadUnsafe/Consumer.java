package ProducerConsumer.ThreadUnsafe;

import java.util.LinkedList;

public class Consumer extends Thread {
    LinkedList<Integer> sharedBuffer;
    int capacity;

    Consumer(int size, LinkedList<Integer> sharedBuffer){
        this.sharedBuffer = sharedBuffer;
        this.capacity = size;
    }

    @Override
    public void run() {
        while(true){
            while (sharedBuffer.size() == 0)
                ;
            try {
                // Thread.sleep(10);
            } catch (Exception e) {

            }
            System.out.println("Consumer consumed: "+ sharedBuffer.poll());
        }
    }

}