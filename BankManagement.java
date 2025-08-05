package BankManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

//;;;;;;;;;;;;;;;;;;;;;;
//
enum type{
    SAVING,CURRENT;
}
  class bankacc {
    private long AccNo;
    private String Name;
    private int age;
    private type Acctype;//i can create enums
    private double balance;

    public bankacc(long AccNo, String name, int age, type acctype , double balance ){
        this.AccNo =AccNo;
        this.Name =name;
        this.age = age;
        this.Acctype = acctype;
        this.balance = balance;
    }

    public long getAccNo(){return AccNo;}
    public String getName(){return Name;}
    public int getage(){return age;}
    public type getType(){return Acctype;}
    public double getBalance(){return balance;}

    public void setName(String name){this.Name=name;}
    public void setType(type acctype){this.Acctype= acctype;}
    public void setAge(int age){
        if(age<0 || age>100){
            System.out.print("ENTER VALID AGE ");
        }
        this.age=age;
    }

    @Override
    public String toString() {
        return
                "ACCOUNT HOLDER'S DETAILS \n" +
                        "ACCOUNT NUMBER = " + AccNo +
                        "\nNAME = " + Name + '\n' +
                        "AGE = " + age +
                        "\nACCOUNT TYPE = " + Acctype +
                        "\nBALANCE = " + balance
                ;
    }

    public void deposit(int balance){
        this.balance += balance;
    }
    public void withdraw(int money){
        this.balance -= money;
    }

}

public class BankManagement {
    static HashMap<Long, bankacc> AccBook = new HashMap<>();
    static int choice;
    static long Accno = 10000;
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
        System.out.println("=====BANK MANAGEMENT SYSTEM=====");
        System.out.print("1)CREATE NEW ACCOUNT \n2)DEPOSIT MONEY \n3)WITHDRAW MONEY \n4)CHECK BALANCE \n5)VIEW ALL ACCOUNTS \n6)EXIT \nENTER YOUR CHOICE : ");
        choice = sc.nextInt();
        switch (choice){
            case 1 -> CreateAcc();
            case 2 -> deposit();
            case 3 -> withdraw();
            case 4 -> checkBalance();
            case 5 -> viewAll();
            case 6 ->{
                System.out.println("THANKS FOR USING OUR SERVICE");
                return;
            }
            default -> System.out.println("ENTER VALID INPUT");
        }
        }
    }

    public static void CreateAcc(){
        Accno++;
        sc.nextLine();
        System.out.print("NAME :");
        String name= sc.nextLine().toUpperCase();
        System.out.print("AGE :");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("ACC. TYPE(SAVING/CURRENT) :");
        String testype = sc.nextLine().toUpperCase();
        try{ type validtype = type.valueOf(testype);} catch (IllegalArgumentException e) {
            System.out.println("ENTER VALID INPUTS");
        } catch (Throwable e){
            System.out.println("EXCEPTION OCCURRED");
        }
        System.out.print("BALANCE :");
        int balace = sc.nextInt();
        if(balace<500){
            System.out.println("INITIAL DEPOSIT MUST BE MORE THAN EQUALS TO 500");
            System.out.print("BALANCE  :");
            balace = sc.nextInt();
        }
        AccBook.put(Accno,new bankacc(Accno,name,age,type.valueOf(testype),balace));
        System.out.println("THANKS FOR USING OUR SERVICE \nYOUR ACCOUNT IS SUCCESSFULLY CREATED ,\nYOUR ACCOUNT NUMBER IS = "+ AccBook.get(Accno).getAccNo());
        for (Long l : AccBook.keySet()) {
            System.out.println(l);
        }
        System.out.println();
    }

    public static void deposit(){
        System.out.print("ENTER ACCOUNT NUMBER :");
        long key = sc.nextInt();
        if (!AccBook.containsKey(key)) {
            System.out.println("ENTER VALID ACCOUNT NUMBER , NO SUCH BANK ACCOUNT FOUND AT THIS ACCOUNT NUMBER");
        } else {
            int dep =-1;
            while(dep<=0){
            System.out.print("ENTER Rs. ");
            dep = sc.nextInt();
            if(dep<0){
                System.out.println("ENTER VALID INPUT");
            }}
            AccBook.get(key).deposit(dep);
            System.out.println("BALANCE IS = Rs "+   AccBook.get(key).getBalance());
        }
    }
    public static void withdraw(){
        System.out.print("ENTER ACCOUNT NUMBER :");
        long key = sc.nextInt();
        if(AccBook.containsKey(key)){
            System.out.println("ENTER MONEY:");
            int money = sc.nextInt();
            if(money>AccBook.get(key).getBalance()){
                System.out.println("INSUFFICIENT MONEY");
                return;
            }
            AccBook.get(key).withdraw(money);
            System.out.println("Rs "+ money + "WITHDREW SUCCESSFULLY");
        } else {
            System.out.println("ENTER VALID ACCOUNT NUMBER , NO SUCH BANK ACCOUNT FOUND AT THIS ACCOUNT NUMBER");
        }
    }
    public static void  checkBalance(){
        System.out.print("ENTER ACCOUNT NUMBER :");
        long key = sc.nextInt();
        if(AccBook.containsKey(key)){
            System.out.println("YOUR CURRENT BALANCE IS = "+AccBook.get(key).getBalance());
        }
    }
    public static void viewAll(){
        if(AccBook.isEmpty()){
            System.out.println("NO RECORDS");
            return;

        }
        AccBook.forEach((a,b)-> System.out.println(b));
    }
}
