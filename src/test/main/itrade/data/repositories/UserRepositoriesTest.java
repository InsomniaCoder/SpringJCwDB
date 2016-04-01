package test.main.itrade.data.repositories;

import main.itrade.ApplicationConfigure;
import main.itrade.data.entities.User;
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

    @Test
    public void testFindByIdAdmin(){
        User foundUser = userRepository.findOne(0);
        User adminUser = User.createUser(User.UserRole.ADMIN,"admin","admin");
        Assert.assertEquals("First user found is not admin user",adminUser,foundUser);
    }

    @Test
    public void testFindRegularUserByIdAndPasswordShouldFound(){

        List<User> foundUsers = userRepository.findUserByUserIdAndPassword("user","user");
        Assert.assertEquals("Found more than 1 regular user",1,foundUsers.size());

        User regularUser = User.createUser(User.UserRole.REGULAR,"user","user");
        Assert.assertEquals("Regular user not found or not match",regularUser,foundUsers.get(0));
    }

    @Test
    public void testFindNonExistingUserShouldFail(){

        List<User> foundUsers = userRepository.findUserByUserIdAndPassword("someone","something");
        Assert.assertEquals("Found should not found user ",0,foundUsers.size());
    }



}
