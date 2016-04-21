package main.itrade.controllers;

import com.google.gson.Gson;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@RestController(value = "/")
public class UserController {

    private static Gson gson = new Gson();

    @Autowired
    UserRepository userRepository;

    /**
     * verify userId and password in the database
     * if found -> create session and add user into it
     * not found -> return null
     *
     * @param jsonUser json data from user contains userId and password form post data
     * @param request  HttpServletRequest is used to intercept session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(60 * 60);

        User user = gson.fromJson(jsonUser, User.class);
        String userId = user.getUserId();
        String password = user.getPassword();
        int company_id = Integer.valueOf(user.getCompany_id());

        List<User> foundUsers = userRepository.findUserByUserIdAndPassword(userId, password);

        int foundSize = foundUsers.size();
        if (foundSize == 0) {
            return (new ResponseEntity<>("user not found", buildHeader(), HttpStatus.OK));
        } else if (foundSize == 1) {

            User foundUser = foundUsers.get(0);

            if(foundUser.getCompany().getId() != company_id){
                return (new ResponseEntity<>("company code is incorrect", buildHeader(), HttpStatus.OK));
            }

            session.setAttribute("currentUser", foundUser);
            String responseJson = gson.toJson(foundUser);

            return (new ResponseEntity<>(responseJson, buildHeader(), HttpStatus.OK));
        } else {
            return (new ResponseEntity<>("", buildHeader(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    /**
     * return json of current user from session if not found return null
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentUser(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if(null == session){

            return (new ResponseEntity<>("", buildHeader(), HttpStatus.BAD_REQUEST));
        }else{

            User user = (User) session.getAttribute("currentUser");

            if(user == null){
                return (new ResponseEntity<>("", buildHeader(), HttpStatus.BAD_REQUEST));
            }else{
                String responseJson = gson.toJson(user);
                return (new ResponseEntity<>(responseJson, buildHeader(), HttpStatus.OK));
            }
        }
    }


    public HttpHeaders buildHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

}
