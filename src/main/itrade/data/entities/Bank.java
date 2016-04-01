package main.itrade.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Entity
public class Bank {
    private Integer id;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
