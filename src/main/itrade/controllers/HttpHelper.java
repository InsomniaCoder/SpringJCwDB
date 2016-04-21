package main.itrade.controllers;

import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by tanatlokejaroenlarb on 4/21/2016 AD.
 */
public class HttpHelper {

    public static boolean sessionIsExist(HttpServletRequest request){

        HttpSession session = request.getSession(false);
        if(session == null){
            return false;
        }else{
            return  true;
        }
    }

    public static HttpHeaders buildHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }


}
