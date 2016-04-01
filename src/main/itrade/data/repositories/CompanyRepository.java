package main.itrade.data.repositories;

import main.itrade.data.entities.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer> {
}
