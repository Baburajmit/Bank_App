import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankManagementService {
    private static final Map<Long, CreateAccount> createAccountList = new HashMap<>();

    public static void accountCreate(String name,int pin,double deposit){
        long generateAccountNumber;

        do {
            generateAccountNumber= 1000000000L + (long)(Math.random() * 9000000000L);
        }while (findAccount(generateAccountNumber).isPresent());

        boolean exits = createAccountList.values().stream()
                .anyMatch(a->a.getAccountHolderName().equals(name) && a.getAccountPinNumber() == pin);
        if (exits){
            System.out.println("Account with this name and PIN already exists.");
            return;
        }

        CreateAccount newAccount = new CreateAccount(generateAccountNumber,name,pin,deposit);
        createAccountList.put(generateAccountNumber,newAccount);

        System.out.println("Account created successfully!");
        System.out.println("Your Account Number: " + generateAccountNumber);
    }

    public static void accountDeposit(long accountNum, int pin, double depositAmount){
        Optional<CreateAccount> UserOpt = findAccount(accountNum);

        if (UserOpt.isEmpty()){
            System.out.println("Account Not Found!");
            return;
        }

        CreateAccount acc=UserOpt.get();

        if (acc.getAccountPinNumber()!=pin){
            System.out.println("Wrong Pin!");
            return;
        }

        acc.setBalance(acc.getBalance() + depositAmount);
        System.out.println("Deposit successful! Updated Balance: Rs. "+acc.getBalance());
    }

    public static void accountWithdraw(long accountNum,int pin,double withdrawAmount){
        Optional<CreateAccount> UserOpt= findAccount(accountNum);

        if (UserOpt.isEmpty()){
            System.out.println("Account Not Found!");
            return;
        }

        CreateAccount acc= UserOpt.get();

        if (acc.getAccountPinNumber()!=pin){
            System.out.println("Wrong Pin!");
            return;
        }

        if (withdrawAmount > acc.getBalance()){
            System.out.println("Insufficient balance!");
            return;
        }

        acc.setBalance(acc.getBalance() - withdrawAmount);
        System.out.println("Withdraw successful! Updated Balance: Rs. "+acc.getBalance());
    }

    public static double balanceCheck(long accountNum,int pin){
        Optional<CreateAccount> UserOpt=findAccount(accountNum);

        if (UserOpt.isEmpty()){
            System.out.println("Account Not Found!");
            return -1;
        }

        CreateAccount acc= UserOpt.get();

        if (acc.getAccountPinNumber()!=pin){
            System.out.println("Wrong Pin!");
            return -1;
        }

        return acc.getBalance();
    }

    public static void displayAccountDetails(long accountNum,int pin){
        Optional<CreateAccount> UserOpt=findAccount(accountNum);

        if (UserOpt.isEmpty()){
            System.out.println("Account Not Found!");
            return;
        }

        CreateAccount acc= UserOpt.get();

        if (acc.getAccountPinNumber()!=pin){
            System.out.println("Wrong Pin!");
            return;
        }

        System.out.println("\n---View Account Details---");
        System.out.println(acc);
    }

    public static Optional<CreateAccount> findAccount(long accountNumber){
        return Optional.ofNullable(createAccountList.get(accountNumber));
    }
}
