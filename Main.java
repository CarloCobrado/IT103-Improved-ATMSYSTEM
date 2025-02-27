import java.util.Scanner;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        HashMap<String, Integer> accounts = new HashMap<String, Integer>();
        HashMap<String, Double> accountbalance = new HashMap<String, Double>();
        double initialbalance = 0;
        
        System.out.println("Welcome dear customer! Choose your option:");
        boolean startup = true;
        while (startup) {
            System.out.println("1. Register"); 
            System.out.println("2. Login"); 
            System.out.println("3. Shutdown"); 
            System.out.print("Enter Choice: "); 
            int choice = input.nextInt();
            input.nextLine();
            
            if (choice==1) {
                System.out.print("Enter Account Number: "); 
                String newaccount = input.nextLine();
                    
                System.out.print("Enter PIN: ");
                int newpin = input.nextInt();
                    
                if (accounts.containsKey(newaccount)){
                        System.out.println("Sorry, account already exists.");
                }
                else {
                        accounts.put(newaccount, newpin);
                        accountbalance.put(newaccount, initialbalance);
                        System.out.println("Account Successfully Registered.");
                }
            }
            else if (choice==2){
                System.out.print("Enter Account Number: ");
                String enteraccnum = input.nextLine();
        
                System.out.print("Enter PIN: ");
                int enterpin = input.nextInt();
                    
                if (accounts.containsKey(enteraccnum) && accounts.get(enteraccnum)==enterpin){
                    System.out.println("Login Successful!");
                        
                    double balance = 0;
                    boolean validlogin = true;
                    while (validlogin) {
                        System.out.println("ATM Menu:"); 
                        System.out.println("1. Check Balance"); 
                        System.out.println("2. Deposit Money"); 
                        System.out.println("3. Withdraw Money"); 
                        System.out.println("4. Exit"); 
                        System.out.print("Choose an option: "); 
                        int validloginchoice = input.nextInt();
                        input.nextLine();
                        
                        if (validloginchoice==1) {
                            System.out.println("Your balance is: $" + accountbalance.get(enteraccnum));
                        }
                            
                        else if (validloginchoice==2){
                            System.out.print("Enter deposit amount: ");
                                double deposit = input.nextDouble();
                                balance += deposit;
                                accountbalance.replace(enteraccnum, balance);
                                System.out.println("Deposit successful. New balance: $" + accountbalance.get(enteraccnum) );
                        }
                            
                        else if (validloginchoice==3){
                            boolean withdrawal = true;
                            while (withdrawal) {
                                System.out.print("Enter withdrawal amount: ");
                                double withdraw = input.nextDouble();
                                if (withdraw <= balance) {
                                    balance -= withdraw;
                                    accountbalance.replace(enteraccnum, balance);
                                    System.out.println("Withdrawal successful. New balance: $" + accountbalance.get(enteraccnum) );
                                    withdrawal = false;
                                }
                                else {
                                    System.out.println("Insufficient balance.");
                                    System.out.println("Would you like to continue withdrawing?");
                                    System.out.println("1 to continue, 2 to return.");
                                    int withdrawchoice = input.nextInt();
                                    input.nextLine();
                                      
                                    switch(withdrawchoice) {  
                                        case 1:
                                            break;
                                        
                                        case 2:
                                            withdrawal = false;
                                            break;
                                                
                                        default:
                                                System.out.println("Invalid option. Please try again.");
                                    }
                                }
                            }
                        }
                            
                        else if (validloginchoice==4){
                            System.out.println("Logging out... Thank you for using the ATM.");
                            validlogin = false;
                        }
                            
                        else {
                            System.out.println("Invalid option. Please try again.");
                        }
                    }
                }
                else {
                    System.out.println("Invalid account number or PIN. Access denied.");
                }
            }
            else if (choice==3){
                System.out.println("Shutting down... Goodbye!");
                startup = false;
            }

            else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}