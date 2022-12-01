import java.util.Scanner;
public class Banking {
    public static String name = ""; //FOR CREATING AN INSTANCE OF BANKING CLASS
    private static String pin= "0123"; //PIN CODE SET
    public static void exit() { //EXIT MESSAGE
        System.out.println("Exiting...");
        System.out.println("Have a nice day!");
    }
    public static void welcome(){ //WELCOME MESSAGE + OPTIONS
        System.out.printf("\n Welcome to your %s ATM interface!%n",name);
        System.out.println("Press 1 for exit");
        System.out.println("Press 2 for money transfer");
        System.out.println("Press 3 for withdraw");
        System.out.println("Press 4 for deposit");
    }
    public static void trr() { // ASK FOR ANOTHER TRANSACTION MESSAGE
        System.out.println("Would you like to make another transaction? 1-YES 2-NO");
    }
    public static void err() { //ERROR MESSAGE
        System.out.println("ERROR! Amount exceeds balance, please enter another value:");
    }
    public static void show(int bal){ //METHOD TO PRINT BALANCE
        System.out.println("Your balance is: "+bal);
    }
    public static boolean pin() { //CHECK PIN METHOD
        Scanner sc = new Scanner(System.in); ////CREATE AN INSTANCE OF SCANNER CLASS TO BE ABLE TO READ USER INPUTS
        int n = 0; //COUNTER
        while (n < 3) { //For 3 attempts
            if (n==0) System.out.println("Please enter your PIN: "); //First try
            else System.out.println("Wrong PIN, please enter your correct PIN: ");//Second and third tries
            String p = sc.next(); //USER INPUT FOR PIN
            if (p.equals(pin)) break; // COMPARES USER INPUT WITH THE DEFINED PIN
            n++; //COUNTER INCREMENT
            if (n == 3) { //After the 3rd try
                System.out.println("You entered the wrong PIN 3 times, your card is blocked!");
                exit(); //exit message
                return false;
            }
        }
    return true;
    }
    public static void exec() {
        if (pin()) { //CHECK IF PIN METHOD RETURNED TRUE (CORRECTLY INSERTED PIN) TO ACCESS ATM INTERFACE
            Scanner sc = new Scanner(System.in); //CREATE AN INSTANCE OF SCANNER CLASS TO BE ABLE TO READ USER INPUTS
            int min = 0;
            int max = 1000;
            int balance = (int) (Math.random() * (max - min + 1) + min); //GENERATE A RANDOM NUMBER FOR BALANCE
            a:while (true) { //LOOP THAT NEEDS A BRAKE TO CLOSE IT
                welcome(); //welcome message + options
                int op = sc.nextInt(); // SCAN USER INPUT (CHOICE)
                if (balance == 0) {
                    System.out.println("Your balance is 0, would you like to make a deposit? 1-Yes 2-NO");
                    int res = sc.nextInt();// SCAN USER INPUT
                    if (res == 2) { //IF USER INPUT = 2
                        exit(); //exit message
                        break; //BREAK MAIN LOOP
                    } else {
                        op = 4; //deposit
                    }
                }
                if (op == 1) { //EXIT OPTION
                    exit(); //exit message
                    break; //end program
                } else if (op == 2) { // TRANSFER OPTION
                    show(balance); // DISPLAY BALANCE
                    System.out.println("How much would you like to transfer?");
                    int transfer = sc.nextInt(); //user input for transfer amount
                    while (true) {
                        if (transfer > balance) { // if user input for transfer amount exceeds balance
                            err(); //error message
                            transfer = sc.nextInt(); //insert another value
                        } else {
                            balance -= transfer; // new balance = old balance - transfer amount
                            System.out.println("Transfer successful! Your current balance: " + balance);
                            trr(); //ASK USER IF HE WANTS TO MAKE ANOTHER TRANSACTION
                            int res = sc.nextInt(); //USER INPUT (CHOICE) FOR ANOTHER TRANSACTION
                            if (res == 2) { //IF USER INPUT = 2
                                exit();//exit message
                                break a; //BREAK MAIN LOOP
                            } else break; //BREAK CURRENT LOOP
                        }
                    }
                }
                else if (op == 3) {
                    show(balance);
                    System.out.println("How much would you like to withdraw?");
                    int withdraw = sc.nextInt(); //user input for withdraw amount
                    while (true) {
                        if (withdraw > balance) { // if user input for withdraw amount exceeds balance
                            err(); // error message
                            withdraw = sc.nextInt(); //user input for withdraw amount
                        } else {
                            balance -= withdraw; // new balance = old balance - withdraw amount
                            System.out.println("Withdraw successful! Your current balance: " + balance);
                            trr(); //ASK USER IF HE WANTS TO MAKE ANOTHER TRANSACTION
                            int res = sc.nextInt(); //USER INPUT (CHOICE) FOR ANOTHER TRANSACTION
                            if (res == 2) {  //IF USER INPUT = 2
                                exit(); //exit message
                                break a; //BREAK MAIN LOOP
                            } else break;
                        }
                    }
                }
                else if (op == 4) {
                    show(balance);
                    System.out.println("How much would you like to deposit?");
                    int deposit = sc.nextInt(); //user input for deposit amount
                    balance += deposit; // new balance = old balance + deposit amount
                    System.out.println("Deposit submitted! Your current balance: " + balance);
                    trr(); //ASK USER IF HE WANTS TO MAKE ANOTHER TRANSACTION
                    int res = sc.nextInt(); //USER INPUT (CHOICE) FOR ANOTHER TRANSACTION
                    if (res == 2) { //IF USER INPUT = 2
                        exit(); //exit message
                        break; //BREAK MAIN LOOP
                    }
                }
                else System.out.println("Invalid operation"); //IF USER INPUT IS NOT EQUAL TO ONE OF THE OPTIONS AVAILABLE
            }
        }
    }

    public static void main(String[] args) { // MAIN METHOD
        exec(); // METHOD CALL
    }
}
