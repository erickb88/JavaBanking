import java.util.Scanner;
public class Banking {
    public static void exit() {
        System.out.println("Exiting...");
        System.out.println("Have a nice day!");
    }
    public static void welcome(){
        System.out.println("\nWelcome to our banking app");
        System.out.println("Press 1 for exit");
        System.out.println("Press 2 for money transfer");
        System.out.println("Press 3 for withdraw");
    }
    public static void trr() {
        System.out.println("Would you like to make another transaction? 1-YES 2-NO");
    }
    public static void err() {
        System.out.println("ERROR! Amount exceeds balance, please enter another value:");
    }

    public static void main(String[] args) {
        int min=0;
        int max=1000;
        int balance = (int)(Math.random()*(max-min+1)+min);
        Scanner sc = new Scanner(System.in);
        a:while(true)
        {
        welcome();
        int op = sc.nextInt();
            if(balance<=0) {
                System.out.println("Your balance is 0, you have to make a deposit first");
                exit();
                break ;
            }
        if(op == 1 )  {
            exit();
            break;
        }
        else if (op==2) {
            System.out.println("Your balance is: "+balance);
            System.out.println("How much would you like to transfer?");
            int transfer=sc.nextInt();
            while(true) {
                if (transfer > balance) {
                    err();
                    transfer = sc.nextInt();
                } else {
                    balance -= transfer;
                    System.out.println("Transfer successful! Your current balance: " +balance);
                    trr();
                    int res = sc.nextInt();
                    if (res == 2) {
                        exit();
                        break a;
                    }
                    else break;
                }
            }
        }
        else if (op==3) {
            System.out.println("Your balance is: " + balance);
            System.out.println("How much would you like to withdraw?");
            int withdraw = sc.nextInt();
            while (true) {
                if (withdraw > balance) {
                    err();
                    withdraw = sc.nextInt();
                } else {
                    balance -= withdraw;
                    System.out.println("Withdraw successful! Your current balance: " +balance);
                    trr();
                    int res = sc.nextInt();
                    if (res == 2) {
                        exit();
                        break a;
                    }
                    else break;
                }
            }
        }
        else System.out.println("Invalid operation");
        }
    }
}
