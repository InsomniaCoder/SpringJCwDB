package test.main.itrade.data.repositories;

import main.itrade.ApplicationConfigure;
import main.itrade.data.entities.Company;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.CompanyRepository;
import main.itrade.data.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 4/1/2016 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfigure.class})
public class UserRepositoriesTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testFindByIdAdmin() {
        List<User> foundUsers = userRepository.findUserByUserIdAndPassword("admin", "admin");
        User adminUser = User.createUser(User.UserRole.ADMIN, "admin", "admin");
        Assert.assertEquals("First user found is not admin user", adminUser, foundUsers.get(0));
    }

    @Test
    public void testFindRegularUserByIdAndPasswordShouldFound() {

        List<User> foundUsers = userRepository.findUserByUserIdAndPassword("user", "user");
        Assert.assertEquals("Found more than 1 regular user", 1, foundUsers.size());

        User regularUser = User.createUser(User.UserRole.REGULAR, "user", "user");
        Assert.assertEquals("Regular user not found or not match", regularUser, foundUsers.get(0));
    }

    @Test
    public void testFindNonExistingUserShouldReturnEmpty() {

        List<User> foundUsers = userRepository.findUserByUserIdAndPassword("someone", "something");
        Assert.assertEquals("Found should not found user ", 0, foundUsers.size());
    }

    @Test
    public void testAdminUserMustBeInParentCompany() {

        User foundUsers = userRepository.findByUserId("admin");

        Company parentCompany = companyRepository.findByCode("1001");

        Assert.assertEquals("Admin is not in parent company", foundUsers.getId(), parentCompany.getUsers().get(0).getId());
    }

    @Test
    public void testRegularUserMustBeInChildCompany() {

        User foundUsers = userRepository.findByUserId("user");

        Company childCompany = companyRepository.findByCode("1002");

        Assert.assertEquals("User is not in child company", foundUsers.getId(), childCompany.getUsers().get(0).getId());
    }
}
