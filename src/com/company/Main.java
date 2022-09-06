package com.company;

import java.util.Scanner;

public class Main {
// login--- user password
 // create account user password
 //send money from one account to another---> user password ,destination account number
 // check and  add balance
 //withdraw money,delete account
 public static void main(String[] args){
     Bank bank=new Bank();
     int option;

     do {
         System.out.println("Choose the below options.");
         System.out.println("1. Create an account.");
         System.out.println("2.Check balance of your account.");
         System.out.println("3. Add money to your account.");
         System.out.println("4.Transfer money to other account. ");
         System.out.println("5. Withdraw money from your account. ");
         System.out.println("6. Delete your account");
         System.out.println("7.Exit");

         Scanner sc = new Scanner(System.in);
         option = sc.nextInt();
         int id=0;String password="";
         int receiverID;double amount;
         boolean login;
         if(option!=7)
         {
             System.out.print("Enter your User id");
             id = sc.nextInt();
             System.out.print("Enter your password");
             password = sc.next();
         }
         switch (option) {

             case 1:
                 bank.addUser(id, password);
                 break;

             case 2:
                 login= bank.verifyCredentials(id, password);
                 if(login)
                 {
                     bank.checkBalance(id);
                 }
                 else
                 {
                     System.out.println("Invalid Credentials");
                 }
                 break;

             case 3:
                 login= bank.verifyCredentials(id,password);
                 if(login){
                     System.out.println("Enter the amount");
                     amount= sc.nextDouble();
                     bank.addMoney(id,amount);

                 }
                 else{
                     System.out.println("Invalid credentials");
                 }
                 break;
             case 4:
                 login= bank.verifyCredentials(id,password);
                 if(login){
                     System.out.println("Enter receiver ID");
                     receiverID=sc.nextInt();
                     System.out.println("Enter the amount:");
                     amount=sc.nextDouble();
                     bank.sendMoney(id,password,receiverID,amount);

                 }
                 else{
                     System.out.print("Invalid Credentials");
                 }
                 break;

             case 5:
                 login= bank.verifyCredentials(id,password);
                 if(login){
                     System.out.print("Enter the amount :");
                     amount=sc.nextDouble();
                     bank.withdrawMoney(id,amount);

                 }
                 else{
                     System.out.println("Invalid Credentials");
                 }
                 break;

             case 6:
                 login= bank.verifyCredentials(id,password);
                 if(login){
                    bank.deleteAccount(id);
                    System.out.println("Account deleted successfully!!!");

                 }
                 else{
                     System.out.println("Invalid Credentials");
                 }
                 break;




             case 7:
                 System.out.print("Exited Successfully!!!");
                 break;
             default:
                 break;


         }
     }while(option!=7);


 }
}
