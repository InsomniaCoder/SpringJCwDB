package test.main.itrade.controllers;

import main.itrade.ApplicationConfigure;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
/**
 * Created by tanatlokejaroenlarb on 4/1/2016 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfigure.class})
@WebAppConfiguration
public class UserControllerTest {

    //main entry point, execute request by calling perform
    private MockMvc mockMvc;
    //Mock request by MockMVCRequestBuilder

    UserRepository userRepository;

    @Test
    public void login_withAdminUserNameAndPasswordShouldReturn200(){

        User adminUser = User.createUser(User.UserRole.ADMIN,"admin","admin");
    }

}
