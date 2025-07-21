import java.util.Scanner;
class Account1 {

    long balance;
    private long acc_no;
    private String name;
    void Account_creation(long acc,String name){

        this.acc_no =acc;
        this.name = name;
        this.balance=0;
        System.out.println("Account successfully created.");
        System.out.println();
    }
    long deposit(long amount){
        balance+=amount;
        System.out.println("successfully deposited.");
        System.out.println("current balance:"+balance);
        System.out.println();
        return balance;
    }

    long withdraw(long amount){
        balance=balance-amount;
        System.out.println("successfully withdrawal.");
        System.out.println("current balance:"+balance);
        System.out.println();
        return balance;
    }
    boolean isAccountCreated() {
        return name != null;
    }

    public long getAcc_no() {
        return acc_no;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account1 account1 = new Account1();
        while (true) {
            System.out.println("press\n 1.acc_creation\n2.deposit\n3.withdraw\n4.Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.print("enter mobile number:");
                    long acc_no = sc.nextLong();
                    System.out.print("\nenter your name:");
                    String name = sc.nextLine();
                    account1.Account_creation(acc_no, name);
                    break;
                case 2:
                    if (!account1.isAccountCreated()) {
                        System.out.println("create account first.");
                    } else {
                        System.out.print("enter mobile number:");
                        long acc1_no = sc.nextLong();
                        if(account1.getAcc_no()==acc1_no){
                            System.out.println("enter amount to be deposited:");
                            long amount = sc.nextLong();
                            account1.deposit(amount);
                        }else{
                            System.out.println("wrong credentials.11");
                        }
                    }
                    break;
                case 3:
                    if (!account1.isAccountCreated()) {
                        System.out.println("create account first.");
                    } else {
                        System.out.println("enter Account number:");
                        long acc = sc.nextLong();
                        if (account1.getAcc_no() == acc) {
                            System.out.println("enter withdrawal amount:");
                            long amount = sc.nextLong();
                            if (account1.balance > amount) {
                                account1.withdraw(amount);
                            } else {
                                System.out.println("insufficient Balance.");
                            }
                        } else {
                            System.out.println("wrong Account number.");
                        }
                    }
                case 4:
                    System.out.println("Thank you for banking with us.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");


            }


        }
    }
}

