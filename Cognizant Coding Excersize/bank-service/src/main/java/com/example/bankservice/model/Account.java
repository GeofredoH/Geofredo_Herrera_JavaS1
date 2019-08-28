package com.example.bankservice.model;


import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private Integer accountNumber;
    private BigDecimal credit;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                Objects.equals(credit, account.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, credit);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", credit=" + credit +
                '}';
    }
}
