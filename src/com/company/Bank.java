package com.company;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer,User> Users;

    Bank(){
        Users=new HashMap<Integer,User>();
    }
    // a hashmap comtaining id as key and User information as value;

    public void addUser(int id,String password){
        if(Users.containsKey(id))
            System.out.println("User id already exists.");
        else{
            User newUser=new User(id,password);
            Users.put(id,newUser);
            System.out.print("Account Successfully created.");
        }
    }
    public boolean verifyCredentials(int id,String password){
        User user=Users.get(id);
        if(user == null)
            return false;
        return user.verifyPassword(password);

    }
    public void sendMoney(int id,String password,int destID,double amount){
        User sender=Users.get(id);
        if(verifyCredentials(id,password)){
            if(sender.getBalance()>=amount){
                System.out.println("Transferring Money......");
                User receiver =Users.get(destID);
                if(receiver==null){
                    System.out.println("Receiver not found!!");
                    return;
                }
                sender.setBalance(sender.getBalance()-amount);
                receiver.setBalance(receiver.getBalance()+amount);
                System.out.println("Transferred money successfully!!!");
                System.out.println("Your new balance is"+  sender.getBalance());

            }
            else{
                System.out.print("Insufficient balance");
            }
        }
    }
    public void addMoney(int id,double amount){
        User user=Users.get(id);
        user.addBalance(amount);
        System.out.println("Successfully added money!!!");
        System.out.println("Your new balance:"+ user.getBalance());
    }
    public void checkBalance(int id){
        User user=Users.get(id);
        System.out.println("Your balance is:"+ user.getBalance());
    }
    public void withdrawMoney(int id, double amount){
        User user=Users.get(id);
        if(user.getBalance()>= amount){
            user.withdrawBalance(amount);
            System.out.println("Withdrew Successfully!!!");
            System.out.println("Your new balance is:"+ user.getBalance());
        }
        else{
            System.out.print("Not enough balance.");
        }


    }
    public void deleteAccount(int id){
        Users.remove(id);



    }

}
