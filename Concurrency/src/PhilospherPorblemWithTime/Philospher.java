package PhilospherPorblemWithTime;

import java.util.Date;

public class Philospher extends Thread {
    Fork leftFork;
    Fork rightFork;
    Fork[] forkArr;
    int ate;
    int count = 0;

    Philospher(Fork leFork, Fork riFork, String name) {
        super(name);
        this.leftFork = leFork;
        this.rightFork = riFork;
        this.ate = 0;
    }

    @Override

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + ": is thinking");
            Date timer = new Date();
            synchronized (leftFork) {
                System.out.println(Thread.currentThread().getName() + ": picked up Left Fork");

                synchronized (rightFork) {

                    System.out.println(Thread.currentThread().getName() + ": picked up Right Fork");

                    System.out.println(Thread.currentThread().getName() + ": ate");
                    ate++;
                    rightFork.notify();
                    leftFork.notify();
                }
            }

            Date eTime = new Date();

            if (eTime.getTime() - timer.getTime() > 500) {
                System.out.println("Philospher" + currentThread().getName() + " died");
                stop();

            }

        }
        //printAte();
    }

    public void printAte() {
        System.out.println(Thread.currentThread().getName() + ": ate " + ate + " times.");
    }
}
