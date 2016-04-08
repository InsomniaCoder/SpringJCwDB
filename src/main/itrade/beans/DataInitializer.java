package main.itrade.beans;

import main.itrade.data.entities.Company;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.CompanyRepository;
import main.itrade.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Component
public class DataInitializer {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void setUpMockData() {
        System.out.println("Setting up mock up data in database");
        createMockCompany();
    }

    @Transactional
    private void createMockCompany() {

        Company parent = Company.createCompanyByCodeName("1001", "CHINA_SYSTEMS");
        Company children = Company.createCompanyByCodeName("1002", "ITOS_CORPORATION");
        parent.getChildren().add(children);
        children.setParent(parent);
        companyRepository.save(parent);
        companyRepository.save(children);
        createMockUser(parent, children);
    }

    private void createMockUser(Company parent, Company children) {
        User adminUser = User.createUser(User.UserRole.ADMIN, "admin", "admin");
        adminUser.setCompany(parent);
        User authorizeUser = User.createUser(User.UserRole.AUTHORIZER, "authorizer", "authorizer");
        User regularUser = User.createUser(User.UserRole.REGULAR, "user", "user");
        regularUser.setCompany(children);
        userRepository.save(adminUser);
        userRepository.save(authorizeUser);
        userRepository.save(regularUser);
    }

}
