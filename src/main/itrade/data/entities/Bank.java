package main.itrade.data.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String abbreviation;

    @Column
    private String fullName;

    @Column
    private String country;

    @OneToMany
    private List<LimitInfo> limitInfo;

    @OneToMany
    private List<LC> lcs;


    public Bank() {
    }



    private Bank(String abbreviation, String fullName, String country) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
        this.country = country;
    }

     public static class BankBuilder{

        private String abbreviation;
        private String fullName;
        private String country;

        public BankBuilder(){

        }
        public BankBuilder abbreviation(String abbvr){
            this.abbreviation = abbvr;
            return this;
        }

        public BankBuilder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public BankBuilder country(String country){
            this.country = country;
            return this;
        }

        public Bank build(){
            return new Bank(abbreviation,fullName,country);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (abbreviation != null ? !abbreviation.equals(bank.abbreviation) : bank.abbreviation!= null) return false;
        if (country != null ? !country.equals(bank.country) : bank.country != null) return false;
        return fullName != null ? fullName.equals(bank.fullName) : bank.fullName == null;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<LimitInfo> getLimitInfo() {
        return limitInfo;
    }

    public void setLimitInfo(List<LimitInfo> limitInfo) {
        this.limitInfo = limitInfo;
    }

    public List<LC> getLcs() {
        return lcs;
    }

    public void setLcs(List<LC> lcs) {
        this.lcs = lcs;
    }
}
