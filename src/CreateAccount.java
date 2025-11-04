import java.util.ArrayList;
import java.util.List;

public class CreateAccount{
    private final long accountNumber;
    private final String accountHolderName;
    private final int accountPinNumber;
    private double balance=0;
    private final List<Transaction> transactions = new ArrayList<>();

    public CreateAccount(long accountNumber,String accountHolderName,int accountPinNumber,double balance){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.accountPinNumber=accountPinNumber;
        this.balance+=balance;
        addTransaction("INITIAL DEPOSIT",balance);
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

    public void addTransaction(String type, double amount){
        transactions.add(new Transaction(type,amount));
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    @Override
    public String toString() {
        return "Account Holder: " + accountHolderName +
                "\nAccount Number: " + accountNumber +
                "\nCurrent Balance: Rs. " + balance;
    }
}