package com.userbanklist;

public class Account {
    private int accountid;
    private int account;
    private int userid;

    public Account(int accountid, int account, int userid) {
        this.accountid = accountid;
        this.account = account;
        this.userid = userid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountid=" + accountid +
                ", account=" + account +
                ", userid=" + userid +
                '}';
    }
}
