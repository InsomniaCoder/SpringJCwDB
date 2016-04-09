package main.itrade.controllers;

import com.google.gson.Gson;
import main.itrade.data.dtos.limit.SaveAccountDTO;
import main.itrade.data.dtos.limit.SaveLimitDTO;
import main.itrade.data.dtos.limit.Commission;
import main.itrade.data.entities.LimitInfo;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.LimitInfoRepository;
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

/**
 * Created by Tanat on 4/8/2016.
 */

/**
 * controller  serves service for cl related calls.
 */
@RestController
public class CLController {

    @Autowired
    UserRepository userRepository;

    
    Gson gson = new Gson();

    public HttpHeaders buildHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> saveAccount(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (null == currentUser) {
            return (new ResponseEntity<Object>("please login first", buildHeader(), HttpStatus.BAD_REQUEST));
        }

        SaveAccountDTO saveAccountDTO = gson.fromJson(jsonUser, SaveAccountDTO.class);

        LimitInfo userLimit = currentUser.getLimitInfo();
        //if user has no limit before -> insert into table
        if(userLimit == null){
            userLimit = new LimitInfo();
            currentUser.setLimitInfo(userLimit);
            userRepository.save(currentUser);
        }
        //set all value into entity
        setAllAccountValue(userLimit,saveAccountDTO);
        currentUser.setLimitInfo(userLimit);
        userRepository.save(currentUser);

        Object userLimitJson = gson.toJson(userLimit);

        return (new ResponseEntity<>(userLimitJson, buildHeader(), HttpStatus.OK));
    }

    private void setAllAccountValue(LimitInfo userLimit, SaveAccountDTO saveAccountDTO) {
        double savingAccount = saveAccountDTO.getSavingAccount();
            if(savingAccount > 0){
                userLimit.setSavingAccount(savingAccount);
            }
        double currentAccount = saveAccountDTO.getCurrentAccount();
            if(currentAccount > 0){
                userLimit.setCurrentAccount(currentAccount);
            }
        double fcdAccount = saveAccountDTO.getFcdAccount();
            if(fcdAccount > 0){
                userLimit.setFcdAccount(fcdAccount);
            }
        double otherAccount = saveAccountDTO.getOtherAccount();
            if(otherAccount > 0){
                userLimit.setOtherAccount(otherAccount);
            }
    }

    @RequestMapping(value = "/saveLimit", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveLimit(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (null == currentUser) {
            return (new ResponseEntity<>("please login first", buildHeader(), HttpStatus.BAD_REQUEST));
        }

        SaveLimitDTO saveLimitDTO = gson.fromJson(jsonUser, SaveLimitDTO.class);


        //header configure

        return (new ResponseEntity<>("", buildHeader(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/getLimit", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> getLimit(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (null == currentUser) {
            return (new ResponseEntity<>("please login first", buildHeader(), HttpStatus.BAD_REQUEST));
        }

        //retrieve credit and return.
        return (new ResponseEntity<>("", buildHeader(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/saveCommission", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveCommission(@RequestBody String jsonUser, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (null == currentUser) {
            return (new ResponseEntity<>("please login first", buildHeader(), HttpStatus.BAD_REQUEST));
        }

        Commission commissionDTO = gson.fromJson(jsonUser, Commission.class);


        //header configure

        return (new ResponseEntity<>("", buildHeader(), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
