import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApp {
    static Scanner sc=new Scanner(System.in);
    static BankManagementService bankManagement = new BankManagementService();

    public static void main(String[] args) {
        while (true){
            System.out.println("\n---Welcome to Zoho Bank---\n1. Create Bank Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Display Account Details & History\n6. Exit");
            System.out.print("Enter Your Choice: ");

            int choice=getValidIntInput();

            switch (choice){
                case 1 -> createrAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> displayDetalis();
                case 6 -> {
                    System.out.println("Exited... \nThank You For Using Zoho Bank!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void createrAccount(){
        System.out.print("Enter account holder name (As per Aadhar Card): ");
        String name=sc.nextLine().trim().toUpperCase();

        System.out.print("Enter your new four-digit PIN: ");
        int pin=getValidPin();

        System.out.println("\nFor initial deposit, you need to to add Rs.1000");
        System.out.print("Enter 1 to Accept or 2 to cancel: ");
        int choice=getValidIntInput();

        if (choice!=1){
            System.out.println("Account creation cancelled.");
            return;
        }

        BankManagementService.accountCreate(name,pin,1000.00);
    }

    public static void deposit(){
        System.out.print("Enter Account Number: ");
        long accNo = getValidLongInput();

        System.out.print("Enter Pin Number: ");
        int pin = getValidPin();

        System.out.print("Enter Amount to Deposit: ");
        int Amount=getValidPositiveAmount();

        BankManagementService.accountDeposit(accNo,pin,(double) Amount);
    }

    public static void withdraw(){
        System.out.print("Enter Account Number: ");
        long accNo = getValidLongInput();

        System.out.print("Enter Pin Number: ");
        int pin = getValidPin();

        System.out.print("Enter Amount to Withdraw: ");
        int Amount=getValidPositiveAmount();

        BankManagementService.accountWithdraw(accNo,pin,(double) Amount);
    }

    public static void checkBalance(){
        System.out.print("Enter Account Number: ");
        long accNo = getValidLongInput();

        System.out.print("Enter Pin Number: ");
        int pin = getValidPin();

        double balance= BankManagementService.balanceCheck(accNo,pin);
        if (balance >= 0){
            System.out.println("Current Balance: Rs. " + balance);
        }
    }

    public static void displayDetalis(){
        System.out.print("Enter Account Number: ");
        long accNo = getValidLongInput();

        System.out.print("Enter Pin Number: ");
        int pin = getValidPin();

        BankManagementService.displayAccountDetails(accNo,pin);
    }

    public static int getValidIntInput(){
        while (true){
            try{
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            }catch (InputMismatchException e){
                System.err.print("Enter numbers only: ");
                sc.nextLine();
            }
        }
    }

    public static int getValidPin(){
        while (true){
            int pin = getValidIntInput();
            if (pin > 999 && pin <= 9999){
                return pin;
            }
            System.err.print("Enter a Valid 4-digit PIN: ");
        }
    }

    public static long getValidLongInput(){
        while (true){
            try {
                long input = sc.nextLong();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e){
                System.err.print("Enter Valid Account Number: ");
                sc.nextLine();
            }
        }
    }

    public static int getValidPositiveAmount(){
        while (true){
            int amount = getValidIntInput();
            if (amount > 0) return amount;
            System.err.print("Amount must be greater than 0: ");
        }
    }
}