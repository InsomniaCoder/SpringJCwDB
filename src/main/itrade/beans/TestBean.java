package main.itrade.beans;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Component
public class TestBean {

    @PersistenceContext
    EntityManager entityManager;

}
