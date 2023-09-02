package PhilosphersProblem;

public class Philospher extends Thread {
    Fork leftFork;
    Fork rightFork;
    int ate;

    Philospher(Fork leFork, Fork riFork) {
        this.leftFork = leFork;
        this.rightFork = riFork;
        this.ate = 0;
    }

    @Override
    public void run() {
        
       
        while (true) {
            System.out.println(Thread.currentThread().getName() + ": is thinking");

            try{
                leftFork.pickUp();
                System.out.println(Thread.currentThread().getName() + ": picked up Left Fork");
                
                rightFork.pickUp();
                System.out.println(Thread.currentThread().getName() + ": picked up Right Fork");

                System.out.println(Thread.currentThread().getName() + ": ate");
                try {
                    Thread.sleep(250);
                } catch (Exception e) {

                }
                ate++;
                leftFork.putDown();
                rightFork.putDown();
                System.out.println(Thread.currentThread().getName() + ": completed eating and now thinking");
            }
            catch (InterruptedException e) {
                
            }
        }
        //printAte();
    }

    public void printAte(){
        System.out.println(Thread.currentThread().getName() + ": ate "+ate+" times.");
    }
}
