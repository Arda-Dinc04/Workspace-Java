package ArrayBasedCircularQueue;

public class QueueOverflowException extends Exception{

    QueueOverflowException(String msg){
        super(msg);
    }
}
