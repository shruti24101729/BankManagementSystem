package com.company;

public class User {
    
    private int id;
    private String password;
    private double balance;
    private String mobileNum;

    User(int id,String password){
        this.id=id;
        this.password=password;
        balance=0;

    }

    public int getId(){
        return this.id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }
    public void addBalance(double amount){
        this.balance=this.balance+amount;
    }
    public void withdrawBalance(double amount){
        this.balance=this.balance -amount;
    }
}
