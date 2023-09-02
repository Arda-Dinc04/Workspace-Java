public class CreditUnion {
    
    public boolean check(int amount){
        if(amount > 100){
            System.out.println("You have been granted credit");
            return true;
        }
        else{
            System.out.println("Your credit has been rejected");
            return false;
        }
    }
}
