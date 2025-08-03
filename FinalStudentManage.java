package StudentManagementSystemProject;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FinalStudentManage {
static ArrayList<Studentz> list = new ArrayList<>();
static Scanner sc = new Scanner(System.in);
static int choice ;
static int i=0;

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>WELCOME TO STUDENT MANAGEMENT SYSTEM<<<<<<<<<<<");
        while(true) {
            try{
            mainMenu();
            switch (choice) {
                case 1 -> AddStudent();
                case 2 -> EditStudent();
                case 3 -> ViewStudents();
                case 4 -> RemoveStudent();
                case 5 -> SearchStudent();
                case 0 -> {
                    return;
                }
                default -> System.out.println("ENTER VALID INPUT");
            }}catch (InputMismatchException in){
                System.out.println("ENTER VALID INPUT");
                choice = sc.nextInt();
            }
        }
    }
    public static void mainMenu(){
        System.out.println("---------------------------------------------------------");
        System.out.println("MAIN MENU");
        System.out.print("1)ADD STUDENT \n2)EDIT STUDENT \n3)VIEW ALL STUDENTS \n4)DELETE STUDENT \n5)SEARCH STUDENT \n0)EXIT \n->");
        choice = sc.nextInt();
    }

   public static void AddStudent(){
        i++;
       sc.nextLine();
   try {
       System.out.print("NAME: ");
       String name = sc.nextLine();
       System.out.print("AGE: ");
       int age = sc.nextInt();
       System.out.print("COURSE: ");
       sc.nextLine();
       String course = sc.nextLine();
       System.out.print("YEAR: ");
       int year = sc.nextInt();

       list.add(new Studentz(i, name, age, course, year));
       System.out.println("\nSTUDENT ADDED SUCCESFULLY\n");
   } catch (RuntimeException e) {
       System.out.println("ENTER VALID INPUT");
       AddStudent();
   }
   }

   public static void EditStudent(){
        sc.nextLine();
       System.out.print("ROLL NO. : ");
       int roll = sc.nextInt();
       for (Studentz stu : list) {
           if(stu.getId()==roll){
               System.out.println("STUDENT FOUND AT RESPECTIVE ROLL NUMBER");
               System.out.println(stu);
               int Choice;
               System.out.print("1)NAME \n2)AGE \n3)COURSE \n4)YEAR \n5)EXIT \n->");
               Choice= sc.nextInt();

               switch(Choice){
                   case 1->{
                       sc.nextLine();
                       System.out.print("NAME:");
                       String name = sc.nextLine();
                       stu.setName(name.toUpperCase());
                       System.out.println("NAME CHANGED");
                       return;
                   }
                   case 2 ->{
                       System.out.print("AGE: ");
                       int age = sc.nextInt();
                       stu.setAge(age);
                       System.out.println("AGE CHANGED");
                       return;
                   }
                   case 3->{
                       sc.nextLine();
                       System.out.println("COURSE");
                       String course = sc.nextLine();
                       stu.setCourse(course.toUpperCase());
                       System.out.println("COURSE CHANGED");
                       return;
                   }
                   case 4->{
                       System.out.print("YEAR: ");
                       int year = sc.nextInt();
                       stu.setYear(year);
                       System.out.println("YEAR CHANGED");
                       return;
                   }
                   case 5->{
                      return;
                   }

               }
           }
       }
       System.out.println("NO SUCH STUDENT FOUND");
   }
   public static void ViewStudents(){
        if (list.isEmpty()){
            System.out.println("RECORD EMPTY");
        }
       for (Studentz stu : list) {
           System.out.println(stu);
       }
   }
   public static void RemoveStudent(){
       System.out.print("ROLL NO. : ");
       int roll = sc.nextInt();
       for (Studentz stu : list) {
           if(stu.getId()==roll) {
               System.out.println("STUDENT FOUND AT RESPECTIVE ROLL NUMBER");
               System.out.println(stu);
               list.remove(stu);
               System.out.println("STUDENT "+stu.name+" IS REMOVED FROM RECORDS");
               return;
           }
           }
       System.out.println("NO SUCH STUDENT FOUND!!");
   }
   public static void SearchStudent(){
       System.out.print("ROLL NO. : ");
       int roll = sc.nextInt();
       for (Studentz stu : list) {
           if(stu.getId()==roll) {
               System.out.println("STUDENT FOUND AT RESPECTIVE ROLL NUMBER");
               System.out.println(stu);
               return;
           }
       }
   }



}
