import javax.sound.midi.Soundbank;

public class Morgage {
    Bank bank;
    CreditUnion creditU;

    Morgage() {
        this.bank = new Bank();
        this.creditU = new CreditUnion();
    }

    public boolean check(int amount, String name, int id){

        boolean flag = true;

        if (!bank.check(amount, name))
            flag = false;
        if (!creditU.check(id))
            flag = false;

        return flag;
    }
}
