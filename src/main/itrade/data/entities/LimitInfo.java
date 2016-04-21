package main.itrade.data.entities;

import main.itrade.data.dtos.limit.Commission;

import javax.persistence.*;

/**
 * Created by Tanat on 4/8/2016.
 */
@Entity
public class LimitInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private double savingAccount;

    @Column
    private double currentAccount;

    @Column
    private double fcdAccount;

    @Column
    private double otherAccount;

    @Column
    private double lcAmount;

    @Column
    private double trAmount;

    @Column
    private double beAmount;

    @Column
    private double sgAmount;

    @Column
    private double pkAmount;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Bank bank;

    public LimitInfo() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public double getLcAmount() {
        return lcAmount;
    }

    public void setLcAmount(double lcAmount) {
        this.lcAmount = lcAmount;
    }

    public double getTrAmount() {
        return trAmount;
    }

    public void setTrAmount(double trAmount) {
        this.trAmount = trAmount;
    }

    public double getBeAmount() {
        return beAmount;
    }

    public void setBeAmount(double beAmount) {
        this.beAmount = beAmount;
    }

    public double getSgAmount() {
        return sgAmount;
    }

    public void setSgAmount(double sgAmount) {
        this.sgAmount = sgAmount;
    }

    public double getPkAmount() {
        return pkAmount;
    }

    public void setPkAmount(double pkAmount) {
        this.pkAmount = pkAmount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }


}
