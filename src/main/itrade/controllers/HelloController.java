package main.itrade.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@RestController(value = "/")
public class HelloController {

    @RequestMapping("/test")
    public String testEndpoint(){
        return "testCompleted";
    }

}
