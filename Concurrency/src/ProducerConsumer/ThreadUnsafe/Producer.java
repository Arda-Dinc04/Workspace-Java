package ProducerConsumer.ThreadUnsafe;

import java.util.LinkedList;

public class Producer extends Thread {
    LinkedList<Integer> sharedBuffer;
    int capacity;

    Producer(int size, LinkedList<Integer> sharedBuffer){
        this.sharedBuffer = sharedBuffer;
        this.capacity = size;
    }

    @Override
    public void run() {
        int value = 1;
        while(true){
            while (sharedBuffer.size() >= capacity)
                ;
            System.out.println("Producer produced: " + value);
            try{
                // Thread.sleep(10);
            }
            catch (Exception e) {
                
            }
            sharedBuffer.add(value);
            value++;
        }
    }

}
