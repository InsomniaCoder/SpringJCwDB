package main.itrade.data.entities;

import javax.persistence.*;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String code;

    @Column
    private String name;

}
