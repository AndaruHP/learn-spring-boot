package com.example.backendtrial.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank")
public class BankAccount {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private double balance;

    public BankAccount() {
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BankAccount)) return false;
        final BankAccount other = (BankAccount) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (Double.compare(this.getBalance(), other.getBalance()) != 0) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BankAccount;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final long $balance = Double.doubleToLongBits(this.getBalance());
        result = result * PRIME + (int) ($balance >>> 32 ^ $balance);
        return result;
    }

    public String toString() {
        return "BankAccount(name=" + this.getName() + ", balance=" + this.getBalance() + ")";
    }
}
