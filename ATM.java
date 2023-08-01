import java.util.Scanner;

class ATMapp {
    String name = "Abc", history = "";
    String cardHolderName;
    int cardNo = 123, balance = 0, transaction = 0;
    int atmNo, deposit, withdraw, menu;

    String option[] = new String[6];
    Scanner r = new Scanner(System.in);

    // register the ATM Card
    void RegisterCard() {
        System.out.println("Enter the card holders name ");
        cardHolderName = r.next();
        System.out.println("Enter the ATM card number ");
        atmNo = r.nextInt();

        if (cardHolderName.equals(name) && atmNo == cardNo) {
            System.out.println("Card Rgistered Successfully");
            CardOperations();
        } else {
            System.out.println("Card not found. Enter the correct details");
        }
    }

    // private void CardOperations() {
    // exit the system
    void Exit() {
        System.out.println("Thank You Visit Again");
        System.exit(0);
    }

    // Transfering the amount if sufficient balance exixt
    void Transfer() {
        if (balance >= withdraw) {
            balance = balance - withdraw;
            System.out.println("Transfer Rs " + withdraw + "\t Balance Rs: " + balance);
            transaction++;
            String str = "\nAmount Transfer : Rs " + withdraw + "\t Balance : Rs" + balance;
            history = history.concat(str);
        } else {
            System.out.println("InSufficient Balance ");
        }
        System.out.println("------------------------------------------------------");
    }

    // Withdraw the amount if sufficient Balance exixt
    void Withdraw() {
        if (balance >= withdraw) {
            balance = balance - withdraw;
            System.out.println("Withdraw Rs:" + withdraw + "\t Balance : Rs " + balance);
            transaction++;
            String str = "\nAmount Withdraw : rs " + withdraw + "\t Balance : Rs " + balance;
            history = history.concat(str);
        } else {
            System.out.println("InSufficient balance ");
        }
        System.out.println("-----------------------------");
    }

    // Deposit the entered amount
    void Deposit() {
        balance = balance + deposit;
        System.out.println("Deposit Rs " + deposit + "\t Balance Rs " + balance);
        System.out.println("----------------------------------------");
        transaction++;
        String str = "\nAmount  Deposit : Rs " + deposit + "\t Balance :  Rs " + balance;
        history = history.concat(str);
    }

    // check balance of account holder
    void CheckBalance() {
        System.out.print("Your Account Balance is Rs ");
        System.out.println(balance);
        System.out.println("\n------------------------------------");
    }

    // Get transaction history of the Account
    void TransactionHistory() {
        if (transaction == 0) {
            // transaction++;
            System.out.println("No Records Found ");
        } else {
            System.out.println(history);
        }
        System.out.println("\n---------------------------");
    }

    void CardOperations() {
        System.out.println("------------------------------------");
        System.out.println("Operation Menue");
        System.out.println("--------------------------------------");
        option[0] = "Check Balance";
        option[1] = "Deposit Cash";
        option[2] = "Withdraw Cash";
        option[3] = "Transfer Cash";
        option[4] = "Transaction History";
        option[5] = "Exit";
        for (int i = 0; i < option.length; i++) {
            System.out.println(i + 1 + " " + option[i]);
        }
        System.out.println("---------------------------");

        do {
            System.out.println("Select the operation(  Enter the serial no .)");
            menu = r.nextInt();

            switch (menu) {
                case 1: {
                    CheckBalance();
                    break;
                }
                case 2: {
                    System.out.println("Enter the amouunt to deposit: Rs ");
                    deposit = r.nextInt();
                    Deposit();
                    break;
                }
                case 3: {
                    System.out.println("Enter the amouunt to Withdraw : Rs ");
                    withdraw = r.nextInt();
                    Withdraw();
                    break;
                }
                case 4: {
                    System.out.println("Enter the amount to transfer : Rs ");
                    withdraw = r.nextInt();
                    Transfer();
                    break;
                }
                case 5: {
                    System.out.println("Transaction History of " + name);
                    TransactionHistory();
                    break;
                }
                case 6: {
                    Exit();
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value" + (menu + 1));

            }
        } while (menu < 6);
        r.close();

    }
}

public class ATM {
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(" Welcome to Atm service App ");
        System.out.println("----------------------------------------");
        ATMapp atm = new ATMapp();
        atm.RegisterCard();
    }
}