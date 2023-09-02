public class Bank {


    public boolean check(int amount, String name){
        if(amount >= 1000){
            System.out.println("The bank approved your loan of "+amount+".");
            return true;
        }
        else{
            System.out.println("The bank rejeceted your loan" +name);
            return false;
        }
    }
}
