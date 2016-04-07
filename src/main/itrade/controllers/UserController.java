package main.itrade.controllers;

import com.google.gson.Gson;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@RestController(value = "/")
public class UserController {

    private static User currentUser;
    private static Gson gson = new Gson();

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes ="application/json")
    public ResponseEntity<String> login(@RequestBody String jsonUser){

        User user = gson.fromJson(jsonUser,User.class);
        String userId = user.getUserId();
        String password = user.getPassword();

        List<User> foundUsers = userRepository.findUserByUserIdAndPassword(userId, password);

        int foundSize = foundUsers.size();
        if(foundSize == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user not found");
        }else if(foundSize == 1){
            currentUser = foundUsers.get(0);
            String responseJson = gson.toJson(currentUser);
            return ResponseEntity.status(HttpStatus.OK).body(responseJson);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentUser(){
             String responseJson = gson.toJson(currentUser);
            return ResponseEntity.status(HttpStatus.OK).body(responseJson);
    }

}
