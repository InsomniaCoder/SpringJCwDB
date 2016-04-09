package main.itrade.data.dtos.limit;

/**
 * Created by Tanat on 4/8/2016.
 */
public class SaveAccountDTO {


    private double savingAccount;
    private double currentAccount;
    private double fcdAccount;
    private double otherAccount;

    public double getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(double savingAccount) {
        this.savingAccount = savingAccount;
    }

    public double getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(double currentAccount) {
        this.currentAccount = currentAccount;
    }

    public double getFcdAccount() {
        return fcdAccount;
    }

    public void setFcdAccount(double fcdAccount) {
        this.fcdAccount = fcdAccount;
    }

    public double getOtherAccount() {
        return otherAccount;
    }

    public void setOtherAccount(double otherAccount) {
        this.otherAccount = otherAccount;
    }
}
