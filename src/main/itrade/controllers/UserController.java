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
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60);

        //CORS
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "*");
        //create object from json form
        User user = gson.fromJson(jsonUser, User.class);
        String userId = user.getUserId();
        String password = user.getPassword();

        List<User> foundUsers = userRepository.findUserByUserIdAndPassword(userId, password);

        int foundSize = foundUsers.size();
        if (foundSize == 0) {
            return (new ResponseEntity<>("user not found", headers, HttpStatus.OK));
        } else if (foundSize == 1) {
            User foundUser = foundUsers.get(0);
            session.setAttribute("currentUser", foundUser);
            String responseJson = gson.toJson(foundUser);
            return (new ResponseEntity<>(responseJson, headers, HttpStatus.OK));
        } else {
            return (new ResponseEntity<>("", headers, HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentUser(HttpServletRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");

        String responseJson = gson.toJson(request.getSession().getAttribute("currentUser"));
        return (new ResponseEntity<>(responseJson, headers, HttpStatus.OK));
    }

}
