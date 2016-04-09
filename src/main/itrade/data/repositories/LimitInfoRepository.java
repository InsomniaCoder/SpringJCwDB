package main.itrade.data.repositories;

import main.itrade.data.entities.LimitInfo;
import main.itrade.data.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Repository
public interface LimitInfoRepository extends CrudRepository<LimitInfo,Integer> {

}
