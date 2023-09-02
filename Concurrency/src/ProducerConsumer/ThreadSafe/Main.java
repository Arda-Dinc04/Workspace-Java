package ProducerConsumer.ThreadSafe;


import java.util.LinkedList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws InterruptedException{
        LinkedList<Integer> buffer = new LinkedList<>();
        Producer prod = new Producer(10,buffer);
        Consumer cons = new Consumer(10, buffer);

        prod.start();
        cons.start();
        
        prod.join();
        cons.join();
    }
}