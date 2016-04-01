package main.itrade.beans;

import main.itrade.data.entities.User;
import main.itrade.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Component
public class DataInitializer {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void setUpMockData()
    {
        System.out.println("Setting up mock up data in database");
        createMockUser();
    }

    @Transactional
    private void createMockUser() {
        User adminUser = User.createUser(User.UserRole.ADMIN,"admin","admin");
        User authorizeUser = User.createUser(User.UserRole.AUTHORIZER,"authorizer","authorizer");
        User regularUser = User.createUser(User.UserRole.REGULAR,"user","regular");
        userRepository.save(adminUser);
        userRepository.save(authorizeUser);
        userRepository.save(regularUser);
    }

}
