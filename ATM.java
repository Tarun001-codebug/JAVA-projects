import java.util.Scanner;

public class ATM {
    static  int op;
    static  Scanner sc = new Scanner(System.in);
    private float Balance;
    private int pin = 9213;
    public void SetPin(int pin){
        this.pin = pin;
    }
    public int getPin(){
        return pin;
    }
    public float getBalance(){
        return Balance;
    }
    public void setBalance(float balance){
        this.Balance = balance;
    }

    public void checkBalance(){
        System.out.println("your current balance : "+getBalance());
    }
    public void AddMoney(){
        System.out.print("Enter the money :");
       float money = sc.nextFloat();

       setBalance(getBalance()+money);
        System.out.println("money added successfully ");
        System.out.println("Now, your current balance is "+getBalance());
    }

    public void withrawMoney(){
        System.out.print("Enter amount :");
        float money = sc.nextFloat();

        setBalance(getBalance()-money);
        System.out.println("Amount reducted successfully ");
        System.out.println("Now, your current balance is "+getBalance());
    }
    public void checkPin() {
        System.out.print("Enter the PIN :");
        int chk = sc.nextInt();
        if (pin == chk) {
            System.out.println("welcome to dashboard");
            while(op!=4){
            menu();
            }
        } else {
            System.out.println("Enter a valid pin");
            checkPin();
        }
    }
    public void menu(){
        System.out.println(">>>>>>>>>>>MAIN MANU<<<<<<<<<<< ");
        System.out.println("1) Check Balance \t\t\t\t 2) Add Money\n3) Withdraw Money \t\t\t\t 4) Exit ");
        op = sc.nextInt();
        switch (op){
            case 1->checkBalance();
            case 2->AddMoney();
            case 3->withrawMoney();
            case 4-> {
                return;
            }
            default->{
                System.out.println("Enter valid input");
                menu();
            }
        }

    }

        public static void main (String[]args){
            ATM obj = new ATM();
            obj.checkPin();


        }
    }
