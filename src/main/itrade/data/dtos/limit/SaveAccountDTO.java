package main.itrade.data.dtos.limit;

/**
 * Created by Tanat on 4/8/2016.
 */
public class SaveAccountDTO {


    private String savingAccount;
    private String currentAccount;
    private String fcdAccount;
    private String otherAccount;

    public String getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(String savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(String currentAccount) {
        this.currentAccount = currentAccount;
    }

    public String getFcdAccount() {
        return fcdAccount;
    }

    public void setFcdAccount(String fcdAccount) {
        this.fcdAccount = fcdAccount;
    }

    public String getOtherAccount() {
        return otherAccount;
    }

    public void setOtherAccount(String otherAccount) {
        this.otherAccount = otherAccount;
    }
}
