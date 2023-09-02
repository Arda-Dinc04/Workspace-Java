package PhilosphersProblem;

import java.util.concurrent.Semaphore;

public class Fork {
    int value;
    private Semaphore semaphore;

    Fork(int value){
        this.value = value;
        this.semaphore = new Semaphore(1);
    }

    public void pickUp() throws InterruptedException{
        semaphore.acquire();
    }

    public void putDown() throws InterruptedException {
        semaphore.release();
    }
}
