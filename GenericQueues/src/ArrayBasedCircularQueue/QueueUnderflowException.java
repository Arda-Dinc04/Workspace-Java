package ArrayBasedCircularQueue;

public class QueueUnderflowException extends Exception{
    QueueUnderflowException(String msg){
        super(msg);
    }
}
