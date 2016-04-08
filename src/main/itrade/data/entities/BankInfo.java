package main.itrade.data.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tanat on 4/8/2016.
 */
public class BankInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String abbreviation;

    @Column
    private String fullName;

    @Column
    private String country;

    public BankInfo() {
    }



}
