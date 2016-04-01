package main.itrade.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue
    Integer id;

    @Column
    String name;

}
