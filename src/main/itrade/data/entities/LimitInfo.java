package main.itrade.data.entities;

import javax.persistence.*;

/**
 * Created by Tanat on 4/8/2016.
 */
@Entity
public class LimitInfo {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String savingAccount;

    @Column
    private String currentAccount;

    @Column
    private String fcdAccount;

    @Column
    private String otherAccount;

    @Column
    private String lcAmount;

    @Column
    private String trAmount;

    @Column
    private String beAmount;

    @Column
    private String sgAmount;

    @Column
    private String pkAmount;

    @Column
    private Commission commission;

    public LimitInfo() {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getLcAmount() {
        return lcAmount;
    }

    public void setLcAmount(String lcAmount) {
        this.lcAmount = lcAmount;
    }

    public String getTrAmount() {
        return trAmount;
    }

    public void setTrAmount(String trAmount) {
        this.trAmount = trAmount;
    }

    public String getBeAmount() {
        return beAmount;
    }

    public void setBeAmount(String beAmount) {
        this.beAmount = beAmount;
    }

    public String getSgAmount() {
        return sgAmount;
    }

    public void setSgAmount(String sgAmount) {
        this.sgAmount = sgAmount;
    }

    public String getPkAmount() {
        return pkAmount;
    }

    public void setPkAmount(String pkAmount) {
        this.pkAmount = pkAmount;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public class Commission{

        private double flat;
        private double rate;
        private double period;
        private double min;

        public Commission() {
        }

        public Commission(double flat, double rate, double period, double min) {
            this.flat = flat;
            this.rate = rate;
            this.period = period;
            this.min = min;
        }

        public double getFlat() {
            return flat;
        }

        public void setFlat(double flat) {
            this.flat = flat;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public double getPeriod() {
            return period;
        }

        public void setPeriod(double period) {
            this.period = period;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }
    }

}
