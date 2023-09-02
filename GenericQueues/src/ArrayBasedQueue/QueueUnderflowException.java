package ArrayBasedQueue;

public class QueueUnderflowException extends Exception{
    QueueUnderflowException(String msg){
        super(msg);
    }
}
