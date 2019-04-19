package enthuare.examples;

public interface Account {

    default String getID() {
        return "0000";
    }
}

interface PremiumAccount extends Account {
    String getID();
}

class BankAccount implements PremiumAccount {
    public static void main(String[] args) {

    }

    @Override
    public String getID() {
        return null;
    }
}