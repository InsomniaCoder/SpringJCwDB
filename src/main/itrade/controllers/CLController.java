package main.itrade.controllers;

import main.itrade.data.entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Tanat on 4/8/2016.
 */
@RestController
public class CLController {


    public HttpHeaders buildHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();





        //header configure

        return (new ResponseEntity<>("", buildHeader() , HttpStatus.INTERNAL_SERVER_ERROR));
    }


}
