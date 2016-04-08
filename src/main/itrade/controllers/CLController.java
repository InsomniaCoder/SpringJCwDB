package main.itrade.controllers;

import com.google.gson.Gson;
import main.itrade.data.dtos.limit.SaveAccountDTO;
import main.itrade.data.dtos.limit.SaveLimitDTO;
import main.itrade.data.entities.LimitInfo;
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

    Gson gson = new Gson();

    public HttpHeaders buildHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveAccount(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String responseJson = gson.toJson(session.getAttribute("currentUser"));
        if(null == responseJson){
            return (new ResponseEntity<>("please login first", buildHeader(), HttpStatus.BAD_REQUEST));
        }

        SaveAccountDTO saveAccountDTO = gson.fromJson(jsonUser, SaveAccountDTO.class);
        

        //header configure

        return (new ResponseEntity<>("", buildHeader() , HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/saveLimit", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveLimit(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String responseJson = gson.toJson(session.getAttribute("currentUser"));
        if(null == responseJson){
            return (new ResponseEntity<>("please login first", buildHeader(), HttpStatus.BAD_REQUEST));
        }

        SaveLimitDTO saveLimitDTO = gson.fromJson(jsonUser, SaveLimitDTO.class);


        //header configure

        return (new ResponseEntity<>("", buildHeader() , HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/saveCommission", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveCommission(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String responseJson = gson.toJson(session.getAttribute("currentUser"));
        if(null == responseJson){
            return (new ResponseEntity<>("please login first", buildHeader(), HttpStatus.BAD_REQUEST));
        }

        LimitInfo.Commission commissionDTO = gson.fromJson(jsonUser, LimitInfo.Commission.class);


        //header configure

        return (new ResponseEntity<>("", buildHeader() , HttpStatus.INTERNAL_SERVER_ERROR));
    }




}
