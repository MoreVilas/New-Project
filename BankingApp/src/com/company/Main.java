package com.company;

import java.util.Scanner;

class BankDetails{
    private String accno;
    private String name;
    private long balance;
    Scanner sc = new Scanner(System.in);

    public void CreateAccount(){
        System.out.print("Enter Account NO: ");
        accno = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance=sc.nextLong();
    }
    public void showAccount(){
        System.out.println("Name of account holder: "+ name);
        System.out.println("Account no: "+accno);
        System.out.println("Balance: "+balance);
    }
    public void deposit(){
        long amt;
        System.out.println("Enter the amount you want to deposite:");
        amt=sc.nextLong();
        balance= balance + amt;
    }
    public void withdrawal(){
        long amt;
        System.out.println("Enter the amount you want to withdrawal: ");
        amt = sc.nextLong();
        if(balance >= amt){
            balance = balance - amt;
            System.out.println("Balance after withdrawal: "+ balance);
        }else{
            System.out.println("Your balance is less than" + amt + "\tTransaction failed...!!");

        }
    }
    public void showBalance(String accno){
        if(accno.equals(accno)){
            showAccount();
        }
        System.out.println("Name of account holder: "+ name +"Account no: "+accno+ "Balance: "+balance);

    }
    public boolean search(String ac_no){
        if(accno.equals(ac_no)){
            showAccount();
            return(true);
        }
        return(false);
    }

}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n***Banking System Application***");
        System.out.println("\n1.Create account \n2.Search the account \n3.Deposite the amount \n4.Withdraw the amount \n5.Exit");
        System.out.println("Enter your choice: ");
        int n = sc.nextInt();
        BankDetails C[]= new BankDetails[n];
        for(int i=0; i<C.length; i++){
            C[i] = new BankDetails();
            C[i].CreateAccount();

        }
        int ch;
        do{

            ch = sc.nextInt();
            switch(ch){
                case 1:
                    for(int i=0; i<C.length; i++){
                        C[i].CreateAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no.you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for(int i=0; i<C.length; i++){
                        found = C[i].search(ac_no);
                        if(found){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account dosen't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no: ");
                    ac_no = sc.next();
                    found = false;
                    for(int i=0; i<C.length; i++){
                        found = C[i].search(ac_no);
                        if(found){
                            C[i].deposit();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account dosen't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No: ");
                    ac_no = sc.next();
                    found = false;
                    for(int i=0; i<C.length; i++){
                        found = C[i].search(ac_no);
                        if(found){
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account dosen't exist..!!");
                    }
                    break;
                case 5:
                    System.out.print("See you soon...");
                    break;

            }
        }
        while(ch !=5);

    }
}
