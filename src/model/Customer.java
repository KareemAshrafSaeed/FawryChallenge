package model;

public class Customer {
    private String name;
    private double balance;
    public Customer(String name, double balance) {
        if(name.isEmpty())
            throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
        if(balance<0)
            throw new IllegalArgumentException("Balance can't be negative");
        this.balance = balance;
    }

    public Customer(String name) {
        if(name.isEmpty())
            throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
        balance = 0;
    }
    public void setName(String name) {
        if(name.isEmpty())
            throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        if(balance<0)
            throw new IllegalArgumentException("Balance can't be negative");
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
}
