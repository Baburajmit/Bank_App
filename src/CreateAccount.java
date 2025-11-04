public class CreateAccount{
    private final long accountNumber;
    private final String accountHolderName;
    private final int accountPinNumber;
    private double balance=0;

    public CreateAccount(long accountNumber,String accountHolderName,int accountPinNumber,double balance){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.accountPinNumber=accountPinNumber;
        this.balance+=balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountPinNumber() {
        return accountPinNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance=balance;
    }

    @Override
    public String toString() {
        return "Account Holder: " + accountHolderName +
                "\nAccount Number: " + accountNumber +
                "\nCurrent Balance: Rs. " + balance;
    }
}