package main.itrade.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by CartoON on 5/22/2016.
 */
@Controller
public class HomeController {

    
         @RequestMapping(value = { "/home"}, method = RequestMethod.GET)
         public ModelAndView welcomePage() {
                 ModelAndView modelAndView = new ModelAndView();
                 modelAndView.setViewName("index");
                 return modelAndView;
             }

}
